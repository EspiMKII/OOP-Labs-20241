package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 69;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	//add and remove methods
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Added " + media.getTitle() + " to cart.");
			if (itemsOrdered.size() == MAX_NUMBERS_ORDERED-1) {
				System.out.println("The cart is almost full.");
			} else if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is full.");
			}
		} else {
			System.out.println("The cart is full. Remove an item before adding more.");
		}
	}
	public void addMedia(Media[] mediaList) {
		for (Media media :mediaList) {
			this.addMedia(media);
		}
	}

	public void removeMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			System.out.println("Item " + media.getTitle() + " not found in the cart.");
		} else {
			itemsOrdered.remove(media);
			System.out.println("Item " + media.getTitle() + " has been removed from the cart.");
		}
	}
	public void removeMedia(Media[] mediaList) {
		for (Media media : mediaList) {
			this.removeMedia(media);
		}
	}

	//display methods
	public void detailedDisplayCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i += 1) {
			System.out.println((i+1) + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("***************************************************");
	}


	//search methods
	public void searchByTitle(String searchTitle) {
		ArrayList<Media> searchResults = new ArrayList<>();
		for (Media media : itemsOrdered) {
			if (media.isMatch(searchTitle)) {
				searchResults.add(media);
			}
		}
		if (searchResults.isEmpty()) {
			System.out.println("No results found.");
		} else {
			System.out.println("Search results: ");
			for (Media media : searchResults) {
				System.out.println("- " + media.getTitle());
			}
		}
	}

	public void searchByID(int searchID) {
		for (Media media : itemsOrdered) {
			if (media.getId() == searchID) {
				System.out.println("Found DVD: " + media.getTitle());
				return;
			}
		}
		System.out.println("No results found.");
	}

	//misc methods
	public float totalCost() {
		float totalCost = 0;
		for (Media media : itemsOrdered) {
			totalCost += media.getCost();
		}
		return totalCost;
	}

	public void sortCartbyTitle() {
		itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
		System.out.println("Cart sorted by title.");
	}

	public void sortCartbyCost() {
		itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
		System.out.println("Cart sorted by cost.");
	}
}