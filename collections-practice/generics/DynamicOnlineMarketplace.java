import java.util.*;
public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        List<Product<? extends Category>> catalog = new ArrayList<Product<? extends Category>>();

        System.out.print("enter book name: ");
        String bookName = scn.nextLine();
        BookCategory bookCat = new BookCategory("education");
        Product<BookCategory> book = new Product<BookCategory>(bookName, 500.0, bookCat);

        catalog.add(book);

        // taking clothing details
        System.out.print("enter clothing name: ");
        String clothName = scn.nextLine();
        ClothingCategory clothCat = new ClothingCategory("fashion");
        Product<ClothingCategory> cloth = new Product<ClothingCategory>(clothName, 1200.0, clothCat);

        catalog.add(cloth);

        // applying discount
        applyDiscount(book, 10.0);
        applyDiscount(cloth, 5.0);

        System.out.println("\nproduct catalog:");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p.getDetails());
        }
    }

    // generic discount method
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {

        // calculating discount
        double price = product.getPrice();
        double discount = (price * percentage) / 100;
        double finalPrice = price - discount;

        // setting new price
        product.setPrice(finalPrice);
    }
}

// base category interface
interface Category {

    String getCategoryName();
}

// book category
class BookCategory implements Category {

    private String name;

    public BookCategory(String name) {
        this.name = name;
    }

    // overriding method
    public String getCategoryName() {
        return this.name;
    }
}

// clothing category
class ClothingCategory implements Category {

    private String name;

    public ClothingCategory(String name) {
        this.name = name;
    }

    // overriding method
    public String getCategoryName() {
        return this.name;
    }
}

// gadget category
class GadgetCategory implements Category {

    // category name
    private String name;

    public GadgetCategory(String name) {
        this.name = name;
    }

    // overriding method
    public String getCategoryName() {
        return this.name;
    }
}

// generic product class
class Product<T extends Category> {

    private String productName;

    private double price;

    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    // getter for price
    public double getPrice() {
        return this.price;
    }

    // setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        String info = productName + " | price: " + price + " | category: " + category.getCategoryName();
        return info;
    }
}

