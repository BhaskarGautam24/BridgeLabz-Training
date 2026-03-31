
import java.util.*;
public class InputDiscount {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int fee = scn.nextInt();
    int discountPercent = scn.nextInt();
    int discount = (fee * discountPercent)/100;
    int result = fee - discount;
    system.out.println("The discount amount is INR"+" "+discount+" "+"and final discounted fee is INR"+" "+result);

  }
  
}
