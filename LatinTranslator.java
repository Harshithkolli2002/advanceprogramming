/**
 * Student Name: [Harshith kolli]
 * Course: MCIS5103_032242S
 * Date: [3/4/2025]
 */
// @author Harshith Kolli
// This program translates text to Fake Latin and back.

import java.util.Scanner;

/**
 * The LatinTranslator class handles text translation to and from Fake Latin.
 */
public class LatinTranslator {

    /**
     * @param text The input English text.
     * @return The translated Fake Latin text.
     */
    public static String toFakeLatin(String text) {
        // Translating English to Fake Latin
        String[] intoWords = text.split(" "); // Split into words
        StringBuilder result = new StringBuilder(); // Using StringBuilder

        for (String word : intoWords) {
            if (!word.isEmpty()) {
                String modifiedWord = word.substring(1) + word.charAt(0) + "ay ";
                result.append(modifiedWord); // Append modified word
            }
        }
        return result.toString().trim(); // Returning without spaces
    }

    /**
     * @param text The input Fake Latin text.
     * @return The translated English text.
     */
    public static String fromFakeLatin(String text) {
        // Translating Fake Latin back to English
        String[] intoWords = text.split(" "); // Input into words
        StringBuilder result = new StringBuilder(); // StringBuilder to store result

        for (String word : intoWords) {
            if (word.length() > 2 && word.endsWith("ay")) {
                String core = word.substring(0, word.length() - 2); // Remove "ay"
                char firstLetter = core.charAt(core.length() - 1); // Extract original first letter
                result.append(firstLetter) // Append first letter
                        .append(core, 0, core.length() - 1) // Append rest of the word
                        .append(" ");
            }
        }
        return result.toString().trim(); // Trim space
    }
}


// The TranslatorApp class handles user input and calls translation methods.

class TranslatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scan for input

        System.out.println("Enter text:");
        String input = sc.nextLine();

        System.out.println("To Fake Latin: " + LatinTranslator.toFakeLatin(input)); // Convert to Fake Latin

        System.out.println("Enter Fake Latin text:");
        String fakeLatinInput = sc.nextLine(); // Read Fake Latin input

        System.out.println("From Fake Latin: " + LatinTranslator.fromFakeLatin(fakeLatinInput)); // Convert back to English

        sc.close(); // Close scanner
    }
}
