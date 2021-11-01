// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 학기 과제 2
// 과제명: 포켓몬팡: 힌트 제공.
// 저자: 2020136018 김성녕

import javafx.scene.input.MouseEvent;

/**
 * 한국기술교육대학교 컴퓨터공학부
 * 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 포켓몬팡의 컨트롤러 클래스: 사용자 상호작용 부분과 각종 타이머 사건 처리
 */
public class PangGridController {
	private PangGridView view = null;
	private PangGridModel model = null;
	/**
	 * 마우스 클릭 처리 메소드 
	 */
	private void mouseClickHandle(MouseEvent mouseEvent) {
		view.removeEffect();;
		double x = mouseEvent.getX()+1;
		double y = mouseEvent.getY()+1;
		
		int r = (int)(y/PangUtility.POKETMONIMAGESIZE);
    	int c = (int)(x/PangUtility.POKETMONIMAGESIZE);
    	Location clickedLoc = new Location(r,c);
    	System.out.println(clickedLoc);
    	view.showEffect(clickedLoc);
    }
	
	public PangGridController(PangGridView view, PangGridModel model){
		this.view = view;
		this.model = model;
		view.getCenter().setOnMouseClicked(e->mouseClickHandle(e));
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
		model.initAssign();
		Sound.play("pokemon");
	}
	
}