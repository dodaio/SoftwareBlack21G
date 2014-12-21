package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * This test class is designed to the Hand class.
 * test correction of the methods getDealerScore() and getPlayerScore() in the Model.
 * Especially check multiple aces in hand.
 */
public class TestScoreCalculating {

	static Hands hands;
	static Card card;


	@Before
	public void setUp() throws Exception {
		hands = new Hands();
	}

	@Test
	public void testDealer4AcesScore() {
		for (int i = 0; i < 4; i++) {
			card = new Card(CardType.values()[i], 1, new String(
					"/GameImages/Club-" + i + ".png"));
			hands.getDealerCards().add(card);
		}
		assertEquals(14, hands.getDealerScore());
	}

	@Test
	public void testDealer3AcesScore() {
		for (int i = 0; i < 3; i++) {
			card = new Card(CardType.values()[i], 1, new String(
					"/GameImages/Club-" + i + ".png"));
			hands.getDealerCards().add(card);
		}
		assertEquals(13, hands.getDealerScore());
	}

	@Test
	public void testDealerAceAndRoylaty() {

		card = new Card(CardType.values()[0], 1, new String("/GameImages/Club-"
				+ 0 + ".png"));
		hands.getDealerCards().add(card);
		card = new Card(CardType.values()[0], 11, new String(
				"/GameImages/Club-" + 0 + ".png"));
		hands.getDealerCards().add(card);
		assertEquals(21, hands.getDealerScore());
	}

	@Test
	public void testDealerAceAs1() {

		card = new Card(CardType.values()[0], 10, new String(
				"/GameImages/Club-" + 0 + ".png"));
		hands.getDealerCards().add(card);
		card = new Card(CardType.values()[1], 4, new String("/GameImages/Club-"
				+ 1 + ".png"));
		hands.getDealerCards().add(card);
		card = new Card(CardType.values()[1], 1, new String("/GameImages/Club-"
				+ 1 + ".png"));
		hands.getDealerCards().add(card);
		assertEquals(15, hands.getDealerScore());
	}

	@Test
	public void testPlayer4AcesScore() {
		for (int i = 0; i < 4; i++) {
			card = new Card(CardType.values()[i], 1, new String(
					"/GameImages/Club-" + i + ".png"));
			hands.getPlayerCards().add(card);
		}
		assertEquals(14, hands.getPlayerScore());
	}

	@Test
	public void testPlayer3AcesScore() {
		for (int i = 0; i < 3; i++) {
			card = new Card(CardType.values()[i], 1, new String(
					"/GameImages/Club-" + i + ".png"));
			hands.getPlayerCards().add(card);
		}
		assertEquals(13, hands.getPlayerScore());
	}

	@Test
	public void testPlayerAceAndRoylaty() {

		card = new Card(CardType.values()[0], 1, new String("/GameImages/Club-"
				+ 0 + ".png"));
		hands.getPlayerCards().add(card);
		card = new Card(CardType.values()[0], 11, new String(
				"/GameImages/Club-" + 0 + ".png"));
		hands.getPlayerCards().add(card);
		assertEquals(21, hands.getPlayerScore());
	}

	@Test
	public void testPlayerAceAs11And1() {


		card = new Card(CardType.values()[1], 4, new String("/GameImages/Club-"
				+ 1 + ".png"));
		hands.getPlayerCards().add(card);
		card = new Card(CardType.values()[1], 1, new String("/GameImages/Club-"
				+ 1 + ".png"));
		hands.getPlayerCards().add(card);
		card = new Card(CardType.values()[0], 1, new String("/GameImages/Club-"
				+ 0 + ".png"));
		hands.getPlayerCards().add(card);
		assertEquals(16, hands.getPlayerScore());
	}
}
