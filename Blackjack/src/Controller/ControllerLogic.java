package Controller;

import Model.ModelLogic;
import Viewer.ViewLogic;
import javafx.stage.Stage;



public class ControllerLogic {

	//***************************************** Variables *********************************************
	
	private static ControllerLogic instance;

	private ModelLogic model;

	private static ViewLogic view;
	
	public static ControllerLogic controller;
	
	private static Stage primarystage;

	
	
	
	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor. 
	 */
	public ControllerLogic(Stage stg) {
	
		instance = this;
		primarystage = stg;
		controller=instance;
		model = new ModelLogic();
		view= new ViewLogic(controller);
		view.executeLoginView(primarystage);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
