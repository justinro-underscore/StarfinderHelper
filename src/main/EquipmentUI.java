package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Controls the user interaction for StarFinderHelper
 *
 * @author Justin Roderman
 * @since October 21, 2018
 */

public class EquipmentUI implements Initializable
{
	@FXML private GridPane grdEquipment;
	@FXML private Label lblPlayerCredits;
	@FXML private TextField txtCredits;
	@FXML private Button btnSetCredits;
	@FXML private Button btnAddCredits;
	@FXML private Button btnRemCredits;

	@FXML private Button btnAddEquipment;
	@FXML private Button btnRemEquipment;

	/**
	 * Runs when the EquipmentUI is initialized
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
        initializeUI();
	}

	/**
	 * Initializes all aspects of the UI
	 */
	private void initializeUI()
	{
		lblPlayerCredits.textProperty().bind(PlayerRunner.player.getCreditsProp().asString());
		btnSetCredits.setOnAction(e -> {
			String creds = txtCredits.getText().trim();
			if(!creds.isEmpty())
			{
				try { PlayerRunner.player.setCredits(Integer.parseInt(creds)); }
				catch(NumberFormatException e1) {}
			}
			txtCredits.clear();
		});
		btnAddCredits.setOnAction(e -> {
			String creds = txtCredits.getText().trim();
			if(creds.isEmpty())
				PlayerRunner.player.addCredits(1);
			else
			{
				try { PlayerRunner.player.addCredits(Integer.parseInt(creds)); }
				catch(NumberFormatException e1) {}
			}
			txtCredits.clear();
		});
		btnRemCredits.setOnAction(e -> {
			String creds = txtCredits.getText().trim();
			if(creds.isEmpty())
				PlayerRunner.player.addCredits(-1);
			else
			{
				try { PlayerRunner.player.addCredits(-1 * Integer.parseInt(creds)); }
				catch(NumberFormatException e1) {}
			}
			txtCredits.clear();
		});
	}
}
