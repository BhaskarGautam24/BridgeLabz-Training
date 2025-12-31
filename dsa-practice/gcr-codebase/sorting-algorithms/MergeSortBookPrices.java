import java.util.*;
// abstract class for sorting
abstract class BookSorter {
    private int[] prices; 
    BookSorter(int[] prices) {
        this.prices = prices;
    }
    // getter method
    public int[] getPrices() {
        return prices;
    }
    // abstract method for sort
    abstract void sort(int left, int right);

    // concrete method to print array
    void printPrices() {
        // loop for printing
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();
    }
}

// child class for merge sort
class MergeSortBooks extends BookSorter {
    MergeSortBooks(int[] prices) {
        super(prices);
    }

    // overriding sort method
    void sort(int left, int right) {
        if (left < right) {       
            int mid = (left + right) / 2;

            // sort left side
            sort(left, mid);

            // sort right side
            sort(mid + 1, right);

            // merge both sides
            merge(left, mid, right);
        }
    }
    // method to merge arrays
    void merge(int left, int mid, int right) {

        int[] arr = getPrices();

        // calculate sizes
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // temp arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // copy left values
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        // copy right values
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // index variables
        int i = 0;
        int j = 0;
        int k = left;

        // merge logic
        while (i < n1 && j < n2) {

            // compare elements
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy remaining left
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // copy remaining right
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
public class MergeSortBookPrices {
    public static void main(String[] args) {
        // scanner for input
        Scanner scn = new Scanner(System.in);

        // take number of books
        System.out.print("Enter number of books: ");
        int size = scn.nextInt();

        // array for prices
        int[] prices = new int[size];

        // take prices input
        System.out.println("Enter book prices:");
        for (int i = 0; i < size; i++) {
            prices[i] = scn.nextInt();
        }
        // parent reference used
        BookSorter sorter = new MergeSortBooks(prices)
        // call sorting
        sorter.sort(0, size - 1);
        // print result
        System.out.println("Sorted book prices:");
        sorter.printPrices();
    }
}
