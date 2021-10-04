import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * @file DrawArcs.java
 * JavaFX를 이용한 원호 그리기
 */
public class DrawArcs extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Arc a1 = new Arc(150d,100d,100d,100d,135d,90d);
		a1.setType(ArcType.OPEN);
		a1.setStroke(Color.RED);
		a1.setFill(null);
		a1.setStrokeWidth(3d);
		
		Arc a2 = new Arc(150d,100d,100d,100d,315d,90d);
		a2.setType(ArcType.CHORD);
		a2.setStroke(Color.RED);
		a2.setFill(null);
		a2.setStrokeWidth(3d);

		Arc a3 = new Arc(150d,300d,100d,100d,45d,90d);
		a3.setType(ArcType.ROUND);
		a3.setStroke(Color.RED);
		a3.setFill(null);
		a3.setStrokeWidth(3d);

		Group group = new Group();
		group.getChildren().addAll(a1, a2, a3);
		
		primaryStage.setTitle("Draw Arc JavaFX App");
		primaryStage.setScene(new Scene(group, 300d, 350d));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
