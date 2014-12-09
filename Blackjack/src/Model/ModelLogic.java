package Model;

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
	}

	public void hit() {
		hands.hitDealer();
		int score = hands.getPlayerScore();
		if (score > 21) {
			announceResualt(false);
		} else if (score == 21) {
			announceResualt(true);
		}
	}

	public void stand() {
		while (hands.getDealerScore() <= dealer_limit) {
			hands.hitDealer();
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
	private void announceResualt(boolean result) {
		controller.printGameResualt(result, result ? win_msg : lose_msg);
	}

}
