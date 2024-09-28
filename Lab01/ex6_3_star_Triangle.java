/* Ex 6.3 */


import java.util.Scanner;

public class ex6_3_star_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the height of the triangle
        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();

        // Print the triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*(i-1)+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}