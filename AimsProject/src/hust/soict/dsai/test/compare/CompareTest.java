package hust.soict.dsai.test.compare;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

public class CompareTest {
	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart();
		
		CompactDisc cd = new CompactDisc("Pink Panther", "Cartoon", "Animator", 10.8f);
		
		cd.addTrack(new Track("Episode 1", 10));
		cd.addTrack(new Track("Episode 2", 9));
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		
		Book book = new Book("HUST", "Education", 5.2f);
		book.addAuthor("Author A");
		book.addAuthor("Author B");
		
		cart.addMedia(cd);
		cart.addMedia(dvd);
		cart.addMedia(book);
		
		cart.sortByCostTitle();
		System.out.println();
		cart.sortByTitleCost();
	}
}
