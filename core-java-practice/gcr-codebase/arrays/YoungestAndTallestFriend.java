
package arrays;
import java.util.*;
public class YoungestAndTallestFriend {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        // Input ages and heights
        for (int i = 0; i < friends.length; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scn.nextInt();
            System.out.print("Enter height of " + friends[i] + " in centimeters: ");
            heights[i] = scn.nextDouble();
        }
        // Find youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
         // Find tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        } 
        // Display results
        System.out.println("The youngest friend is: " + friends[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("The tallest friend is: " + friends[tallestIndex] + " with height " + heights[tallestIndex] + " cm");
    }
}