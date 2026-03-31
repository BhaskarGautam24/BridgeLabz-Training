public class HandBook {
	// Instance variables to store book information
	String bookTitle;
	String bookAuthor;
	double price;
	HandBook(String bookTitle, String bookAuthor, double price) {
		// Using 'this' keyword to assign values to instance variables
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.price = price;
	}
	public void displayBookDetails() {
		System.out.println("Title of the book: " + bookTitle);
		System.out.println("Author of the book: " + bookAuthor);
		System.out.println("Price of the book: " + price);
	}
	public static void main(String[] args) {
		
		// Creating first HandBook object using constructor
		HandBook book1 = new HandBook("2States", "Chetan Bhagat", 500);		
		// Creating second HandBook object using constructor
		HandBook book2 = new HandBook("Wings Of Fire", "Abdul kalam.A.P.J", 500);
		book1.displayBookDetails();
		book2.displayBookDetails();
	}
}

