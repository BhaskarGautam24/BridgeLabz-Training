package strings;
import java.util.*;
public class VotingEligibility {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    System.out.print("Enter the number of students: ");
    int n = scn.nextInt();
    int[] ages = generateRandomAges(n);                       // method to generate random ages
    String[][] eligibilityData = checkVotingEligibility(ages); // method to check voting eligibility
    displayEligibilityTable(eligibilityData);                 // method to display the table
  }

  public static int[] generateRandomAges(int n){
    Random rand = new Random();
    int[] ages = new int[n];
    for(int i=0;i<n;i++){
      ages[i] = rand.nextInt(90) + 1;            // Generate random age between 1 and 90
    }
    return ages;
  }

  public static String[][] checkVotingEligibility(int[] ages){
    String[][] result = new String[ages.length][2];
    for(int i=0;i<ages.length;i++){
      result[i][0] = String.valueOf(ages[i]);
      if(ages[i] < 0){
        result[i][1] = "Cannot Vote";
      }
      else if(ages[i] >= 18){
        result[i][1] = "Can Vote";
      }
      else{
        result[i][1] = "Cannot Vote";
      }
    }
    return result;
  }

  public static void displayEligibilityTable(String[][] data){
    System.out.println("Age\tEligibility");
    System.out.println("---------------------");
    for(int i=0;i<data.length;i++){
      System.out.println(data[i][0] + "\t" + data[i][1]);
    }
  }
}
