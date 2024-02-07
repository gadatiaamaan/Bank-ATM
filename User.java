import java.util.Scanner;

public class User {
    private String accountNumber; // Stores the account number of the user
    private String pin; // Stores the PIN of the user
    private CheckingAccount checkingAccount; // Stores the checking account object associated with the user
    private SavingsAccount savingsAccount; // Stores the savings account object associated with the user
    private Scanner scanner; // Scanner object for user input

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for PIN
    public String getPin() {
        return pin;
    }

    // Constructor for User class
    public User(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        checkingAccount = new CheckingAccount(); // Initializes a new CheckingAccount object
        savingsAccount = new SavingsAccount(0.05); // Initializes a new SavingsAccount object with a 5% interest rate
        scanner = new Scanner(System.in); // Initializes a Scanner object for user input
    }

    // Getter method for savings account
    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    // Method to login and access user menu
    public void login() {
        userMenu();
    }

    // Method to display the user menu and handle user choices
    private void userMenu() {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Get checking balance");
            System.out.println("2. Deposit into checking");
            System.out.println("3. Withdraw from checking");
            System.out.println("4. Get savings balance");
            System.out.println("5. Deposit into savings");
            System.out.println("6. Withdraw from savings");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Reads user choice
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Checking balance: $" + checkingAccount.getBalance());
                    break;
                case 2:
                    depositIntoChecking();
                    break;
                case 3:
                    withdrawFromChecking();
                    break;
                case 4:
                    System.out.println("Savings balance: $" + savingsAccount.getBalance());
                    break;
                case 5:
                    depositIntoSavings();
                    break;
                case 6:
                    withdrawFromSavings();
                    break;
                case 7:
                    return; // Exits the user menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to deposit money into the checking account
    private void depositIntoChecking() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble(); // Reads deposit amount
        checkingAccount.deposit(amount); // Deposits the amount into checking account
        System.out.println("Deposit successful.");
    }

    // Method to withdraw money from the checking account
    private void withdrawFromChecking() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble(); // Reads withdrawal amount
        if (checkingAccount.withdraw(amount)) { // Checks if withdrawal is successful
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Method to deposit money into the savings account
    private void depositIntoSavings() {
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble(); // Reads deposit amount
        savingsAccount.deposit(amount); // Deposits the amount into savings account
        System.out.println("Deposit successful.");
    }

    // Method to withdraw money from the savings account
    private void withdrawFromSavings() {
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble(); // Reads withdrawal amount
        if (savingsAccount.withdraw(amount)) { // Checks if withdrawal is successful
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
