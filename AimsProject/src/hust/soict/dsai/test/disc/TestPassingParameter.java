package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());

        System.out.println("Inverting the jungle dvd title change.... .");
        jungleDVD.setTitle("Jungle");
        realSwap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
    // Output:
    // Jungle dvd title: Jungle
    // Cinderella dvd title: Cinderella
    // => This method did nothing to swap these 2 things
    // => because Java is a pass-by-value language

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
    // Output:
    // Jungle dvd title: Cinderella
    // because in the 2nd line of this method, when we called dvd.setTitle(title), we changed the title of the dvd object
    // "dvd" in this method is merely a reference
    // so in the 3rd line, all we are doing is just pointing dvd to a new object, not changing the title of the original object, which got its named changed in the line before
    // => Java is still a pass-by-value language, it just also passes a copy of the reference of the object


    // Task: write a swap method that correctly swaps the 2 objects
    public static void realSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String temp = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(temp);
    }
}
