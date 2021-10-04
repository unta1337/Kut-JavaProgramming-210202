import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * @file DrawLines.java
 * JavaFX를 이용한 수직, 수평선 그리기
 */
public class DrawDottedLines extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {
		Line[] lines = new Line[5];

		lines[0] = new Line(50d, 50d, 550d, 50d);
		lines[0].getStrokeDashArray().addAll(25d, 20d, 5d, 20d);
		lines[1] = new Line(50d, 100d, 550d, 100d);
		lines[1].getStrokeDashArray().addAll(50d, 50d);
		lines[2] = new Line(50d, 150d, 550d, 150d);
		lines[2].getStrokeDashArray().addAll(25d, 10d);
		lines[3] = new Line(50d, 200d, 550d, 200d);
		lines[3].getStrokeDashArray().addAll(5d);
		lines[4] = new Line(50d, 250d, 550d, 250d);
		lines[4].getStrokeDashArray().addAll(2d, 8d);

		for(var line: lines){
			line.setStrokeWidth(2d);
			line.setStrokeLineCap(StrokeLineCap.BUTT);
		}
		
		Group group = new Group();
		group.getChildren().addAll(lines);
		
		mainStage.setTitle("Draw Dash Lines JavaFX App");
		mainStage.setScene(new Scene(group, 600d, 300d));
		mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
