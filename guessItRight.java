/**
 * Student Name: [Harshith kolli]
 * Course: MCIS5103_032242S
 * Date: [2/18/2025]
 */
import java.util.Scanner;
import java.util.Random;

/**
 * @author Harshith Kolli
 */
public class guessItRight {

    public static void main(String[] args) {
        // Create an instance to handle the guessing logic
        NumberGuesser game = new NumberGuesser();
        game.startGame();
    }
}
class NumberGuesser {
    private final int min = 20;  // Min number
    private final int max = 10_000_000; // Max number
    private final int randomNumber; // The random number to be guessed
    private int count; // Counts valid attempts
    private int lastGuess; // Stores the last guess
    private final Scanner sc;



    /**
     * Constructor that initializes the game by generating a random number.
     */
    public NumberGuesser() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(max - min) + min; // Generate random number in range [min, max)
        this.count = 0; // Initialize attempt count
        this.lastGuess = -1; // Set previous guess to an impossible value
        this.sc = new Scanner(System.in); // Initialize scanner for input
    }


     // Starts the guessing game and manages user input
    public void startGame() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the secret number between " + min + " and " + max);

        while (true) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt(); // Read user input

            // Count the attempt only if the guess is different from the last one
            if (guess != lastGuess) {
                count++;
            }
            lastGuess = guess; // Store the current guess for comparison

            // Check if the guess is too low, too high, or correct
            if (guess < randomNumber) {
                System.out.println(guess + " is too small. Try again.");
            } else if (guess > randomNumber) {
                System.out.println(guess + " is too large. Try again.");
            } else {
                System.out.println("Congratulations! You guessed it in " + count + " valid attempts.");
                break;
            }
        }

        sc.close();
    }
}

