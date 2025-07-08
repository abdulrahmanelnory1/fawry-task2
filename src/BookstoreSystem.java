import java.util.ArrayList;
import java.util.List;

public class BookstoreSystem {

    public static void main(String[] args) {

        Book eBook = new EBook("iden 1" , "email book 1" , "2022", 1000, "Email@gmail.com 1");
        Book paperBook = new PaperBook("iden 2" , "paper 2" , "2024", 1000, 10);
        Book demoBook = new DemoBook("iden 3" , "demo 1" , "2022");

        System.out.println("\nAdding Test: ");

        Inventory.addBook(eBook);
        Inventory.addBook(paperBook);
        Inventory.addBook(demoBook);

        System.out.println("\nBuying EBook - Email service activation");
        Inventory.buyBook("iden 1", 4,  "Email@gmail.com 1");

        System.out.println("--------------------------------------------------------------\n");
        System.out.println("Buying PaperBook with - available quantity books - shipping service activation");
        Inventory.buyBook("iden 2", 4,  "Email@gmail.com 1");

        System.out.println("--------------------------------------------------------------\n");
        System.out.println("Removing outdated books 3 years ago");
        Inventory.removeOutDatedBooks(3);

        System.out.println("--------------------------------------------------------------\n");
        System.out.println("Buying PaperBook with - not available quantity books - shipping service activation");
        Inventory.buyBook("iden 2", 100,  "Email@gmail.com 1");

    }
}
