package hust.soict.dsai.test.cart;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart testingCart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation","Guy Ritchie",128, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Big Hero 6", "Animation", "Don Hall", 102, 14.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 19.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion King 2", "Animation", "Darrell Rooney", 81, 19.95f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Toy Story 2", "Animation", "John Lasseter", 92, 17.99f);

		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7};
		testingCart.addDigitalVideoDisc(dvdList);
		System.out.println();

		testingCart.detailedDisplayCart();
		System.out.println();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a title to search for: ");
		String searchTitle = scanner.nextLine();
		testingCart.searchByTitle(searchTitle);
		System.out.println();

		System.out.println("Enter an ID to search for: ");
		int searchID = scanner.nextInt(); //searchID: 3
		testingCart.searchByID(searchID); //should print out Big Hero 6
		System.out.println();

		scanner.close();
    }
}
