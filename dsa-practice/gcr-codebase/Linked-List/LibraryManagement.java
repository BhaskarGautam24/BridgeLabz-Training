class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean available;

    BookNode next;
    BookNode prev;

    BookNode(int id, String title, String author, String genre, boolean available) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }
}

// Doubly Linked List class
class Library {

    BookNode head, tail;
    // Add book at end
    void addBook(int id, String title, String author, String genre, boolean available) {

        BookNode newNode = new BookNode(id, title, author, genre, available);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    // Remove book by ID
    void removeBook(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {

                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }
    // Search book
    void searchBook(String key) {

        BookNode temp = head;

        while (temp != null) {
            if (temp.title.equals(key) || temp.author.equals(key)) {
                System.out.println(temp.title + " by " + temp.author);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found");
    }
    // Update availability
    void updateStatus(int id, boolean status) {

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }
    // Display forward
    void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " Available: " + temp.available);
            temp = temp.next;
        }
    }
    // Display reverse
    void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " Available: " + temp.available);
            temp = temp.prev;
        }
    }
    // Count books
    int countBooks() {

        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(1, "Java", "James", "Tech", true);
        lib.addBook(2, "Python", "Guido", "Tech", true);
        lib.addBook(3, "C++", "Bjarne", "Tech", false);
        lib.displayForward();
        lib.searchBook("Guido");
        lib.updateStatus(3, true);

        System.out.println("Reverse Order:");
        lib.displayReverse();
        System.out.println("Total Books: " + lib.countBooks());
    }
}

