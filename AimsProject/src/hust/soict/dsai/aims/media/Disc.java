package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
	private int length; // in minutes
    
    //constructor
    public Disc() {
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    //getters
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    //setters
    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    
}
