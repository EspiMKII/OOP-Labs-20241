package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 69;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	//add and remove methods
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Added " + media.getTitle() + " to cart.");
			System.out.println("Cart now has " + itemsOrdered.size() + " items.");
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

	public void simpleDisplayCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i += 1) {
			System.out.println((i+1) + ". " + itemsOrdered.get(i).getClass().getSimpleName() + ": " + itemsOrdered.get(i).getTitle());
		}
		System.out.println("***************************************************");
	}


	//search methods
	public void filterByTitle(String searchTitle) {
		ArrayList<Media> filterResults = new ArrayList<>();
		for (Media media : itemsOrdered) {
			if (media.isMatch(searchTitle)) {
				filterResults.add(media);
			}
		}
		if (filterResults.isEmpty()) {
			System.out.println("No results found.");
		} else {
			System.out.println("Filter results: ");
			for (Media media : filterResults) {
				System.out.println("- " + media.getTitle());
			}
		}
	}

	public void filterByID(int searchID) {
		for (Media media : itemsOrdered) {
			if (media.getId() == searchID) {
				System.out.println("Found DVD: " + media.getTitle());
				return;
			}
		}
		System.out.println("No results found.");
	}

	public Media findByTitle(String searchTitle) {
		for (Media media : itemsOrdered) {
			if (media.isMatch(searchTitle)) {
				return media;
			}
		}
		return null;
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

	public void clear() {
		itemsOrdered.clear();
		System.out.println("Cart cleared.");
	}
}