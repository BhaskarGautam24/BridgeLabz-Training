class MovieNode {

    String title;
    String director;
    int year;
    double rating;

    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
// Doubly Linked List class
class MovieList {
    MovieNode head;
    MovieNode tail;
    // Add movie at end
    void addMovie(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    // Delete movie by title
    void deleteMovie(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {

                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } 
                else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } 
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }
    // Search by director
    void searchByDirector(String director) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println(temp.title + " (" + temp.rating + ")");
            }
            temp = temp.next;
        }
    }
    // Update rating by title
    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }
    // Display forward
    void displayForward() {

        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.rating);
            temp = temp.next;
        }
    }
    // Display reverse
    void displayReverse() {

        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.rating);
            temp = temp.prev;
        }
    }
}
public class MovieManagement {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addMovie("Inception", "Nolan", 2010, 8.8);
        list.addMovie("Interstellar", "Nolan", 2014, 8.6);
        list.addMovie("Avatar", "Cameron", 2009, 7.9);

        list.displayForward();
        list.updateRating("Avatar", 8.1);
        list.searchByDirector("Nolan");

        System.out.println("Reverse Order:");
        list.displayReverse();
    }
}

