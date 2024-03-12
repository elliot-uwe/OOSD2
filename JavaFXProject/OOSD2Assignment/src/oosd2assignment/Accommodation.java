package oosd2assignment;

public class Accommodation {
    private String availability;
    private String cleaningStatus;
    private String accomDescriptionAndInventory;
    private String accommType;
    private float price;
    private int accommNo;
    private String[] itemsIncluded;
    private RentalAgreement rentalAgreement;

    // Constructor
    public Accommodation(int accommNo, float price, String accommType,
                         String accomDescriptionAndInventory,
                         String cleaningStatus, String availability, String[] itemsIncluded, RentalAgreement rentalAgreement) {
        this.accommNo = accommNo;
        this.price = price;
        this.accommType = accommType;
        this.accomDescriptionAndInventory = accomDescriptionAndInventory;
        this.cleaningStatus = cleaningStatus;
        this.availability = availability;
        this.itemsIncluded = itemsIncluded;
        
    }

    // Getter and Setter methods for each attribute

    public String getAvailability() {
        return availability;
    }
    
    public RentalAgreement getRentalAgreement(){
        return rentalAgreement;
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
    
    public void setRentalAgreement(RentalAgreement rentalAgreement){
        this.rentalAgreement = rentalAgreement;
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

    public String getType() {
        return accommType;
    }

    public String getDescriptionAndInventory() {
        return accomDescriptionAndInventory;
    }

    public int getAccomNo() {
        return accommNo;
    }
    
    public String getItemsIncluded() {
    // Check if the itemsIncluded array is null or empty
    if (itemsIncluded == null || itemsIncluded.length == 0) {
        return "";
    }

    // Create a StringBuilder to concatenate all items
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < itemsIncluded.length; i++) {
        sb.append(itemsIncluded[i]);
        // Append comma if it's not the last item
        if (i < itemsIncluded.length - 1) {
            sb.append(", ");
        }
    }
    return sb.toString();
}
}
