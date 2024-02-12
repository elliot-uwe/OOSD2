public class AccommodationType {
    private String accommType;

    // Set the accommodation type to "Superior"
    public void setSuperior() {
        this.accommType = "Superior";
    }

    // Set the accommodation type to "Standard"
    public void setStandard() {
        this.accommType = "Standard";
    }

    // Set the accommodation type based on the provided parameter
    public void setAccommodationType(String accomType) {
        this.accommType = accomType;
    }

    // Get the current accommodation type
    public String getAccommodationType() {
        return accommType;
    }

    public static void main(String[] args) {
        // Example usage
        AccommodationType accommodation1 = new AccommodationType();
        System.out.println("Initial accommodation type: " + accommodation1.getAccommodationType());

        accommodation1.setSuperior();
        System.out.println("After setting to Superior: " + accommodation1.getAccommodationType());

        // Example with constructor
        AccommodationType accommodation2 = new AccommodationType();
        accommodation2.setAccommodationType("Standard");
        System.out.println("Accommodation type from setAccommodationType: " + accommodation2.getAccommodationType());
    }
}
