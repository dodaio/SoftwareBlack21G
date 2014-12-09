/**
 * 
 */
package Viewer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import Controller.ControllerLogic;
import Model.Card;

import java.util.*;

/**
 * Control the main game
 *
 */
public class MainGameController extends AnchorPane implements Initializable {
	
	
	
	private ControllerLogic controllerInstance;
	/**
	 * test purpose only!
	 */
	@FXML
	Label Massegelbl;
	
	@FXML
	Button BtnDeal;
	
	
	//*******************************C'tor***********************************************
	
	public MainGameController() {
		controllerInstance = ViewLogic.controller;
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
	}
	
	@FXML
	private void onDealClick(){
		Massegelbl.setText("Deal");
	}
	
	@FXML
	private void onStandClick(){
		Massegelbl.setText("Stand");
	}
	
	/**
	 * 
	 * @param bool
	 * @param str
	 */
	public void printGameResult(boolean bool, String str){
		
	}
	

	//*******************************Methods************************************

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
}
