// 2020136018 김성녕

/*
 * # 조커 아이템 추가
	1. 조커가 포함되면 두 개 이상의 포켓몬만 일치해도 됨.
	e.g. [조커] [포켓몬1] [포켓몬1] 과 같은 형태로 팡으로 인정.

	2. 조커가 처음 생성되었을 때 1.의 조건이 만족되어도 자동으로 팡이 발생하진 않음. (플레이어가 직접 알아내야 함.)

	3. 한 번에 두 개 이상의 조커를 사용할 수 없음.
	e.g. [조커] [조커] [포켓몬1] 과 같은 형태는 팡으로 인정하지 않음.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 1학기 학기 프로젝트: 포켓몬팡
 * @author 김상진 
 * 포켓몬팡의 메인
 * MVC 모델 이용
 */
public class PangMain extends Application{
	private PangGridView view = new PangGridView();
	private PangGridModel model = new PangGridModel(view);
	private PangGridController controller = new PangGridController(view, model);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller.startGame();
		primaryStage.setTitle("JavaFX PokemonPang");
		primaryStage.setScene(new Scene(view));
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
