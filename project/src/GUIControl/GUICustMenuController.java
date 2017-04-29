/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControl;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import main.Controller;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author tn
 */
public class GUICustMenuController implements Initializable {

	private Controller c = Controller.getInstance();
	
	@FXML
	private Button viewAvailCust;
	
	@FXML
	private Button makeBooking;
    
    @FXML
    private Button logout;
    /**
     * Initializes the controller class.
     */
  
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
       	//TN - get reference button stage
        Stage stage = (Stage) viewAvailCust.getScene().getWindow();
       	//TN - load other scene
        Parent root = FXMLLoader.load(getClass().getResource("GUICustViewAvail.fxml"));
   
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void logoutButtonAction(ActionEvent event) throws IOException {
    	c.logout();
    	
    	Stage stage = (Stage) logout.getScene().getWindow();
    	
    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	   
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleBookingAction(ActionEvent event) throws IOException {
       	//TN - get reference button stage
        Stage stage = (Stage) makeBooking.getScene().getWindow();
       	//TN - load other scene
        Parent root = FXMLLoader.load(getClass().getResource("GUIBooking.fxml"));
   
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Opens the ViewCustomerDetails screen
     * @author krismania
     */
    @FXML
    public void handleViewDetails(ActionEvent event) throws IOException
    {
    	Node source = (Node) event.getSource();
    	Stage stage = (Stage) source.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("ViewCustomerDetails.fxml"));
    	
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}