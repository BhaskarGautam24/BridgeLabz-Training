package com.testcase;

public class  BankSystem {

    private double balance;

    public BankSystem(double initialBalance){
        this.balance=initialBalance;
    }

    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount<0){
            throw new RuntimeException("Deposit amount cannot be negative");
        }
        balance=balance+amount;
    }

    public void withdraw(double amount){
        if(amount>balance){
            throw new RuntimeException("Insufficient funds.");
        }
        balance=balance-amount;
    }
}


