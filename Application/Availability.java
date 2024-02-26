public class Availability {
    private String availability;

    public Availability(String availability) {
        this.availability = availability;
    }

    public Availability() {
    }

    public void setUnavailable() {
        this.availability = "Unavailable";
    }

    public void setAvailable() {
        this.availability = "Available";
    }

    public String getAvailability() {
        return availability;
    }

    public static void main(String[] args) {
        Availability availability1 = new Availability();
        System.out.println("Initial availability: " + availability1.getAvailability());

        availability1.setUnavailable();
        System.out.println("After setting to unavailable: " + availability1.getAvailability());

        Availability availability2 = new Availability("Available");
        System.out.println("Availability from constructor: " + availability2.getAvailability());
    }
}
