import java.util.*;
public class BasicCalculator {
  public static void main(String[] args){
    Scanner scn= new Scanner(System.in);
    float number1 = scn.nextFloat();
    float number2 = scn.nextFloat();
    double addition = number1 + number2;
    double subtraction = number1 - number2;
    double multiplication = number1 * number2;
    double division = number1 / number2;
    System.out.println("The addition, subtraction, multiplication and division value of 2 numbers"+" "+number1+"and"+number2+" "+"is"+" "+addition+" , "+subtraction+" , "+multiplication+" , "+division);


  }
  
}