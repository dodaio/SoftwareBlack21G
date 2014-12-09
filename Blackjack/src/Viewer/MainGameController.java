/**
 * 
 */
package Viewer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * Control the main game
 *
 */
public class MainGameController extends AnchorPane implements Initializable {

//	@FXML
//	TextField txt_Dcard1;
//	@FXML
//	TextField txt_Dcard2;
//	@FXML
//	TextField txt_Dcard3;
//	
//	@FXML
//	TextField txt_Pcard1;
//	@FXML
//	TextField txt_Pcard2;
//	@FXML
//	TextField txt_Pcard3;
	
	@FXML
	Label Massegelbl;
	
	//*******************************Dealer variables************************************
	@FXML
	Label MassegelblD1;
	@FXML
	Label MassegelblD2;
	@FXML
	Label MassegelblD3;
	@FXML
	Label lblHeaderD3;
	
	//*******************************Player variables************************************
	
	@FXML
	Label Massegelblp1;
	@FXML
	Label Massegelblp2;
	@FXML
	Label Massegelblp3;
	@FXML
	Label lblHeaderP3;
	
	
	
	//*******************************Initialize************************************

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MassegelblD1.setText("Hidden");
		MassegelblD2.setText("Some Card");
		//MassegelblD3.setText("None");
		
		Massegelblp1.setText("Empty");
		Massegelblp2.setText("Empty");
		//Massegelblp3.setText("Empty");
		
		Massegelbl.setText("Whoooooo");
		
	}
	
	
	
	@FXML
	private void Exit(){
		System.exit(0);
	}
	
	@FXML
	private void onHitClick(){
		Massegelbl.setText("Hit");
	}
	
	@FXML
	private void onDealClick(){
		Massegelbl.setText("Deal");
	}
	
	@FXML
	private void onStandClick(){
		Massegelbl.setText("Stand");
	}
	

}
