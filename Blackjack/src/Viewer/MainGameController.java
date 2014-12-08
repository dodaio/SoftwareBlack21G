/**
 * 
 */
package Viewer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Control the main game
 *
 */
public class MainGameController extends AnchorPane implements Initializable {

	@FXML
	TextField txt_Dcard1;
	@FXML
	TextField txt_Dcard2;
	@FXML
	TextField txt_Dcard3;
	
	@FXML
	TextField txt_Pcard1;
	@FXML
	TextField txt_Pcard2;
	@FXML
	TextField txt_Pcard3;
	
	@FXML
	Label Massegelbl;
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txt_Dcard1.setText("Hidden");
		txt_Dcard2.setText("Some Card");
		txt_Dcard3.setText("None");
		
		txt_Pcard1.setText("Empty");
		txt_Pcard2.setText("Empty");
		txt_Pcard3.setText("Empty");
		
		Massegelbl.setText("Whoooooo");
		
	}
	
	
	
	@FXML
	private void Exit(){
		System.exit(0);
	}
	
	@FXML
	private void HandleHit(ActionEvent ex){
		Massegelbl.setText("Hit");
	}
	
	@FXML
	private void HandleDeal(ActionEvent ex){
		Massegelbl.setText("Deal");
	}
	
	@FXML
	private void HandleStand(ActionEvent ex){
		Massegelbl.setText("Stand");
	}
	

}
