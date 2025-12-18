import java.util.*;
public class Height{
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    double HeightInCentimeter = scn.nextDouble();
    double HeightInInches = HeightInCentimeter / 2.54;
    int HeightInFoots = (HeightInInches / 12);
    System.out.println("Your Height in cm is"+" "+HeightInCentimeter+" "+"while in feet is"+" "+HeightInFoots+" "+"and inches is"+" "+HeightInInches);


    
  }
}