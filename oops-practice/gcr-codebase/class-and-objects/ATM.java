class BankAccount {

    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {        // constructor to initialize account details
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayBalance() {                       // Display current balance
        System.out.println("Current balance: " + balance);
    }

    void deposit(double amount) {                   // Deposit amount
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    void withdraw(double amount) {                    // Withdraw amount
        System.out.println("Withdraw amount is : " + amount);
        if (balance >= amount) {
            balance = balance - amount;
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class ATM {
    public static void main(String[] args) {

        System.out.println("State of Chennai");
        BankAccount acc = new BankAccount("Kannan", "ACC001", 700.0);

        acc.displayBalance();
        acc.deposit(200.0);
        acc.withdraw(100.0);
        acc.withdraw(900.0);   
    }
}

