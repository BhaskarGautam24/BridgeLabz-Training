
import java.util.*;
public class SimpleInterest {
    public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
        double p = scn.nextDouble();
        
        double r = scn.nextDouble();
        double t = scn.nextDouble();
  
          double si = (p * r * t) / 100;
  
          System.out.println(si);

    }
  
}
