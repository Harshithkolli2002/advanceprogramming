/**
 * Student Name: [Harshith kolli]
 * Course: MCIS5103_032242S
 * Date: [2/18/2025]
 */
import java.util.Scanner;
/**
 * @author [Harshith kolli]
 * This class calculates the weekday for a given date.
 * It follows a formula to determine the correct weekday for dates from 1901 to present.
 */

public class WeekdayCalculator {
	public static void main(String[] args) {
		// Scanner object to take input from the user
		Scanner keyboard = new Scanner(System.in);

		// Display introductory message
		System.out.println("Welcome to MCIS5103's fantastic birth-o-meter!");
		System.out.println();
		System.out.println("All you have to do is enter your birth date, and it will");
		System.out.println("tell you the day of the week on which you were born.");
		System.out.println();

		// Automatic test cases to validate the function
		System.out.println("Some automatic tests....");
		System.out.println("12 10 2003 => " + weekday(12, 10, 2003));
		System.out.println(" 2 13 1976 => " + weekday(2, 13, 1976));
		System.out.println(" 2 13 1977 => " + weekday(2, 13, 1977));
		System.out.println(" 7  2 1974 => " + weekday(7, 2, 1974));
		System.out.println(" 1 15 2003 => " + weekday(1, 15, 2003));
		System.out.println("10 13 2000 => " + weekday(10, 13, 2000));
		System.out.println();

		// Asking user for their birthdate input
		System.out.println("Now it's your turn! What's your birthday?");
		System.out.print("Birth date (mm dd yyyy): ");
		int mm = keyboard.nextInt();
		int dd = keyboard.nextInt();
		int yyyy = keyboard.nextInt();

		// Displaying the calculated day of birth
		System.out.println("You were born on " + weekday(mm, dd, yyyy));

		keyboard.close(); // Closing scanner to prevent memory leaks
	}

	/**
	 * Computes the day of the week for a given date.
	 *
	 * @param mm  Month (1-12)
	 * @param dd  Day of the month (1-31)
	 * @param yyyy  Year (1901-present)
	 * @return The full date including the weekday
	 */
	public static String weekday(int mm, int dd, int yyyy) {
		int yy, total;
		String date;

		// Extract last two digits of the year
		yy = yyyy % 100;
		int century = yyyy / 100; // Extract the century part
		int monthOffset = DateUtil.month_offset(mm); // Get the month offset

		// Adjust for leap year if the month is January or February
		if (mm == 1 || mm == 2) {
			if (DateUtil.is_leap(yyyy)) {
				monthOffset -= 1;
			}
		}

		// Compute the total for day-of-week calculation
		total = yy + (yy / 4) + monthOffset + dd + DateUtil.century_offset(century);
		int weekdayIndex = total % 7;

		// Construct the full date string
		date = DateUtil.weekday_name(weekdayIndex) + ", " + DateUtil.month_name(mm) + " " + dd + ", " + yyyy;
		return date;
	}
}

/**
 * @author [Harshith kolli]
 * This class provides utility methods for date-related calculations.
 */
class DateUtil {

	/**
	 * Returns the offset value for the given month.
	 *
	 * @param month The month (1-12)
	 * @return The corresponding offset value
	 */
	public static int month_offset(int month) {
		int[] offsets = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		return offsets[month - 1];
	}

	/**
	 * Returns the name of the given month.
	 *
	 * @param month The month (1-12)
	 * @return The full name of the month
	 */
	public static String month_name(int month) {
		String[] months = {
				"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"
		};
		return months[month - 1];
	}

	/**
	 * Returns the name of the weekday for a given index.
	 *
	 * @param index The day index (0=Sunday, ..., 6=Saturday)
	 * @return The corresponding weekday name
	 */
	public static String weekday_name(int index) {
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		return days[index];
	}

	/**
	 * Checks if the given year is a leap year.
	 *
	 * @param year The year to check
	 * @return True if it's a leap year, false otherwise
	 */
	public static boolean is_leap(int year) {
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}

	/**
	 * Returns the century offset for the given century.
	 *
	 * @param century The century part of the year
	 * @return The century offset value
	 */
	public static int century_offset(int century) {
		int[] offsets = {6, 4, 2, 0}; // for 1900s, 2000s, 2100s, etc.
		return offsets[century % 4];
	}
}
