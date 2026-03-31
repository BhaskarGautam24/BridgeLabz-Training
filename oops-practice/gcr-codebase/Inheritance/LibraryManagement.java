import java.util.*;
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        
        String title;
        int publicationYear;

        String authorName;
        String authorBio;
        System.out.println("enter book title:");
        title = scn.nextLine();
        System.out.println("enter publication year:");
        publicationYear = scn.nextInt();
        scn.nextLine();

       
        System.out.println("enter author name:");
        authorName = scn.nextLine();

        
        System.out.println("enter author bio:");
        authorBio = scn.nextLine();

        // parent reference holding child object
        Book book = new Author(title, publicationYear, authorName, authorBio);

        // displaying book and author info
        book.displayInfo();
    }
}

// superclass book
class Book {

    // private variable for title
    private String title;

    // private variable for year
    private int publicationYear;

    // constructor for book
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // getter for title
    public String getTitle() {
        return title;
    }

    // setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // getter for year
    public int getPublicationYear() {
        return publicationYear;
    }

    // setter for year
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // method to display book info
    public void displayInfo() {
        System.out.println("book title: " + title);
        System.out.println("publication year: " + publicationYear);
    }
}

// subclass author extending book
class Author extends Book {

    // private variable for author name
    private String name;

    // private variable for author bio
    private String bio;

    // constructor for author
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // getter for author name
    public String getName() {
        return name;
    }

    // setter for author name
    public void setName(String name) {
        this.name = name;
    }

    // getter for bio
    public String getBio() {
        return bio;
    }

    // setter for bio
    public void setBio(String bio) {
        this.bio = bio;
    }

    // overriding display method
    @Override
    public void displayInfo() {

        // calling parent display
        super.displayInfo();

        // showing author details
        System.out.println("author name: " + name);
        System.out.println("author bio: " + bio);
    }
}

