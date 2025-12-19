import java.util.*;

public class NaturalNumberSum {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int number = scn.nextInt();
    int sum =0;
    if(number>=1){
      sum  = (number*(number+1))/2;                 // formula to calculate sum of natural numbers
      System.out.println("The sum of"+" "+number+" "+"natural numbers is"+" "+sum);
    }
    else{
      Sytem.out.println("The number"+" "+number+" "+"is not a natural number");
    }

  }
  
}
