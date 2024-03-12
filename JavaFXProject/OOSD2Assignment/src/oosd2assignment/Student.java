package oosd2assignment;

public class Student {
    private String mobileNumber;
    private int studentNumber;
    private String studentName;

    // Constructor
    public Student(String studentName, int studentNumber, String mobileNumber) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.mobileNumber = mobileNumber;
    }

    // Getter and Setter methods for each attribute

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Other methods...

    public static void main(String[] args) {
        // Example usage:
        Student student = new Student("John Doe", 12345, "123-456-7890");

        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student Number: " + student.getStudentNumber());
        System.out.println("Mobile Number: " + student.getMobileNumber());
    }
}
