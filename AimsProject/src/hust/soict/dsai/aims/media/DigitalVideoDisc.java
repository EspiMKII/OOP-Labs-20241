package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length; // in minutes

	//constructors
	public DigitalVideoDisc(String title) {
		this.setTitle(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.setTitle(title);
		this.setCategory(category);
		this.director = director;
		this.setCost(cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.director = director;
		this.length = length;
		this.setCost(cost);
	}

	//Other methods (probably will have to categorize them at some point lol)
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director + " - " + Integer.toString(this.length) + " - " + Float.toString(this.getCost()) + "$";
	}

	public boolean isMatch(String title) {
		return this.getTitle().toLowerCase().contains(title.toLowerCase());
	}

	public static void main(String[] args) {
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		System.out.println(dvd.toString());
		System.out.println(dvd.isMatch("lion"));
	}
}
