package Model;

import java.util.List;

import Controller.ControllerLogic;
import Model.AudioPlayer.Effects;

public class ModelLogic {

	// ***************************************** Variables *********************************************
	/** The instance of the controller */
	private static ControllerLogic controller;
	/** Dealer and player hands */
	private static Hands hands;
	/** Soft hand */
	private static int dealer_limit = 17;
	/** Result string for View layer */
	private static String win_msg = "You Won";
	/** Result string for View layer */
	private static String lose_msg = "You Lost";
	/**Sound reference */
	private static AudioPlayer sounds;
	/** Counts the game round */
	private static int RoundofGameCount = 0;
	/** Counts wins */
	private static int wins;
	/** Counts lost */
	private static int loses;
	/** Score of player */
	private static int Gamescore = 0;

	/*************************
	 * For use in next iteration of scrum private static
	 * 
	 * int sessionScore = 0; private static int roundNum = 0;
	 */

	// ***************************************** Constructors ******************************************
	/**
	 * C'tor for tests 
	 */
	public ModelLogic() {
	}
	
	/**
	 * Full C'tor.
	 */
	public ModelLogic(ControllerLogic controller) {
		ModelLogic.controller = controller;
		hands = new Hands();
		sounds = new AudioPlayer();
		sounds.playMusic(AudioPlayer.Musics.GAME_MUSIC);
	}

	// ***************************************** Methods ******************************************

	/**
	 * This method for round end.
	 */
	protected void endRound() {
		int dealerScore = hands.getDealerScore();
		int playerScore = hands.getPlayerScore();
		boolean result = calculteGameResualt(dealerScore, playerScore); // calculate who won.
		announceResualt(result); // pass it to controller and view logic
		controller.hitAndStandBtnVisability(false); // turn both hit and stand
													// button off
		controller.dealBtnVisability(true); // and deal button on.
		controller.showDealerFirstCard(true);
		updateDealer();
		updatePlayer();
		RoundofGameCount++;
		updateWinsAndLoses(wins, loses);
		updateScore(calculatePlayerScroe(playerScore, result)); //update score according to results
		
	}

	/**
	 * Start the round. This method shuffles the deck and initialize the new
	 * Hands.
	 */
	public void deal() {
		hands.reset();
		controller.showDealerFirstCard(false);
		controller.resetGameOnUI();
		sounds.playEffect(AudioPlayer.Effects.SHUFFLE);
		for (int i = 0; i < 2; i++) { // deals two cards for the player and
										// dealer
			hands.hitDealer();
			hands.hitPlayer();
		}
		controller.hitAndStandBtnVisability(true); // turn both hit and stand
													// button on
		controller.dealBtnVisability(false); // and deal button off.
		updateDealerCards(hands.getDealerCards());
		sounds.playEffect(AudioPlayer.Effects.DEAL);
		updatePlayer();
		if (hands.getPlayerScore() == 21)
			endRound();	 // player is at 21 and forced to stand, dealer play
	}

	/**
	 * Deals another card to player and modifies the visibility of hit button in
	 * needed.
	 */
	public void hit() {
		sounds.playEffect(AudioPlayer.Effects.HIT);
		hands.hitPlayer();
		int score = hands.getPlayerScore();
		updatePlayer(); // update the score for the UI
		if (score > 21) // player bust
			endRound(); // end round and declare result to player. result
						// calculated in endRound();
		if (score == 21)
			endRound();	 // player is at 21 and forced to stand, dealer play
		updatePlayer();

	}

	/**
	 * After clicking stand in the UI, this method start dealing card to the
	 * dealer according to the game rules and than calculating and presenting
	 * result.
	 */
	public void stand() {
		while (hands.getDealerScore() <= dealer_limit) { // as long dealer has
															// not passed 17.
			hands.hitDealer();
			updateDealer(); // update the score for the UI
		}
		endRound(); // end round and declare result to player
	}
	
	/**
	 * Updates music setting
	 * @param status True if on
	 */
	public void setMusicSetting(boolean status) {
		sounds.setMusic(status);
	}

	/**
	 * Updates sound effects setting
	 * @param status True if on
	 */
	public void setSoundEffectsSetting(boolean status) {
		sounds.setSoundEffects(status);
	}
	
	/**
	 * returns game result
	 * 
	 * @return true if player wins, otherwise false
	 */
	public boolean calculteGameResualt(int dealerScore , int playerScore ) {

		if (dealerScore == 21 || playerScore > 21 || dealerScore == playerScore || (playerScore < 21 && dealerScore < 21 && dealerScore > playerScore)) 
		{
			loses++;
			return false; // lose
		} 
		else
		{
			wins++;
			return true; // win
		}
	}

	/**
	 * Announces result to controller
	 * 
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
	
	/**
	 * Update WinsAndLoses to theScreen
	 */
	public void updateWinsAndLoses(int Wins, int Loses){
		controller.updateWinsAndLoses(Wins, Loses);
	}
	
	/**
	 * Update Score to theScreen
	 */
	public void updateScore(int score){
		controller.updateScore(score);
	}

	/**
	 * Run a new game - reset all stats and score
	 * score and round number.
	 */ 
	 public void newSession(){ 
		 wins = 0;
		 loses = 0;
		 RoundofGameCount = 0;
		 Gamescore = 0;
		 controller.showDealerFirstCard(true);
		 controller.resetGameOnUI();
		 controller.RestartGame();
		 hands.reset();
		 controller.hitAndStandBtnVisability(false); // turn off hit and stand buttons
		 controller.dealBtnVisability(true); //  turn deal  button on.
	 }
	 
	 /**
	  * Calculate the score of the game for player
	  * The result is calculated according to the requirement if round is even the triple the score, if odd the multiply the score
	  * the total score is wins - loses
	  */
	 public int calculatePlayerScroe(int score, boolean resualt){
		 if(resualt){							//if player won then we add the score
			 if(RoundofGameCount % 2 == 0)
				 Gamescore += score*3;			//if the round is even multiply the score by 3
			 else
				 Gamescore += score*2;			//if the round is even multiply the score by 3
		 }
		
		 if(!resualt){
			 if(RoundofGameCount % 2 == 0)
				 Gamescore -= score*3;			//if the round is even multiply the score by 3
			 else
				 Gamescore -= score*2;			//if the round is even multiply the score by 3
		 }
		 
		 if(Gamescore>0)
			 return Gamescore;	
		 else
			 Gamescore = 0;		//if result is negative then return zero
		 
		 return Gamescore;
	 }
	 
	 /**
		 * PlaySoundEffect
		 */
		public void butttonSound() {
			sounds.playEffect(Effects.MOVE_OVER_BUTTON);
		}
	 
	 
}
