package hust.soict.dsai.aims.media;

//basically only for use in CompactDisc.java
public class Track implements Playable {
    private String title;
    private int length; //in minutes
    
    public Track() {}

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Now playing: " + this.getTitle());
        System.out.println("Length: " + this.getLength());
    }
    
}
