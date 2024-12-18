package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparator;

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

    public void listMediaSimple() {
        System.out.println("*************************STORE*************************");
        System.out.println("Available Items:");
        for (Media media : itemsInStore) {
            System.out.println("- " + media.getClass().getSimpleName() + ": " + media.getTitle());
        }
        System.out.println("*******************************************************");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void IDAssignment() { //we're just gonna assign IDs based on the order and number of the items in the store
        itemsInStore.sort(new MediaComparator.MediaComparatorByTitleCost());
        for (int i = 0; i < itemsInStore.size(); i++) {
            itemsInStore.get(i).setId(i+1);
        }
    }
}