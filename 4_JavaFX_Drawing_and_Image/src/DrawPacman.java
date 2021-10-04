import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * @file DrawPacman.java
 * Pacman 게임에서 Pacman 그리기
 */
public class DrawPacman extends Application {
	@Override
	public void start(Stage mainStage) throws Exception {
		double centerX = 150d;
		double centerY = 150d;
		double radius = 100d;
	    
		double uRadian = 315*Math.PI/180.0;
	    double upperX = (radius)*Math.cos(uRadian)+centerX;
	    double upperY = (radius)*Math.sin(uRadian)+centerY;
		double lRadian = 45*Math.PI/180.0;
		double lowerX = (radius)*Math.cos(lRadian)+centerX;
		double lowerY = (radius)*Math.sin(lRadian)+centerX;
		
		Path pacman = new Path();
		pacman.getElements().add(new MoveTo(upperX,upperY));
		pacman.getElements().add(new LineTo(centerX-radius/2, centerY));
		pacman.getElements().add(new LineTo(lowerX, lowerY));
		
		ArcTo arcTo = new ArcTo();
		arcTo.setX(upperX);
		arcTo.setY(upperY);
		arcTo.setRadiusX(radius);
		arcTo.setRadiusY(radius);
		arcTo.setLargeArcFlag(true);
		arcTo.setSweepFlag(true);
		
		pacman.getElements().add(arcTo);
		pacman.setFill(Color.YELLOW);
		
		StackPane mainPane = new StackPane();
		mainPane.getChildren().add(pacman);
		
		mainStage.setTitle("Pacman JavaFX App");
		mainStage.setScene(new Scene(mainPane, 300d, 300d));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
