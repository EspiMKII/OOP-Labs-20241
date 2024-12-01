package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Item " + media.getTitle() + " is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("Added item " + media.getTitle() + " to the store.");
        }
    }
    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            this.addMedia(media);
        }
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("Item " + media.getTitle() + " is not in the store.");
        } else {
            itemsInStore.remove(media);
            System.out.println("Removed item " + media.getTitle() + " from the store.");
        }
    }
    public void removeMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            this.removeMedia(media);
        }
    }

    public void listMedia() {
        System.out.println("*************************STORE*************************");
        System.out.println("Available Items:");
        for (Media media : itemsInStore) {
           System.out.println("- " + media.toString());
        }
        System.out.println("*******************************************************");
    }
}

