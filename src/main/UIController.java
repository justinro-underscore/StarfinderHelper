package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Controls the user interaction for StarFinderHelper
 *
 * @author Justin Roderman
 * @since October 5, 2018
 */

public class UIController extends Application
{
	@FXML Label lblPlayerName;
	@FXML Label lblCurrPage;
	private Image arrow = new Image("file:res/arrow.png");
	@FXML private ImageView imgLeft;
	@FXML private ImageView imgRight;

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
	public void start(Stage arg0) throws IOException
	{
		FXMLLoader load = new FXMLLoader(getClass().getResource("StarfinderUI.fxml")); // You may have to change the path in order to access StarfinderUI.fxml
		load.setController(this); // Makes it so that you can control the UI using this class

		Parent root = (Parent) load.load();
		Scene scene = new Scene(root);

		// Start the application
		Stage stage = new Stage();
		stage.setTitle("Starfinder Helper");
		stage.setScene(scene);
		initializeUI();

		stage.show();
	}

	/**
	 * Initializes all aspects of the UI
	 */
	private void initializeUI()
	{
		lblPlayerName.setText(PlayerRunner.player.getName());
		lblCurrPage.setText("Equipment");
		imgLeft.setImage(arrow);
		imgRight.setImage(arrow);
	}
}
