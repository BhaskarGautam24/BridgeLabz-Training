package com.testcase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class test{

    @Test
    public void Test_Deposit_ValidAmount(){
        BankSystem account=new BankSystem(1000);
        account.deposit(500);
        assertEquals(1500,account.getBalance());
    }

    @Test
    public void Test_Deposit_NegativeAmount(){
    	BankSystem account=new BankSystem(1000);
        assertThrows(RuntimeException.class,()->account.deposit(-200));
    }

    @Test
    public void Test_Withdraw_ValidAmount(){
    	BankSystem account=new BankSystem(1000);
        account.withdraw(300);
        assertEquals(700,account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds(){
    	BankSystem account=new BankSystem(1000);
        assertThrows(RuntimeException.class,()->account.withdraw(1500));
    }
}
