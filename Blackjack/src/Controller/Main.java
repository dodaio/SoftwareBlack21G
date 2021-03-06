package Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage pstage;

	@Override
	public void start(Stage primaryStage) {
		try {
			pstage = primaryStage;
			new ControllerLogic(pstage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
