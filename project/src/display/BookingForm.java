package display;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import main.Controller;
import main.Validate;
import model.Account;
import model.BusinessOwner;
import model.Customer;
import javafx.scene.Parent;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
//TN - Provides GUI functionality to create a booking
public class BookingForm
{
    Controller c = Controller.getInstance();
    private String customerUsername = null;
    @FXML private Label lblError;
    @FXML private Label customerLabel;
    @FXML private TextField customerUser;
    @FXML private Button navMenu;
    @FXML private Button submitBooking;
    @FXML private DatePicker datePicker;
    @FXML private ChoiceBox<String> employeePicker;
    @FXML private ChoiceBox<String> bookingOptionsDropdown;
    @FXML private Label TitleOfDetails;
    @FXML private Label Email;
    @FXML private Label Phone;
    @FXML private Label Name;
    @FXML private Label customerEmail;
    @FXML private Label customerPhone;
    @FXML private Label customerName;
   
    @FXML
    public void initialize()
    {
    	//TN - Not yet required, Stub for future initializers.
    }
    //TN - Implements Back button for application navigation
    @FXML 
    public void handleBack(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) navMenu.getScene().getWindow();
        // load the scene
        Scene accountMenu;
        if(c.getLoggedUser() instanceof Customer)
        {
            accountMenu = new Scene(FXMLLoader.load(getClass().getResource("CustMenu.fxml")));
        }
        else
        {
            accountMenu = new Scene(FXMLLoader.load(getClass().getResource("BOMenu.fxml")));
        }
        // switch scenes
        stage.setScene(accountMenu);
    }
    //TN - Handles booking process button action
    @FXML
    private void handleBook(ActionEvent event) throws IOException{
        if(c.getLoggedUser() instanceof BusinessOwner && customerUser.getText().isEmpty())
        {
            System.out.println("Cannot process a booking without customer name");
        }
        else
        {
            boolean booked = c.addBooking(datePicker.getValue(), 
            		LocalTime.parse(bookingOptionsDropdown.getValue()), 
    				Integer.parseInt(employeePicker.getValue()), customerUser.getText());
            if(booked)
            {
                GUIAlert.infoBox("Booking Successful", "Booking Confirmation");
            }
            else 
            {
                GUIAlert.infoBox("Booking was not successful. Please ensure you"
                		+ " have not already booked this date.", "Booking Confirmation");
            }
        }
    }
    //TN - Handles date selection 
    @FXML
    public void handleDateChange(ActionEvent event)
    {
        employeePicker.getSelectionModel().clearSelection();
        bookingOptionsDropdown.getSelectionModel().clearSelection();
        generateEmployeesByDate();
        if(c.getLoggedUser() instanceof BusinessOwner) 
        {
            customerLabel.setVisible(true);
            customerUser.setVisible(true);
            TitleOfDetails.setVisible(true);
    	    Email.setVisible(true);
            Phone.setVisible(true);
            Name.setVisible(true);
        }
    }
    //TN - Handles Available times dropdaown options by context
    @FXML
    public void handleEmployeeChange(ActionEvent event)
    {
        bookingOptionsDropdown.getSelectionModel().clearSelection();
        generateTimesByEmp();
    }
    
    @FXML
    public void handleTimeChange(ActionEvent event)
    {
        if(c.loggedUser instanceof Customer)
        {
            if (bookingOptionsDropdown.getSelectionModel().getSelectedItem() != null)
            {
                submitBooking.setDisable(false);
            }
            else
            {
                submitBooking.setDisable(true);
            }
        }
    }
    //TN - Pulls Customers from controller to populate GUI list
    @FXML
    private void generateCustomerList()
    {
        Customer customer = c.getCustomer(customerUser.getText());
        if (customer != null)
        {
            submitBooking.setDisable(false);
            lblError.setVisible(false);
            customerName.setVisible(true);
            customerName.setText(customer.getFirstName() + " " + customer.getLastName());
            customerEmail.setVisible(true);
            customerEmail.setText(customer.getEmail());
            customerPhone.setVisible(true);
            customerPhone.setText(customer.getPhoneNumber());
        }
        else
        {
            submitBooking.setDisable(true); 
            lblError.setVisible(true);
            customerName.setVisible(false);
            customerEmail.setVisible(false);
            customerPhone.setVisible(false);
        }
    }
    //TN - Context menu to generate employees by selected dates and availability
    @FXML
    private void generateEmployeesByDate()
    {
        LocalDate day = datePicker.getValue();
        employeePicker.getItems().removeAll(employeePicker.getItems());
    	
        if(day.isBefore(LocalDate.now())) {
            System.out.println("Date has passed.");
            employeePicker.getItems().addAll("Please select today or a date in the future");
        }
    	else 
    	{
            ArrayList<String> empIDs = c.getEmpByDay(day);
            if(empIDs.isEmpty())
            {
                employeePicker.getItems().addAll("No employees working on selected date");
            }
            else 
            {
                employeePicker.getItems().addAll(empIDs);
            }
        }
    }
    //TN - Context menu to generate employees by selected times based on employees availability
    @FXML
    private void generateTimesByEmp()
    {
        ArrayList<String> times = c.getShiftsByEmp(employeePicker.getValue(), datePicker.getValue());
        bookingOptionsDropdown.getItems().removeAll(bookingOptionsDropdown.getItems());
        bookingOptionsDropdown.getItems().addAll(times);
    }
    //Stub - not required yet
    public void initialize(URL url, ResourceBundle rb)
	{
        //TN - initialize screen output - no need for implementation yet
	}
}