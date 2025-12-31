import java.util.*;
// abstract class for sorting
abstract class ExamSorter {

    // private array for scores
    private int[] scores;

    // constructor
    ExamSorter(int[] scores) {
        this.scores = scores;
    }

    // getter method
    public int[] getScores() {
        return scores;
    }

    // abstract sort method
    abstract void sort();

    // method to print scores
    void printScores() {
        // loop to print values
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
    }
}
// child class for selection sort
class SelectionSortScores extends ExamSorter {

    // constructor
    SelectionSortScores(int[] scores) {
        super(scores);
    }
    // overriding sort method
    void sort() {

        // get array
        int[] arr = getScores();
        int n = arr.length;

        // loop for each position
        for (int i = 0; i < n - 1; i++) {

            // assume min index
            int minIndex = i;

            // find minimum element
            for (int j = i + 1; j < n; j++) {

                // compare values
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap values
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
public class SelectionSortExamScores {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // take number of students
        System.out.print("Enter number of students: ");
        int size = scn.nextInt();

        // array for exam scores
        int[] scores = new int[size];

        // take scores input
        System.out.println("Enter exam scores:");
        for (int i = 0; i < size; i++) {
            scores[i] = scn.nextInt();
        }

        // parent reference used
        ExamSorter sorter = new SelectionSortScores(scores);

        // call selection sort
        sorter.sort();

        // print sorted scores
        System.out.println("Sorted exam scores:");
        sorter.printScores();
    }
}
