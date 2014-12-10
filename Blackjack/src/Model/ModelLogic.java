package Model;

import java.util.List;

import Controller.ControllerLogic;

public class ModelLogic {

	// ***************************************** Variables
	// *********************************************
	/** The instance of the cpntroller */
	private static ControllerLogic controller;
	/** Dealer and player hands  */
	private static Hands hands;
	/** Soft hand */
	private static int dealer_limit = 17;
	/** Result string for View layer  */
	private static String win_msg = "You Won";
	/** Result string for View layer  */
	private static String lose_msg = "You Lost";

	/*************************
	 * For use in next iteration of scrum private static
	 * 
	 * int sessionScore = 0;
	 * private static int roundNum = 0;
	 */

	// ***************************************** Constructors
	// ******************************************
	/**
	 * Full C'tor.
	 */
	public ModelLogic(ControllerLogic controller) {
		ModelLogic.controller = controller;
		hands = new Hands();
	}

	// ***************************************** Methods
	// ******************************************
	
	/**
	 * This method for round end.
	 */
	protected void endRound(){
		boolean result = calculteGameResualt(); // calculate who won.
		announceResualt(result); // pass it to controller and view logic
		controller.hitAndStandBtnVisability(false); // turn both hit and stand button off
		controller.dealBtnVisability(true); 		// and deal button on.
	}

	/**
	 * Start the round. This method shuffles the deck and initialize the new Hands.
	 */
	public void deal() {
		hands.reset();
		
		controller.resetGameOnUI();
				
		for (int i = 0; i < 2; i++) { // deals two cards for the player and dealer
			hands.hitDealer();
			hands.hitPlayer();
		}
		controller.hitAndStandBtnVisability(false); // turn both hit and stand button on
		controller.dealBtnVisability(true); 		// and deal button off.
	}

	/**
	 * Deals another card to player and modifies 
	 * the visibility of hit button in needed.
	 */
	public void hit() {
		hands.hitPlayer();
		int score = hands.getPlayerScore();
		updatePlayer(); // update the score for the UI
		if (score > 21)  // player bust
			endRound(); // end round and declare result to player. result calculated in endRound();
		if (score == 21) 	
			controller.hitBtnVisability(false); // player cant hit
	}

	/**
	 * After clicking stand in the UI, this method start dealing card to the
	 * dealer according to the game rules and than calculating and presenting result.
	 */
	public void stand() {
		while (hands.getDealerScore() <= dealer_limit) { // as long dealer has not passed 17.
			hands.hitDealer();
			updateDealer(); // update the score for the UI
		}
		endRound(); // end round and declare result to player
	}
	

	/**
	 * returns game result
	 * @return true if player wins, otherwise false
	 */
	protected boolean calculteGameResualt() {
		int dealerScore = hands.getDealerScore();
		int playerScore = hands.getPlayerScore();

		if (dealerScore == 21
				|| playerScore > 21
				|| (playerScore < 21 && dealerScore < 21 && dealerScore > playerScore)) {
			return false; // lose
		} else {
			return true; // win
		}
	}

	/**
	 * Announces result to controller
	 * @returns result true if win, false if lose
	 */
	private void announceResualt(boolean result) {
		controller.printGameResualt(result, result ? win_msg : lose_msg);
	}

	/**
	 * update player score and cards for view
	 */
	private void updatePlayer() {
		updatePlayerScore(hands.getPlayerScore());
		updatePlayerCards(hands.getPlayerCards());
	}
	
	/**
	 * update dealer score and cards for view
	 */
	private void updateDealer() {
		updateDealerScore(hands.getDealerScore());
		updateDealerCards(hands.getDealerCards());
	}

	/**
	 * update player score for view
	 */
	private void updatePlayerScore(int score) {
		controller.updatePlayerScore(score);
	}
	
	/**
	 * update dealer score for view
	 */
	private void updateDealerScore(int score) {
		controller.updateDealerScore(score);
	}
	
	/**
	 * update player cards for view
	 */
	private void updatePlayerCards(List<Model.Card> cards) {
		controller.updatePlayerCards(cards);
	}
	
	/**
	 * update player score and cards for view
	 */
	private void updateDealerCards(List<Model.Card> cards) {
		controller.updateDealerCards(cards);
	}
	
	
	/*************************
	 * For use in next iteration of scrum /** new session: rest the session
	 * score and round number.
	 * 
	 * public void newSession(){ sessionScore = 0; roundNum = 0; }
	 */
}
