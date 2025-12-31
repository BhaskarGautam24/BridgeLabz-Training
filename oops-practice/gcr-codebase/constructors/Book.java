public class Book {
    // Attributes (Instance Variables)
    String title;
    String author;
    double price;
    // Default Constructor
    Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void displayBookDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : ₹" + price);
    }
    public static void main(String[] args) {
        Book book1 = new Book();                           // Using default constructor
        System.out.println("Book 1 Details:");
        book1.displayBookDetails();                          
        Book book2 = new Book("Clean Code", "Robert C. Martin", 450.0);   // Using parameterized constructor
        System.out.println("\nBook 2 Details:");
        book2.displayBookDetails();
    }
}

