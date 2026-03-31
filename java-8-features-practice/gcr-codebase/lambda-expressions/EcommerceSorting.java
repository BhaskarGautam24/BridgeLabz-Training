import java.util.ArrayList;
import java.util.*;
class Product{
    String name;
    double price;
    double rating;
    double discount;
    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
}
public class EcommerceSorting{
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 60000, 4.5, 10));
        products.add(new Product("Mobile", 30000, 4.2, 20));
        products.add(new Product("Headphones", 2000, 4.8, 30));
        products.add(new Product("Tablet", 25000, 4.0, 15));

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose sorting type:");
        System.out.println("1. Price");
        System.out.println("2. Rating");
        System.out.println("3. Discount");

        int choice = sc.nextInt();
        products.sort((p1, p2) ->{

            if (choice == 1){
                return Double.compare(p1.price, p2.price);
            } else if (choice == 2){
                return Double.compare(p2.rating, p1.rating);
            } else if (choice == 3){
                return Double.compare(p2.discount, p1.discount);
            } else{
                return 0;
            }
        });
        System.out.println("Sorted Products:");
        for (Product p : products){
            System.out.println(
                    p.name+" | Price: " + p.price+
                    " | Rating: "+p.rating+
                    " | Discount: "+p.discount+"%"
            );
        }
    }
}
