import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * JavaFX 테스트를 위한 간단한 프로그램
 */
public class Hello extends Application {

	@Override
	public void start(Stage mainstage) throws Exception {
		StackPane mainPane = new StackPane();
		Label label = new Label("Hello, World!!!");
		mainPane.getChildren().add(label);
		mainstage.setScene(new Scene(mainPane, 300,300));
		mainstage.setTitle("JavaFX Hello World App");
		mainstage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
