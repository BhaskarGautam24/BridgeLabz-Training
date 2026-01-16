import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    // BankAccount class
    static class BankAccount {
        private double balance;

        BankAccount() {
            balance = 0;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient funds");
            }
        }

        double getBalance() {
            return balance;
        }
    }

    // -------- JUnit Tests --------

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });
    }
}

