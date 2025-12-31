import java.util.*;
public class ProductInventoryDemo {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String name1 = scn.nextLine();
        double price1 = scn.nextDouble();
        scn.nextLine();

        // creating first product
        Product p1 = new Product(name1, price1);

        // taking second product details
        String name2 = scn.nextLine();
        double price2 = scn.nextDouble();

        // creating second product
        Product p2 = new Product(name2, price2);

        // displaying product details
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}

// class for product
class Product {

    // instance variables
    private String productName;
    private double price;

    // class variable
    private static int totalProducts = 0;

    // parameterized constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    // instance method to show product
    public void displayProductDetails() {
        System.out.println(productName + " - " + price);
    }

    // static method to show total count
    public static void displayTotalProducts() {
        System.out.println("total products: " + totalProducts);
    }
}
