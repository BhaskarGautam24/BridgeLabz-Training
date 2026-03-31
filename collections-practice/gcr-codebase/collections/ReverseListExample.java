import java.util.*;
public class ReverseListExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrList = new ArrayList<Integer>();

        System.out.print("Enter number of elements for ArrayList: ");
        int n1 = sc.nextInt();

        for (int i = 0; i < n1; i++) {
            arrList.add(sc.nextInt());
        }

        int start1 = 0;
        int end1 = arrList.size() - 1;

        while (start1 < end1) {
            int temp = arrList.get(start1);
            arrList.set(start1, arrList.get(end1));
            arrList.set(end1, temp);

            start1++;
            end1--;
        }
        System.out.println("Reversed ArrayList: " + arrList);
        LinkedList<Integer> linkList = new LinkedList<Integer>();            //linkedlist

        System.out.print("Enter number of elements for LinkedList: ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n2; i++) {
            linkList.add(sc.nextInt());
        }

        int start2 = 0;
        int end2 = linkList.size() - 1;

        while (start2 < end2) {
            int temp = linkList.get(start2);
            linkList.set(start2, linkList.get(end2));
            linkList.set(end2, temp);

            start2++;
            end2--;
        }

        System.out.println("Reversed LinkedList: " + linkList);
    }
}
