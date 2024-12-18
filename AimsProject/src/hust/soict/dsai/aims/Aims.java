package hust.soict.dsai.aims;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void showMenu(Scanner scanner, Cart cart, Store store) {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");

        int choice = scanner.nextInt();
        String fixEmptyBuffer = scanner.nextLine(); // javagony

        if (choice == 0) { // exit
            System.out.println("Confirm exit? (y/n)");
            String confirm = scanner.next();
            if (confirm.equals("y")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                showMenu(scanner, cart, store);
            }

        } else if (choice == 2) { // update store
            updateStoreMenu(scanner, cart, store);
            // i just remembered at this point that java is a pass-by-value language
            // it's so over there will actually be like tons of garbage data everywhere
        } else if (choice == 1) { // view store
            storeMenu(scanner, cart, store);
        } else if (choice == 3) { // cart
            cartMenu(scanner, cart, store);
        }
        showMenu(scanner, cart, store);
    }

    public static void updateStoreMenu(Scanner scanner, Cart cart, Store store) { /* DONE */
        System.out.println("Update store: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");

        int choice = scanner.nextInt();
        String fixEmptyBuffer = scanner.nextLine(); // javagony

        if (choice == 0) { // back
            showMenu(scanner, cart, store);
        } else if (choice == 1) { // add media
            System.out.println("Which type of media should be added?");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            System.out.println("0. Back");

            choice = scanner.nextInt();
            fixEmptyBuffer = scanner.nextLine(); // javagony
            String[] tempInput;

            if (choice == 0) { // back
                updateStoreMenu(scanner, cart, store);
            } else {
                System.out.println("Enter the media's title, category, and cost, separated by spaces, in that order:");
                tempInput = scanner.nextLine().split(" ");
                String title = tempInput[0];
                String category = tempInput[1];
                float cost = Float.parseFloat(tempInput[2]);

                if (choice == 1) { // book
                    store.addMedia(createBook(scanner, title, category, cost));
                } else if (choice == 2) { // dvd
                    store.addMedia(createDVD(scanner, title, category, cost));
                } else if (choice == 3) { // cd
                    store.addMedia(createCD(scanner, title, category, cost));
                }
            }
        } else if (choice == 2) { // remove media
            store.listMediaSimple();
            System.out.println("Enter the title of the media to be removed:");

            String title = scanner.nextLine();
            store.removeMedia(store.searchByTitle(title));
        }
        showMenu(scanner, cart, store);
    }

    public static Book createBook(Scanner scanner, String title, String category, float cost) { // helper method for
                                                                                                // updateStoreMenu
        System.out.println("Enter the author(s) of the book, separated by spaces:");
        String[] tempInput = scanner.nextLine().split(" ");
        return new Book(title, category, cost, new ArrayList<String>(Arrays.asList(tempInput)));
    }

    public static DigitalVideoDisc createDVD(Scanner scanner, String title, String category, float cost) { // helper
                                                                                                           // method for
                                                                                                           // updateStoreMenu
        System.out
                .println("Enter the director and length (in minutes) of the DVD, separated by spaces, in that order:");
        String[] tempInput = scanner.nextLine().split(" ");
        return new DigitalVideoDisc(title, category, tempInput[0], Integer.parseInt(tempInput[1]), cost);
    }

    public static CompactDisc createCD(Scanner scanner, String title, String category, float cost) { // helper method
                                                                                                     // for
                                                                                                     // updateStoreMenu
        System.out.println("Enter the artist and the number of tracks of the CD, separated by spaces, in that order:");
        String[] tempInput = scanner.nextLine().split(" ");
        String artist = tempInput[0];
        int numTracks = Integer.parseInt(tempInput[1]);
        System.out.println("In the following " + numTracks
                + " lines, enter the title and length (in minutes) of each track, separated by spaces, in that order:");
        ArrayList<Track> tracks = new ArrayList<>();
        for (int i = 0; i < numTracks; i++) {
            tempInput = scanner.nextLine().split(" ");
            tracks.add(new Track(tempInput[0], Integer.parseInt(tempInput[1])));
        }
        return new CompactDisc(title, category, cost, artist, tracks);
    }

    public static void storeMenu(Scanner scanner, Cart cart, Store store) { /* DONE */
        System.out.println("Store: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");

        int choice = scanner.nextInt();
        String fixEmptyBuffer = scanner.nextLine(); // javagony

        if (choice == 0) { // back
            showMenu(scanner, cart, store);
        } else if (choice == 1) { // see media details
            store.listMediaSimple();
            System.out.println("Enter the title of the media to see its details:");

            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
            if (media == null) {
                System.out.println("Media not found.");
            } else {
                mediaDetailsMenu(scanner, cart, store, media);
            }
        } else if (choice == 2) { // add media to cart
            store.listMediaSimple();
            System.out.println("Enter the title of the media to add to cart:");

            String title = scanner.nextLine();
            cart.addMedia(store.searchByTitle(title));
        } else if (choice == 3) { // play media
            store.listMediaSimple();
            System.out.println("Enter the title of the media to play:");

            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else if (choice == 4) { // see cart
            cartMenu(scanner, cart, store);
        }
        showMenu(scanner, cart, store);
    }

    public static void mediaDetailsMenu(Scanner scanner, Cart cart, Store store, Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");

        int choice = scanner.nextInt();
        String fixEmptyBuffer = scanner.nextLine(); // javagony

        if (choice == 0) { // back
            storeMenu(scanner, cart, store);
        } else if (choice == 1) { // add to cart
            cart.addMedia(media);
        } else if (choice == 2) { // play
            if (media instanceof Playable) {
                ((Playable) media).play();
            }

        }
        showMenu(scanner, cart, store);
    }

    public static void cartMenu(Scanner scanner, Cart cart, Store store) { /* DONE */
        System.out.println("Cart: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");

        int choice = scanner.nextInt();
        String fixEmptyBuffer = scanner.nextLine(); // javagony

        if (choice == 0) { // back
            showMenu(scanner, cart, store);
        } else if (choice == 2) { // sort medias
            System.out.println("Sort by title or cost?");
            System.out.println("1. Title");
            System.out.println("2. Cost");
            System.out.println("0. Back");

            choice = scanner.nextInt();
            fixEmptyBuffer = scanner.nextLine(); // javagony
            if (choice == 0) {
                cartMenu(scanner, cart, store);
            } else if (choice == 1) {
                cart.sortCartbyTitle();
            } else if (choice == 2) {
                cart.sortCartbyCost();
            }
        } else if (choice == 3) { // remove media
            cart.simpleDisplayCart();
            System.out.println("Enter the title of the media to remove:");

            String title = scanner.nextLine();
            cart.removeMedia(cart.findByTitle(title));
        } else if (choice == 4) { // play media
            cart.simpleDisplayCart();
            System.out.println("Enter the title of the media to play:");

            String title = scanner.nextLine();
            Media media = cart.findByTitle(title);
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else if (choice == 5) { // place order
            System.out.println("Total cost: " + cart.totalCost());
            System.out.println("Place order? (y/n)");
            String confirm = scanner.next();
            if (confirm.equals("y")) {
                cart.clear();
                System.out.println("Order placed!");
            }
        } else if (choice == 2) { // filter medias
            System.out.println("Filter by title or ID?");
            System.out.println("1. Title");
            System.out.println("2. ID");
            System.out.println("0. Back");

            choice = scanner.nextInt();
            fixEmptyBuffer = scanner.nextLine(); // javagony

            if (choice == 0) {
                cartMenu(scanner, cart, store);
            } else if (choice == 1) {
                System.out.println("Enter the title to filter by:");
                String title = scanner.nextLine();
                cart.filterByTitle(title);
            } else if (choice == 2) {
                System.out.println("Enter the ID to filter by:");
                int ID = scanner.nextInt();
                fixEmptyBuffer = scanner.nextLine(); // javagony
                cart.filterByID(ID);
            }
        }
        showMenu(scanner, cart, store);
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        // i wish i knew how to use a database to store the media data......
        // hey copilot what do i use to do that, preferrably something easy for a
        // beginner like me
        // i dont know how to use databases, but i can help you with the code to connect
        // to a database
        // yeah but with what
        // you can use JDBC to connect to a database
        // oh like java.sql and that stuff?
        // yes, you can use that to connect to a database
        // thanks, i'll look into it... later

        // creating some media, manually.... for now
        ArrayList<String> authors = new ArrayList<String>(Arrays.asList("Reki Kawahara"));
        Book book1 = new Book("SAO Light Novel vol.14: Alicization Uniting", "Action", 15.99f, authors);
        authors = new ArrayList<String>(Arrays.asList("Matt Parker"));
        Book book2 = new Book("Humble Pi", "Science", 10.99f, authors);
        authors = new ArrayList<String>(Arrays.asList("Philipi Schneider"));
        Book book3 = new Book("The Largest Known Prime Number", "Math", 0.99f, authors);
        authors = new ArrayList<String>(Arrays.asList("Sun Tzu"));
        Book book4 = new Book("The Art of War", "Philosophy", 5.99f, authors);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Big Hero 6", "Animation", "Don Hall", 102, 14.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 19.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Parkour Civilization 2", "Socio-philosophy", "Evbo", 113, 6.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Minecraft: Story Mode - Season One", "Adventure",
                "Telltale Games", 450, 29.99f);

        ArrayList<Track> tracks = new ArrayList<Track>(Arrays.asList(new Track("Y6U", 233),
                new Track("Liu La Liu Lo", 196),
                new Track("Side Effects", 274),
                new Track("Ngon Ngan", 195),
                new Track("Van Yeu", 183),
                new Track("Them Dua Nua", 208)));
        CompactDisc cd1 = new CompactDisc("LOV6", "Pop", 9.99f, "Rhymastic", tracks);
        tracks = new ArrayList<Track>(Arrays.asList(new Track("Loi To Tinh Cua Mua Xuan", 384),
                new Track("Don Xuan Nay Nho Xuan Xua", 305),
                new Track("Em Da Thay Mua Xuan Chua", 308),
                new Track("Nang Co Con Xuan", 244),
                new Track("Nhu Hoa Mua Xuan", 255)));
        CompactDisc cd2 = new CompactDisc("Loi To Tinh Cua Mua Xuan", "Pop", 9.99f, "Quoc Thien", tracks);
        // ill get cancer if i tryna make 1 more cd
        // in fact ill get cancer if i tryna make 1 more media object manually holy crap
        // i need to learn jdbc

        Media[] mediaList = { book1, book2, book3, book4, dvd1, dvd2, dvd3, dvd4, cd1, cd2 };
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(new java.io.OutputStream() {
            @Override
            public void write(int b) {
                // do nothing
            }
        }));
        store.addMedia(mediaList);
        store.IDAssignment();
        System.setOut(originalOut);

        System.out.println("Welcome to AIMS!");
        System.out.println(
                "This is a very barebone CLI program; effectively, your only mean of interaction is by typing inputs in the console.");
        System.out.println(
                "Admittedly, this program is not very smart. Please enter numbers/titles correctly, capitals and all.");
        showMenu(scanner, cart, store);

        scanner.close();
    }
}