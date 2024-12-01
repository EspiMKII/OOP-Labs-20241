package hust.soict.dsai.aims.media;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private int id;
    
    //empty constructor because lol
    public Media() {
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    //getters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }


    //setters
    
    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    //other methods
    
    public boolean isMatch(String keyword) {
		return this.getTitle().toLowerCase().contains(keyword.toLowerCase());
	}
    
}
