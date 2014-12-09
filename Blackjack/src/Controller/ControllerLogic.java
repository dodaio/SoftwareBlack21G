package Controller;

import java.util.List;

import Model.ModelLogic;
import Viewer.ViewLogic;
import javafx.stage.Stage;

public class ControllerLogic {

	// ***************************************** Variables
	// *********************************************

	private static ControllerLogic instance;

	private ModelLogic model;

	private static ViewLogic view;

	public static ControllerLogic controller;

	private static Stage primarystage;

	// ***************************************** Constructors
	// ******************************************
	/**
	 * Full C'tor.
	 */
	public ControllerLogic(Stage stg) {

		instance = this;
		primarystage = stg;
		controller = instance;
		model = new ModelLogic(controller);
		view = new ViewLogic(controller);
		view.executeLoginView(primarystage);
	}

	public void onHitClick() {
		model.hit();
	}

	public void onDealClick() {
		model.deal();
	}

	public void onStandClick() {
		model.stand();
	}

	public void printGameResualt(boolean result, String msg) {
		view.printGameResult(result, msg);
	}
	
	public void updatePlayerScore(int score) {
		view.updatePlayerScore(score);
	}
	
	public void updateDealerScore(int score) {
		view.updateDealerScore(score);
	}
	
	public void updatePlayerCards(List<Model.Card> cards) {
		view.updatePlayerCards(cards);
	}
	
	public void updateDealerCards(List<Model.Card> cards) {
		view.updateDealerCards(cards);
	}
	
	

}
