/*
Ex 6.4:
Write a program to display the number of days of a month, which is entered by the user (both month and years, in that order).
If it is an invalid month/year, ask the user to enter again.

The user can enter a month in its full name, in abbreviation, in 3 letters, or in a number. 
Example: January, Jan, Jan. and 1.

The user must enter a year in a non-negative number and with all its digits.
Example: 1999 (NOT 99, "one thousand one hundred ninety nine", or anything else).

A leap year's February has 29 days. A leap year is divisible by 4, except for years divisible by 100 but not 400.
Example: 1800 is not a leap year, and 2000 is a leap year.
*/
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class ex6_4_checkDays {
	public static void main(String[] args ) {
		Scanner scanner = new Scanner(System.in);
		
		/* Step 1: Input 
		- ultimately, I want the input to become 2 numbers, 1 for month, and 1 for year; which means, i will have to translate whatever the user inputs for month
		  into a number
		  	+ the advantage of using a number like this is that I can just use the index of a list of length 12 (so it spans from 0 to 11) and add 1 to it
		- we can create a few lists that contains how the user would input the month:
			+ 1st one is for the full names: January, February, so on
			+ 2nd one is for the abbreviated names: Jan., Feb.,...
			+ 3rd one is for the 3-letter names: Jan, Feb, Mar, Apr....
			+ we don't need one for numbers because duh
		- we can read the user input, then make a few observation as to what kind of input the user made. We can follow this conditional tree iteratively:
			1. check if it is in any of the 3 lists above
			2. else, check if it's an integer in the range [1, 12]
			3. else, it is not a valid input
		- once we know which kind of input it is, we just see find what index is the user's input in their respective list and use that as the month
		- the year input is quite self explanatory
		
		- to check if the user is inputting the correct month, we can use a while loop. if the user inputs a correct thing, we break the while loop, else we keep it going
			+ we can use the conditional tree above to check if they have inputted the correct month
			+ for year, it's just a number; anything else is not valid
			+ remember to break the while loop!
		*/
		List<String> fullName = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		List<String> abbrName = Arrays.asList("Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.");
		List<String> Three = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		
		String input = ""; int month = 0, year = 0;
		while (true) {
			System.out.print("Input month: ");
			input = scanner.nextLine();
			
			if (fullName.contains(input)) {
				month = fullName.indexOf(input)+1;
			} else if (abbrName.contains(input)) {
				month = abbrName.indexOf(input)+1;
			} else if (Three.contains(input)) {
				month = Three.indexOf(input)+1;
			} else {
				try {
					month = Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Invalid month. Try again.");
					continue;
				}
			}
			break;
		}
		while (true) {
			System.out.print("Input year: ");
			try {
				year = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid year. Try again.");
				continue;
			}
			break;
		}
		
		/* Step 2: Processing
		- month = 1, 3, 5, 7, 8, 10 or 12 => always have 31 days
		- month = 4, 6, 9, 11 => always have 30 days
		- month = 2, we need to determine if is a leap year, using this conditional tree:
			+ year % 400 == 0 => leap year
			+ year % 100 == 0 => normal year
			+ year % 4 == 0 => leap year
			+ else => normal year
		a normal year's month 2 has 28 days, and it's 29 for a leap year
		 */
		List<Integer> oddDays = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
		int result = 0;
		
		if (month == 2) {
			if (year % 400 == 0) {
				result = 29;
			} else if (year % 100 == 0) {
				result = 28;
			} else if (year % 4 == 0) {
				result = 29;
			} else {
				result = 28;
			}
		} else if (oddDays.contains(month)) {
			result = 31;
		} else {
			result = 30;
		}
		
		/* Step 3: Output
		 */
		System.out.println("This month has " + result + " days.");
		scanner.close();
	}
}