/**
 * Student Name: [Harshith kolli]
 * Course: MCIS5103_032242S
 * Date: [2/18/2025]
 */
/**
 * @author [Harshith]
 * This class provides utility functions for retrieving month names.
 */
class MonthHelper {
	/**
	 * Returns the name of the given month.
	 *
	 * @param month The month number (1-12)
	 * @return The name of the corresponding month, or "error" if invalid
	 */
	public String month_name(int month) {
		String result = switch (month) {
			case 1 -> "January";
			case 2 -> "February";  // Fixed typo
			case 3 -> "March";
			case 4 -> "April";
			case 5 -> "May";
			case 6 -> "June";
			case 7 -> "July";
			case 8 -> "August";
			case 9 -> "September";
			case 10 -> "October";
			case 11 -> "November";
			case 12 -> "December";  // Fixed typo
			default -> "error";  // Handle invalid month input
		};
		return result;
	}
}

/**
 * @author [Harshith kolli]
 * This class tests the MonthHelper class by printing month names.
 */
public class MonthName {
	/**
	 * Main method to test the MonthHelper class.
	 * It instantiates an object of MonthHelper and calls the method.
	 */
	public static void main(String[] args) {
		MonthHelper monthUtil = new MonthHelper(); // Instantiating the helper class

		// Keeping the original printing statements unchanged
		System.out.println("Month 1: " + monthUtil.month_name(1));
		System.out.println("Month 2: " + monthUtil.month_name(2));
		System.out.println("Month 3: " + monthUtil.month_name(3));
		System.out.println("Month 4: " + monthUtil.month_name(4));
		System.out.println("Month 5: " + monthUtil.month_name(5));
		System.out.println("Month 6: " + monthUtil.month_name(6));
		System.out.println("Month 7: " + monthUtil.month_name(7));
		System.out.println("Month 8: " + monthUtil.month_name(8));
		System.out.println("Month 9: " + monthUtil.month_name(9));
		System.out.println("Month 10: " + monthUtil.month_name(10));
		System.out.println("Month 11: " + monthUtil.month_name(11));
		System.out.println("Month 12: " + monthUtil.month_name(12));
		System.out.println("Month 43: " + monthUtil.month_name(43)); // Testing an invalid case
	}
}
