import java.util.*;
// abstract class for sorting
abstract class SalarySorter {
    // private array for salaries
    private int[] salaries;

    // constructor
    SalarySorter(int[] salaries) {
        this.salaries = salaries;
    }

    // getter method
    public int[] getSalaries() {
        return salaries;
    }

    // abstract sort method
    abstract void sort();

    // method to print salaries
    void printSalaries() {
        // loop for printing
        for (int i = 0; i < salaries.length; i++) {
            System.out.print(salaries[i] + " ");
        }
        System.out.println();
    }
}

// child class for heap sort
class HeapSortSalaries extends SalarySorter {

    // constructor
    HeapSortSalaries(int[] salaries) {
        super(salaries);
    }

    // overriding sort method
    void sort() {

        // get array
        int[] arr = getSalaries();
        int n = arr.length;

        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // swap root with last
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // method to maintain heap
    void heapify(int[] arr, int size, int root) {

        // assume root is largest
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // check left child
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // check right child
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // swap if needed
        if (largest != root) {

            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            // heapify again
            heapify(arr, size, largest);
        }
    }
}
public class HeapSortJobSalaries {
    public static void main(String[] args) {
        // scanner for input
        Scanner scn = new Scanner(System.in);

        // take number of applicants
        System.out.print("Enter number of job applicants: ");
        int size = scn.nextInt();

        // array for salary demands
        int[] salaries = new int[size];

        // take salary input
        System.out.println("Enter expected salaries:");
        for (int i = 0; i < size; i++) {
            salaries[i] = scn.nextInt();
        }
        // parent reference
        SalarySorter sorter = new HeapSortSalaries(salaries);
        // call heap sort
        sorter.sort();
        // print sorted salaries
        System.out.println("Sorted salary demands:");
        sorter.printSalaries();
    }
}

