import java.util.*;

public class SpringSeason {
  public static void main(String[] args){
    int month = Integer.parseInt(args[0]);        // read month from command line argument  
    int day = Integer.parseInt(args[1]);           // read day from command line argument
    if((month == 3 && day >= 20 && day <= 31) || (month == 4)  || (month == 5)  || (month == 6 && day >= 1 && day <= 20)){
      System.out.println("It a Spring Season");
    }
    else{
      System.out.println("Not a Spring Season");
        }

  }
  
}
