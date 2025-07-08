public class BookstoreSystem {

    public static void main(String[] args) {

        Book eBook = new EBook("iden 1" , "email book 1" , "2022", 1000, "Email@gmail.com 1");

        Book paperBook = new PaperBook("iden 2" , "paper 2" , "2020", 1000, 10);

        Book demoBook = new DemoBook("iden 3" , "demo 1" , "2022");



        Inventory.addBook(eBook);
        Inventory.addBook(paperBook);
        Inventory.addBook(demoBook);

        Inventory.buyBook("iden 1", 4,  "Email@gmail.com 1");

        //Inventory.removeOutDatedBooks(3);


    }
}
