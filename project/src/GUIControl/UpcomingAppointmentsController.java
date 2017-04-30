package GUIControl;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import main.Booking;

/**
 * Customer screen to view their upcoming bookings
 * @author krismania
 */
public class UpcomingAppointmentsController
{
	@FXML Node root;
	
	@FXML TableColumn<Booking, String> date;
	@FXML TableColumn<Booking, String> time;
	@FXML TableColumn<Booking, String> employee;
	
	@FXML
	public void handleBack(ActionEvent event)
	{
		switchTo("GUICustMenu");
	}
	
	/**
	 * @author krismania
	 */
	private void switchTo(String fxmlName)
	{
		try
		{
			// load the scene
			Scene newScene = new Scene(FXMLLoader.load(getClass().getResource(fxmlName + ".fxml")));
			
			// get current stage
			Stage stage = (Stage) root.getScene().getWindow();
			
			// switch scenes
			stage.setScene(newScene);
		}
		catch (IOException e)
		{
			System.out.println("Could not switch scene.");
			e.printStackTrace();
		}
	}
}