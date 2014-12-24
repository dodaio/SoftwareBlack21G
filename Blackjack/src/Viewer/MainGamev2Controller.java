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
import javafx.scene.control.RadioMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class MainGamev2Controller extends AnchorPane implements Initializable {

	/**
	 * local stage for locking up About window
	 */
	private Stage loaclstage;

	/**
	 * Controller instance
	 */
	private ControllerLogic controllerInstance;

	// *********************************Buttons of Game **********************************
	
		@FXML
		Label Massegelbl;

		/**
		 * Deal button javaFX
		 */
		@FXML
		Button BtnDeal;

		/**
		 * Hit button javaFX
		 */
		@FXML
		Button BtnHit;

		/**
		 * Stand button JavaFX
		 */
		@FXML
		Button BtnStand;

		@FXML
		Label lblMsg;
		
		@FXML
		RadioMenuItem music;
		
		@FXML
		RadioMenuItem effects;

	// *******************************C'tor***********************************************
	
	/**
	 * Constructor to initialize viewlogice and receiving stage from parent
	 */
	public MainGamev2Controller() {

		controllerInstance = ViewLogic.controller;
		loaclstage = ViewLogic.mstage;
	}

	// *******************************Dealer variables************************************
	
	/**
	 * Dealer javaFX connection variables to GUI
	 */
	@FXML
	ImageView FirstCardDealer;
	@FXML
	ImageView FirstHideCardDealer; 
	@FXML
	ImageView SecoundCardDealer;
	@FXML
	ImageView ThirdCardDealer;
	@FXML
	ImageView FourthCardDealer;
	@FXML
	ImageView FifthCardDealer;
	@FXML
	ImageView SixthCardDealer;
	@FXML
	ImageView SeventhCardDealer;
	@FXML
	ImageView EightCardDealer;
	@FXML
	ImageView NineghtCardDealer;
	
	@FXML
	Label DScore;

	// *******************************Player variables************************************

	/**
	 * Player javaFX connection variables to GUI
	 */
	@FXML
	ImageView FirstCardPlayer;
	@FXML
	ImageView SecoundCardPlayer;
	@FXML
	ImageView ThirdCardPlayer;
	@FXML
	ImageView FourthCardPlayer;
	@FXML
	ImageView FifthCardPlayer;
	@FXML
	ImageView SixthCardPlayer;
	@FXML
	ImageView SeventhCardPlayer;
	@FXML
	ImageView EightCardPlayer;
	@FXML
	ImageView NineghtCardPlayer;
	
	@FXML
	Label PScore;
	@FXML
	Label PScore2;		//player score to display next to his card for more convince
	

	// *******************************Initialize************************************

	/**
	 * initialize hit & stand buttons to be hidden
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		BtnHit.setVisible(false);
		BtnStand.setVisible(false);
		music.setSelected(true);
		effects.setSelected(true);
	}

	// *******************************GUI Methods************************************

	/**
	 * System exit when user select to exit
	 */
	@FXML
	private void Exit() {
		System.exit(0);
	}
	/**
	 * when user clicked hit button it calls to controllerlogic
	 */
	@FXML
	private void onHitClick() {
		controllerInstance.onHitClick();
	}

	/**
	 * when user clicked deal button it calls to controllerlogic
	 */
	@FXML
	private void onDealClick() {
		controllerInstance.onDealClick();
	}

	/**
	 * when user clicked stand button it calls to controllerlogic
	 */
	@FXML
	private void onStandClick() {
		controllerInstance.onStandClick();
	}

	/**
	 * printing the result of the game to the screen
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
	
	/**
	 * Handles music menu item click
	 */
	@FXML
	private void musicClick() {
		controllerInstance.onMusicMenuClick(music.isSelected());
	}
	
	/**
	 * Handles effects menu item click
	 */
	@FXML
	private void effectsClick() {
		controllerInstance.onEffectsMenuClick(effects.isSelected());
	}

	// *******************************Methods************************************

	// *******************************Methods************************************

		/**
		 * RestGame
		 * 
		 * Clearing all cards and messages on the screen
		 */
		public void Resetgame() {

			FirstCardPlayer.setVisible(false);
			FirstCardDealer.setVisible(false);
			SecoundCardPlayer.setVisible(false);
			SecoundCardDealer.setVisible(false);
			ThirdCardDealer.setVisible(false);
			ThirdCardPlayer.setVisible(false);
			FourthCardDealer.setVisible(false);
			FourthCardPlayer.setVisible(false);
			FifthCardDealer.setVisible(false);
			FifthCardPlayer.setVisible(false);
			SixthCardDealer.setVisible(false);
			SixthCardPlayer.setVisible(false);
			SeventhCardDealer.setVisible(false);
			SeventhCardPlayer.setVisible(false);
			EightCardDealer.setVisible(false);
			EightCardPlayer.setVisible(false);
			NineghtCardDealer.setVisible(false);
			NineghtCardPlayer.setVisible(false);
			
			lblMsg.setText("");


			PScore.setText("");  //reset dealer score
			PScore2.setText("");  //reset player score next to card
			DScore.setText("");	 //reset player score
		}

		/**
		 * Update the score of the player to the screen
		 * @param score
		 */
		public void updatePlayerScore(int score) {
			PScore.setText(String.valueOf(score));
			PScore2.setText(String.valueOf(score));
		}

		/**
		 * Update the score of the dealer to the screen
		 * @param score
		 */
		public void updateDealerScore(int score) {
			DScore.setText(String.valueOf(score));
		}

		/**
		 * Initialize the player cards to the screen - max card available is 9
		 * @param cardlist
		 */
		public void updatePlayerCards(List<Card> cardlist) {
			int size = cardlist.size();
			if (size >= 2) {																	
				FirstCardPlayer.setImage(new Image(cardlist.get(0).getLink().toString()));		//initialize only if the user has only two
				FirstCardPlayer.setVisible(true);
				SecoundCardPlayer.setImage(new Image(cardlist.get(1).getLink().toString()));
				SecoundCardPlayer.setVisible(true);
			}

			if (size >= 3) {
				ThirdCardPlayer.setImage(new Image(cardlist.get(2).getLink().toString()));		//initialize only if the user has three
				ThirdCardPlayer.setVisible(true);
			}

			if (size >= 4) {
				FourthCardPlayer.setImage(new Image(cardlist.get(3).getLink().toString()));		//initialize only if the user has four
				FourthCardPlayer.setVisible(true);
			}

			if (size >= 5) {
				FifthCardPlayer.setImage(new Image(cardlist.get(4).getLink().toString()));		//initialize only if the user has five
				FifthCardPlayer.setVisible(true);
			}

			if (size >= 6) {
				SixthCardPlayer.setImage(new Image(cardlist.get(5).getLink().toString()));		//initialize only if the user has six
				SixthCardPlayer.setVisible(true);
			}

			if (size >= 7) {
				SeventhCardPlayer.setImage(new Image(cardlist.get(6).getLink().toString()));		//initialize only if the user has seven
				SeventhCardPlayer.setVisible(true);
			}

			if (size >= 8) {
				EightCardPlayer.setImage(new Image(cardlist.get(7).getLink().toString()));		//initialize only if the user has only eight
				EightCardPlayer.setVisible(true);
			}

			if (size >= 9) {
				NineghtCardPlayer.setImage(new Image(cardlist.get(8).getLink().toString()));		//initialize only if the user has only nine
				NineghtCardPlayer.setVisible(true);
			}
		}

		/**
		 * Initialize the Dealer cards to the screen - max card available is 9
		 * @param cardlist
		 */
		public void updateDealerCards(List<Card> cardlist) {
			int size = cardlist.size();
			
			if (size >= 2) {
				FirstCardDealer.setImage(new Image(cardlist.get(0).getLink().toString()));		//initialize only if the user has two
				
				SecoundCardDealer.setImage(new Image(cardlist.get(1).getLink().toString()));		
				SecoundCardDealer.setVisible(true);
			}

			if (size >= 3) {
				ThirdCardDealer.setImage(new Image(cardlist.get(2).getLink().toString()));		//initialize only if the user has three
				ThirdCardDealer.setVisible(true);
			}
			

			if (size >= 4) {
				FourthCardDealer.setImage(new Image(cardlist.get(3).getLink().toString()));		//initialize only if the user has four
				FourthCardDealer.setVisible(true);
			}

			if (size >= 5) {
				FifthCardDealer.setImage(new Image(cardlist.get(4).getLink().toString()));		//initialize only if the user has five
				FifthCardDealer.setVisible(true);
			}

			if (size >= 6) {
				SixthCardDealer.setImage(new Image(cardlist.get(5).getLink().toString()));		//initialize only if the user has six
				SixthCardDealer.setVisible(true);
			}

			if (size >= 7) {
				SeventhCardDealer.setImage(new Image(cardlist.get(6).getLink().toString()));		//initialize only if the user has seven
				SeventhCardDealer.setVisible(true);
			}

			if (size >= 8) {
				EightCardDealer.setImage(new Image(cardlist.get(7).getLink().toString()));		//initialize only if the user has  eight
				EightCardDealer.setVisible(true);
			}

			if (size >= 9) {
				NineghtCardDealer.setImage(new Image(cardlist.get(8).getLink().toString()));		//initialize only if the user has nine
				NineghtCardDealer.setVisible(true);
			}
		}

		/**
		 * Change dealer's first card visibility
		 * 
		 * @param visible
		 *            true for visible and showing the actual card, false for hidden and then showing the back of the card
		 */
		protected void showDealerFirstCard(boolean visible) {
			if(!visible){	
				FirstHideCardDealer.setImage(new Image("Viewer/BackCard.png"));
				FirstHideCardDealer.setVisible(true);
			}
			
			if (visible) {
				FirstHideCardDealer.setVisible(false);
				FirstCardDealer.setVisible(true);
			}
		}

		/**
		 * Hide the deal button
		 */
		protected void hideButtonDeal() {
	        BtnDeal.setVisible(false);
		}

		/**
		 * Hide the hit button
		 */
		protected void hideButtonHit() {
			BtnHit.setVisible(false);
		}

		/**
		 * Hide the Stand button
		 */
		protected void hideButtonStand() {
			BtnStand.setVisible(false);
		}

		/**
		 * Show the deal button
		 */
		protected void showButtonDeal() {
			BtnDeal.setVisible(true);
		}

		/**
		 * Show the hit button
		 */
		protected void showButtonHit() {
			BtnHit.setVisible(true);
		}

		/**
		 * Show the stand button
		 */
		protected void showButtonStand() {
			BtnStand.setVisible(true);
		}
}
