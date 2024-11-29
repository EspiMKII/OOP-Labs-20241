package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Kung Fu Panda", "Animation", "John Stevenson", 92, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation","Guy Ritchie",128, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Big Hero 6", "Animation", "Don Hall", 102, 14.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 19.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Lion King 2", "Animation", "Darrell Rooney", 81, 19.95f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Toy Story 2", "Animation", "John Lasseter", 92, 17.99f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Toy Story 3", "Animation", "Lee Unkrich", 103, 16.99f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Toy Story 4", "Animation", "Josh Cooley", 100, 15.99f);
        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 20.99f);
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("The Bee Movie", "Animation", "Simon J. Smith", 91, 13.99f);
        DigitalVideoDisc dvd12 = new DigitalVideoDisc("The Incredibles 2", "Animation", "Brad Bird", 118, 21.99f);
        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9, dvd10, dvd11, dvd12};

        // actual mickey mouse testing YEP

        Store testingStore = new Store();
        testingStore.addDVD(dvdList);
        System.out.println();

        testingStore.listDVDs();
        System.out.println();

        testingStore.removeDVD(dvd11);
        testingStore.listDVDs(); 
        System.out.println();
}
}
