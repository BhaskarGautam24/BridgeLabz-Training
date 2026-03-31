import java.util.*;
// interface for search work
interface LinearSearch {
    // method to find first negative
    int findFirstNegative(int[] numbers);
}
// abstract class for common logic
abstract class BaseLinearSearch implements LinearSearch {

    public void showInfo() {
        System.out.println("searching first negative number");
    }

    // abstract method
    public abstract int findFirstNegative(int[] numbers);
}

// child class implementing linear search
class NegativeNumberSearch extends BaseLinearSearch {

    // private variable for array
    private int[] array;

    // setter method
    public void setArray(int[] array) {
        // assigning using this
        this.array = array;
    }
    public int[] getArray() {
        // returning array
        return this.array;
    }

    // overriding search method
    @Override
    public int findFirstNegative(int[] numbers) {

        // loop for linear search
        for (int i = 0; i < numbers.length; i++) {

            // checking negative number
            if (numbers[i] < 0) {

                // returning index
                return i;
            }
        }
        return -1;
    }
}

public class LinearSearchFirstNegative {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // asking array size
        System.out.println("enter array size");

        // storing size
        int size = scn.nextInt();

        // creating array
        int[] numbers = new int[size];

        // loop for taking input
        for (int i = 0; i < size; i++) {

            // asking element
            System.out.println("enter element " + (i + 1));
            numbers[i] = scn.nextInt();
        }

        // parent reference for polymorphism
        BaseLinearSearch search = new NegativeNumberSearch();

        // checking instance type
        if (search instanceof NegativeNumberSearch) {

            // casting to child class
            NegativeNumberSearch negSearch = (NegativeNumberSearch) search;

            // setting array
            negSearch.setArray(numbers);

            // showing info
            negSearch.showInfo();

            // performing search
            int resultIndex = negSearch.findFirstNegative(negSearch.getArray());

            // checking result
            if (resultIndex != -1) {
                // printing found index
                System.out.println("first negative number found at index: " + resultIndex);
            } else {
                // printing not found msg
                System.out.println("no negative number found");
            }
        }
    }
}
