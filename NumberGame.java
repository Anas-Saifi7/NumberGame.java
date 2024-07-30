import java.util.Scanner;
import java.util.Random;
import java.lang;

 public class  NumberGame {
  public static void main(String[] args) {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    int userGuess = 0;
    int totalScore = 0;
    int roundsWon = 0;
    int maxAttempts = 3;

    boolean playAgain = true;
    while (playAgain) {
      int randomNumber = random.nextInt(100) + 1;
      int attempts = 0;
      boolean roundWon = false;

      System.out.println("Welcome to the Guessing Game of the Nummber between 1 to 100:");
      System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

      while (userGuess != randomNumber && attempts < maxAttempts) {
        System.out.println("Enter your Guess:");
        userGuess = sc.nextInt();
        attempts++;
        if (userGuess == randomNumber) {
          System.out.println("Congratulations! You Guessed the correct number: " + randomNumber + "and it took the"
              + attempts + "attempts");

          roundWon = true;
          totalScore += (maxAttempts - attempts + 1) * 10;
          roundsWon++;
          break;
        }

        else if (userGuess < randomNumber) {
          System.out.println("Too low! Try again");
          System.out.println("Attempts remaining :" + (maxAttempts - attempts));
        }

        else {
          System.out.println("Too high! Try again");
          System.out.println("Attempts remaining :" + (maxAttempts - attempts));

        }
      }

      if (!roundWon) {
        System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
      }
      // Ask if the user wants to play again
      System.out.print("Do you want to play again? (yes/no): ");
      String response = sc.next().trim().toLowerCase();
      playAgain = response.equals("yes");
    }
    System.out.println("Game Over!");
    System.out.println("Total Score: " + totalScore);
    System.out.println("Rounds Won: " + roundsWon);
  }
}
