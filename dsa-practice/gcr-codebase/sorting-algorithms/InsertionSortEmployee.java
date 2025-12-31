import java.util.*;
class InsertionSortEmployee {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Ask user for number of employees
        System.out.print("Enter number of employees: ");
        int n = scn.nextInt();

        // Array to store employee IDs
        int[] empIds = new int[n];

        // Taking employee IDs input
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = scn.nextInt();
        }

        // Insertion Sort logic
        for (int i = 1; i < n; i++) {

            int key = empIds[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }
            // Insert key at correct position
            empIds[j + 1] = key;
        }

        // Printing sorted employee IDs
        System.out.println("Employee IDs in ascending order:");
        for (int i = 0; i < n; i++) {
            System.out.print(empIds[i] + " ");
        }
    }
}
