package JunitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * The main suite case for the tests.
 * Test classes: 
 * 		ModelLogic
 * 		Hand
 * 		Deck
 * 		Card
 * Almost all of the method that are worth testing are in the Model package,
 * and some of them are protected and for that the testing classes located in this package.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestCard.class, TestDeck.class, TestResultCalculating.class,
		TestScoreCalculating.class })
public class AllModelTests {

}
