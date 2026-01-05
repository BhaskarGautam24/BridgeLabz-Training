package reviews;
import java.util.*;
public class SwapTwoNumbers {
  public static void main(String[] args){
  Scanner scn = new Scanner(System.in);
  int a = scn.nextInt();
  int b = scn.nextInt();

  a = a+b;
  b = a-b;
  a= a-b;

  System.out.println(a);
  System.out.println(b);

  }
  
}
