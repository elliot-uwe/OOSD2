public class Accommodation {
    private String availability;
    private String cleaningStatus;
    private String accomDescriptionAndInventory;
    private String accommType;
    private float price;
    private int accommNo;

    // Constructor
    public Accommodation(int accommNo, float price, String accommType,
                         String accomDescriptionAndInventory,
                         String cleaningStatus, String availability) {
        this.accommNo = accommNo;
        this.price = price;
        this.accommType = accommType;
        this.accomDescriptionAndInventory = accomDescriptionAndInventory;
        this.cleaningStatus = cleaningStatus;
        this.availability = availability;
    }

    // Getter and Setter methods for each attribute

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public String getAccomDescriptionAndInventory() {
        return accomDescriptionAndInventory;
    }

    public void setAccomDescriptionAndInventory(String accomDescriptionAndInventory) {
        this.accomDescriptionAndInventory = accomDescriptionAndInventory;
    }

    public String getAccommType() {
        return accommType;
    }

    public void setAccommType(String accommType) {
        this.accommType = accommType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAccommNo() {
        return accommNo;
    }

    public void deleteRentalAgreement(RentalAgreement rentalAgreement) {

    }

    public void setRentalAgreement(RentalAgreement rentalAgreement) {

    }

    public String getType() {
        return accommType;
    }

    public String getDescriptionAndInventory() {
        return accomDescriptionAndInventory;
    }

    public int getAccomNo() {
        return accommNo;
    }

    public static void main(String[] args) {
        // Example usage:
        Accommodation accommodation = new Accommodation(1, 100.0f, "Type", "Description", "Dirty", "Available");
        accommodation.setCleaningStatus("Offline");
        System.out.println("Set Accommodation Cleaning Status to " + accommodation.getCleaningStatus());
        accommodation.setCleaningStatus("Clean");
        System.out.println("Set Accommodation Cleaning Status to " + accommodation.getCleaningStatus());
    }
}
