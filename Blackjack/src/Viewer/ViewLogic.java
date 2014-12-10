package Viewer;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Controller.ControllerLogic;

public class ViewLogic {

	// ***************************************** Variables
	// *********************************************
	/** ControllerLogic reference pointer */
	protected static ControllerLogic controller;
	/** stage */
	protected static Stage mstage;
	/** stage */
	protected static MainGameController mgame;

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
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("MainGame.fxml"));
			Parent root = (AnchorPane)loader.load();
			//Parent root = FXMLLoader.load(getClass().getResource("MainGame.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = mstage;
			scene.getStylesheets().add(getClass().getResource("MainGame.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			
			mgame = loader.getController();
			
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
		mgame.printGameResult(result, msg);
	}
	
	/**
	 * 
	 * @param score
	 */
	public void updatePlayerScore(int score) {
		mgame.updatePlayerScore(score);
	}
	
	/**
	 * 
	 * @param score
	 */
	public void updateDealerScore(int score) {
		mgame.updateDealerScore(score);
	}
	
	/**
	 * 
	 * @param cards
	 */
	public void updatePlayerCards(List<Model.Card> cards) {
		mgame.updatePlayerCards(cards);
	}
	
	/**
	 * 
	 * @param cards
	 */
	public void updateDealerCards(List<Model.Card> cards) {
		mgame.updateDealerCards(cards);
	}
	
	/**
	 * Sets DEAL button visibility
	 * @param visible true to set visible, false to disable 
	 */
	public void dealBtnVisability(boolean visible) {
		
		if(visible)                      //show button
			mgame.showButtonDeal();
		if(!visible)                      //show button
			mgame.hideButtonDeal();
		
		
	}
	
	/**
	 * Sets HIT button visibility
	 * @param visible true to set visible, false to disable 
	 */
	public void hitBtnVisability(boolean visible) {
		
		if(visible) 				//display button
		{
			mgame.showButtonHit();
		}
		
		if(!visible) 				//hide button
		{
			mgame.hideButtonHit();
		}
	}
	
	/**
	 * Sets HIT AND STAND button visibility
	 * @param visible true to set visible, false to disable 
	 */
	public void hitAndStandBtnVisability(boolean visible) {
			
		if(visible) 				//display button
		{
			mgame.showButtonHit();
			mgame.showButtonStand();
		}
		
		if(!visible) 				//hide button
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
}
