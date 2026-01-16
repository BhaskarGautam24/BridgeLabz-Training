import java.util.*;

class Policy implements Comparable<Policy> {

    int policyNo;
    String holderName;
    int expiryDays;
    String coverage;
    double premium;

    // constructor
    Policy(int policyNo, String holderName, int expiryDays,
           String coverage, double premium) {

        this.policyNo = policyNo;
        this.holderName = holderName;
        this.expiryDays = expiryDays;
        this.coverage = coverage;
        this.premium = premium;
    }

    // check uniqueness by policy number
    public boolean equals(Object obj) {
        Policy p = (Policy) obj;
        return this.policyNo == p.policyNo;
    }

    public int hashCode() {
        return policyNo;
    }

    // sorting based on expiry days
    public int compareTo(Policy p) {
        return this.expiryDays - p.expiryDays;
    }

    public String toString() {
        return policyNo + " | " + holderName + " | "
                + expiryDays + " days | "
                + coverage + " | "
                + premium;
    }
}

public class InsuranceManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Policy> hashSet = new HashSet<Policy>();
        LinkedHashSet<Policy> linkedSet = new LinkedHashSet<Policy>();
        TreeSet<Policy> treeSet = new TreeSet<Policy>();
        System.out.print("Enter total policies: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Policy Number: ");
            int num = sc.nextInt();
            System.out.print("Holder Name: ");
            String name = sc.next();
            System.out.print("Expiry days left: ");
            int days = sc.nextInt();
            System.out.print("Coverage Type: ");
            String type = sc.next();

            System.out.print("Premium Amount: ");
            double amount = sc.nextDouble();
            Policy p = new Policy(num, name, days, type, amount);

            hashSet.add(p);
            linkedSet.add(p);
            treeSet.add(p);
        }

        System.out.println("\nAll Unique Policies:");
        for (Policy p : hashSet) {
            System.out.println(p);
        }

        System.out.println("\nPolicies expiring within 30 days:");
        for (Policy p : treeSet) {
            if (p.expiryDays <= 30) {
                System.out.println(p);
            }
        }

        // search by coverage
        System.out.print("\nEnter coverage to search: ");
        String search = sc.next();

        for (Policy p : hashSet) {
            if (p.coverage.equalsIgnoreCase(search)) {
                System.out.println(p);
            }
        }

        // performance check
        Policy test = hashSet.iterator().next();

        long start, end;

        start = System.nanoTime();
        hashSet.contains(test);
        end = System.nanoTime();
        System.out.println("\nHashSet search time: " + (end - start));

        start = System.nanoTime();
        linkedSet.contains(test);
        end = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (end - start));

        start = System.nanoTime();
        treeSet.contains(test);
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start));
    }
}
