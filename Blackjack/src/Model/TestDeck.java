package Model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * This test class is designed to the Deck class.
 * test durability in unlikely case that card array index gets out of bound.
 */
public class TestDeck {
	
	Deck deck ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		deck = new Deck();	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOutOfBoundOver52() {
		Deck.deckIndex = 60;
		assertNotNull(deck.getCard());
	}
	
	@Test
	public void testOutOfBoundUnder0() {
		Deck.deckIndex = -10;
		assertNotNull(deck.getCard());
	}

}
