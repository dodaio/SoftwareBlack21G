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
	
	
	/**
	 * pass hit button clicked to model
	 */
	public void onHitClick() {
		model.hit();
	}

	/**
	 * pass deal button clicked to model
	 */
	public void onDealClick() {
		model.deal();
	}

	/**
	 * pass stand button clicked to model
	 */
	public void onStandClick() {
		model.stand();
	}
	
	/**
	 * pass New Game button clicked to model
	 */
	public void onNewGameClick() {
		model.newSession();
	}

	/**
	 * pass round result to view
	 */
	public void printGameResualt(boolean result, String msg) {
		view.printGameResult(result, msg);
	}

	/**
	 * pass score result to view
	 */
	public void updatePlayerScore(int score) {
		view.updatePlayerScore(score);
	}

	/**
	 * pass score result to view
	 */
	public void updateDealerScore(int score) {
		view.updateDealerScore(score);
	}

	/**
	 * pass cards to view
	 */
	public void updatePlayerCards(List<Model.Card> cards) {
		view.updatePlayerCards(cards);
	}

	/**
	 * pass cards to view
	 */
	public void updateDealerCards(List<Model.Card> cards) {
		view.updateDealerCards(cards);
	}
	
	/**
	 * Update WinsAndLoses
	 */
	public void updateWinsAndLoses(int wins, int loses){
		view.updateWinsAndLoses(wins, loses);
	}
	
	/**
	 * Update Score to theScreen
	 */
	public void updateScore(int score){
		view.updateScore(score);
	}

	/**
	 * Sets DEAL button visibility
	 * 
	 * @param visible
	 *            true to set visible, false to disable
	 */
	public void dealBtnVisability(boolean visible) {
		view.dealBtnVisability(visible);
	}

	/**
	 * Sets HIT button visibility
	 * 
	 * @param visible
	 *            true to set visible, false to disable
	 */
	public void hitBtnVisability(boolean visible) {
		view.hitBtnVisability(visible);
	}

	/**
	 * Sets hit AND STAND button visibility
	 * 
	 * @param visible
	 *            true to set visible, false to disable
	 */
	public void hitAndStandBtnVisability(boolean visible) {
		view.hitAndStandBtnVisability(visible);
	}
	
	/**
	 * Handle music menu button click
	 * @param status true if on
	 */
	public void onMusicMenuClick(boolean status) {
		model.setMusicSetting(status);
	}
	
	/**
	 * Handle sound effects menu button click
	 * @param status true if on
	 */
	public void onEffectsMenuClick(boolean status) {
		model.setSoundEffectsSetting(status);
	}

	/**
	 * Reset game board
	 */
	public void resetGameOnUI() {
		view.resetGameOnUI();
	}

	/**
	 * Change dealer's first card visibility
	 * @param visible true for visible, false for hidden
	 */
	public void showDealerFirstCard(boolean visible) {
		view.showDealerFirstCard(visible);
	}
	
	/**
	 * Restaet the game - new game button pressed
	 */
	public void RestartGame(){
		view.RestartGame();
	}
	
	/**
	 * Exit
	 */
	public void executeSysExit() {
		System.exit(0);
	}
	
	/**
	 * PlaySoundEffect
	 */
	public void butttonSound() {
		model.butttonSound();
	}

}
