/**
 * 
 */
package Viewer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Controller.ControllerLogic;
import Model.Card;

import java.util.*;

/**
 * Control the main game
 *
 */
public class MainGameController extends AnchorPane implements Initializable {
	
	/**
	 * local stage for locking up About window 
	 */
	private Stage loaclstage;
	
	/**
	 * Controller instance
	 */
	private ControllerLogic controllerInstance;
	
	/**
	 * test purpose only!
	 */
	
	@FXML
	Label Massegelbl;
	
	@FXML
	Button BtnDeal;
	
	@FXML
	Button BtnHit;
	
	@FXML
	Button BtnStand;
	
	//*******************************C'tor***********************************************
	
	public MainGameController() {
		
		controllerInstance = ViewLogic.controller;
		loaclstage = ViewLogic.mstage;
	}

	//*******************************Dealer variables************************************
	@FXML
	Label MassegelblD1;
	@FXML
	Label MassegelblD2;
	@FXML
	Label MassegelblD3;
	@FXML
	Label lblHeaderD3;
	
	//*******************************Player variables************************************
	
	@FXML
	Label Massegelblp1;
	@FXML
	Label Massegelblp2;
	@FXML
	Label Massegelblp3;
	@FXML
	Label lblHeaderP3;
	
	
	
	//*******************************Initialize************************************

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		MassegelblD1.setText("Hidden");
		MassegelblD2.setText("Some Card");
		//MassegelblD3.setText("None");
		
		Massegelblp1.setText("Empty");
		Massegelblp2.setText("Empty");
		//Massegelblp3.setText("Empty");
		
		Massegelbl.setText("Whoooooo");
		
	}
	
	
	//*******************************Methods GUI************************************

	
	@FXML
	private void Exit(){
		System.exit(0);
	}
	
	@FXML
	private void onHitClick(){
		Massegelbl.setText("Hit");
		controllerInstance.onHitClick();
	}
	
	@FXML
	private void onDealClick(){
		Massegelbl.setText("Deal");
		controllerInstance.onDealClick();
	}
	
	@FXML
	private void onStandClick(){
		Massegelbl.setText("Stand");
		controllerInstance.onStandClick();
	}
	
	/**
	 * 
	 * @param bool
	 * @param str
	 */
	protected void printGameResult(boolean result, String msg){
		
	}
	
	/**
	 * display About window
	 */
	@FXML
	private void showAboutWindow(){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.initModality(Modality.WINDOW_MODAL);
			primaryStage.initOwner(loaclstage);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	

	//*******************************Methods************************************

	/**
	 * RestGame
	 */
	public void Resetgame(){
		
		MassegelblD1.setText("");
		
		MassegelblD2.setText("");
		
		MassegelblD3.setText("");
		
		Massegelblp1.setText("");
		
		Massegelblp2.setText("");
		
		Massegelblp3.setText("");
	}
	
	
	/**
	 * 
	 * @param score
	 */
	public void updatePlayerScore(int score){
		
	}
	
	/**
	 * 
	 * @param score
	 */
	public void updateDealerScore(int score){
		
	}
	
	/**
	 * 
	 * @param cardlist
	 */
	public void updatePlayerCards(List<Card> cardlist){
		
	}
	
	/**
	 * 
	 * @param cardlist
	 */
	public void updateDealerCards(List<Card> cardlist){
		
	}
	
	/**
	 * 
	 * @param startcard
	 */
	public void showDealerStartCards(Card startcard){
		
	}
	
	/**
	 * 
	 */
	public void hideButtonDeal(){
		
		BtnDeal.setVisible(false);
		
	}
	
	/**
	 * 
	 */
	public void hideButtonHit(){
		
		BtnDeal.setVisible(false);
		
	}
	
	/**
	 * 
	 */
	public void hideButtonStand(){
		
		BtnDeal.setVisible(false);
		
	}
	
	/**
	 * 
	 */
	public void showButtonDeal(){
		
		BtnDeal.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	public void showButtonHit(){
		
		BtnHit.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	public void showButtonStand(){
		
		BtnStand.setVisible(true);
		
	}
}
