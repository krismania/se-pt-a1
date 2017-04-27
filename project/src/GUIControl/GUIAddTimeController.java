/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControl;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import main.Account;
import javafx.scene.Parent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

/**
 * FXML Controller class
 *
 * @author tn
 */
public class GUIAddTimeController implements Initializable {


    @FXML
    private Button exit;

    @FXML
    private Button navMenu;

    @FXML
    private Button btRecordAvail;
    
    @FXML
	private DatePicker datePicker;
    
    @FXML
    private ChoiceBox<String> shiftDropdown;
    
    @FXML
    private ChoiceBox<String> durationDropdown;

	
    @FXML
    //TN - Button to close app.
    private void closeButtonAction(ActionEvent event) throws IOException {
    	Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void navMenuButtonAction(ActionEvent event) throws IOException {
    	Stage stage = (Stage) navMenu.getScene().getWindow();
		// load the scene
		Scene boMenu = new Scene(FXMLLoader.load(getClass().getResource("GUIBOMenu.fxml")));
		
		// switch scenes
		stage.setScene(boMenu);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
	
    //TN Collect DatePicker data and also timestamp	
    LocalDate localDate = datePicker.getValue();
	Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
	Date date = (Date) Date.from(instant);
	//TN Test datepicker output in console
	System.out.println(localDate + "\n" + instant + "\n" + date);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	//TN - initialise shift time slot dropdown menus
    	shiftDropdown.getItems().removeAll(shiftDropdown.getItems());
        shiftDropdown.getItems().addAll("9:00 am", "9:30 am", "10:00 am", "10:30 am", 
        		"11:00 am", "11:30 pm", "12:00 pm", "12:30 pm", "1:00 pm", "1:30 pm", 
        		"2:00 pm", "2:30 pm", "3:00 pm", "3:30 pm", "4:00 pm", "4:30pm", "5:00 pm");
        shiftDropdown.getSelectionModel().select("9:00 am");
        
        //TN - initialise shift duration dropdown menus
        durationDropdown.getItems().removeAll(durationDropdown.getItems());
        durationDropdown.getItems().addAll("30 minutes", "1 hour", 
        		"1 hour 30 minutes", "2 hours");
        durationDropdown.getSelectionModel().select("30 minutes");
    }

    /* @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
    Stage stage;
    Parent root;
    if(event.getSource()==btRecordAvail) {
        //TN - Need to implement capture data and send to method
    	Account account = c.login(shiftDropdown.getText(), durationDropdown.getText());
        //TN - Directs to confirmation scene
        stage=(Stage) btRecordAvail.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("GUIAddShift.fxml")); 
     }
     else
     {
         stage=(Stage) menu.getScene().getWindow();
         root = FXMLLoader.load(getClass().getResource("GUIBOMenu.fxml"));
     } 
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.show(); 
 }   */
}
