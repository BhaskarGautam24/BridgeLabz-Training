import java.util.*;

public class SearchPerformance {
    static int linearSearch(int arr[], int size, int target) {         //linear search method
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
   
    static int binarySearch(int arr[], int size, int target) {             // Binary Search Method
        int start = 0;
        int end = size - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter dataset size: ");
        int n = scn.nextInt();

        int ar[] = new int[n];
        int i;

        for (i = 0; i < n; i++) {
            ar[i] = i + 1;
        }

        System.out.print("Enter target element: ");
        int target = scn.nextInt();

        // Linear Search Time Calculation
        long startTime1 = System.nanoTime();
        linearSearch(ar, n, target);
        long endTime1 = System.nanoTime();
        long linearTime = endTime1 - startTime1;

        Arrays.sort(ar);

        // Binary Search Time Calculation
        long startTime2 = System.nanoTime();
        binarySearch(ar, n, target);
        long endTime2 = System.nanoTime();
        long binaryTime = endTime2 - startTime2;
    
        System.out.println("Linear Search Time  : " + linearTime + " ns"); 
        System.out.println("Binary Search Time : " + binaryTime + " ns");
    }
}

