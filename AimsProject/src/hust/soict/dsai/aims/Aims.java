package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();
        System.out.println("Created a new cart.");

        //Create a new DVD object and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
        anOrder.addDigitalVideoDisc(dvdList);

        //Print the cart and the total cost of the items in the cart
        anOrder.displayCart();
        System.out.println("ID of \"The Lion King\" dvd is " + dvd1.getId());

        // Lab03 section 5 information:
        // anOrder.displayCart() only displays the titles of the DVDs in the cart
        // This is an example of instance attributes in play: we only take the titles (instance attributes) of the DVDs in the cart
        // dvd1's id is also an instance attribute, but it is determined by the class attribute nbDigitalVideoDiscs

        System.out.println("Total cost is: " + anOrder.totalCost() + "$");
    }
}