import java.util.*;
public class EcommercePlatformDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("enter customer name: ");
        String customerName = scn.nextLine();

        // creating customer object
        Customer customer = new Customer(customerName);
        Order order = new Order();

        System.out.print("enter first product name: ");
        String productOneName = scn.nextLine();

        System.out.print("enter first product price: ");
        double productOnePrice = scn.nextDouble();
        scn.nextLine(); // clearing buffer little bit

        System.out.print("enter second product name: ");
        String productTwoName = scn.nextLine();

        System.out.print("enter second product price: ");
        double productTwoPrice = scn.nextDouble();

        // creating product objects
        Product productOne = new Product(productOneName, productOnePrice);
        Product productTwo = new Product(productTwoName, productTwoPrice);

        // adding products to order
        order.addProduct(productOne);
        order.addProduct(productTwo);

        // customer placing order
        customer.placeOrder(order);

        // showing order details
        order.showOrderDetails();
    }
}
class Customer {

    // customer name variable
    private String customerName;

    // order reference
    private Order order;

    // constructor for customer
    public Customer(String customerName) {
        // assigning customer name
        this.customerName = customerName;
    }

    // method to place order
    public void placeOrder(Order order) {
        // assigning order
        this.order = order;
        // setting customer in order
        order.setCustomer(this);

        // simple message
        System.out.println("\norder placed by " + customerName);
    }

    // getter for customer name
    public String getCustomerName() {
        return customerName;
    }
}
class Order {

    // list to store products
    private ArrayList<Product> productList;

    // customer reference
    private Customer customer;

    // constructor for order
    public Order() {
        // creating product list
        this.productList = new ArrayList<Product>();
    }

    // method to add product
    public void addProduct(Product product) {
        // adding product into list
        productList.add(product);
    }

    // method to show order details
    public void showOrderDetails() {

        // total price variable
        double totalPrice = 0.0;

        // printing customer name
        System.out.println("\norder details:");
        System.out.println("customer: " + customer.getCustomerName());
        System.out.println("products:");

        // loop for products
        for (int i = 0; i < productList.size(); i++) {
            // getting product object
            Product tempProduct = productList.get(i);
            // printing product info
            System.out.println("- " + tempProduct.getProductName() + " : " + tempProduct.getPrice());
            // adding price
            totalPrice = totalPrice + tempProduct.getPrice();
        }

        // printing total price
        System.out.println("total amount: " + totalPrice);
    }

    // setter for customer
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
class Product {

    // product name variable
    private String productName;

    // product price variable
    private double price;

    // constructor for product
    public Product(String productName, double price) {
        // assigning values
        this.productName = productName;
        this.price = price;
    }

    // getter for product name
    public String getProductName() {
        return productName;
    }

    // getter for price
    public double getPrice() {
        return price;
    }
}

