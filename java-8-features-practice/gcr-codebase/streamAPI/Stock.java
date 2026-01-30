import java.util.*;
public class Stock {
    public static void main(String[] args) {
        List<Double> prices = new ArrayList<Double>();
        prices.add(120.5);
        prices.add(121.8);
        prices.add(119.4);
        prices.forEach(p -> System.out.println("Stock price : " + p));
    }
}

