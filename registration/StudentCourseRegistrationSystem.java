package registration;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Introduction to Computer Science", "An introduction to the fundamentals of computer science.", 30, "MWF 9:00-10:00"));
        courses.add(new Course("MATH101", "Calculus I", "An introduction to the concepts and methods of calculus.", 40, "TR 10:00-11:30"));
        courses.add(new Course("ENGL101", "Composition I", "An introduction to the principles of effective written communication.", 25, "MWF 11:00-12:00"));
        
        System.out.print("Enter your student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        Student student = new Student(id, name);

        while (true) {
            System.out.println("Welcome to the Student Course Registration System. Please choose an option:");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Available Courses:");
                    for (Course course : courses) {
                        System.out.println(course.getCode() + ": " + course.getTitle());
                        System.out.println("\tDescription: " + course.getDescription());
                        System.out.println("\tSchedule: " + course.getSchedule());
                        System.out.println("\tAvailable Slots: " + (course.getCapacity() - course.getRegisteredStudents().size()));
                    }
                    break;
                case 2:
                    System.out.print("Enter the course code to register for: ");
                    String registerCode = scanner.nextLine();
                    Course registerCourse = null;
                    for (Course course : courses) {
                        if (course.getCode().equals(registerCode)) {
                            registerCourse = course;
                            break;
                        }
                    }
                    if (registerCourse == null) {
                        System.out.println("Invalid course code.");
                    } else if (student.registerCourse(registerCourse)) {
                        System.out.println("Registration successful.");
                    } else {
                        System.out.println("Registration failed. The course may be full or you may already be registered.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the course code to drop: ");
                    String dropCode = scanner.nextLine();
                    Course dropCourse = null;
                    for (Course course : student.getRegisteredCourses()) {
                        if (course.getCode().equals(dropCode)) {
                            dropCourse = course;
                            break;
                        }
                    }
                    if (dropCourse == null) {
                        System.out.println("Invalid course code.");
                    } else if (student.removeCourse(dropCourse)) {
                        System.out.println("Course dropped successfully.");
                    } else {
                        System.out.println("Failed to drop course.");
                    }
                    break;
                case 4:
                    System.out.println("Registered Courses:");
                    for (Course course : student.getRegisteredCourses()) {
                        System.out.println(course.getCode() + ": " + course.getTitle());
                    }
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
