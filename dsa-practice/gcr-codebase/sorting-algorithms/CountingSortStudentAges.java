import java.util.*;
// abstract class for sorting
abstract class AgeSorter {
    private int[] ages;
    AgeSorter(int[] ages) {
        this.ages = ages;
    }
    // getter method
    public int[] getAges() {
        return ages;
    }
    // abstract sort method
    abstract void sort();
    // method to print ages
    void printAges() {
        // loop to print values
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        System.out.println();
    }
}

// child class for counting sort
class CountingSortAges extends AgeSorter {
    // fixed age limits
    static final int MIN_AGE = 10;
    static final int MAX_AGE = 18;

    // constructor
    CountingSortAges(int[] ages) {
        super(ages);
    }

    // overriding sort method
    void sort() {

        // get main array
        int[] arr = getAges();

        // calculate range
        int range = MAX_AGE - MIN_AGE + 1;

        // count array
        int[] count = new int[range];

        // output array
        int[] output = new int[arr.length];

        // store frequency of ages
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - MIN_AGE]++;
        }

        // calculate cumulative count
        for (int i = 1; i < range; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // place elements in correct position
        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            int pos = count[age - MIN_AGE] - 1;
            output[pos] = age;
            count[age - MIN_AGE]--;
        }

        // copy output to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
public class CountingSortStudentAges {
    public static void main(String[] args) {

        // scanner for input
        Scanner sc = new Scanner(System.in);

        // take number of students
        System.out.print("Enter number of students: ");
        int size = sc.nextInt();

        // array for student ages
        int[] ages = new int[size];

        // take ages input
        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < size; i++) {
            ages[i] = sc.nextInt();
        }

        // parent reference
        AgeSorter sorter = new CountingSortAges(ages);

        // call counting sort
        sorter.sort();

        // print sorted ages
        System.out.println("Sorted student ages:");
        sorter.printAges();
    }
}

