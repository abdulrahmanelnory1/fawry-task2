import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    /** represents the available books. */

    private static Map<String, Book> books = new HashMap<>();

    public static void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Book with isbn " + book.getIsbn() + " added successfully");
    }
    


    public static List<Book> removeOutDatedBooks(int years) {
        
        List<Book> outDatedBooks = new ArrayList<>();
        List<String> keysToRemove = new ArrayList<>();
        
        int currentYear = LocalDate.now().getYear();

        // find keys to remove.
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            
            Book book = entry.getValue();
            
            int publishedYear = Integer.parseInt(book.getYear());
            
            // outdated book
            if (currentYear - publishedYear >= years) {
                outDatedBooks.add(book);
                keysToRemove.add(entry.getKey());
            }
        }

        // Remove outdated books
        for (String key : keysToRemove) {
            books.remove(key);
            System.out.println("Book removed successfully");
        }

        return outDatedBooks;
    }

    public static double buyBook(String isbn, int quantity, String Email){

        if(!books.containsKey(isbn))
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist");

        Book book = books.get(isbn);

        if(book instanceof DemoBook)
            throw new IllegalArgumentException("the book is not for sail.");


        if((book instanceof EBook)){

            // Send EBook to MailService with the email provided
            MailService.Mail(((EBook) book).getEmailLink());
            return book.getPrice(); // the quantity does not matter.
        }

        if((book instanceof PaperBook)){

            PaperBook paperBook = (PaperBook) book;

            if(quantity > paperBook.getStock())
                throw new IllegalArgumentException("there is not enough books in the stock.");

            int updatedStock = paperBook.getStock() - quantity;

            paperBook.setStock(updatedStock);

            ShippingService.Shipping("dump address");

            return book.getPrice() *  quantity;
        }

        return book.getPrice();
    }
}
