
public class PaperBook extends Book {

    /** the number of available physical copies of the book in the inventory. */
    private int stock;


    public  PaperBook(String isbn, String title, String year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
    }


    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}
