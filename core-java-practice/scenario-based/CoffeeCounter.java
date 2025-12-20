import java.util.*;
public class CoffeeCounter { 
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    double pricePerCup = 0.0;
    
    while(true){
      String coffeeType;
      System.out.println("Enter the quantities of cofffee.");
      int quantityOfCoffee = scn.nextInt();
      System.out.println("Enter the type of coffee you want (Espresso/Latte/Cappuccino): ");
      coffeeType = scn.next();

      if(coffeeType.equalsIgnorecase("exit")){
        System.out.println("you have exited the coffee counter.");
        break;

      }
      switch(coffeeType.tolowercase()){
        case "espresso":
          System.out.println("You have ordered " + quantityOfCoffee + " Espresso(s).");
          pricePerCup = 250.0;
          break;
        case "latte":
          System.out.println("You have ordered " + quantityOfCoffee + " Latte(s).");
          pricePerCup = 300.0;
          break;
        case "cappuccino":
          System.out.println("You have ordered " + quantityOfCoffee + " Cappuccino(s).");
          pricePerCup = 350.0;
          break;
        default:
          System.out.println("Invalid coffee type.");
          break;
      }
      double total = quantityOfCoffee * pricePerCup;
      
      double totalWithTax = total + (total * 0.07);                     // add 7% gst tax
      System.out.println("Total amount (including 7% GST): " + totalWithTax);


    }


     
    
  }


  
}
