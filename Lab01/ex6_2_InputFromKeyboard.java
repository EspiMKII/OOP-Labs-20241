/* Ex 6.2 */

import java.util.Scanner;

public class ex6_2_InputFromKeyboard {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What's your name?");
		String name = keyboard.nextLine();
		System.out.println("How old are you?");
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = keyboard.nextDouble();
		
		System.out.println("Mr/Mrs. " + name
							+ ", " + iAge + " years old. Your height is " + dHeight + ".");
		keyboard.close();
	}
}