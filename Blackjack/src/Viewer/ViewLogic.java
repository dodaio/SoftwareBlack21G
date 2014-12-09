package Viewer;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Controller.ControllerLogic;

public class ViewLogic {

	// ***************************************** Variables
	// *********************************************
	/** ControllerLogic reference pointer */
	protected static ControllerLogic controller;
	/** stage */
	protected static Stage mstage;

	// ***************************************** Constructors
	// ******************************************
	/**
	 * Full C'tor.
	 */
	public ViewLogic(ControllerLogic cont) {
		controller = cont;
	}

	// ***************************************** Methods
	// ***********************************************

	public void executeLoginView(Stage stg) {
		mstage = stg;

		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					"MainGame.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = mstage;
			scene.getStylesheets().add(
					getClass().getResource("MainGame.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void executeSysExit() {

		System.exit(0);

	}

	
	/**
	 * 
	 * @param result
	 * @param msg
	 */
	public void printGameResult(boolean result, String msg){
		// TODO: connect to the same method in MainGameController
	}
}
