import java.util.*;
public class LibraryAggregationDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // asking library name
        System.out.print("enter first library name: ");
        String firstLibraryName = scn.nextLine();
        // asking second library name
        System.out.print("enter second library name: ");
        String secondLibraryName = scn.nextLine();
        // creating library objects
        Library firstLibrary = new Library(firstLibraryName);
        Library secondLibrary = new Library(secondLibraryName);
        // creating book objects
        Book bookOne = new Book("clean code", "robert martin");
        Book bookTwo = new Book("effective java", "joshua bloch");
        Book bookThree = new Book("java basics", "some author");
        // adding books to first library
        firstLibrary.addBook(bookOne);
        firstLibrary.addBook(bookTwo);

      // adding books to second library
        secondLibrary.addBook(bookTwo);
        secondLibrary.addBook(bookThree);

        // showing library books
        firstLibrary.showBooks();
        secondLibrary.showBooks();
    }
}
class Library {

    // library name variable
    private String libraryName;

    // list to store books
    private ArrayList<Book> bookList;

    // constructor for library
    public Library(String libraryName) {
        // assigning name using this keyword
        this.libraryName = libraryName;
        // creating arraylist for books
        this.bookList = new ArrayList<Book>();
    }

    // method to add book
    public void addBook(Book book) {
        // adding book into list
        bookList.add(book);
    }

    // method to display books
    public void showBooks() {
        // printing library name
        System.out.println("\nlibrary name: " + libraryName);

        // loop for showing books
        for (int i = 0; i < bookList.size(); i++) {
            // getting book object
            Book tempBook = bookList.get(i);
            // showing book details
            tempBook.displayBook();
        }
    }

    // getter for library name
    public String getLibraryName() {
        return libraryName;
    }

    // setter for library name
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
}
class Book {

    // title of book
    private String title;

    // author of book
    private String author;

    // constructor for book
    public Book(String title, String author) {
        // assigning values
        this.title = title;
        this.author = author;
    }

    // method to show book info
    public void displayBook() {
        // printing book details
        System.out.println("book title: " + title + " | author: " + author);
    }

    // getter for title
    public String getTitle() {
        return title;
    }

    // setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // getter for author
    public String getAuthor() {
        return author;
    }

    // setter for author
    public void setAuthor(String author) {
        this.author = author;
    }
}
