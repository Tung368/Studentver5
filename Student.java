package Studentver5;

import java.util.Date;

class Student extends Person implements IPerson {
    private float gpa;
    private String major;

    public Student(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate, float gpa, String major) {
        super(id, fullName, dateOfBirth, bookBorrowDate, bookReturnDate);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void addPerson() {
        System.out.println("Adding new student...");
    }

    @Override
    public void updatePerson(String id) {
        System.out.println("Updating student with ID: " + id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Major: " + major);
        System.out.println("GPA: " + gpa);
        System.out.println("Book Borrow Date: " + getBookBorrowDate());
        System.out.println("Book Return Date: " + getBookReturnDate());
        System.out.println("Book Overdue: " + (isBookOverdue() ? "Yes" : "No"));
    }
}
