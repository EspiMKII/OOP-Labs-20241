/* Ex 6.5 */

import java.util.*;

public class ex6_5_arraySorter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		String[] inputArray = input.split(" ");
		ArrayList<Integer> my_array = new ArrayList<>();
		for (String str : inputArray) {
			int temp = Integer.parseInt(str);
			my_array.add(temp);
		}
		
		Collections.sort(my_array);
		System.out.println("Sorted array: " + my_array);
		System.out.println("Sum: " + sum(my_array));
		System.out.println("Average: " + String.format("%.3f", avg(my_array)));
		scanner.close();
	}
	public static int sum(ArrayList<Integer> my_array) {
		int result = 0;
		for (Integer element : my_array) {
			result += element;
		}
		return result;
	}
	public static double avg(ArrayList<Integer> my_array) {
		return (double) sum(my_array) / my_array.size();
	}
}