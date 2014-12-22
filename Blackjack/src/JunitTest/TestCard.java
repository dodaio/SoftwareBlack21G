package JunitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Card;
import Model.CardType;
/*
 * This test class is designed to the Card class.
 * test equals for card: various combinations of values and types.
 */
public class TestCard {
	
	Card card1;
	Card card2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSameTypeDifferentValue() {
		card1 = new Card(CardType.Club, 10, "/GameImages/Club-10.png");
		card2 = new Card(CardType.Club, 5, "/GameImages/Club-5.png"); 
		assertNotEquals(card1, card2);
	}
	
	@Test
	public void testSameValueDifferentType() {
		card1 = new Card(CardType.Club, 10, "/GameImages/Club-10.png");
		card2 = new Card(CardType.Spade, 10, "/GameImages/Club-5.png"); 
		assertNotEquals(card1, card2);
	}
	
	@Test
	public void testSameCards() {
		card1 = new Card(CardType.Club, 10, "/GameImages/Club-10.png");
		card2 = new Card(CardType.Club, 10, "/GameImages/Club-5.png"); 
		assertEquals(card1, card2);
	}

}
