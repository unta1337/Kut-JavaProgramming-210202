import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2021년도 2학기
 * @author 김상진 
 * @file DrawRectangle.java
 * JavaFX를 직사각형, 둥근지사각형 그리기
 */
public class DrawRectangle extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		Rectangle box1 = new Rectangle(50d, 50d, 100d, 150d);
		box1.setStroke(Color.BLACK);
		box1.setFill(Color.CYAN);
		box1.setStrokeWidth(3d);
		
		Rectangle box2 = new Rectangle(200d, 50d, 100d, 150d);
		box2.setStroke(Color.BLUE);
		box2.setFill(null);
		box2.setStrokeWidth(5d);
		box2.setArcWidth(20d);
		box2.setArcHeight(20d);
			
		Pane mainPane = new Pane();
		mainPane.getChildren().addAll(box1, box2);
		
		mainStage.setTitle("Draw Rectangle");
		mainStage.setScene(new Scene(mainPane, 350d, 250d));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
