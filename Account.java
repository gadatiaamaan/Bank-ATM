import java.io.Serializable;

// The Account class represents a basic bank account.
// It implements the Serializable interface to allow objects of this class to be serialized.
public class Account implements Serializable {
    protected double balance;  // Balance of the account

    // Constructor: initializes the balance to 0.
    public Account() {
        balance = 0;
    }

    // Getter method to retrieve the current balance of the account.
    public double getBalance() {
        return balance;
    }

    // Method to deposit funds into the account.
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw funds from the account.
    // Returns true if the withdrawal was successful, false otherwise.
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;  // Withdrawal successful
        }
        return false;  // Insufficient funds
    }
}
