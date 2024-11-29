package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();
    
    public CompactDisc() {
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        }
    }
    //I didn't want to inform the user (here, it would probably be the store manager) with messages for the 2 methods above because after all,
    //they are used to construct CDs, which are the things actually being sold.
    //I don't think the user would want to know if the track is already in the CD or not, they just want to add it to the CD

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public static void main(String[] args) {
        CompactDisc cd = new CompactDisc();
        Track track1 = new Track("Hello", 5);
        Track track2 = new Track("World", 3);
        cd.addTrack(track1);
        cd.addTrack(track2);
        System.out.println(cd.getLength());
    }
}
