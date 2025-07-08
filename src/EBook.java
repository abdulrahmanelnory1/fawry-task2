public class EBook extends Book {

    private String EmailLink;

    public  EBook(String isbn, String title, String year, double price, String EmailLink) {
        super(isbn, title, year, price);
        this.EmailLink = EmailLink;
    }

    public String getEmailLink(){
        return EmailLink;
    }
}
