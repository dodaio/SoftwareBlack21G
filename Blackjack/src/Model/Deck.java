package Model;

import java.util.Random;
import Model.Card;

public class Deck {

	// ***************************************** Variables
	/** The deck itself */
	private Card[] CardsDeck;
	/** index to point on the next Card to "pull". start from 0.*/
	static private int deckIndex = 0;
	// ***************************************** Constructors
	/**
	 * Full C'tor.
	 */
	protected Deck() {
		this.CardsDeck = reset(); // init deck
		this.CardsDeck = shuffleArray(this.getCardsDeck()); // shuffle deck
	}

	/**
	 * @return the CardsDeck
	 */
	protected Card[] getCardsDeck() {
		return CardsDeck;
	}

	/**
	 * @param CardsDeck
	 *            the CardsDeck to set
	 */
	protected void setCardsDeck(Card[] CardsDeck) {
		this.CardsDeck = CardsDeck;
	}

	private Card[] reset() {
		Card c;
		int k = 0;
		Card[] tempDeck = new Card[52];
		if (getCardsDeck() != null)
			for (int j = 0; j < 4; j++)
				for (int i = 0; i < 52; i++) {
					c = new Card(CardType.values()[j], i); // create new Card ,
															// j is the Card ype
															// ,i is the value
					tempDeck[k++] = c; // inserting the Cards to our temp sorted
										// deck;
				}
		return tempDeck;
	}

	/**
	 * method to shuffle the deck.
	 */
	protected Card[] shuffleArray(Card[] tempDeck) {
		Random rnd = new Random();
		for (int i = tempDeck.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Card c = tempDeck[index];
			tempDeck[index] = tempDeck[i];
			tempDeck[i] = c;
		}
		deckIndex = 0;
		return tempDeck;
	}
	
	/**
	 * get a Card to deal
	 */
	protected Card getCard(){
		if(getCardsDeck() != null)
			return getCardsDeck()[deckIndex++]; // deckIndex is re-initilized at shuffle()
		return null; // if deck doesn't exists.
	}

}
