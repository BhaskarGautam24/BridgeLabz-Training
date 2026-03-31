import java.util.*;
public class PriceOfItems {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    double unitprice = scn.nextDouble();
    int quantity = scn.nextInt();
    double total = unitprice * quantity;
    System.out.println("The total purchase price is INR"+" "+total+" "+"if the quantity"+" "+quantity+" "+"and unit price is INR"+" "+unitprice);
  }
  
}
