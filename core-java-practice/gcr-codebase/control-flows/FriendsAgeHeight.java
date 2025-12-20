import java.util.*;

public class FriendsAgeHeight {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Amar's age: ");
        int amarAge = scn.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = scn.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scn.nextInt();

        System.out.print("Enter Amar's height (in cm): ");
        int amarHeight = scn.nextInt();

        System.out.print("Enter Akbar's height (in cm): ");
        int akbarHeight = scn.nextInt();

        System.out.print("Enter Anthony's height (in cm): ");
        int anthonyHeight = scn.nextInt();

        // Finding the youngest friend
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Amar is the youngest friend.");
        } 

        else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the youngest friend.");
        } 
        else {
            System.out.println("Anthony is the youngest friend.");
        }

        // Finding the tallest friend
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the tallest friend.");
        } 
        else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the tallest friend.");
        } 
        else {
            System.out.println("Anthony is the tallest friend.");
        }
    }
}

