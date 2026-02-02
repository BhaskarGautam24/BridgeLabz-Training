import java.util.*;
interface Observer{
    void update(String message);
}
interface User extends Observer{
    void showRole();
}
class Student implements User{
    private String name;

    public Student(String name){
        this.name=name;
    }
    public void showRole(){
        System.out.println(name+" is a Student.");
    }
    public void update(String message){
        System.out.println(name+" notified: "+message);
    }
}
class Faculty implements User{
    private String name;

    public Faculty(String name){
        this.name=name;
    }

    public void showRole(){
        System.out.println(name+" is a Faculty.");
    }

    public void update(String message){
        System.out.println(name+" notified: "+message);
    }
}
class Librarian implements User{
    private String name;

    public Librarian(String name){
        this.name=name;
    }

    public void showRole(){
        System.out.println(name+" is a Librarian.");
    }

    public void update(String message){
        System.out.println(name+" notified: "+message);
    }
}
class UserFactory{
    public static User createUser(String type,String name){
        if(type.equalsIgnoreCase("student")){
            return new Student(name);
        }
        else if(type.equalsIgnoreCase("faculty")){
            return new Faculty(name);
        }
        else if(type.equalsIgnoreCase("librarian")){
            return new Librarian(name);
        }
        else{
            throw new IllegalArgumentException("Invalid User Type");
        }
    }
}
class Book{
    private String title;
    private String author;
    private String edition;
    private String genre;

    private Book(BookBuilder builder){
        this.title=builder.title;
        this.author=builder.author;
        this.edition=builder.edition;
        this.genre=builder.genre;
    }

    public String getTitle(){
        return title;
    }

    public static class BookBuilder{
        private String title;
        private String author;
        private String edition;
        private String genre;

        public BookBuilder(String title){
            this.title=title;
        }

        public BookBuilder author(String author){
            this.author=author;
            return this;
        }

        public BookBuilder edition(String edition){
            this.edition=edition;
            return this;
        }

        public BookBuilder genre(String genre){
            this.genre=genre;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }
}
class LibraryCatalog{
    private static LibraryCatalog instance;
    private List<Book> books;
    private List<Observer> observers;

    private LibraryCatalog(){
        books=new ArrayList<Book>();
        observers=new ArrayList<Observer>();
    }

    public static synchronized LibraryCatalog getInstance(){
        if(instance==null){
            instance=new LibraryCatalog();
        }
        return instance;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void addBook(Book book){
        books.add(book);
        notifyObservers(book.getTitle());
    }

    private void notifyObservers(String bookName){
        for(Observer observer:observers){
            observer.update("New book available: "+bookName);
        }
    }
}
public class LibraryApp{
    public static void main(String[] args){
        LibraryCatalog catalog=LibraryCatalog.getInstance();
        User student=UserFactory.createUser("student","Bhaskar");
        User faculty=UserFactory.createUser("faculty","Gaurav");

        student.showRole();
        faculty.showRole();
        catalog.addObserver(student);
        catalog.addObserver(faculty);
        Book book=new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .genre("Software Engineering")
                .build();
        catalog.addBook(book);
    }
}

