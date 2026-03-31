import java.util.*;
public class Height{
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    double heightInCentimeter = scn.nextDouble();
    double heightInInches = HeightInCentimeter / 2.54;
    int heightInFoots = (HeightInInches / 12);
    System.out.println("Your Height in cm is"+" "+heightInCentimeter+" "+"while in feet is"+" "+heightInFoots+" "+"and inches is"+" "+heightInInches);


    
  }
}