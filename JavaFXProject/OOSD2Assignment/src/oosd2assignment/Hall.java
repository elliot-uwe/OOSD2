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
            String[] itemsIncluded = {"WiFi", "TV", "Air conditioning", "Heating"};
            accommodations.add(new Accommodation(i, 700.0f, "Standard", "Description", "Clean", "Available", itemsIncluded, null));
        }

        // Add 10 superior rooms
        for (int i = 31; i <= 40; i++) {
            String[] itemsIncluded = {"WiFi", "TV", "Air conditioning", "Heating", "Mini fridge", "Swimming Pool", "Lounge", "Gym"};
            accommodations.add(new Accommodation(i, 750.0f, "Superior", "Description", "Clean", "Available", itemsIncluded, null));
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
        availableRooms = 0;
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCleaningStatus() != "Offline" && accommodation.getRentalAgreement() == null) {
                availableRooms++;
            }
        }
        return availableRooms;
    }

    public int getRoomsReqCleaning() {
        roomsReqCleaning = 0;
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCleaningStatus() != "Dirty") {
                roomsReqCleaning++;
            }
        }
        return (accommodations.size() - roomsReqCleaning);
    }

    public int getRoomsOffline() {
        roomsOffline = 0;
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getCleaningStatus() == "Offline") {
                roomsOffline++;
            }
        }
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
