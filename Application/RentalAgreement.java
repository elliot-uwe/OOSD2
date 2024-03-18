public class RentalAgreement {
    private Room room;
    private Student studentInfo;
    private int leaseNumber;

    // Constructor
    public RentalAgreement(int leaseNumber, Student studentInfo, Room room) {
        this.leaseNumber = leaseNumber;
        this.studentInfo = studentInfo;
        this.room = room;
    }

    // Getter methods

    public Room getRoom() {
        return room;
    }

    public Student getStudentInfo() {
        return studentInfo;
    }

    public int getLeaseNumber() {
        return leaseNumber;
    }

    public static void main(String[] args) {
        Room room = new Room(/* initialize your Room */);
        Student student = new Student("James", 325604, "07340532552");
        RentalAgreement rentalAgreement = new RentalAgreement(1, student, room);

        System.out.println("Lease Number: " + rentalAgreement.getLeaseNumber());
        System.out.println("Student Info: " + rentalAgreement.getStudentInfo());
        System.out.println("Room: " + rentalAgreement.getRoom());
    }
}
