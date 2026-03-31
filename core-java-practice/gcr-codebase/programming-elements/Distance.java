
import java.util.*;
public class Distance {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int distanceinfeet = scn.nextInt();
    float distanceinyards = distanceinfeet / 3.0f;
    float distanceinmiles = distanceinyards / 1760.0f;
    System.out.println("Your distance in feet is"+" "+distanceinfeet+" "+"while in yards is"+" "+distanceinyards+" "+"and miles is"+" "+distanceinmiles);
  }
  
}
