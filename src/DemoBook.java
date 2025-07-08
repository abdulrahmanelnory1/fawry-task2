public class DemoBook extends Book {

    private String isbn;
    private String title;
    private String year;
    private double price;

    public DemoBook(String isbn, String title, String year) {
        super(isbn, title, year, 0);
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

}
