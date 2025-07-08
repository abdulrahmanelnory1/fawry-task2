
public class PaperBook extends Book {

    /** the number of available physical copies of the book in the inventory. */
    private int stock;
    private String isbn;
    private String title;
    private String year;
    private double price;

    public  PaperBook(String isbn, String title, String year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
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

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}
