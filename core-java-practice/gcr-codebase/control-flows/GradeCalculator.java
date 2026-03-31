import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int physics = scn.nextInt();

        System.out.print("Enter Chemistry marks: ");
        int chemistry = scn.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = scn.nextInt();
        double percentage = (physics + chemistry + maths) / 3.0;

        String grade, remarks;
        // Grade calculation
        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Level 2, below but approaching standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level 1, too below standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }
        System.out.println("\nAverage Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
