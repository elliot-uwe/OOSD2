package oosd2assignment;

public class Room {
    private int roomNumber;

    // Constructor with room number parameter
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Default constructor
    public Room() {
        // Default constructor with no parameters
    }

    // Set the room number
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Get the room number
    public int getRoomNumber() {
        return roomNumber;
    }

    public static void main(String[] args) {
        // Example usage
        Room room1 = new Room();
        System.out.println("Initial room number: " + room1.getRoomNumber());

        room1.setRoomNumber(101);
        System.out.println("After setting room number: " + room1.getRoomNumber());

        // Example with constructor
        Room room2 = new Room(202);
        System.out.println("Room number from constructor: " + room2.getRoomNumber());
    }
}
