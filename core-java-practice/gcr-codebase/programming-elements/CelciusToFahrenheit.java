
import java.util.*;
public class CelciusToFahrenheit {
    public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      double celcius = scn.nextDouble();

        double fahrenheit = (celcius * 9/5) + 32;

        System.out.println(fahrenheit);
    }

  
}
