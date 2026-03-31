import java.util.*;

public class LargestOfThreeCheck {
  public static void main(String[] args){
    Scanner scn  = new Scanner(System.in);
    int number1 = scn.nextInt();
    int number2 = scn.nextInt();
    int number3 = scn.nextInt();

    boolean isfirstlargest = (number1 > number2) && (number1 > number3);    // check whether first number is largest
    boolean issecondlargest = (number2 > number1) && (number2 > number3);     // check whether second number is largest
    boolean isthirdlargest = (number3 > number1) && (number3 > number2);      // check whether third number is largest

    System.out.println("Is the first number the largest?"+" "+isfirstlargest);
    System.out.println("Is the second number the largest?"+" "+issecondlargest);
    System.out.println("Is the third number the largest?"+" "+isthirdlargest);


  }
  
}
