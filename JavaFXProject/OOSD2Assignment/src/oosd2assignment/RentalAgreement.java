package oosd2assignment;

public class RentalAgreement {
    private int leaseNumber;
    private String firstName;
    private String lastName;
    private int studentNumber;
    private String mobileNumber;

    // Constructor
    public RentalAgreement(int leaseNumber, String firstName, String lastName, int studentNumber, String mobileNumber) {
        this.leaseNumber = leaseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.mobileNumber = mobileNumber;
    }

    // Getter methods
    public int getLeaseNumber() {
        return leaseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public int getStudentNumber() {
        return studentNumber;
    }
    
    public String getMobileNumber() {
        return mobileNumber;
    }
}
