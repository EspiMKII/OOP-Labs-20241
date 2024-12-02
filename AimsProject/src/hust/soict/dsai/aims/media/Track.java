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

    @Override
    public boolean equals(Object obj) {
        Track track = (Track) obj;
        //assumption: obj is an instance of class Track
        //what happens if obj is not? => the program throws a ClassCastException
        return this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength();
    }

    public static void main(String[] args) {
        Track track1 = new Track("Hello", 5);
        Track dvd2 = new Track("Hello", 5);
        System.out.println(track1.equals(dvd2));
    }
    
}
