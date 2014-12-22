package Model;

import java.util.ArrayList;
import java.util.List;

public class Hands {

	// ***************************************** Variables
	/** The dealer's hand */
	private List<Card> dealerCards;
	/** The player's hand */
	private List<Card> playerCards;
	/** Pointer to the game's deck */
	private Deck deck;

	// ***************************************** Constructors
	/**
	 * Full C'tor.
	 */
	public Hands() {
		this.dealerCards = new ArrayList<Card>();
		this.playerCards = new ArrayList<Card>();
		this.deck = new Deck();
	}

	/**
	 * @return the dealerCards
	 */
	public List<Card> getDealerCards() {
		return dealerCards;
	}

	/**
	 * @param dealerCards
	 *            the dealerCards to set
	 */
	protected void setDealerCards(List<Card> dealerCards) {
		this.dealerCards = dealerCards;
	}

	/**
	 * @return the playerCards
	 */
	public List<Card> getPlayerCards() {
		return playerCards;
	}

	/**
	 * @param playerCards
	 *            the playerCards to set
	 */
	protected void setplayerCards(List<Card> playerCards) {
		this.playerCards = playerCards;
	}

	/**
	 * Reseting the hands and the deck after each round.
	 * the deck stays the same array, only shuffeld and index is set to 0;
	 */
	protected void reset() {
		getDealerCards().clear();
		getPlayerCards().clear();
		deck.shuffleArray();
	}

	/**
	 * hit the dealer
	 */
	protected void hitDealer() {
		getDealerCards().add(deck.getCard());
	}

	/**
	 * hit the player
	 */
	protected void hitPlayer() {
		getPlayerCards().add(deck.getCard());
	}

	/**
	 * return for calculating the simple score of the dealer
	 * 
	 * @return the dealer simple score
	 */
	public int getDealerScore() {
		int score = 0, cValue;
		for (Card card : dealerCards) {
			cValue = card.getcValue();
			if (cValue > 10) // if royalty
				score += 10;
			else {
				if (cValue == 1) // if ace
					if (score <= 10) // hand won't burst with ace as 11
						score += 11;
					else
						// hand will burst with ace as 11
						score += 1;
				else
					// everything else: value (2-10)
					score += cValue;
			}
		}
		return score;
	}

	/**
	 * return for calculating the simple score of the player
	 * 
	 * @return the player simple score
	 */
	public int getPlayerScore() {
		int i = 0, cValue;
		boolean ace = false;
		for (Card card : playerCards) {
			cValue = card.getcValue();
			if (cValue > 10) // if royalty
				i += 10;
			else {
				if (cValue == 1) // if ace
					if (ace == false) { // first ace
						i += 11;
						ace = true;
					} else
						// after first ace
						i += 1;
				else
					// everything else: value (2-10)
					i += cValue;
			}
		}
		return i;
	}

}
