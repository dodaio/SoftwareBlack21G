package Viewer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class AboutController extends AnchorPane implements Initializable {


	@FXML
	TextArea Orders;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		Orders.setText("Objective \n\n\n"
				+ "The objective of the game is to beat the dealer. \n"
				+ "If your cards total higher than the dealer's cards without going over 21 you win. \n"
				+ "You are not trying to get close to 21. \n"
				+ "If your hand or the dealer's hand goes over 21 you Bust. \n"
				+ "If you bust you automatically lose. \n"
				+ "If the dealer busts and you do not you win. \n"
				+ "The player must act first. \n"
				+ "If the player busts he loses regardless if the dealer busts or not.\n"
				+ "in the case of a tie score the dealer wins.\n"
				+ "Card Values\n\n"
				+ "The suits of the cards have no effect on the game.\n"
				+ "Cards 2 - 10 are counted at face value without regards to their suit.\n"
				+ "All face cards have a value of ten.\n"
				+ "An ace can count as either one or eleven.\n"
				+ "An ace and a five would total either 6 or 16.\n"
				+ "A hand that does not have an ace is referred to as a Hard Hand because it has only one value.\n"
				+ "A hand that contains an ace is referred to as a Soft Hand because the value can change.\n"
				+ "If you draw to a soft hand and the three cards total a number where counting an ace as eleven puts you over 21 then the hand becomes a hard hand.\n"
				+ "Example: You are dealt an ace and a three.\n"
				+ "You have 4 or 14. If you then draw a ten you now have a hard 14 because if you count the ace as 11 you would have 25, which would bust you.\n"
				+ "Blackjack If you or the dealer is dealt an Ace and a ten-value card you have 21 known as a blackjack. This is a natural.\n"
				+ "If you and the dealer have blackjack he won.\n"
				+ "If only the dealer has blackjack all players will lose, else the player win.\n"
				+ "Deal When the player will hit the eal button he and the dealer will get cards from the deck, while the 2 cards of the player reveal one of the dealer is stays upside down."
				+ "Hitting To take a hit means that you want to draw another card.\n"
				+ "To signal the dealer for another card after the first you would hit the hit button entail you will push the stand button or Bust.\n"
				+ "Standing Once you are satisfied with either your first two cards or after hitting, you will hit the stand button the dealer than will reveal his hand."
				);
		
		Orders.setStyle("-fx-background-color: DARKGRAY;"
                + "-fx-text-fill: BLACK;"
                + "-fx-font-size: 12pt;");
		
		Orders.setEditable(false);
	
	}
	

	public AboutController() {
	}

}
