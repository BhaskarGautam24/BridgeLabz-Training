import java.util.*;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        // HashMap to store prefix sum and list of indices
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int sum = 0;
        // For subarrays starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i];
            // If prefix sum already exists
            if (map.containsKey(sum)) {

                ArrayList<Integer> list = map.get(sum);

                // Print all zero-sum subarrays
                for (int startIndex : list) {
                    System.out.println(
                        "Zero sum subarray found from index "
                        + (startIndex + 1) + " to " + i
                    );
                }
            }
            // Add current index to map
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findZeroSumSubarrays(arr);
    }
}
