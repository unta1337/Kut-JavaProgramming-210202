import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @copyright �ѱ�����������б� ��ǻ�Ͱ��к� �ڹ����α׷���
 * @version 2021�⵵ 2�б�
 * @author ����� 
 * JavaFX �׽�Ʈ�� ���� ������ ���α׷�
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
