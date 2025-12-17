import java.util.*;

class LengthOfLastWord {

    
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        return arr[n - 1].length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int result = lengthOfLastWord(s);

        System.out.println(result);
    }
}
