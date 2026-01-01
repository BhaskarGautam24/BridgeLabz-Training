import java.util.*;

// interface for timing
interface TimeCalc {
    void checkTime(int arr[], int n);
}
// abstract parent class
abstract class SortBase {
    private String name;
    SortBase(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    abstract void sort(int arr[], int n);

    void showName() {
        System.out.println("\nusing " + name);
    }
}

// bubble sort class
class BubbleSortAlgo extends SortBase implements TimeCalc {

    BubbleSortAlgo() {
        super("bubble sort");
    }

    void sort(int arr[], int n) {


        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                // condition check
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

 
    public void checkTime(int arr[], int n) {

        long start = System.nanoTime();
        sort(arr, n);
        long end = System.nanoTime();

        System.out.println("time : " + (end - start) + " ns");
    }
}

// merge sort class
class MergeSortAlgo extends SortBase implements TimeCalc {

    MergeSortAlgo() {
        super("merge sort");
    }

    // sort call
    void sort(int arr[], int n) {
        mergeSort(arr, 0, n - 1);
    }

    // merge sort logic
    void mergeSort(int arr[], int l, int r) {

        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // merge logic
    void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // time check
    public void checkTime(int arr[], int n) {

        long start = System.nanoTime();
        sort(arr, n);
        long end = System.nanoTime();

        System.out.println("time : " + (end - start) + " ns");
    }
}

// quick sort class
class QuickSortAlgo extends SortBase implements TimeCalc {

    QuickSortAlgo() {
        super("quick sort");
    }

    // sort call
    void sort(int arr[], int n) {
        quickSort(arr, 0, n - 1);
    }

    // quick sort logic
    void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int p = partition(arr, low, high);

            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    // partition logic
    int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // time check
    public void checkTime(int arr[], int n) {

        long start = System.nanoTime();
        sort(arr, n);
        long end = System.nanoTime();

        System.out.println("time : " + (end - start) + " ns");
    }
}

public class SortLargeDataTest {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("enter size : ");
        int n = scn.nextInt();

        int base[] = new int[n];
        for (int i = 0; i < n; i++) {
            base[i] = n - i;
        }

        // copy arrays
        int a1[] = base.clone();
        int a2[] = base.clone();
        int a3[] = base.clone();
        SortBase s;

        // bubble test
        s = new BubbleSortAlgo();
        s.showName();
        if (s instanceof TimeCalc) {
            ((TimeCalc) s).checkTime(a1, n);
        }
        // merge test
        s = new MergeSortAlgo();
        s.showName();
        if (s instanceof TimeCalc) {
            ((TimeCalc) s).checkTime(a2, n);
        }
        // quick test
        s = new QuickSortAlgo();
        s.showName();
        if (s instanceof TimeCalc) {
            ((TimeCalc) s).checkTime(a3, n);
        }
    }
}

