
import java.util.*;

public class DivisibleByFive {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    boolean isDivisibleByFive = (number % 5 == 0);    // check divisibility by 5

    System.out.println("Is the number"+" "+number+" "+"divisible by 5? : "+isDivisibleByFive);

  }

  
}
