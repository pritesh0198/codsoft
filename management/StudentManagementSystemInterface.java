package management;

import java.util.Scanner;

public class StudentManagementSystemInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("Welcome to the Student Management System. Please choose an option:");
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the student's roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the student's grade: ");
                    String grade = scanner.nextLine();
                    system.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter the roll number of the student to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    if (system.removeStudent(removeRollNumber)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Failed to remove student. The student may not exist.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the roll number of the student to search for: ");
                    int searchRollNumber = scanner.nextInt();
                    Student student = system.searchStudent(searchRollNumber);
                    if (student != null) {
                        System.out.println("Name: " + student.getName());
                        System.out.println("Roll Number: " + student.getRollNumber());
                        System.out.println("Grade: " + student.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("welcome sir");
                    system.displayStudents();
                    break;
                case 5:
                    System.out.println("thank you and visit again");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}