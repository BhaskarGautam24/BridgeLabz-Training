import java.util.*;
class Policy {

    int policyNo;
    String holderName;
    int expiryDays; // how many days left for expiry
    double premium;

    Policy(int policyNo, String holderName, int expiryDays, double premium) {
        this.policyNo = policyNo;
        this.holderName = holderName;
        this.expiryDays = expiryDays;
        this.premium = premium;
    }

    public String toString() {
        return policyNo + " | " + holderName + " | " + expiryDays + " days | " + premium;
    }
}

class InsuranceSystem {

    HashMap<Integer, Policy> policyMap = new HashMap<Integer, Policy>();       // fast access map
    LinkedHashMap<Integer, Policy> policyOrder = new LinkedHashMap<Integer, Policy>(); // keep order of input
    TreeMap<Integer, Policy> policyExpiry = new TreeMap<Integer, Policy>();    // sort by expiry days

    Scanner scn = new Scanner(System.in);

    void addPolicies() {
        System.out.print("Enter number of policies: ");
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Policy No: ");
            int no = scn.nextInt();
            System.out.print("Holder Name: ");
            String name = scn.next();
            System.out.print("Expiry Days: ");
            int days = scn.nextInt();
            System.out.print("Premium: ");
            double amt = scn.nextDouble();

            Policy p = new Policy(no, name, days, amt);
            policyMap.put(no, p);        // store in hashmap
            policyOrder.put(no, p);      // store in linked hashmap to keep order
            policyExpiry.put(days, p);   // store in treemap for sorting by expiry
        }
    }

    void getPolicyByNumber() {
        System.out.print("Enter policy number to search: ");
        int no = scn.nextInt();
        if (policyMap.containsKey(no)) {
            System.out.println(policyMap.get(no)); // found policy
        } else {
            System.out.println("Policy not found"); // not found
        }
    }

    void policiesExpiringSoon() {
        System.out.println("Policies expiring in 30 days or less:");
        for (Integer d : policyExpiry.keySet()) {
            if (d <= 30) {
                System.out.println(policyExpiry.get(d)); // printing policy expiring soon
            }
        }
    }

    void policiesByHolder() {
        System.out.print("Enter holder name: ");
        String name = scn.next();
        for (Policy p : policyMap.values()) {
            if (p.holderName.equals(name)) {
                System.out.println(p); // print policy of this holder
            }
        }
    }

    void removeExpired() {
        Iterator<Integer> it = policyMap.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            if (policyMap.get(key).expiryDays <= 0) {
                it.remove(); // remove expired policy from map
            }
        }
        System.out.println("Expired policies removed."); // notify
    }
}
class VotingSystem {

    Scanner scn = new Scanner(System.in);
    HashMap<String, Integer> votesMap = new HashMap<String, Integer>();     // candidate -> votes
    LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<String, Integer>(); // keep order of votes
    TreeMap<String, Integer> sortedVotes = new TreeMap<String, Integer>();  // sort candidates

    void addVotes() {
        System.out.print("Enter number of votes: ");
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            String candidate = scn.next();
            votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1); // increase vote count
            voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1); // keep order also
        }
        sortedVotes.putAll(votesMap); // copy to tree map for sorted display
    }

    void showSortedVotes() {
        System.out.println("Votes in sorted order:");
        for (String c : sortedVotes.keySet()) {
            System.out.println(c + " : " + sortedVotes.get(c)); // print each candidate
        }
    }
}
class ShoppingCart {

    Scanner scn = new Scanner(System.in);
    HashMap<String, Integer> priceMap = new HashMap<String, Integer>();   // item -> price
    LinkedHashMap<String, Integer> cartOrder = new LinkedHashMap<String, Integer>(); // keep order added
    TreeMap<Integer, String> sortedPrice = new TreeMap<Integer, String>(); // sort by price

    void addItems() {
        System.out.print("Enter number of items: ");
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            String item = scn.next();
            int price = scn.nextInt();
            priceMap.put(item, price); // store price
            cartOrder.put(item, price); // keep order
            sortedPrice.put(price, item); // sorted by price
        }
    }

    void showSortedItems() {
        System.out.println("Items sorted by price:");
        for (Integer p : sortedPrice.keySet()) {
            System.out.println(sortedPrice.get(p) + " : " + p); // print item and price
        }
    }
}
class BankingSystem {

    Scanner scn = new Scanner(System.in);
    HashMap<Integer, Integer> accounts = new HashMap<Integer, Integer>();   // acc -> balance
    TreeMap<Integer, Integer> sortedBalances = new TreeMap<Integer, Integer>(); // sort by balance
    Queue<Integer> withdrawQueue = new LinkedList<Integer>(); // withdrawal requests

    void addAccounts() {
        System.out.print("Enter number of accounts: ");
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int acc = scn.nextInt();
            int bal = scn.nextInt();
            accounts.put(acc, bal); // store account
            sortedBalances.put(bal, acc); // for sorted display
        }
    }

    void addWithdrawRequests() {
        System.out.print("Enter number of withdraw requests: ");
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) {
            withdrawQueue.add(scn.nextInt()); // queue the request
        }
    }

    void processWithdrawals() {
        while (!withdrawQueue.isEmpty()) {
            int acc = withdrawQueue.remove();
            if (accounts.containsKey(acc)) {
                accounts.put(acc, accounts.get(acc) - 100); // deduct 100
            }
        }
        System.out.println("Withdrawals processed."); // done
    }
}
public class MainSystem {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Choose system: 1-Insurance 2-Voting 3-Cart 4-Bank");
        int choice = scn.nextInt();

        if (choice == 1) {
            InsuranceSystem ins = new InsuranceSystem();
            ins.addPolicies();
            ins.getPolicyByNumber();
            ins.policiesExpiringSoon();
            ins.policiesByHolder();
            ins.removeExpired();
        } else if (choice == 2) {
            VotingSystem vote = new VotingSystem();
            vote.addVotes();
            vote.showSortedVotes();
        } else if (choice == 3) {
            ShoppingCart cart = new ShoppingCart();
            cart.addItems();
            cart.showSortedItems();
        } else if (choice == 4) {
            BankingSystem bank = new BankingSystem();
            bank.addAccounts();
            bank.addWithdrawRequests();
            bank.processWithdrawals();
        } else {
            System.out.println("Invalid choice");
        }
    }
}
