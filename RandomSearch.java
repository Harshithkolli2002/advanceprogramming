//Name: Harshith Kolli
//Student NUmber: 999904298
//Section:MSIS5103_032242S

import java.util.Random;
import java.util.Scanner;

/**
 * Class that handles creating and searching a random integer array
 * @author Harshith Kolli
 */
class RandomArrayGenerator {
    private int[] num;

    /**
     * Constructor initializes and fills the array with unique random values
     */
    public RandomArrayGenerator() {
        num = new int[10];
        fillNewNums();
    }

    /**
     * Fills the array with different random integers in the range 7-123
     */
    private void fillNewNums() {
        Random rand = new Random();
        int count = 0;

        // Generate unique values until the array is full
        while (count < 10) {
            int candidate = rand.nextInt(117) + 7; // range 7-123
            if (!isInArray(candidate)) {
                num[count] = candidate;
                count++;
            }
        }
    }

    /**
     * Checks if a number already exists in the array
     * @param num the number to check
     * @return true if number exists, false otherwise
     */
    private boolean isInArray(int num) {
        for (int n : this.num) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays all numbers in the array
     */
    public void displayArray() {
        System.out.println("Array values:");
        for (int num : num) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Counts how many times a given number appears in the array
     * @param searchNum number to search for
     * @return number of occurrences
     */
    public int countOccurrences(int searchNum) {
        int count = 0;
        for (int num : num) {
            if (num == searchNum) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Main class to run the random array search application
 */
public class RandomSearch {

    /**
     * Main method to execute the program logic
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating two RandomArrayHandler objects as per OOP requirement
        RandomArrayGenerator handler1 = new RandomArrayGenerator();
        RandomArrayGenerator handler2 = new RandomArrayGenerator();

        // Using only the first object for demonstration, the second is created for OOP compliance
        handler1.displayArray();

        // Prompt the user to enter a number
        System.out.print("Enter a number to search for in the array: ");
        int searchNum = scanner.nextInt();

        // Count how many times the number appears
        int count = handler1.countOccurrences(searchNum);
        System.out.println("The number " + searchNum + " was found " + count + " time(s) in the array.");

        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
