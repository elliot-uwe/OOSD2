package oosd2assignment;

import java.util.ArrayList;

public class Hall {
    public ArrayList<Accommodation> accommodations;

    public String hallName;
    public String hallTelNumber;
    public String hallManager;
    public int totalRooms;
    public int availableRooms;
    public int roomsReqCleaning;
    public int roomsOffline;

    public Hall(String hallName, String hallTelNumber, String hallManager,int totalRooms,
                int availableRooms, int roomReqCleaning, int roomsOffline) {
        this.hallName = hallName;
        this.hallTelNumber = hallTelNumber;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        this.roomsReqCleaning = roomReqCleaning;
        this.roomsOffline = roomsOffline;
        this.hallManager = hallManager;

        this.accommodations = new ArrayList<>();

        // Initialize accommodations
        initializeAccommodations();
    }

    private void initializeAccommodations() {
        // Add 30 standard rooms
        for (int i = 1; i <= 30; i++) {
            String[] itemsIncluded = {"WiFi", "TV", "Air conditioning", "Mini fridge"};
            accommodations.add(new Accommodation(i, 700.0f, "Standard", "Description", "Clean", "Available", itemsIncluded));
        }

        // Add 10 superior rooms
        for (int i = 31; i <= 40; i++) {
            String[] itemsIncluded = {"WiFi", "TV", "Air conditioning", "Mini fridge", "Swimming Pool", "Personal Casino", "Head"};
            accommodations.add(new Accommodation(i, 760.0f, "Superior", "Description", "Clean", "Available", itemsIncluded));
        }
    }
    
    public String getHallManager() {
        return hallManager;
    }

    public String getHallName() {
        return hallName;
    }

    public String getHallTelNumber() {
        return hallTelNumber;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public int getRoomsReqCleaning() {
        return roomsReqCleaning;
    }

    public int getRoomsOffline() {
        return roomsOffline;
    }
    
    public int getTotalRooms(){
        return totalRooms;
    }

    public void addAccommodation(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }
}
