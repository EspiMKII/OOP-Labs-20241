/* Ex 6.6 
Write a program to add 2 matrices.
=> we need to
	+ implement a matrix system somehow 
	+ implement an addition between 2 matrices somehow
	I think the 1st one kind of has to be built with 2nd in mind
	
* Matrix implementation
- I could do a nested list: a list whose elements are lists
- so in the code, a matrix A of sizee mxn would be a list<list<Integer>>
	+ it contains lists; the amount of lists it contains is m, the number of rows
	+ each of said lists has n elements, the number of columns
* Addition
- for 2 matrices A and B, I would need to add each of their lists together
=> need a helper method to add 2 lists together

* Input
- need to take m and n, the sizes of the matrices
- for each matrix, we take each row (list) of it, then append it to the matrix
 */

import java.util.*;

public class ex6_6_MatrixAdder {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("A matrix has size m*n.");
		System.out.print("Input m: "); int m = scanner.nextInt();
		System.out.print("Input n: "); int n = scanner.nextInt();
		
		System.out.println("We have 2 matrices, A and B, of the same size m*n.");
		List<List<Integer>> A = new ArrayList<>(), B = new ArrayList<>();
		System.out.println("Input rows of A: ");
		for (int i = 0; i < m; i++) {
			List<Integer> helper = inputHelper(n, scanner);		
			A.add(helper);
		}
		System.out.println("Input rows of B: ");
		for (int i = 0; i < m; i++) {
			List<Integer> helper = inputHelper(n, scanner);
			B.add(helper);
		}
		
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			result.add(addHelper(A.get(i), B.get(i)));
		}
		System.out.println("The result of adding A and B is: ");
		printHelper(result);

		
		scanner.close();
	}

	public static List<Integer> inputHelper(int n, Scanner scanner) {
		// just takes a line of integers from the user and turn it into a List<Integer>
		String input = new String();
		input = scanner.nextLine();
		if (input.isEmpty()) { // the program is somehow trying to get an empty input from scanner, when the user has not actually inputted anything, so we are putting this here
			input = scanner.nextLine();
		}
		String[] inputArray = input.split(" ");
		List<Integer> result = new ArrayList<>();
		for (String element : inputArray) {
			result.add(Integer.parseInt(element));
		}
		return result;
	}
	
	public static void printHelper(List<List<Integer>> myMatrix) {
		for (List<Integer> row : myMatrix) {
			for (Integer element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	public static List<Integer> addHelper(List<Integer> A, List<Integer> B) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < A.size(); i++) {
			result.add(A.get(i) + B.get(i));
		}
		return result;
	}
}