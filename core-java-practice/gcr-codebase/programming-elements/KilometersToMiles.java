
import java.util.*;
public class KilometersToMiles {
    public static void main(String [] args){
      Scanner scn = new Scanner(System.in);
      double km = scn.nextDouble();

      double miles = km * 0.621371;
      System.out.println(miles);
      
    }
}