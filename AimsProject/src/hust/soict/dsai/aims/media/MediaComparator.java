package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparator {
    public static class MediaComparatorByTitleCost implements Comparator<Media>{
        @Override
        public int compare(Media media1, Media media2) {
            int titleCompare = media1.getTitle().compareTo(media2.getTitle());
            if (titleCompare == 0) {
                return Float.compare(media1.getCost(), media2.getCost());
            } else {return titleCompare;}
        }
    }
    
    public static class MediaComparatorByCostTitle implements Comparator<Media> {
        @Override
        public int compare(Media media1, Media media2) {
            int costCompare = -Float.compare(media1.getCost(), media2.getCost());
            if (costCompare == 0) {
                return media1.getTitle().compareTo(media2.getTitle());
            } else {
                return costCompare;
            }
        }
    }
}