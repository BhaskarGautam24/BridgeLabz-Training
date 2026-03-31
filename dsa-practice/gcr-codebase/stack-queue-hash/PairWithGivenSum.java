import java.util.*;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashMap to store visited elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int required = target - current;
            // Check if required number exists
            if (map.containsKey(required)) {
                System.out.println(
                    "Pair found: " + current + " + " + required + " = " + target
                );
                return true;
            }
            // Store current number
            map.put(current, i);
        }
        return false;
        
    }
    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        boolean result = hasPairWithSum(arr, target);
        if (!result) {
            System.out.println("No pair found with given sum");
        }
    }
}
