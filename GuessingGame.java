import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int min = 1;
        int max = 100;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int attempts = 0;
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess it?");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + randomNumber + ".");
            }
            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }
        System.out.println("Your final score is: " + score);
        System.out.println("thank you and visit again");
    }
}
