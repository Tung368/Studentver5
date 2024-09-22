package Studentver5;

import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new student");
            System.out.println("2. Add new teacher");
            System.out.println("3. Update person by ID");
            System.out.println("4. Delete person by ID");
            System.out.println("5. Display all students and teachers");
            System.out.println("6. Find the student with the highest GPA");
            System.out.println("7. Find teachers by department");
            System.out.println("8. Notify whether the book's return due date has arrived or not");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter full name: ");
                    String studentFullName = scanner.next();
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    System.out.print("Enter major: ");
                    String major = scanner.next();
                    personList.addStudent(new Student(studentId, studentFullName, new Date(), new Date(), new Date(), gpa, major));
                    break;

                case 2:
                    System.out.print("Enter teacher ID: ");
                    String teacherId = scanner.next();
                    System.out.print("Enter full name: ");
                    String teacherFullName = scanner.next();
                    System.out.print("Enter department: ");
                    String department = scanner.next();
                    System.out.print("Enter teaching subject: ");
                    String teachingSubject = scanner.next();
                    personList.addTeacher(new Teacher(teacherId, teacherFullName, new Date(), new Date(), new Date(), department, teachingSubject));
                    break;

                case 3:
                    System.out.print("Enter person ID to update: ");
                    String updateId = scanner.next();
                    Person person = personList.findPersonById(updateId);
                    if (person instanceof Student) {
                        System.out.print("Enter new full name: ");
                        String newStudentFullName = scanner.next();
                        System.out.print("Enter new GPA: ");
                        float newGpa = scanner.nextFloat();
                        System.out.print("Enter new major: ");
                        String newMajor = scanner.next();
                        personList.updatePerson(updateId, new Student(updateId, newStudentFullName, new Date(), new Date(), new Date(), newGpa, newMajor));
                    } else if (person instanceof Teacher) {
                        System.out.print("Enter new full name: ");
                        String newTeacherFullName = scanner.next();
                        System.out.print("Enter new department: ");
                        String newDepartment = scanner.next();
                        System.out.print("Enter new teaching subject: ");
                        String newTeachingSubject = scanner.next();
                        personList.updatePerson(updateId, new Teacher(updateId, newTeacherFullName, new Date(), new Date(), new Date(), newDepartment, newTeachingSubject));
                    }
                    break;

                case 4:
                    System.out.print("Enter person ID to delete: ");
                    String deleteId = scanner.next();
                    personList.deletePersonById(deleteId);
                    break;

                case 5:
                    personList.displayEveryone();
                    break;

                case 6:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 7:
                    System.out.print("Enter department to find teachers: ");
                    String findDepartment = scanner.next();
                    for (Teacher teacher : personList.findTeacherByDepartment(findDepartment)) {
                        teacher.displayInfo();
                    }
                    break;

                case 8:
                    personList.checkBookBorrowing();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
