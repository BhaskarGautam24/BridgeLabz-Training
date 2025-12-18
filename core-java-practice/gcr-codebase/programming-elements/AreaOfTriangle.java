
import java.util.*;
public class AreaOfTriangle {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    double base = scn.nextDouble();
    double height = scn.nextDouble();
    double base_in_inches = base / 2.54;
    double height_in_inches = height / 2.54;
    double area_in_square_cm = 0.5 * base * height;
    double area_in_square_inches = 0.5 * base_in_inches * height_in_inches;
    System.out.println("The area of triangle with base"+" "+base+" cm and height"+" "+height+" cm is"+" "+area_in_square_cm+" square cm or"+" "+area_in_square_inches+" square inches"); 

  }
  
}
