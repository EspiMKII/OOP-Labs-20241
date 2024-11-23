package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.*; // yeah no arrays suck + literally every relevant jre ever is gonna have this
//rewriting everything in this class to use ArrayLists instead of arrays

public class Cart {
    // "Constructor" for the cart: it's just an ArrayList of DVDs
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();
	
	public void displayCart() {
		System.out.println("Your cart has the following items: ");
		for (DigitalVideoDisc dvd : itemsOrdered) {
			System.out.println(dvd.getTitle());
		}
	}

	public void detailedDisplayCart() {
		// TasK: display the cart like this:
		// ***********************CART***********************
		// Ordered Items:
		// 1. DVD - [Title] - [category] - [Director] - [Length]: [Price] $
		// 2. DVD - [Title] - ...
		// Total cost: [total cost]
		// ***************************************************
		// this is why they told us to write the toString() method in DigitalVideoDisc.java, it makes this task a lot easier
		// question is, should the amount of stars snap to the length of the longest line, or is it fixed?
		// I'm gonna assume it's fixed cause it makes my life easier lol

		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i += 1) {
			System.out.println((i+1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("***************************************************");
	}

	public void searchByTitle(String searchTitle) {
		// Task: search for a dvd in the cart by title, and display the results
		// if no match is found, notify the user
		// Given search reqs from lab02: "When a customer searches for DVDs by title, he or she provides a string of keywords. 
		// If any DVD has the title containing any word in the string of keywords, it is counted as a match. 
		// Note that the comparison of words here is case-insensitive."

		ArrayList<DigitalVideoDisc> searchResults = new ArrayList<>();
		for (DigitalVideoDisc dvd : itemsOrdered) {
			if (dvd.isMatch(searchTitle)) {
				searchResults.add(dvd);
			}
		}
		if (searchResults.isEmpty()) {
			System.out.println("No results found.");
		} else {
			System.out.println("Search results: ");
			for (DigitalVideoDisc dvd : searchResults) {
				System.out.println("- " + dvd.getTitle());
			}
		}
	}

	public void searchByID(int searchID) {
		// ID is kinda a "hidden" attribute, so there is no quick isMatch() method we can pull out
		// That said, if given an ID, there can either only be one match or no match at all, so we can just compare directly the IDs
		// of each DVD

		for (DigitalVideoDisc dvd : itemsOrdered) {
			if (dvd.getId() == searchID) {
				System.out.println("Found DVD: " + dvd.getTitle());
				return;
			}
		}
		System.out.println("No results found.");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc newDisc) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("Your cart is full; please remove some items if you want to add new ones.");
		} else {
			if (itemsOrdered.contains(newDisc)) {
				System.out.println("The disc \"" + newDisc.getTitle() + "\" is already in your cart.");
			} else {
				itemsOrdered.add(newDisc);
				System.out.println("The disc \"" + newDisc.getTitle() + "\" has been added successfully to your cart.");
				if (itemsOrdered.size() == MAX_NUMBERS_ORDERED-1) {
					System.out.println("Your cart is almost full.");
				} else if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
					System.out.println("Your cart is full.");
				}
			}
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc dvd : dvdList) {
			addDigitalVideoDisc(dvd);
		}
	}
	// Obviously, using an array as input is much nicer to write with than using a list of arguments
	// This is an example of method overloading: having multiple methods with the same name but different parameters
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	// This is also an example of method overloading

	public void removeDigitalVideoDisc(DigitalVideoDisc targetDisc) {
		/* we're using remove(int index) cuz it also shifts the elements after the removed one to the left */
		if (itemsOrdered.contains(targetDisc) == false) {
			System.out.println("The disc\"" + targetDisc.getTitle() + "\" does not exist in your cart.");
		} else {
			int temp = itemsOrdered.indexOf(targetDisc);
			itemsOrdered.remove(temp);
			System.out.println("The disc \"" + targetDisc.getTitle() + "\" has been removed successfully from your cart.");
		}
	}

	public float totalCost() {
		float totalCost = 0;
		for (DigitalVideoDisc dvd : itemsOrdered) {
			totalCost += dvd.getCost();
		}
		return totalCost;
	}

	public static void main(String[] args) {
		
	}
}