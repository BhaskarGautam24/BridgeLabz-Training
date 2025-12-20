/*Create a program to print a multiplication table of a number.
Hint => 
Get an integer input and store it in the number variable. Also, define a integer array to store the results of multiplication from 1 to 1
Run a loop from 1 to 10 and store the results in the multiplication table array
Finally, display the result from the array in the format number * i = ___
 */
package arrays;
import java.util.*;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter an integer to print its multiplication table: ");
        int number = scn.nextInt();
        
        int[] multiplicationTable = new int[10];
        
        // Populate the multiplication table array
        for (int i = 0; i < multiplicationTable.length; i++) {
            multiplicationTable[i] = number * (i + 1);
        }
        
        // Display the multiplication table
        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }
    }
}
