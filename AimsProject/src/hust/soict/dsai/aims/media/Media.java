package hust.soict.dsai.aims.media;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private int id;
    
    public Media() {
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
    
}
