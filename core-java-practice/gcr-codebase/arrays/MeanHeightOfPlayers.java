
package arrays;
import java.util.*;
public class MeanHeightOfPlayers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of 11 players in centimeters:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Height of player " + (i + 1) + ": ");
            heights[i] = scn.nextDouble();
            sum += heights[i]; // Accumulate the sum of heights
        }

        double meanHeight = sum / heights.length;
        System.out.printf("The mean height of the football team is: %.2f cm%n", meanHeight);
    }
}
