import java.util.*;
public class BankAssociationDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // asking bank name
        System.out.print("enter bank name: ");
        String bankName = scn.nextLine();
        // creating bank object
        Bank bank = new Bank(bankName);

        // asking customer name
        System.out.print("enter customer name: ");
        String customerName = scn.nextLine();

        // creating customer object
        Customer customer = new Customer(customerName);

        // asking initial balance
        System.out.print("enter opening balance: ");
        double openingBalance = scn.nextDouble();

        // opening account using bank
        bank.openAccount(customer, openingBalance);

        // customer checking balance
        customer.viewBalance();
    }
}
class Bank {

    // bank name variable
    private String bankName;

    // list to store customers
    private ArrayList<Customer> customerList;

    // constructor for bank
    public Bank(String bankName) {
        // assigning bank name
        this.bankName = bankName;
        // creating customer list
        this.customerList = new ArrayList<Customer>();
    }

    // method to open account
    public void openAccount(Customer customer, double balance) {
        // creating account object
        Account account = new Account(balance, this);

        // setting account to customer
        customer.setAccount(account);

        // adding customer to bank list
        customerList.add(customer);

        // small confirmation message
        System.out.println("account opened in " + bankName);
    }

    // getter for bank name
    public String getBankName() {
        return bankName;
    }

    // setter for bank name
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
class Customer {

    // customer name variable
    private String customerName;

    // account reference
    private Account account;

    // constructor for customer
    public Customer(String customerName) {
        // assigning customer name
        this.customerName = customerName;
    }

    // method to view balance
    public void viewBalance() {
        // checking account exists or not
        if (account != null) {
            // showing balance
            System.out.println("customer: " + customerName);
            System.out.println("bank: " + account.getBank().getBankName());
            System.out.println("balance: " + account.getBalance());
        } else {
            // message if no account
            System.out.println("no account found yet");
        }
    }

    // setter for account
    public void setAccount(Account account) {
        this.account = account;
    }

    // getter for account
    public Account getAccount() {
        return account;
    }
}
class Account {

    // balance variable
    private double balance;

    // bank reference
    private Bank bank;

    // constructor for account
    public Account(double balance, Bank bank) {
        // assigning balance
        this.balance = balance;
        // assigning bank
        this.bank = bank;
    }

    // getter for balance
    public double getBalance() {
        return balance;
    }

    // setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // getter for bank
    public Bank getBank() {
        return bank;
    }
}

