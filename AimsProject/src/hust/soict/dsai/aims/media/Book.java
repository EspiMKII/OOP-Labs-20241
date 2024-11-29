package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class Book {
    private String title;
    private String category;
    private float cost;
    private ArrayList<String> authors = new ArrayList<String>();
    private int id;
    
    public Book() {
    }

    //getters
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
    public ArrayList<String> getAuthors() {
        return authors;
    }
    public int getId() {
        return id;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public void addAuthor(String authorName) {
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public String toString() {
        return "Book - " + this.title + " - " + this.category + " - " + this.authors + " - " + this.cost + "$";
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
