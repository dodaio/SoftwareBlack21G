package Viewer;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Controller.ControllerLogic;

public class ViewLogic {

	// ***************************************** Variables *********************************************
	/** ControllerLogic reference pointer */
	protected static ControllerLogic controller;
	/** stage */
	protected static Stage mstage;
	/** stage */
	protected static MainGamev2Controller mgame;

	// ***************************************** Constructors ******************************************
	/**
	 * Full C'tor.
	 */
	public ViewLogic(ControllerLogic cont) {
		controller = cont;
	}

	// ***************************************** Methods
	// ***********************************************

	/**
	 * Execute game view
	 * 
	 * @param stg
	 *            pointer to game view
	 */
	public void executeLoginView(Stage stg) {
		mstage = stg;

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainGamev2.fxml"));
			Parent root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Stage primaryStage = mstage;
			scene.getStylesheets().add(getClass().getResource("MainGamev2.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			primaryStage.getIcons().add(new Image("/GameImages/icon3.png"));
			mgame = loader.getController();

			primaryStage.show();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * Exit
	 */
	public void executeSysExit() {
		controller.executeSysExit();
	}

	/**
	 * Show game result
	 * 
	 * @param result
	 * @param msg
	 */
	public void printGameResult(boolean result, String msg) {
		mgame.printGameResult(result, msg);
	}

	/**
	 * Update players score
	 * 
	 * @param score
	 */
	public void updatePlayerScore(int score) {
		mgame.updatePlayerScore(score);
	}

	/**
	 * Update dealer's score
	 * 
	 * @param score
	 */
	public void updateDealerScore(int score) {
		mgame.updateDealerScore(score);
	}

	/**
	 * Update Player's cards
	 * 
	 * @param cards
	 */
	public void updatePlayerCards(List<Model.Card> cards) {
		mgame.updatePlayerCards(cards);
	}

	/**
	 * Update dealer's cards
	 * 
	 * @param cards
	 */
	public void updateDealerCards(List<Model.Card> cards) {
		mgame.updateDealerCards(cards);
	}

	/**
	 * Sets DEAL button visibility
	 * 
	 * @param visible
	 *            true to set visible, false to disable
	 */
	public void dealBtnVisability(boolean visible) {

		if (visible) // show button
			mgame.showButtonDeal();

		if (!visible) // show button
			mgame.hideButtonDeal();

	}

	/**
	 * Sets HIT button visibility
	 * 
	 * @param visible
	 *            true to set visible, false to disable
	 */
	public void hitBtnVisability(boolean visible) {

		if (visible) // display button
		{
			mgame.showButtonHit();
		}

		if (!visible) // hide button
		{
			mgame.hideButtonHit();
		}
	}

	/**
	 * Sets HIT AND STAND button visibility
	 * 
	 * @param visible
	 *            true to set visible, false to disable
	 */
	public void hitAndStandBtnVisability(boolean visible) {

		if (visible) // display button
		{
			mgame.showButtonHit();
			mgame.showButtonStand();
		}

		else // hide button
		{
			mgame.hideButtonHit();
			mgame.hideButtonStand();
		}

	}

	/**
	 * Reset game board
	 */
	public void resetGameOnUI() {
		mgame.Resetgame();
	}
	
	/**
	 * Change dealer's first card visibility
	 * @param visible true for visible, false for hidden
	 */
	public void showDealerFirstCard(boolean visible) {
		mgame.showDealerFirstCard(visible);
	}
}
