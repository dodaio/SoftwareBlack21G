package Model;

import java.util.ArrayList;
import java.util.List;

public class Hands {

	// ***************************************** Variables
	/** The dealer's hand */
	private List<Card> dealerCards;
	/** The player's hand */
	private List<Card> playerHand;
	/** Pointer to the game's deck*/
	private Deck deck;
	// ***************************************** Constructors
	/**
	 * Full C'tor.
	 */
	protected Hands(Deck deck) {
		this.dealerCards = new ArrayList<Card>();
		this.playerHand = new ArrayList<Card>();
		this.deck = deck;
	}
	
	/**
	 * @return the dealerCards
	 */
	protected List<Card> getDealerCards() {
		return dealerCards;
	}


	/**
	 * @param dealerCards the dealerCards to set
	 */
	protected void setDealerCards(List<Card> dealerCards) {
		this.dealerCards = dealerCards;
	}


	/**
	 * @return the playerHand
	 */
	protected List<Card> getPlayerHand() {
		return playerHand;
	}


	/**
	 * @param playerHand the playerHand to set
	 */
	protected void setPlayerHand(List<Card> playerHand) {
		this.playerHand = playerHand;
	}
	
	/**
	 * Reseting the hands after each round
	 */
	protected void reset() {
		getDealerCards().clear();
		getPlayerHand().clear();
	}
	
	/**
	 * hit the dealer
	 */
	protected void hitDealer(){
		getDealerCards().add(deck.getCard());
	}
	
	/**
	 * hit the player
	 */
	protected void hitPlayer(){
		getPlayerHand().add(deck.getCard());
	}
	
	
	
	// המתודות למטה לא גמורות, צריך להתחשב במקרה של אס.
	
	
	/**
	 * return for calculating the simple score of the dealer
	 * @return the dealer simple score
	 */
	protected int getDealerScore(){
		int i = 0;
		for (Card card : dealerCards) 
			i += card.getcValue();
		return i;
	}
	
	/**
	 * return for calculating the simple score of the player
	 * @return the player simple score
	 */
	protected int getPlayerScore(){
		int i = 0;
		for (Card card : playerHand) 
			i += card.getcValue();
		return i;
	}
	
	
}
