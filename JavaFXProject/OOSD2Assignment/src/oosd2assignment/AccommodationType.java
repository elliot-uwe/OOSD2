package oosd2assignment;

public class AccommodationType {
    private String accommType;

    public void setSuperior() {
        this.accommType = "Superior";
    }

    public void setStandard() {
        this.accommType = "Standard";
    }

    public void setAccommodationType(String accomType) {
        this.accommType = accomType;
    }

    public String getAccommodationType() {
        return accommType;
    }

    public static void main(String[] args) {
        AccommodationType accommodation1 = new AccommodationType();
        System.out.println("Initial accommodation type: " + accommodation1.getAccommodationType());

        accommodation1.setSuperior();
        System.out.println("After setting to Superior: " + accommodation1.getAccommodationType());

        AccommodationType accommodation2 = new AccommodationType();
        accommodation2.setAccommodationType("Standard");
        System.out.println("Accommodation type from setAccommodationType: " + accommodation2.getAccommodationType());
    }
}
