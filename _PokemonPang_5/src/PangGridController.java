import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;


/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 포켓몬팡의 컨트롤러 클래스: 사용자 상호작용 부분과 각종 타이머 사건 처리
 */
public class PangGridController {
	// 게임 종료 타이머: 1초마다 알람, gameOverCount를 통해 게임 시간 조절
	private Timeline gameOverTimeline = new Timeline();
	private Timeline hintTimeline = new Timeline();
	private SequentialTransition processClickTransition = new SequentialTransition();
	private PangGridView view = null;
	private PangGridModel model = null;
	private Location srcLoc = null;		// 첫 번째 클릭 위치
	private Location destLoc = null;	// 두 번째 클릭 위치
	
	/*
	 *  콤보 관련 멤버들
	 *  콤보는 최초 3초 이전에 계속 팡하면 콤보 증가, 그 다음에 2.5초, 2초, 1초
	 */
	private Timeline comboTimeline = new Timeline();
	private int[] comboTime = {3000, 2500, 2000, 1000};
	private int comboTimeIndex = 0;
	
	/**
	 * 게임 종료 타이머를 재시작 
	 */
	private void restartGameOverTimeLine(){
		gameOverTimeline.stop();
		gameOverTimeline.jumpTo(Duration.ZERO);
		gameOverTimeline.play();
	}
	
	private void restartHintTimeLine(){
		view.removeHint();
		hintTimeline.stop();
		hintTimeline.jumpTo(Duration.ZERO);
		hintTimeline.play();
	}
	
	private void restartComboTimeLine(){		
		comboTimeline.stop();
		if(model.getCombo()==0) {
			comboTimeline.getKeyFrames().clear();
			comboTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(comboTime[comboTimeIndex]),
					e->comboHandle()));
			comboTimeline.setCycleCount(1);
		}
		comboTimeline.jumpTo(Duration.ZERO);
		comboTimeline.play();
	}
	
	// 콤보 처리
	public void comboHandle() {
		model.updateCombo(false);
		if(comboTimeIndex<comboTime.length-1) ++comboTimeIndex;
	}
	
	/**
	 * 1초마다 gameOverTimeline에 의해 호출되는 함수 
	 */
	public void gameOverHandle() {
		model.updateGameTime();
		if(model.isGameOver()) {
			lastPang();
			PauseTransition lastPangTransition 
				= new PauseTransition(Duration.millis(2000));
			lastPangTransition.setOnFinished(e->gameOver());
			lastPangTransition.play();
		}
	}
	
	private void lastPang(){
		List<Location> ghostLocs = model.getSpecialLocs(Pokemon.DUSKULL);
		for(Location loc: ghostLocs) {
			model.processSpecialPokemon(loc); 
			processClick();
		}
		List<Location> dragonLocs = model.getSpecialLocs(Pokemon.DRAGONITE);
		for(Location loc: dragonLocs) {
			model.processSpecialPokemon(loc);
			processClick();
		}
	}
	
	/**
	 * 마우스 클릭 처리 메소드 
	 */
	private void mouseClickHandle(MouseEvent mouseEvent) {
		view.removeEffect();;
		double x = mouseEvent.getX()+1;
		double y = mouseEvent.getY()+1;
		
		int r = (int)(y/PangUtility.POKETMONIMAGESIZE);
    	int c = (int)(x/PangUtility.POKETMONIMAGESIZE);
    	if(srcLoc==null){
    		srcLoc = new Location(r,c);
    		if(model.isSpecialPokemon(srcLoc)){
    			model.processSpecialPokemon(srcLoc);
    			finalizeSuccessfulClick();
    			srcLoc = null;
    		}
    		else view.showEffect(srcLoc);
    	}
    	else{
    		destLoc = new Location(r,c);
    		if(model.isValidSwap(srcLoc,destLoc)){
    			model.swap(srcLoc, destLoc);
    			model.checkAndMark();
    			finalizeSuccessfulClick();
    		}
    		view.removeEffect();
    		srcLoc = destLoc = null;
    	}
    }
	
	private void finalizeSuccessfulClick() { 
		processClick();
		model.updateCombo(true);
		restartHintTimeLine();
		restartComboTimeLine();
	}
	
	private void processClick(){
		processClickTransition.play();
	}
	
	private void checkForAdditionalPang() {
		Sound.play("pang");
		if(model.checkAndMark()) processClick();
		else{
			model.insertSpecialPokemon();
			if(!model.findHints()) gameOver();
		}
	}
	
	private void setupProcessClickTransition() {
		PauseTransition pushUpTransition = new PauseTransition(Duration.millis(100));
		pushUpTransition.setOnFinished(event->model.pushUpMarked());
		PauseTransition replaceTransition = new PauseTransition(Duration.millis(100));
		replaceTransition.setOnFinished(event->model.replaceMarked());
		processClickTransition.getChildren().addAll(pushUpTransition, replaceTransition);
		processClickTransition.setOnFinished(event->checkForAdditionalPang());
	}
	
	public PangGridController(PangGridView view, PangGridModel model){
		this.view = view;
		this.model = model;
		view.getCenter().setOnMouseClicked(e->mouseClickHandle(e));
		
		gameOverTimeline.getKeyFrames().add(
			new KeyFrame(Duration.millis(1000),e->gameOverHandle()));
		gameOverTimeline.setCycleCount(Animation.INDEFINITE);
		hintTimeline.getKeyFrames().add(
			new KeyFrame(Duration.millis(3000),e->{
				model.findHints();
				view.showHint();}));
		hintTimeline.setCycleCount(1);
		setupProcessClickTransition();
	}
	
	public void startGame(){
		Sound.play("opening");
		PangUtility.pokemonInfoDialog("PokemonPang 게임시작", "게임을 시작하시겠습니까???");
		Sound.stop("opening");
		initGame();
	}
	/**
	 * 새 게임마다 새롭게 초기화되어야 하는 것들을 초기화
	 */
	public void initGame(){
		comboTimeIndex = 0;
		model.initAssign();
		restartGameOverTimeLine(); 
		restartHintTimeLine(); 
		restartComboTimeLine();
		Sound.play("pokemon");
	}
	
	private void gameOver(){
		gameOverTimeline.stop(); 	// 타이머 종료
		hintTimeline.stop();
		comboTimeline.stop();
		Sound.stop("pokemon");
		final Window stage = view.getScene().getWindow();
		stage.hide();
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	HallOfFame dialog = new HallOfFame();
    			dialog.show(model.getScore());
    			stage.hide();
            	if(PangUtility.pokemonConfirmDialog("PokemonPang 게임종료", "새 게임을 하시겠습니까???", 
            			"새 게임", "게임 종료")){
            		initGame();
            		((Stage)stage).show();
        		}
        		else Platform.exit();
            }
        });
	}
}