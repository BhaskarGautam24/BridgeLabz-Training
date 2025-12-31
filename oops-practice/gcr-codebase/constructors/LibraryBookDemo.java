import java.util.*;
public class LibraryBookDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // taking book details
        String title = scn.nextLine();
        String author = scn.nextLine();
        double price = scn.nextDouble();

        // creating book object
        Book book = new Book(title, author, price, true);

        // trying to borrow book
        book.borrowBook();

        // trying again to check logic
        book.borrowBook();
    }
}

// class for book
class Book {

    // book variables
    private String title;
    private String author;
    private double price;
    private boolean availability;

    // parameterized constructor
    public Book(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // method to borrow book
    public void borrowBook() {

        // checking availability
        if (availability) {
            availability = false;
            System.out.println("book borrowed successfully");
        } else {
            System.out.println("book not available now");
        }
    }
}

