package main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.user.Player;

/**
 * Controls the user interaction for StarFinderHelper
 *
 * @author Justin Roderman
 * @since October 5, 2018
 */

public class UIController extends Application
{
	private Player player;

	@FXML Label lblPlayerName;
	@FXML Label lblCurrPage;
	private Image arrow = new Image("file:res/arrow.png");
	@FXML private ImageView imgLeft;
	@FXML private ImageView imgRight;

	@FXML protected GridPane grdEquipment;
	@FXML protected Label lblPlayerCredits;
	@FXML protected TextField txtCredits;
	@FXML protected Button btnAddCredits;
	@FXML protected Button btnRemCredits;

	@FXML protected Button btnAddEquipment;
	@FXML protected Button btnRemEquipment;

	/**
	 * Where the application launches from
	 * @param args What is passed in (don't worry about this)
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

	/**
	 * Where the application launches from
	 * @throws IOException If an input or output exception occurred
	 */

	@Override
	public void start(Stage arg0) throws Exception
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("StarfinderUI.fxml")); // You may have to change the path in order to access StarfinderUI.fxml
		load.setController(this); // Makes it so that you can control the UI using this class

		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		// Start the application
		Stage stage = new Stage();
		stage.setTitle("Starfinder Helper");
		stage.setScene(scene);
		initializeVariables();
		initializeUI();

		stage.show();
	}

	private void initializeVariables()
	{
		player = new Player("Jonh");
	}

	/**
	 * Initializes all aspects of the UI
	 */
	private void initializeUI()
	{
		lblPlayerName.setText("Jonh");
		lblPlayerCredits.textProperty().bind(player.getCreditsProp().asString());
		lblCurrPage.setText("Equipment");
		imgLeft.setImage(arrow);
		imgRight.setImage(arrow);

		btnAddCredits.setOnAction(e -> {
			String creds = txtCredits.getText().trim();
			if(creds.isEmpty())
				player.addCredits(1);
			else
			{
				try { player.addCredits(Integer.parseInt(creds)); }
				catch(NumberFormatException e1) {}
			}
		});
		btnRemCredits.setOnAction(e -> {
			String creds = txtCredits.getText().trim();
			if(creds.isEmpty())
				player.addCredits(-1);
			else
			{
				try { player.addCredits(-1 * Integer.parseInt(creds)); }
				catch(NumberFormatException e1) {}
			}
		});
	}
}
