import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기 
 * @author 김상진 
 * @file DrawSmileFace.java
 * Group를 이용한 새 개체 만들기
 * 개체를 구성하는 각 도형이나 이미지는 생성자에서 주어진 좌표를 기반으로 상대적 위치에 나타나도록 해야 함
 */
public class DrawSmileFace extends Application {

	public static class SmileFace extends Group{
		public SmileFace(double x, double y) {
			constructFace(x, y);
		}
		private void constructFace(double xLeft, double yTop) {
			Circle face = new Circle(xLeft+100d,yTop+100d,100d);
			face.setStrokeWidth(2d);
			face.setFill(Color.YELLOW);
			Circle leftEye = new Circle(xLeft+70d,yTop+75d,10d);
			leftEye.setFill(Color.BLACK);
			Circle rightEye = new Circle(xLeft+130d,yTop+75d,10d);
			rightEye.setFill(Color.BLACK);
			Arc smile = new Arc(xLeft+100d,yTop+100d,60d,60d,195d,150d);
			smile.setType(ArcType.OPEN);
			smile.setStroke(Color.BLACK);
			smile.setFill(null);
			smile.setStrokeWidth(4d);
			getChildren().addAll(face,leftEye,rightEye,smile);
		}
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		SmileFace face1 = new SmileFace(50d, 50d);
		SmileFace face2 = new SmileFace(250d, 250d);
		Pane pane = new Pane();
		pane.getChildren().addAll(face1, face2);
		
		mainStage.setTitle("Smile Face");
		mainStage.setScene(new Scene(pane, 500d, 500d));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
