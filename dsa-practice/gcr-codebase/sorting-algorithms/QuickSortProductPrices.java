import java.util.*;
// abstract class for sorting
abstract class ProductSorter {
    // private array for prices
    private int[] prices;
    // constructor
    ProductSorter(int[] prices) {
        this.prices = prices;
    }
    // getter method
    public int[] getPrices() {
        return prices;
    }
    // abstract sort method
    abstract void sort(int low, int high);
    // method to print prices
    void printPrices() {
        // loop to print values
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();
    }
}
class QuickSortProducts extends ProductSorter {
    // constructor
    QuickSortProducts(int[] prices) {
        super(prices);
    }
    // overriding sort method
    void sort(int low, int high) {

        // check range
        if (low < high) {

            // get pivot position
            int p = partition(low, high);

            // sort left part
            sort(low, p - 1);

            // sort right part
            sort(p + 1, high);
        }
    }

    // method to partition array
    int partition(int low, int high) {

        // get array
        int[] arr = getPrices();

        // take last element as pivot
        int pivot = arr[high];

        // index for smaller element
        int i = low - 1;

        // loop for partition
        for (int j = low; j < high; j++) {

            // compare with pivot
            if (arr[j] < pivot) {

                i++;

                // swap values
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot at correct spot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return pivot index
        return i + 1;
    }
}
public class QuickSortProductPrices {

    public static void main(String[] args) {

        // scanner for input
        Scanner scn = new Scanner(System.in);

        // take number of products
        System.out.print("Enter number of products: ");
        int size = scn.nextInt();

        // array for product prices
        int[] prices = new int[size];

        // take prices input
        System.out.println("Enter product prices:");
        for (int i = 0; i < size; i++) {
            prices[i] = scn.nextInt();
        }

        // parent reference
        ProductSorter sorter = new QuickSortProducts(prices);

        // call quick sort
        sorter.sort(0, size - 1);

        // print sorted prices
        System.out.println("Sorted product prices:");
        sorter.printPrices();
    }
}

