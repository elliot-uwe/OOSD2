import java.util.ArrayList;

public class Hall {
    public ArrayList<Accommodation> accommodations;
    public String hallName;
    public String hallTelNumber;
    public int totalRooms;
    public int availableRooms;
    public int roomsReqCleaning;
    public int roomsOffline;

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

    public void addAccommodation(Accommodation accommodation) {
        accommodations.add(accommodation);
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    public Hall(String hallName, String hallTelNumber, int totalRooms, 
                int availableRooms, int roomReqCleaning, int roomsOffline) {
        this.hallName = hallName;
        this.hallTelNumber = hallTelNumber;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        this.roomsReqCleaning = roomReqCleaning;
        this.roomsOffline = roomsOffline;
    }
}