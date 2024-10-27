package Lab02.Aims;
public class DigitalVideoDisc {
	//Attributes should mostly be private because, again, you don't want to expose the implementation details of a class to other things in your programs!
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

	//constructors
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
//	public DigitalVideoDisc(String category) {
//		super();
//		this.category = category;
//	}
	/* Question: If you create a constructor method to build a DVD by title then create a constructor method to build a DVD by category, 
	 * does JAVA allow you to do this?
	 * 
	 * Answer: no: in the class' program, it will raise error "Duplicate method DigitalVideoDisc(String)".
	*/
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	//Accessor methods (generally not a good practice in OO systems)
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
}
