package oosd2assignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ObservableValue;

public class GUIController implements Initializable {

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
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the ArrayList
        halls = new ArrayList<>();
        
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
                    // Run a method based on the selected option
                    switch (newValue) {
                        case "Clean":
                            selectedAccommodation.setCleaningStatus("Clean");
                            ObservableList<Accommodation> accommodationList1 = FXCollections.observableArrayList(selectedHall.getAccommodations());
                            accommodationTableView.setItems(accommodationList1);
                            break;
                        case "Dirty":
                            selectedAccommodation.setCleaningStatus("Dirty");
                            ObservableList<Accommodation> accommodationList2 = FXCollections.observableArrayList(selectedHall.getAccommodations());
                            accommodationTableView.setItems(accommodationList2);
                            break;
                        case "Offline":
                            selectedAccommodation.setCleaningStatus("Offline");
                            ObservableList<Accommodation> accommodationList3 = FXCollections.observableArrayList(selectedHall.getAccommodations());
                            accommodationTableView.setItems(accommodationList3);
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



        // Create instances of Hall and add their names to the ComboBox
        halls.add(new Hall("Brecon Court", "07123456789", "Joshua",40, 40, 0, 0));
        halls.add(new Hall("Cotswold Court", "07123456788", "John",40, 30, 5, 5));
        halls.add(new Hall("Mendip Court", "07123456787", "Elliot",40, 20, 0, 20));
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
                // Set the accommNo TextField with the selected accommodation's accommNo
                accommNo.setText("" + newValue.getAccommNo());
                type.setText("" + newValue.getType());
                price.setText("" + newValue.getPrice());
                occupancy.setText("" + newValue.getAvailability());
                itemsIncluded.setText(newValue.getItemsIncluded());
            }
            
            
        });
        
        
    }
}
