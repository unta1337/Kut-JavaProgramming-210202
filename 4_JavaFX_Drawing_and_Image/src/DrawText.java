import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2021년도 2학기
 * @author 김상진 
 * @file DrawLines.java
 * JavaFX를 이용한 수직, 수평선 그리기
 */
public class DrawText extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Text text = new Text(50d, 100d, "Hello, World!");
		text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 24d));
		text.setStroke(Color.BLUE);
		text.setStrokeWidth(1d);
		text.setFill(Color.RED);
		
		Rectangle rectangle = new Rectangle(50d, 100d, text.getLayoutBounds().getWidth(), 50d);
		rectangle.setStroke(Color.RED);
		rectangle.setFill(null);

		Pane mainPane = new Pane();
		mainPane.getChildren().addAll(text, rectangle);
		
		mainStage.setTitle("Draw Text JavaFX App");
		mainStage.setScene(new Scene(mainPane, 300d, 300d));
		mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
