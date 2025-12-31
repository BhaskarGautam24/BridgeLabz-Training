import java.util.*;

public class BankAccount{
    private static String bankname = "State Bank of India";
    private static int totalAccounts = 0;
     
    private String accountHolderName;
    private final String accountNumber;
    private double balance;

    // Constructor
    BankAccount(String accountHolderName, String accountNumber, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    static void getTotalAccounts(){
        
        System.out.println("Total number of accounts: " + totalAccounts);           
    }
    public void displayAccountDetails(){
        if(this instanceof BankAccount){
        System.out.println("Bank Name: " + bankname);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
    else{
        System.out.println("Invalid BankAccount instance.");
    }
    }
       // Getters and setters
   public String getAccountHolderName() {
       return accountHolderName;
   }
   public void setAccountHolderName(String accountHolderName) {
       this.accountHolderName = accountHolderName;
   }
   public double getBalance() {
       return balance;
   }
   public void deposit(double amount) {
       if (amount > 0) {
           balance += amount;
           System.out.println("Deposited: $" + amount);
       } else {
           System.out.println("Invalid deposit amount.");
       }
   }
   public void withdraw(double amount) {
       if (amount > 0 && amount <= balance) {
           balance -= amount;
           System.out.println("Withdrawn: $" + amount);
       } else {
           System.err.println("Insufficient balance or invalid amount.");
       }
   }
   public static void main(String[] args) {
       // Create two bank accounts
       BankAccount account1 = new BankAccount("Bhaskar Gautam", "ACC12345", 100000.00);
       BankAccount account2 = new BankAccount("Gaurav Kumar", "ACC67890", 500000.00);
       // Display account details
       System.out.println("\nAccount 1 Details:");
       account1.displayAccountDetails();
       System.out.println("\nAccount 2 Details:");
       account2.displayAccountDetails();
       // Check total accounts
       BankAccount.getTotalAccounts();
       // Deposit and withdraw operations
       System.out.println("\nPerforming transactions on Account 1:");
       account1.deposit(200);
       account1.withdraw(150);
       account1.displayAccountDetails();
       account2.displayAccountDetails();
       account2.deposit(100);
       account2.withdraw(800);
   }
}