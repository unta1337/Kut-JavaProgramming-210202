// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 4 주차
// 과제명: DrawSmileFace와 같은 클래스를 정의하여 도형 그리기.
// 주제: 너무 많은 과제 때문에 슬픈 학부생.
// 저자: 2020136018 김성녕

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DrawMoodyFaceDueToTheAssignments extends Application {
	public static class MoodyFace extends Group {
		// 얼굴의 구성 요소 정의.
		Circle face;
		Circle[] eyes = new Circle[2];
		Circle nose;
		Arc lips;

		// 얼굴이 나타날 위치는 받아 구성 요소 설정.
		public MoodyFace(double x, double y) {
			face = new Circle(x + 100d, y + 100d, 100d);
			face.setStrokeWidth(2d);
			face.setFill(Color.CORAL);
			
			for (int i = 0; i < 2; i++) {
				eyes[i] = new Circle(x + 70d * (i + 1), y + 75d, 10d);
				eyes[i].setFill(Color.BLACK);
			}
			
			nose = new Circle(x + 100d, y + 100d, 5d);
			
			lips = new Arc(x + 100d, y + 200d, 60d, 60d, 40d, 100d);
			lips.setType(ArcType.OPEN);
			lips.setStroke(Color.BLACK);
			lips.setFill(null);
			lips.setStrokeWidth(4d);
			
			getChildren().addAll(face, eyes[0], eyes[1], nose, lips);
		}
	}
	
	@Override
	public void start(Stage mainStage) throws Exception {
		MoodyFace face1 = new MoodyFace(250d, 50d);
		MoodyFace face2 = new MoodyFace(50d, 250d);

		Pane pane = new Pane();
		pane.getChildren().addAll(face1, face2);
		
		mainStage.setTitle("Moody Face");
		mainStage.setScene(new Scene(pane, 500d, 500d));
		mainStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}