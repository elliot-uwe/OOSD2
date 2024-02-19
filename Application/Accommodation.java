public class Accommodation {
    private String availability;
    private String accomDescriptionAndInventory;
    private String accommType;
    private float price;
    private int accommNo;

    enum Level {
        CLEAN,
        DIRTY,
        OFFLINE
      }

    // Constructor
    public Accommodation(int accommNo, float price, String accommType,
                         String accomDescriptionAndInventory,
                        String availability) {
        this.accommNo = accommNo;
        this.price = price;
        this.accommType = accommType;
        this.accomDescriptionAndInventory = accomDescriptionAndInventory;
        this.availability = availability;
    }

    // Getter and Setter methods for each attribute

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Level getCleaningStatus() {
        return Level.CLEAN;
    }

    public void setCleaningStatus(Level cleaningStatus) {
        
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

    // Other methods...

    public static void main(String[] args) {
        // Example usage:
        Accommodation accommodation = new Accommodation(1, 100.0f, "Type", "Description", "Available");
        accommodation.setCleaningStatus(Level.CLEAN);
    }
}
