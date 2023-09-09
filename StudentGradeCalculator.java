import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects = 5;
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;
        double averagePercentage;
        String grade;

        System.out.println("Enter the marks obtained (out of 100) in each subject: ");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        averagePercentage = (double) totalMarks / numberOfSubjects;

        if (averagePercentage >= 90) {
            grade = "A grade and excellent guys";
        } else if (averagePercentage >= 80) {
            grade = "B grade and well done ";
        } else if (averagePercentage >= 70) {
            grade = "C grade good one ";
        } else if (averagePercentage >= 60) {
            grade = " D grade avgrage ";
        } else {
            grade = "You are fail";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
