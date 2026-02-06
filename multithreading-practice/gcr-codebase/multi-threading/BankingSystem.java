import java.util.*;
class BankAccount{
    int balance=10000;
    void withdraw(String customerName, int amount){
        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);
        if (balance >= amount){
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                System.out.println("Transaction interrupted");
            }

            balance=balance-amount;
            System.out.println("Transaction successful: " +
                    customerName+
                    ", Amount: "+amount+
                    ", Balance: "+balance+
                    ", Time: "+new Date());
        } else {
            System.out.println("Transaction failed: "+
                    customerName+
                    ", Amount: "+amount+
                    ", Balance: "+balance+
                    ", Time: "+new Date());
        }
    }
}
class Transaction implements Runnable{
    BankAccount account;
    String customerName;
    int withdrawAmount;
    Transaction(BankAccount account, String customerName, int withdrawAmount) {
        this.account = account;
        this.customerName = customerName;
        this.withdrawAmount = withdrawAmount;
    }
    public void run(){
        account.withdraw(customerName, withdrawAmount);
    }
}
public class BankingSystem{
    public static void main(String[] args){
        BankAccount account = new BankAccount();
        Thread t1 = new Thread(
                new Transaction(account, "Customer-1", 3000),
                "Customer-1");
        Thread t2 = new Thread(
                new Transaction(account, "Customer-2", 4000),
                "Customer-2");
        Thread t3 = new Thread(
                new Transaction(account, "Customer-3", 2000),
                "Customer-3");
        Thread t4 = new Thread(
                new Transaction(account, "Customer-4", 5000),
                "Customer-4");
        Thread t5 = new Thread(
                new Transaction(account, "Customer-5", 1500),
                "Customer-5");
        System.out.println("Thread State Before Start:");
        System.out.println(t1.getName() + " : " + t1.getState());
        System.out.println(t2.getName() + " : " + t2.getState());
        System.out.println(t3.getName() + " : " + t3.getState());
        System.out.println(t4.getName() + " : " + t4.getState());
        System.out.println(t5.getName() + " : " + t5.getState());
        System.out.println("Transactions Started");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

