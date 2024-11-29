package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();
    
    public Book() {
        super();
    }

    public void addAuthor(String authorName) {
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.authors + " - " + this.getCost() + "$";
    }
    
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setTitle("SAO Light Novel Volume 14: Alicization Uniting");
        book1.setCategory("Action");
        book1.setCost(15.99f);
        book1.addAuthor("Reki Kawahara");

        System.out.println(book1.toString());
    }
}
