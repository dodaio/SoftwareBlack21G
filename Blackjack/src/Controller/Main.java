package Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage pstage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

			pstage = primaryStage;
			ControllerLogic cont = new ControllerLogic(pstage);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[End process]");
			System.out.println("Blackjack game is up and ready...");
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
