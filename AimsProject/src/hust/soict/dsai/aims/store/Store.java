package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public void addDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd) == true){
            System.out.println("DVD \"" + dvd.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(dvd);
            System.out.println("Added DVD \"" + dvd.getTitle() + "\" to the store.");
        }
    }

    public void addDVD(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            itemsInStore.add(dvd);
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd) == false) {
            System.out.println("DVD \"" + dvd.getTitle() + "\" is not in the store.");
        } else {
            itemsInStore.remove(dvd);
            System.out.println("Removed DVD \"" + dvd.getTitle() + "\" from the store.");
        } 
    }
    public void removeDVD(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            itemsInStore.remove(dvd);
        }
    }

    public void listDVDs() {
        System.out.println("*************************STORE*************************");
        System.out.println("Available Discs:");
        for (DigitalVideoDisc dvd : itemsInStore) {
           System.out.println("- " + dvd.toString());
        }
        System.out.println("*******************************************************");
    }

    // honestly if im using arraylists then what's even the point of these methods above lol
}

