import java.util.*;
// interface for binary search work
interface RotationSearch {

    // method to find rotation index
    int findRotationPoint(int[] numbers);
}

// abstract class for common logic
abstract class BaseRotationSearch implements RotationSearch {
    public void showInfo() {
        System.out.println("finding rotation point using binary search");
    }

    // abstract method
    public abstract int findRotationPoint(int[] numbers);
}

// child class implementing binary search
class RotatedArraySearch extends BaseRotationSearch {

    // private variable for array
    private int[] array;
    public void setArray(int[] array) {
        // assigning array using this
        this.array = array;
    }
    public int[] getArray() {
        // returning array
        return this.array;
    }

    // overriding search method
    @Override
    public int findRotationPoint(int[] numbers) {

        // left index variable
        int left = 0;
        // right index variable
        int right = numbers.length - 1;
        // binary search loop
        while (left < right) {

            // calculating mid
            int mid = (left + right) / 2;

            // checking right half
            if (numbers[mid] > numbers[right]) {

                // moving left side
                left = mid + 1;
            } else {

                // moving right side
                right = mid;
            }
        }
        // returning rotation index
        return left;
    }
}
public class BinarySearchRotationPoint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // asking array size
        System.out.println("enter array size");

        // storing size
        int size = scn.nextInt();

        // creating array
        int[] numbers = new int[size];

        // loop for input
        for (int i = 0; i < size; i++) {

            // asking element
            System.out.println("enter element " + (i + 1));

            // storing element
            numbers[i] = scn.nextInt();
        }

        // parent reference for polymorphism
        BaseRotationSearch search = new RotatedArraySearch();

        // checking instance
        if (search instanceof RotatedArraySearch) {

            // casting to child class
            RotatedArraySearch rotSearch = (RotatedArraySearch) search;

            // setting array
            rotSearch.setArray(numbers);

            // showing info
            rotSearch.showInfo();

            // finding rotation point
            int rotationIndex = rotSearch.findRotationPoint(rotSearch.getArray());

            // printing result
            System.out.println("rotation point index is: " + rotationIndex);
            System.out.println("smallest element is: " + numbers[rotationIndex]);
        }
    }
}
