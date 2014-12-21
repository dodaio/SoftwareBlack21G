package Model;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import Controller.ControllerLogic;

/*
 * This test class is designed to the ModelLogic class.
 * test correction of the method calculteGameResualt() in the Model.
 * Especially check tie, and busted hands.
 */
public class TestResultCalculating {
	
	static ModelLogic model;
	static ControllerLogic controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controller = null ;
		model = new ModelLogic(controller );
	}

	@Test
	public void testTieUnder17() {
		
		assertFalse(model.calculteGameResualt(15, 15));
	}
	
	@Test
	public void testTieSoft17() {
		
		assertFalse(model.calculteGameResualt(17, 17));
	}
	
	@Test
	public void testTieOver17() {
		
		assertFalse(model.calculteGameResualt(19, 19));
	}
	
	@Test
	public void testTie21() {
		
		assertFalse(model.calculteGameResualt(21, 21));
	}
	
	@Test
	public void testDealerWin() {
		
		assertFalse(model.calculteGameResualt(20, 17));
	}
	
	@Test
	public void testPlayerWin() {
		
		assertTrue(model.calculteGameResualt(17, 20));
	}
	
	@Test
	public void testDealerWinWith21() {
		
		assertFalse(model.calculteGameResualt(21, 17));
	}
	
	@Test
	public void testPlayerWinWith21() {
		
		assertTrue(model.calculteGameResualt(17, 21));
	}
	
	@Test
	public void testDealerBust() {
		
		assertTrue(model.calculteGameResualt(22, 17));
	}
	
	@Test
	public void testPlayerBust() {
		
		assertFalse(model.calculteGameResualt(17, 22));
	}
	
	@Test
	public void testDealerBustWithPlayerAt21() {
		
		assertTrue(model.calculteGameResualt(22, 21));
	}
	
	@Test
	public void testPlayerBustWithDealerAt21() {
		
		assertFalse(model.calculteGameResualt(21, 22));
	}
}
