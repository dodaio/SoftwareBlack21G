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
	 * Maps ASCII image for every card type
	 */
	// Uncomment bellow in the next iteration
	/*
	 * private static final Map<CardType, String> ctypeMap; static {
	 * Map<CardType, String> aMap = new HashMap<CardType, String>();
	 * aMap.put(CardType.C, "Club"); aMap.put(CardType.D, "Diamond");
	 * aMap.put(CardType.H, "Heart"); aMap.put(CardType.S, "Spade"); ctypeMap =
	 * Collections.unmodifiableMap(aMap); }
	 */

	/**
	 * Maps Card name string representation for every card
	 */
	private static final Map<Integer, String> cardMap;
	static {
		Map<Integer, String> aMap = new HashMap<Integer, String>();
		aMap.put(1, "Ace");
		aMap.put(2, "2");
		aMap.put(3, "3");
		aMap.put(4, "4");
		aMap.put(5, "5");
		aMap.put(6, "6");
		aMap.put(7, "7");
		aMap.put(8, "8");
		aMap.put(9, "9");
		aMap.put(10, "10");
		aMap.put(11, "Jack");
		aMap.put(12, "Queen");
		aMap.put(13, "King");

		cardMap = Collections.unmodifiableMap(aMap);
	}

	@FXML
	Label Massegelbl;

	@FXML
	Button BtnDeal;

	@FXML
	Button BtnHit;

	@FXML
	Button BtnStand;

	@FXML
	Label lblMsg;

	// *******************************C'tor***********************************************

	public MainGameController() {

		controllerInstance = ViewLogic.controller;
		loaclstage = ViewLogic.mstage;
	}

	// *******************************Dealer
	// variables************************************

	@FXML
	Label MassegelblD1;
	@FXML
	Label MassegelblD2;
	@FXML
	Label MassegelblD3;
	@FXML
	Label MassegelblD4;
	@FXML
	Label MassegelblD5;
	@FXML
	Label MassegelblD6;
	@FXML
	Label MassegelblD7;
	@FXML
	Label MassegelblD8;
	@FXML
	Label MassegelblD9;
	@FXML
	Label lblHeaderD3;
	@FXML
	Label lblHeaderD4;
	@FXML
	Label lblHeaderD5;
	@FXML
	Label lblHeaderD6;
	@FXML
	Label lblHeaderD7;
	@FXML
	Label lblHeaderD8;
	@FXML
	Label lblHeaderD9;
	@FXML
	Label DScore;

	// *******************************Player
	// variables************************************

	@FXML
	Label Massegelblp1;
	@FXML
	Label Massegelblp2;
	@FXML
	Label Massegelblp3;
	@FXML
	Label Massegelblp4;
	@FXML
	Label Massegelblp5;
	@FXML
	Label Massegelblp6;
	@FXML
	Label Massegelblp7;
	@FXML
	Label Massegelblp8;
	@FXML
	Label Massegelblp9;
	@FXML
	Label lblHeaderP3;
	@FXML
	Label lblHeaderP4;
	@FXML
	Label lblHeaderP5;
	@FXML
	Label lblHeaderP6;
	@FXML
	Label lblHeaderP7;
	@FXML
	Label lblHeaderP8;
	@FXML
	Label lblHeaderP9;
	@FXML
	Label PScore;

	// *******************************Initialize************************************

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BtnHit.setVisible(false);
		BtnStand.setVisible(false);
	}

	// *******************************GUI
	// Methods************************************

	@FXML
	private void Exit() {
		System.exit(0);
	}

	@FXML
	private void onHitClick() {
		controllerInstance.onHitClick();
	}

	@FXML
	private void onDealClick() {
		controllerInstance.onDealClick();
	}

	@FXML
	private void onStandClick() {
		controllerInstance.onStandClick();
	}

	/**
	 * 
	 * @param bool
	 * @param str
	 */
	protected void printGameResult(boolean result, String msg) {
		lblMsg.setText(msg);
	}

	/**
	 * display About window
	 */
	@FXML
	private void showAboutWindow() {
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

	// *******************************Methods************************************

	/**
	 * RestGame
	 * 
	 * Clearing all labels
	 */
	public void Resetgame() {

		MassegelblD1.setText("");
		MassegelblD2.setText("");
		MassegelblD3.setText("");
		MassegelblD4.setText("");
		MassegelblD5.setText("");
		MassegelblD6.setText("");
		MassegelblD7.setText("");
		MassegelblD8.setText("");
		MassegelblD9.setText("");

		Massegelblp1.setText("");
		Massegelblp2.setText("");
		Massegelblp3.setText("");
		Massegelblp4.setText("");
		Massegelblp5.setText("");
		Massegelblp6.setText("");
		Massegelblp7.setText("");
		Massegelblp8.setText("");
		Massegelblp9.setText("");

		lblMsg.setText("");

		lblHeaderP3.setText("");
		lblHeaderP4.setText("");
		lblHeaderP5.setText("");
		lblHeaderP6.setText("");
		lblHeaderP7.setText("");
		lblHeaderP8.setText("");
		lblHeaderP9.setText("");

		lblHeaderD3.setText("");
		lblHeaderD4.setText("");
		lblHeaderD5.setText("");
		lblHeaderD6.setText("");
		lblHeaderD7.setText("");
		lblHeaderD8.setText("");
		lblHeaderD9.setText("");

		PScore.setText("");
		DScore.setText("");
	}

	/**
	 * 
	 * @param score
	 */
	public void updatePlayerScore(int score) {
		PScore.setText(String.valueOf(score));
	}

	/**
	 * 
	 * @param score
	 */
	public void updateDealerScore(int score) {
		DScore.setText(String.valueOf(score));
	}

	/**
	 * 
	 * @param cardlist
	 */
	public void updatePlayerCards(List<Card> cardlist) {
		int size = cardlist.size();
		if (size >= 2) {
			Massegelblp1.setText(cardlist.get(0).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(0).getcValue()));
			Massegelblp2.setText(cardlist.get(1).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(1).getcValue()));
		}

		if (size >= 3) {
			lblHeaderP3.setText("Card No. 3");
			Massegelblp3.setText(cardlist.get(2).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(2).getcValue()));
		}

		if (size >= 4) {
			lblHeaderP4.setText("Card No. 4");
			Massegelblp4.setText(cardlist.get(3).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(3).getcValue()));
		}

		if (size >= 5) {
			lblHeaderP5.setText("Card No. 5");
			Massegelblp5.setText(cardlist.get(4).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(4).getcValue()));
		}

		if (size >= 6) {
			lblHeaderP6.setText("Card No. 6");
			Massegelblp6.setText(cardlist.get(5).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(5).getcValue()));
		}

		if (size >= 7) {
			lblHeaderP7.setText("Card No. 7");
			Massegelblp7.setText(cardlist.get(6).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(6).getcValue()));
		}

		if (size >= 8) {
			lblHeaderP8.setText("Card No. 8");
			Massegelblp8.setText(cardlist.get(7).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(7).getcValue()));
		}

		if (size >= 9) {
			lblHeaderP9.setText("Card No. 9");
			Massegelblp9.setText(cardlist.get(8).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(8).getcValue()));
		}
	}

	/**
	 * 
	 * @param cardlist
	 */
	public void updateDealerCards(List<Card> cardlist) {
		int size = cardlist.size();
		if (size >= 2) {
			MassegelblD1.setText(cardlist.get(0).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(0).getcValue()));
			MassegelblD2.setText(cardlist.get(1).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(1).getcValue()));
		}

		if (size >= 3) {
			lblHeaderD3.setText("Card No. 3");
			MassegelblD3.setText(cardlist.get(2).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(2).getcValue()));
		}

		if (size >= 4) {
			lblHeaderD4.setText("Card No. 4");
			MassegelblD4.setText(cardlist.get(3).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(3).getcValue()));
		}

		if (size >= 5) {
			lblHeaderD5.setText("Card No. 5");
			MassegelblD5.setText(cardlist.get(4).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(4).getcValue()));
		}

		if (size >= 6) {
			lblHeaderD6.setText("Card No. 6");
			MassegelblD6.setText(cardlist.get(5).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(5).getcValue()));
		}

		if (size >= 7) {
			lblHeaderD7.setText("Card No. 7");
			MassegelblD7.setText(cardlist.get(6).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(6).getcValue()));
		}

		if (size >= 8) {
			lblHeaderD8.setText("Card No. 8");
			MassegelblD8.setText(cardlist.get(7).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(7).getcValue()));
		}

		if (size >= 9) {
			lblHeaderD9.setText("Card No. 9");
			MassegelblD9.setText(cardlist.get(8).getcType().toString() + "  "
					+ cardMap.get(cardlist.get(8).getcValue()));
		}
	}

	/**
	 * Change dealer's first card visibility
	 * 
	 * @param visible
	 *            true for visible, false for hidden
	 */
	protected void showDealerFirstCard(boolean visible) {
		MassegelblD1.setVisible(visible);
	}

	/**
	 * 
	 */
	protected void hideButtonDeal() {
		BtnDeal.setVisible(false);
	}

	/**
	 * 
	 */
	protected void hideButtonHit() {
		BtnHit.setVisible(false);
	}

	/**
	 * 
	 */
	protected void hideButtonStand() {
		BtnStand.setVisible(false);
	}

	/**
	 * 
	 */
	protected void showButtonDeal() {
		BtnDeal.setVisible(true);
	}

	/**
	 * 
	 */
	protected void showButtonHit() {
		BtnHit.setVisible(true);
	}

	/**
	 * 
	 */
	protected void showButtonStand() {
		BtnStand.setVisible(true);
	}
}
