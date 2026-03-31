import java.util.*;
// interface for search operations
interface SearchOperations {
    // method for first missing positive
    int findFirstMissingPositive(int[] numbers);

    // method for binary search
    int binarySearch(int[] numbers, int target);
}

// abstract class for common behavior
abstract class BaseSearch implements SearchOperations {

    // concrete method for info
    public void showInfo() {
        // small info msg
        System.out.println("running linear and binary search challenge");
    }
    // abstract methods
    public abstract int findFirstMissingPositive(int[] numbers);

    public abstract int binarySearch(int[] numbers, int target);
}

// child class implementing logic
class SearchImplementation extends BaseSearch {

    // private array variable
    private int[] array;

    // setter method
    public void setArray(int[] array) {
        // assigning array using this
        this.array = array;
    }

    // getter method
    public int[] getArray() {
        // returning array
        return this.array;
    }

    // method for linear search missing positive
    @Override
    public int findFirstMissingPositive(int[] numbers) {

        // size variable
        int size = numbers.length;

        // loop for marking visited
        for (int i = 0; i < size; i++) {

            // getting value
            int value = Math.abs(numbers[i]);

            // marking index if valid
            if (value >= 1 && value <= size) {

                // marking as negative
                if (numbers[value - 1] > 0) {
                    numbers[value - 1] = -numbers[value - 1];
                }
            }
        }

        // loop to find missing positive
        for (int i = 0; i < size; i++) {

            // checking positive value
            if (numbers[i] > 0) {

                // returning missing number
                return i + 1;
            }
        }

        // if none missing
        return size + 1;
    }

    // simple bubble sort before binary search
    private void sortArray(int[] numbers) {

        // outer loop
        for (int i = 0; i < numbers.length - 1; i++) {

            // inner loop
            for (int j = 0; j < numbers.length - i - 1; j++) {

                // swapping if needed
                if (numbers[j] > numbers[j + 1]) {

                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // binary search implementation
    @Override
    public int binarySearch(int[] numbers, int target) {

        // sorting array first
        sortArray(numbers);

        // left index
        int left = 0;

        // right index
        int right = numbers.length - 1;

        // binary search loop
        while (left <= right) {

            // mid calculation
            int mid = (left + right) / 2;

            // checking target
            if (numbers[mid] == target) {
                return mid;
            }

            // moving left or right
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // not found
        return -1;
    }
}
public class LinearAndBinarySearchChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size");

        // storing size
        int size = sc.nextInt();
        int[] numbers = new int[size];

        // loop for input
        for (int i = 0; i < size; i++) {

            // asking element
            System.out.println("enter element " + (i + 1));

            // storing value
            numbers[i] = sc.nextInt();
        }

        // asking target for binary search
        System.out.println("enter target number");

        // storing target
        int target = sc.nextInt();

        // parent reference for polymorphism
        BaseSearch search = new SearchImplementation();

        // checking instance
        if (search instanceof SearchImplementation) {

            // casting to child
            SearchImplementation impl = (SearchImplementation) search;

            // setting array
            impl.setArray(numbers);
            impl.showInfo();

            // finding first missing positive
            int missing = impl.findFirstMissingPositive(impl.getArray());
            System.out.println("first missing positive number is: " + missing);
            int index = impl.binarySearch(impl.getArray(), target);
            if (index != -1) {
                System.out.println("target found at index: " + index);
            } else {
                System.out.println("target not found in array");
            }
        }
    }
}

