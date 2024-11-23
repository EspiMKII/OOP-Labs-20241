package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc; 

public class Cart {
    // "Constructor" for the cart: it's just an array of DVDs
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void displayCart() {
		System.out.println("Your cart has the following items: ");
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i += 1) {
			if (itemsOrdered[i] != null) {
				System.out.println("- " + itemsOrdered[i].getTitle());
			}
		}
	}
	
	

	public void addDigitalVideoDisc(DigitalVideoDisc newDisc) {
		/* 
		- adds a new disc to the "end" of the cart list
		- if the cart is full, print out that the disc cannot be added because it's full (duh)
		
		breakdown:
		- the only way we can kind of modify an array is to edit a specific element at an index of that array
		- we also know how to iterate over an array => it's probably possible to check if a cart is full or not with this
		
		- process:
		+ iterate through the array
		+ for each iteration, check if the current element is a DVD, or is nothing yet.
		+ if it is nothing yet, we can modify that element to be the new DVD and terminate the method
		+ if it is a DVD, move on 
		+ if the loop successfully iterates through the entire array, we know that the cart is full => print message
		+ don't forget interaction with customers!
		*/
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i += 1) {
			if (itemsOrdered[i] == null) {
				itemsOrdered[i] = newDisc;
				System.out.println("The disc \"" + newDisc.getTitle() + "\" has been added successfully to your cart.");
				if (i == 19) {
					System.out.println("Your cart is almost full.");
				} else if (i == 20) {
					System.out.println("Your cart is full.");
				}	
				return;
			} else if (itemsOrdered[i].getTitle() == newDisc.getTitle()) {
				System.out.println("The disc \"" + newDisc.getTitle() + "\" is already in your cart.");
				return;
			}
		}
		System.out.println("Your cart is full; please remove some items if you want to add new ones.");
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
		/*
		- removes a disc from the cart, given the disc identity
		- if the disc is not in the cart, prints out to the user that it isn't
		
		- process:
		+ by "removing", we can mean changing that disc in the cart to null
		+ same thing: iterate through the cart
		+ for each element, check if that is the same as the target disc (for the sake of simplicity, let's just say that their titles are the same)
		+ if it is, turn that element to null and terminate the method (since there wouldn't be duplicate discs)
		+ if it is not, continue with the loop
		+ if the loop successfully iterates through the list, the target disc is not in the cart
		*/
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i += 1) {
			if (itemsOrdered[i].getTitle() == targetDisc.getTitle()) {
				itemsOrdered[i] = null;
				System.out.println("The disc \""+ targetDisc.getTitle() + "\" has been successfully removed from your cart.");
				return;
			}
		}
		System.out.println("The disc\"" + targetDisc.getTitle() + "\" does not exist in your cart.");
		
	}

	public float totalCost() {
		float totalCost = 0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i += 1) {
			if (itemsOrdered[i] != null) {
				totalCost += itemsOrdered[i].getCost();
			}
		}
		return totalCost;
	}

}
