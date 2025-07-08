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
    }

    public static List<Book> removeOutDatedBooks(int years){

        List<Book> outDatedBooks = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();

        for (String key : books.keySet()){

            Book book = books.get(key);
            int publishedYear = Integer.parseInt(book.getYear());

            // outdated book
            if(currentYear - publishedYear >= years){
                outDatedBooks.add(book);
                // delete outdated book.
                books.remove(key);
            }
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

            int updatedStock = paperBook.getStock() - quantity;

            paperBook.setStock(updatedStock);

            ShippingService.Shipping("dump address");

            return book.getPrice() *  quantity;
        }

        return book.getPrice();
    }
}
