package methods;
import java.util.*;
public class FriendComparison {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
       // Taking user input for ages and heights of the friends
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + friends[i] + ": ");
            ages[i] = scn.nextInt();
            System.out.print("Enter the height of " + friends[i] + " (in feet): ");
            heights[i] = scn.nextDouble();
        }
        int youngestIndex = findYoungest(ages); // calling method to find youngest friend
        int tallestIndex = findTallest(heights); // calling method to find tallest friend

        System.out.println("The youngest friend is: " + friends[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("The tallest friend is: " + friends[tallestIndex] + " with height " + heights[tallestIndex] + " feet");
    }
    // Method to find the index of the youngest friend
    static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    // Method to find the index of the tallest friend
    static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
}
