
import java.util.*;
public class FirstNumberSmallest {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int firstNumber = scn.nextInt();
    int secondNumber = scn.nextInt();
    int thirdNumber = scn.nextInt();

    boolean isFirstNumberSmallest = (firstNumber < secondNumber) && (firstNumber < thirdNumber);
    System.out.println("Is the first number the smallest?"+" "+isFirstNumberSmallest);
  }
  
}
