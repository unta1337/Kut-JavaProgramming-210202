import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @file DrawLines.java
 * @author 김상진 
 * JavaFX를 이용한 수직, 수평선 그리기
 */
public class DrawGrid extends Application {
	
	@Override
	public void start(Stage mainStage) throws Exception {		
		Group group = new Group();
		Scene mainScene = new Scene(group, 600d, 600d);
		for(int i=10; i<mainScene.getWidth(); i+=10){
			Line vLine = new Line(i,0, i,mainScene.getHeight());
			vLine.setStroke(Color.LIGHTGRAY);
			group.getChildren().add(vLine);
		}
		for(int i=10; i<mainScene.getHeight(); i+=10){
			Line hLine = new Line(0,i, mainScene.getWidth(),i);
			hLine.setStroke(Color.LIGHTGRAY);
			group.getChildren().add(hLine);
		}		
		mainStage.setTitle("Draw Lines JavaFX App");
		mainStage.setScene(mainScene);
		mainStage.setResizable(false); // 크기 조절을 할 수 없도록 
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
