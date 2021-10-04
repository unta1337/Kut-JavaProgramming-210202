import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍 
 * @version 2021년도 2학기
 * @author 김상진 
 * @file ShowImage.java
 * JavaFX를 이용한 이미지 그리기
 */
public class ShowImage extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		Image img = new Image("pikachu.jpg");
		ImageView iView01 = new ImageView(img);
		iView01.setFitWidth(200d);
		iView01.setPreserveRatio(true);
		
		// 이미지와 텍스트 연관 
		ImageView iView02 = new ImageView(img);
		iView02.setFitWidth(150d);
		iView02.setPreserveRatio(true);
		// 텍스트와 이미지 연결
		Label pikachuLabel = new Label("피카츄", iView02);
		// 텍스트 표시 위치
		pikachuLabel.setContentDisplay(ContentDisplay.TOP);
		
		ImageView iView03 = new ImageView(img);
		iView03.setFitWidth(200d);
		iView03.setViewport(new Rectangle2D(img.getWidth()/4.0+25, img.getHeight()/4.0+50,
				img.getWidth()/4.0, img.getHeight()/4.0));
		iView03.setPreserveRatio(true);
		
		ImageView iView04 = new ImageView(img);
		iView04.setFitWidth(200d);
		iView04.setPreserveRatio(true);
		iView04.setRotate(-90d);
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10d);
		hBox.setPadding(new Insets(10d));
		// 이미지와 연관된 레이블이 추가된 순서도 중요함
		hBox.getChildren().addAll(iView01, iView02, pikachuLabel, iView03, iView04);
		mainStage.setTitle("Show Image JavaFX App");
		mainStage.setScene(new Scene(hBox));
		mainStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
