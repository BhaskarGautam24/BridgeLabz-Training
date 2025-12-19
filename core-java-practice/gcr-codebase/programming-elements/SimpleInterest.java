
import java.util.*;
public class SimpleInterest {
    public static void main(String[] args){
      Scanner scn = new Scanner(System.in);
        double principal = scn.nextDouble();
        
        double rate = scn.nextDouble();
        double time = scn.nextDouble();
  
          double simpleinterest = (principal * rate * time) / 100;
  
          System.out.println(simpleinterest);

    }
  
}
