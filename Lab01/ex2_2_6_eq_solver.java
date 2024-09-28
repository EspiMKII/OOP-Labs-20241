/* Ex 2.2.6:
Write a Java program that can solve the following: (for the sake of simplicity, we only work with solutions over the reals)

1. A linear equation of 1 variable x, with the user inputting the coefficients of x^1 and x^0, respectively.
   It should handle the case where the 1st coefficient is 0.
   
2. A set of 2 linear equations of 2 variables x and y, with the users inputting the coefficients.
   It should handle the cases where there are infinitely many solutions, or no solutions at all.
   
3. A quadratic equation of 1 variable x, with the user inputting the coefficients of x^2, x^1 and x^0, respectively.
   it should handle the cases where there is no solution and when there is exactly 1 solution.
*/ 

/* 
obviously we need a mode switcher: let the user select the mode to use the program from these 3 and we go from there 
 */


import java.util.*;

public class ex2_2_6_eq_solver {
	public static void main(String[] args) {
		System.out.println("Select the mode to solve equations:");
		System.out.println("Type \"1\" for a linear equation solver.");
		System.out.println("Type \"2\" for a set of linear equations solver.");
		System.out.println("Type \"3\" for a quadratic equation solver.");
		
		Scanner newscan = new Scanner(System.in);
		String mode = newscan.nextLine();
		
		if (mode.equals("1")) { //linear solver
			/* 
			form: ax + b = 0. the user should input a and b
			if a != 0, solution is -b / a
			if a == 0, there is no solution (because you can't divide by 0 => raises ArithmeticException)
			*/
			System.out.println("Linear equation solver selected.");
			System.out.println("Let the equation be ax + b = 0");
			System.out.print("Input a: "); double a = newscan.nextDouble();
			System.out.print("Input b: "); double b = newscan.nextDouble();
			if (a == 0) {
				System.out.println("The equation has no solution.");
			} else {
				System.out.println("Solution: " + String.format("%.3f", -b / a));
			}
		} else if (mode.equals("2")) { //set solver
			/*
			 form: a1x + b1y = c1; a2x + b2y = c2. the user should input the coefficients
			 consider the set's determinant A = a1b2 - a2b1
			 	+ if A == 0, consider the following:
			 		+ if a1*c2 == a2*c1 (i am actually just shitting myself trying to avoid quotients here), the system has infinitely many solutions
			 		+ else, the system has no solution
			 	+ if A != 0, the system has exactly 1 solution:
			 		y = (c2 - c1*a2/a1) / (b2 - b1*a2/a1) (i just did some matrix manip dont ask how i came to this)
			 		x = (c1 - b1*y)/a1
			*/
			System.out.println("System of linear equations solver selected.");
			System.out.println("Let the equations be a1x + b1y = c1 and a2x + b2y = c2");
			System.out.println("Input the following: ");
			System.out.print("a1: "); double a1 = newscan.nextDouble();
			System.out.print("b1: "); double b1 = newscan.nextDouble();
			System.out.print("c1: "); double c1 = newscan.nextDouble();
			System.out.print("a2: "); double a2 = newscan.nextDouble();
			System.out.print("b2: "); double b2 = newscan.nextDouble();
			System.out.print("c2: "); double c2 = newscan.nextDouble();
			
			double determinant = a1*b2 - a2*b1;
			if (determinant == 0) {
				if (a1*c2 == a2*c1) {
					System.out.println("The system has infinitely many solutions.");
				} else {
					System.out.println("The system has no solution.");
				}
			} else {
				double y = (c2 - c1*a2/a1) / (b2 - b1*a2/a1); double x = (c1 - b1*y)/a1;
				System.out.println("x is " + String.format("%.3f", x)); System.out.println("y is " + String.format("%.3f", y));
			}
		} else  { //quadratic solver
			/*
			form: ax^2 + bx + c = 0. the user should input a, b, and c
			consider the discriminant D = b^2 - 4ac
				+ if D < 0, the system has no solution
				+ if D = 0, the sytem has exactly 1 solution: -b / 2a
				+ if D > 0, the system has exactly 2 solutions, x1 and x2:
					+ x1 = (-b + Math.sqrt(D)) / (2a)
					+ x2 = (-b - Math.sqrt(D)) / (2a)
			*/
			System.out.println("Quadratic equation solver selected.");
			System.out.println("Let the equation be a*x^2 + b*x + c = 0");
			System.out.print("Input a: "); double a = newscan.nextDouble();
			System.out.print("Input b: "); double b = newscan.nextDouble();
			System.out.print("Input c: "); double c = newscan.nextDouble();
			
			double discriminant = Math.pow(b, 2) - 4*a*c; 
			if (discriminant < 0) {
				System.out.println("The system has no solution.");
			} else if (discriminant == 0) {
				System.out.println("The system has exactly 1 solution: " + String.format("%.3f", -b/(2*a)));
			} else {
				double x1 = (-b + Math.sqrt(discriminant)) / (2*a), x2 = (-b - Math.sqrt(discriminant)) / (2*a);
				System.out.println("The system has exactly 2 solution: " + String.format("%.3f", x1) + " and " + String.format("%.3f", x2));
			}
		}
		newscan.close();
	}
} 