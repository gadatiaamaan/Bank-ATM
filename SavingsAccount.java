public class SavingsAccount extends Account {
    private double interestRate; // Interest rate for the savings account

    // Constructor to initialize the savings account with an interest rate
    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    // Method to apply interest to the savings account balance
    public void applyInterest(double period) {
        double principle = getBalance(); // Get the current balance of the account
        double interest = principle * interestRate * period; // Calculate the interest
        deposit(interest); // Deposit the interest into the account
    }
}
