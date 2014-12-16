package Model;

import Model.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// ***************************************** Variables  *****************************************
	/** index to point on the next Card to "pull". start from 0.*/
	static private int deckIndex = 0;
	/** arraylist of carrds **/
	ArrayList<Card> DeckofCards;
	// ***************************************** Constructors  *****************************************
	/**
	 * Full C'tor.
	 */
	protected Deck() {
		DeckofCards  = new ArrayList<Card>();
		newDeck();
	}
	
	protected void newDeck() {
		initDeck();		// init deck 
		shuffleArray(); // shuffle deck
	}

	/**
	 * @return the DeckofCards
	 */
	protected List<Card> getCardsDeck() {
		return DeckofCards;
	}

	/**
	 * @param DeckofCard
	 * the DeckofCard to set
	 */
	protected void setCardsDeck(ArrayList<Card> CardsDeck) {
		this.DeckofCards = CardsDeck;
	}
	
	/**
	 * Create a sorted array of 52 cards.
	 */
	private void initDeck() {
		if(DeckofCards !=null){
			for (int j = 0; j < 4; j++){		// load for each card type
				for (int i = 1; i < 14; i++) {		//load for each card type, it's value.
					switch (j) {
					case 0:
						DeckofCards.add(new Card(CardType.values()[j], i,new String("/GameImages/Club-"+ i + ".png")));
						break;
					case 1:
						DeckofCards.add(new Card(CardType.values()[j], i,new String("/GameImages/Diamond-"+ i + ".png")));
						break;
					case 2:
						DeckofCards.add(new Card(CardType.values()[j], i,new String("/GameImages/Heart-"+ i + ".png")));
						break;
					case 3:
						DeckofCards.add(new Card(CardType.values()[j], i,new String("/GameImages/Spade-"+ i + ".png")));
						break;
					default:
						break;
					}
				
				}
				
			}
			
		}
			
	}

	/**
	 * method to shuffle the array of cards (the deck).
	 */
	protected void shuffleArray() {
		Collections.shuffle(DeckofCards);
	}
	
	/**
	 * get a Card to deal
	 */
	protected Card getCard(){
		
		if(getCardsDeck() != null){
			if(!(deckIndex<52))
			{
				shuffleArray();  //if we are out of cards to deal, shuffle again and deal.
				deckIndex = 0;
				System.out.println("New deck was shuffled");
			}
			return getCardsDeck().get(deckIndex++); // deckIndex is re-initilized at shuffleArray()
		}
		return null; // if deck doesn't exists.
	}

}
