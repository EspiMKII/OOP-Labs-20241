/*
Ex 2.2.5:
Write a program to calculate sum, difference, product, and quotient of 2 double numbers which are entered by users. 
*/

import java.util.*;

public class ex2_2_5_calculator {
	public static void main(String[] args) {
		Scanner newscan = new Scanner(System.in);
		double a = newscan.nextDouble(); double b = newscan.nextDouble();
		
		System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        if (b != 0) {
        	System.out.println(String.format("%.3f", a / b));
        } else {
        	System.out.println("The quotient doesn't exist.");
        }
        newscan.close();
	}
}