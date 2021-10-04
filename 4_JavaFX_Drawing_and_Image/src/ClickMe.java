import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * @file ClickMe.java
 * JavaFX를 이용한 간단한 사건 기반 프로그래밍 (버튼 클릭 처리)
 */
public class ClickMe extends Application {
	private Button btn = new Button("Click Me, Please");
	
	// 자바 8 이전에는 함수를 인자로 전달할 수 없어 이처럼 함수를 하나 가진 클래스를 정의하고
	// 이 클래스의 객체를 사건 처리자로 등록하여 사용하였음
	// 사건이 발생하였을 때 호출하는 함수를 고정하기 위해 interface를 사용함
	private class ButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			if(btn.getText().equals("Click Me, Please"))
				btn.setText("You Clicked Me.");
			else btn.setText("Click Me, Please");
		}
	} // 내부 클래스 
	
	// 자바 8 이후에는 함수를 사건 처리자로 등록할 수 있음
	// 실제는 이 함수가 등록되는 것은 아니고 이 함수를 호출하는 함수가 등록됨
	public void buttonHandle(){
		if(btn.getText().equals("Click Me, Please"))
			btn.setText("You Clicked Me.");
		else btn.setText("Click Me, Please");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		btn.setOnAction(new ButtonHandler());
		//btn.setOnAction(e->buttonHandle());
		StackPane pane = new StackPane();
		pane.getChildren().add(btn);
		primaryStage.setTitle("Click Me JavaFX App");
		primaryStage.setScene(new Scene(pane, 250d, 100d));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
