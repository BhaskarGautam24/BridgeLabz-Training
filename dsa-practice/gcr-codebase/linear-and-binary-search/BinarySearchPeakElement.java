import java.util.*;
interface PeakSearch {

    // method to find peak index
    int findPeak(int[] numbers);
}

// abstract class for common logic
abstract class BasePeakSearch implements PeakSearch {

    // concrete method for info
    public void showInfo() {
        System.out.println("finding peak element using binary search");
    }

    // abstract method
    public abstract int findPeak(int[] numbers);
}

// child class implementing binary search
class PeakElementSearch extends BasePeakSearch {

    // private variable for array
    private int[] array;

    // setter method
    public void setArray(int[] array) {
        // assigning array using this
        this.array = array;
    }
    public int[] getArray() {
        // returning array
        return this.array;
    }

    // overriding peak search method
    @Override
    public int findPeak(int[] numbers) {

        // left index
        int left = 0;

        // right index
        int right = numbers.length - 1;

        // binary search loop
        while (left <= right) {

            // finding mid
            int mid = (left + right) / 2;

            // checking left neighbor
            boolean leftOk = (mid == 0) || (numbers[mid] > numbers[mid - 1]);

            // checking right neighbor
            boolean rightOk = (mid == numbers.length - 1) || (numbers[mid] > numbers[mid + 1]);

            // if both sides ok, peak found
            if (leftOk && rightOk) {
                return mid;
            }
            if (mid > 0 && numbers[mid] < numbers[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
public class BinarySearchPeakElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // asking array size
        System.out.println("enter array size");

        // storing size
        int size = scn.nextInt();

        // creating array
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {

            // asking element
            System.out.println("enter element " + (i + 1));
            numbers[i] = scn.nextInt();
     }
        // parent reference for polymorphism
        BasePeakSearch search = new PeakElementSearch();

        // checking instance type
        if (search instanceof PeakElementSearch) {
            // casting to child class
            PeakElementSearch peakSearch = (PeakElementSearch) search;

            // setting array
            peakSearch.setArray(numbers);

            // showing info
            peakSearch.showInfo();
            int peakIndex = peakSearch.findPeak(peakSearch.getArray());
            // printing result
            if (peakIndex != -1) {
                System.out.println("peak element found at index: " + peakIndex);
                System.out.println("peak element value is: " + numbers[peakIndex]);
            } else {
                System.out.println("no peak element found");
            }
        }
    }
}
