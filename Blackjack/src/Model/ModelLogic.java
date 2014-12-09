package Model;

import java.util.List;

import Controller.ControllerLogic;

public class ModelLogic {

	// ***************************************** Variables
	// *********************************************

	private static ControllerLogic controller;
	private static Hands hands;
	private static int dealer_limit;

	private static String win_msg = "You Won";
	private static String lose_msg = "You Lost";

	// ***************************************** Constructors
	// ******************************************
	/**
	 * Full C'tor.
	 */
	public ModelLogic(ControllerLogic controller) {
		ModelLogic.controller = controller;
		hands = new Hands();
		dealer_limit = 17;
	}

	public void deal() {
		hands.reset();
		for (int i = 0; i < 2; i++) {
			hands.hitDealer();
			hands.hitPlayer();
		}
		dealBtnVisability(false);
	}

	public void hit() {
		hands.hitPlayer();
		int score = hands.getPlayerScore();
		updatePlayer();
		if (score > 21) {
			announceResualt(false);
		} else if (score == 21) {
			announceResualt(true);
		}
	}

	public void stand() {
		while (hands.getDealerScore() <= dealer_limit) {
			hands.hitDealer();
			updateDealer();
		}
		boolean result = hands.calculteGameResualt();
		announceResualt(result);
	}

	/**
	 * Announces result to controller
	 * 
	 * @param result
	 *            true if win, false if lose
	 */
	private void updatePlayer() {
		updatePlayerScore(hands.getPlayerScore());
		updatePlayerCards(hands.getPlayerCards());
	}

	private void updateDealer() {
		updateDealerScore(hands.getDealerScore());
		updateDealerCards(hands.getDealerCards());
	}
	
	private void announceResualt(boolean result) {
		controller.printGameResualt(result, result ? win_msg : lose_msg);
	}

	private void updatePlayerScore(int score) {
		controller.updatePlayerScore(score);
	}

	private void updateDealerScore(int score) {
		controller.updateDealerScore(score);
	}

	private void updatePlayerCards(List<Model.Card> cards) {
		controller.updatePlayerCards(cards);
	}

	private void updateDealerCards(List<Model.Card> cards) {
		controller.updateDealerCards(cards);
	}
	
	/**
	 * Sets deal button visibility
	 * @param visible true to set visible, false to disable 
	 */
	private void dealBtnVisability(boolean visible) {
		controller.dealBtnVisability(visible);
	}

}
