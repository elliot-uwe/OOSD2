public class Availability {
    private String availability;

    // Constructor with availability parameter
    public Availability(String availability) {
        this.availability = availability;
    }

    // Default constructor
    public Availability() {
        // Default constructor with no parameters
    }

    // Set the availability to "Unavailable"
    public void setUnavailable() {
        this.availability = "Unavailable";
    }

    // Set the availability to "Available"
    public void setAvailable() {
        this.availability = "Available";
    }

    // Get the current availability
    public String getAvailability() {
        return availability;
    }

    public static void main(String[] args) {
        // Example usage
        Availability availability1 = new Availability();
        System.out.println("Initial availability: " + availability1.getAvailability());

        availability1.setUnavailable();
        System.out.println("After setting to unavailable: " + availability1.getAvailability());

        // Example with constructor
        Availability availability2 = new Availability("Available");
        System.out.println("Availability from constructor: " + availability2.getAvailability());
    }
}
