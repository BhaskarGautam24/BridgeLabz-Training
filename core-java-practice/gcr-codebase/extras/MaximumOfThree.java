package extras;
import java.util.*;

public class MaximumOfThree {

    // Function to take input from the user
    static int[] takeInput() {
        Scanner scn = new Scanner(System.in);
        int[] numbers = new int[3];
        System.out.print("Enter first number: ");
        numbers[0] = scn.nextInt();
        System.out.print("Enter second number: ");
        numbers[1] = scn.nextInt();
        System.out.print("Enter third number: ");
        numbers[2] = scn.nextInt();
        return numbers;
    }

    // Function to find the maximum of three numbers
    static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = takeInput();
        int max = findMaximum(nums[0], nums[1], nums[2]);
        System.out.println("Maximum number is: " + max);
    }
}

