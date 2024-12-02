package hust.soict.dsai.test;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class miscTest {
    public static void main(String[] args) {
        //copilot please create a cd, a dvd, and a book object for me, you can probably just look at those class programs, good luck

        //cd object
        ArrayList<Track> tracks = new ArrayList<Track>();
        CompactDisc cd = new CompactDisc("CD title", "CD category", 10.0f, "CD director", tracks);
        //dvd object
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD title", "DVD category", "DVD Director", 20, 20.00f); 
        //book object
        ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Author 1", "Author 2"));
        Book book = new Book("Book title", "Book category", 30.00f, authors);

        ArrayList<Media> testMedia = new ArrayList<>(Arrays.asList(cd, dvd, book));
        for (int i = 0; i < testMedia.size(); i++) {
            System.out.println(testMedia.get(i).toString());
        }
        // observation:
        // the output is as expected, the program is able to create the objects and display them correctly
        // that is, for each instance in testMedia, the program is able to call the toString() method of the class of that object:
        // "CD - CD title - CD category - CD director - 0 - 10.0$
        //  DVD - DVD title - DVD category - DVD Director - 20 - 20.0$
        //  Book - Book title - Book category - Author 1 - 30.0$"
        // explanation:
        // the concept of polymorphism is applied here
        // class Media is the superclass of classes Book, CompactDisc, and DigitalVideoDisc (technically we implemented DVD and CD claseses to have a Disc superclass but that class has Media as its superclass anw lol!)
        // the ArrayList testMedia is declared to be of type Media, so it can store objects of any class that extends Media
        // implicitly, the CD, DVD and Book objects were upcasted to class Media when they were added to the ArrayList

    }   
}
