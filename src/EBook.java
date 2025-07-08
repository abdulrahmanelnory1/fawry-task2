public class EBook extends Book {

    private String isbn;
    private String title;
    private String year;
    private double price;
    private String EmailLink;

    public  EBook(String isbn, String title, String year, double price, String EmailLink) {
        super(isbn, title, year, price);
        this.EmailLink = EmailLink;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }
    public String getYear(){
        return year;
    }

    public double getPrice(){
        return price;
    }

    public String getEmailLink(){
        return EmailLink;
    }
}
