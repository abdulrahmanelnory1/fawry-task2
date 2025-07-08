 abstract class Book {

    private String isbn;
    private String title;
    private String year;
    private double price;

    public Book(String isbn, String title, String year,  double price) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
    }


     abstract String getIsbn();

     abstract String getTitle();

     abstract String getYear();

     abstract double getPrice();

}
