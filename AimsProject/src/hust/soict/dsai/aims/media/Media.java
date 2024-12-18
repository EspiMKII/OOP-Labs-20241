package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private String title;
    private String category;
    private float cost;
    private int id;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparator.MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparator.MediaComparatorByCostTitle();
    
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

    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return this.getTitle().equals(media.getTitle());
    }
    
}
