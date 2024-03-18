package oosd2assignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class GUIController implements Initializable {
    
    @FXML
    private Button createButton;
    
    @FXML
    private Button deleteButton;
    
    @FXML
    private TextField leaseNumber;
    
    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField studentNumber;
    
    @FXML
    private TextField mobileNumber;

    @FXML
    private TextField telephone;
    
    @FXML
    private TextField hallManager;
    
    @FXML
    private TextField accommNo;
    
    @FXML
    private TextField type;
    
    @FXML
    private TextField price;
    
    @FXML
    private TextField occupancy;
    
    @FXML
    private TextField itemsIncluded;

    @FXML
    private TableView<Accommodation> accommodationTableView;

    @FXML
    private TableColumn<Accommodation, String> noColumn;

    @FXML
    private TableColumn<Accommodation, String> typeColumn;

    @FXML
    private TableColumn<Accommodation, String> priceColumn;

    @FXML
    private TableColumn<Accommodation, String> availabilityColumn;

    @FXML
    private TableColumn<Accommodation, String> statusColumn;

    @FXML
    private TextField totalRooms;

    @FXML
    private TextField availableRooms;

    @FXML
    private TextField offlineRooms;

    @FXML
    private TextField requiresCleaning;

    @FXML
    private ComboBox<String> hallComboBox; // ComboBox to display hall names
    
    @FXML
    private ComboBox<String> cleaningStatusComboBox; // ComboBox to display cleaning status name

    private ArrayList<Hall> halls; // ArrayList to store hall instances
    private ArrayList<RentalAgreement> rentalAgreements;
    
    public int itemCount;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (rentalAgreements != null){
                    itemCount = (rentalAgreements.size());
                    leaseNumber.setText(String.valueOf(itemCount));
                } else {
                    leaseNumber.clear();
                }
        
        // Initialize the ArrayList
        halls = new ArrayList<>();
        rentalAgreements = new ArrayList<>();
        
        cleaningStatusComboBox.getItems().addAll("Clean", "Dirty", "Offline");
        
        cleaningStatusComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
            if (newValue != null) {
                System.out.println("Selected Option: " + newValue);
                
                String hallName = hallComboBox.getValue();

                // Find the selected hall by its name
                Hall selectedHall = null;
                for (Hall hall : halls) {
                    if (hall.getHallName().equals(hallName)) {
                        selectedHall = hall;
                        break;
                    }
                }

                // Find the selected accommodation
                Accommodation selectedAccommodation = accommodationTableView.getSelectionModel().getSelectedItem();

                if (selectedAccommodation != null) {
                    ObservableList<Accommodation> accommodationList = FXCollections.observableArrayList(selectedHall.getAccommodations());
                    switch (newValue) {
                        case "Clean":
                            selectedAccommodation.setCleaningStatus("Clean");
                            selectedAccommodation.setAvailability("Available");
                            offlineRooms.setText(String.valueOf(selectedHall.getRoomsOffline()));
                            availableRooms.setText(String.valueOf(selectedHall.getAvailableRooms()));
                            requiresCleaning.setText(String.valueOf(selectedHall.getRoomsReqCleaning()));
                            
                            accommodationList.set(accommodationList.indexOf(selectedAccommodation), selectedAccommodation);
                            // Set the updated list to the TableView
                            accommodationTableView.refresh();
                            break;
                        case "Dirty":
                            selectedAccommodation.setCleaningStatus("Dirty");
                            selectedAccommodation.setAvailability("Unavailable");
                            // Update the list to reflect the change
                            // Update offline rooms, available rooms, and require cleaning rooms
                            offlineRooms.setText(String.valueOf(selectedHall.getRoomsOffline()));
                            availableRooms.setText(String.valueOf(selectedHall.getAvailableRooms()));
                            requiresCleaning.setText(String.valueOf(selectedHall.getRoomsReqCleaning()));
                            
                            
                            accommodationList.set(accommodationList.indexOf(selectedAccommodation), selectedAccommodation);
                            // Set the updated list to the TableView
                            accommodationTableView.refresh();
                            break;
                        case "Offline":
                            selectedAccommodation.setCleaningStatus("Offline");
                            selectedAccommodation.setAvailability("Unavailable");
                            // Update the list to reflect the change
                            
                            offlineRooms.setText(String.valueOf(selectedHall.getRoomsOffline()));
                            availableRooms.setText(String.valueOf(selectedHall.getAvailableRooms()));
                            requiresCleaning.setText(String.valueOf(selectedHall.getRoomsReqCleaning()));
                            
                            accommodationList.set(accommodationList.indexOf(selectedAccommodation), selectedAccommodation);
                            // Set the updated list to the TableView
                            accommodationTableView.refresh();
                            break;
                        default:
                            // Handle default case if needed
                            break;
                    }
                }
                
            } else {
                System.out.println("No option selected.");
            }
        });

        // Create an event handler for the button
        EventHandler<ActionEvent> createEventHandler;

        createEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String firstNameValue = firstName.getText();
                String lastNameValue = lastName.getText();
                String mobileNumberValue = mobileNumber.getText();
                String studentNumberValue = studentNumber.getText();

                // Check if firstName, lastName, and mobileNumber are Strings and studentNumber is an integer
                if (firstNameValue instanceof String && 
                    lastNameValue instanceof String && 
                    mobileNumberValue instanceof String) {
                    if (!firstNameValue.trim().isEmpty() &&
                        !lastNameValue.trim().isEmpty() &&
                        !mobileNumberValue.trim().isEmpty()) {
                        try {

                            Accommodation selectedAccommodation = accommodationTableView.getSelectionModel().getSelectedItem();
                            if (selectedAccommodation.getAvailability() == "Available"){
                                // Attempt to parse studentNumberValue into an integer
                                int studentNumberInt = Integer.parseInt(studentNumberValue);
                                // If parsing succeeds, create the rental agreement
                                RentalAgreement newRentalAgreement = new RentalAgreement(itemCount, firstNameValue, lastNameValue, studentNumberInt, mobileNumberValue);
                                rentalAgreements.add(newRentalAgreement);

                                System.out.println("" + selectedAccommodation.getAvailability());
                                selectedAccommodation.setRentalAgreement(newRentalAgreement);
                                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                if (selectedAccommodation.getRentalAgreement() != null){
                                    selectedAccommodation.setAvailability("Unavailable"); 
                                }

                                occupancy.setText("Occupied");

                                Hall selectedHall = null;
                                String hallName = hallComboBox.getValue();
                                for (Hall hall : halls) {
                                    if (hall.getHallName().equals(hallName)) {
                                        selectedHall = hall;
                                        availableRooms.setText(String.valueOf(selectedHall.getAvailableRooms()));  
                                        ObservableList<Accommodation> accommodationList = FXCollections.observableArrayList(selectedHall.getAccommodations());
                                        accommodationTableView.setItems(accommodationList);
                                        accommodationTableView.refresh();
                                        break;
                                    }
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Room Unavailable");
                                alert.setHeaderText(null);
                                alert.setContentText("Please select an available accommodation to create a rental agreement");
                                alert.showAndWait();
                            }



                        } catch (NumberFormatException e) {
                            // If parsing fails, studentNumber is not an integer
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Number Validation Error");
                            alert.setHeaderText(null);
                            alert.setContentText("Please Ensure Student Number is a number");
                            alert.showAndWait();
                        }                        
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Fill in fields");
                        alert.setHeaderText(null);
                        alert.setContentText("Please make sure First Name, Last Name, and Mobile Number is filled in");
                        alert.showAndWait();
                    }

                } else {
                    // Handle the case where firstName, lastName, or mobileNumber are not Strings
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("String Validation Error");
                        alert.setHeaderText(null);
                        //Irrelevant Alert??
                        alert.setContentText("Please Ensure First Name and Last Name are Strings");
                        alert.showAndWait();
                }
            }
        };
        
        EventHandler<ActionEvent> deleteEventHandler;
        deleteEventHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Accommodation selectedAccommodation = accommodationTableView.getSelectionModel().getSelectedItem();
                selectedAccommodation.setRentalAgreement(null);
                selectedAccommodation.setAvailability("Available");
                occupancy.setText("Unnoccupied");
                
                itemCount = itemCount - 1;
                leaseNumber.setText(String.valueOf(itemCount));
                firstName.clear();
                lastName.clear();
                studentNumber.clear();
                mobileNumber.clear();
                Hall selectedHall = null;
                String hallName = hallComboBox.getValue();
                for (Hall hall : halls) {
                    if (hall.getHallName().equals(hallName)) {
                        selectedHall = hall;
                        availableRooms.setText(String.valueOf(selectedHall.getAvailableRooms()));
                        if (selectedAccommodation.getRentalAgreement() != null){
                            occupancy.setText("Occupied");
                        } 
                        break;
                    }
                }
                
                ObservableList<Accommodation> accommodationList = FXCollections.observableArrayList(selectedHall.getAccommodations());
                accommodationTableView.setItems(accommodationList);
                accommodationTableView.refresh();
            }
        };
        // Assuming anotherButton is the reference to your other button
        deleteButton.setOnAction(deleteEventHandler);
        
        createButton.setOnAction(createEventHandler);
        
        // Create instances of Hall and add their names to the ComboBox
        halls.add(new Hall("Brecon Court", "07123456789", "Joshua",40, 40, 0, 0));
        halls.add(new Hall("Cotswold Court", "07123456788", "John",40, 40, 0, 0));
        halls.add(new Hall("Mendip Court", "07123456787", "Elliot",40, 40, 0, 00));
        halls.add(new Hall("Quantock Court", "07123456786", "Yousseff",40, 40, 0, 0));

        for (Hall hall : halls) {
            hallComboBox.getItems().add(hall.getHallName()); // Add hall names to the ComboBox
        }

        // Set a listener for the ComboBox selection change event
        hallComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Find the selected hall by its name
                Hall selectedHall = null;
                for (Hall hall : halls) {
                    if (hall.getHallName().equals(newValue)) {
                        selectedHall = hall;
                        break;
                    }
                }
                // Update the telephone text field with the selected hall's telephone number
                if (selectedHall != null) {
                    telephone.setText(selectedHall.getHallTelNumber());
                    totalRooms.setText(String.valueOf(selectedHall.getTotalRooms()));
                    availableRooms.setText(String.valueOf(selectedHall.getAvailableRooms()));
                    offlineRooms.setText(String.valueOf(selectedHall.getRoomsOffline()));
                    requiresCleaning.setText(String.valueOf(selectedHall.getRoomsReqCleaning()));
                    hallManager.setText(String.valueOf(selectedHall.getHallManager()));
                    
                }

                // Populate the TableView with accommodation data
                if (selectedHall != null) {
                    ObservableList<Accommodation> accommodationList = FXCollections.observableArrayList(selectedHall.getAccommodations());
                    accommodationTableView.setItems(accommodationList);
                }
            }
        });

        // Set cell value factories for each column
        noColumn.setCellValueFactory(new PropertyValueFactory<>("accommNo"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("accommType"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));
        
        // Set a listener for TableView selection change event
        accommodationTableView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Accommodation> observable, Accommodation oldValue, Accommodation newValue) -> {
            if (newValue != null) {
                if (newValue.getRentalAgreement() != null){
                    occupancy.setText("Occupied");
                } else {
                    occupancy.setText("Unnoccupied");
                }
                itemCount = (rentalAgreements.size());
                leaseNumber.setText(String.valueOf(itemCount));
                // Set the accommNo TextField with the selected accommodation's accommNo
                accommNo.setText("" + newValue.getAccommNo());
                type.setText("" + newValue.getType());
                price.setText("" + newValue.getPrice());
                
                itemsIncluded.setText(newValue.getItemsIncluded());
                
                
                RentalAgreement rentalAgreement = newValue.getRentalAgreement();
                if (rentalAgreement != null) {
                    // Set the text of various text fields based on the rental agreement details
                    leaseNumber.setText(String.valueOf(rentalAgreement.getLeaseNumber()));
                    firstName.setText(rentalAgreement.getFirstName());
                    lastName.setText(rentalAgreement.getLastName());
                    studentNumber.setText(String.valueOf(rentalAgreement.getStudentNumber()));
                    mobileNumber.setText(rentalAgreement.getMobileNumber());
                } else {
                    // If RentalAgreement object is null, clear the text of the related text fields
                    
                    firstName.clear();
                    lastName.clear();
                    studentNumber.clear();
                    mobileNumber.clear();
                }
            }
            
            
        });       
        
    }
}
