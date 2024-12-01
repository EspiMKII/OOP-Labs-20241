package hust.soict.dsai.test.store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
       ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Reki Kawahara"));
		Book book1 = new Book("SAO Light Novel vol.14: Alicization Uniting", "Action", 15.99f, authors);
		
		authors = new ArrayList<String>(Arrays.asList("Matt Parker"));
		Book book2 = new Book("Humble Pi", "Science", 10.99f, authors);
		
		authors = new ArrayList<String>(Arrays.asList("Philipi Schneider"));
		Book book3 = new Book("The Largest Known Prime Number", "Math", 0.99f, authors);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Big Hero 6", "Animation", "Don Hall", 102, 14.99f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 19.99f);
		
		ArrayList<Track> tracks = new ArrayList<Track>(Arrays.asList(new Track("Y6U", 233), 
																	new Track("Líu La Líu Lo", 196),
																	new Track("Side Effects", 274),
																	new Track("Ngổn Ngang", 195),
																	new Track("Vẫn Yêu", 183), 
																	new Track("Thêm Đứa Nữa", 208)));
		CompactDisc cd6 = new CompactDisc("LOV6", "Pop", 9.99f, "Rhymastic", tracks);

		tracks = new ArrayList<Track>(Arrays.asList(new Track("Lời Tỏ Tình Của Mùa Xuân", 384),
													new Track("Đón Xuân Này Nhớ Xuân Xưa", 305),
													new Track("Em Đã Thấy Mùa Xuân Chưa", 308),
													new Track("Nắng Có Còn Xuân", 244),
													new Track("Như Hoa Mùa Xuân", 255)));
		CompactDisc cd7 = new CompactDisc("Lời Tỏ Tình Của Mùa Xuân", "Pop", 9.99f, "Quốc Thiên", tracks);
		
		Media[] mediaList = {book1, book2, book3, dvd4, dvd5, cd6, cd7};

        Store testingStore = new Store();
        testingStore.addMedia(mediaList);;
        System.out.println();

        testingStore.listMedia();;
        System.out.println();

        testingStore.removeMedia(dvd5);
        testingStore.listMedia(); 
        System.out.println();
}
}
