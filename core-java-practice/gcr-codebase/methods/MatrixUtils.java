package methods;
import java.util.*;

public class MatrixUtils {

    // Method to create a random matrix with given rows and columns
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random integer between 0-9
            }
        }
        return matrix;
    }

    // Method to print a matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.2f", val);
            }
            System.out.println();
        }
    }

    // Method to find the transpose of a matrix
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // Method to calculate the determinant of a matrix (recursive)
    public static double determinant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];

        double det = 0;
        for (int col = 0; col < n; col++) {
            det += Math.pow(-1, col) * matrix[0][col] * determinant(minor(matrix, 0, col));
        }
        return det;
    }

    // Helper method to get minor matrix by removing row and column
    public static double[][] minor(double[][] matrix, int rowToRemove, int colToRemove) {
        int n = matrix.length;
        double[][] minor = new double[n-1][n-1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == rowToRemove) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == colToRemove) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }

    // Method to find the inverse of a matrix using adjoint method
    public static double[][] inverse(double[][] matrix) {
        int n = matrix.length;
        double det = determinant(matrix);
        if (det == 0) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null;
        }

        double[][] adjoint = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjoint[j][i] = Math.pow(-1, i + j) * determinant(minor(matrix, i, j)); // transpose while assigning
            }
        }

        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = adjoint[i][j] / det;
            }
        }
        return inverse;
    }

    public static void main(String[] args) {
        // Create a random 3x3 matrix
        double[][] matrix = createRandomMatrix(3, 3);

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Transpose
        double[][] transposed = transpose(matrix);
        System.out.println("\nTranspose of Matrix:");
        printMatrix(transposed);

        // Determinant
        double det = determinant(matrix);
        System.out.println("\nDeterminant: " + det);

        // Inverse
        double[][] inv = inverse(matrix);
        if (inv != null) {
            System.out.println("\nInverse of Matrix:");
            printMatrix(inv);
        }
    }
}

