package reviews;
import java.util.*;
public class exceptionhandlingdividebyzero {
  public static void main(String []args){
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();

    try{
      int result = a/b;
      System.out.println(result);
    }
    catch (ArithmeticException e){
      System.out.println("cannot divide by zero");
    }
  }
  
}
