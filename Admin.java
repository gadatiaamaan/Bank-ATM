import java.util.Scanner;

public class Admin {
    private static final String ADMIN_ACCOUNT_NUMBER = "00000";
    private static final String ADMIN_PIN = "12345";
    private ATMSystem atmSystem;
    private Scanner scanner;

    // Constructor to initialize Admin with ATMSystem and Scanner
    public Admin(ATMSystem atmSystem) {
        this.atmSystem = atmSystem;
        scanner = new Scanner(System.in);
    }

    // Method to prompt for admin login and authenticate
    public void login() {
        System.out.print("Enter admin account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Check if entered account number and PIN match the admin credentials
        if (accountNumber.equals(ADMIN_ACCOUNT_NUMBER) && pin.equals(ADMIN_PIN)) {
            adminMenu(); // If authenticated, display admin menu
        } else {
            System.out.println("Invalid credentials. Exiting..."); // Otherwise, display error message
        }
    }

    // Method to display admin menu and handle admin operations
    private void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add a user");
            System.out.println("2. Delete a user");
            System.out.println("3. List all users");
            System.out.println("4. Apply interest to all savings accounts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addUser(); // Option to add a new user
                    break;
                case 2:
                    deleteUser(); // Option to delete a user
                    break;
                case 3:
                    listUsers(); // Option to list all users
                    break;
                case 4:
                    applyInterest(); // Option to apply interest to all savings accounts
                    break;
                case 5:
                    return; // Exit option
                default:
                    System.out.println("Invalid choice. Please try again."); // Invalid choice
            }
        }
    }

    // Method to add a new user
    private void addUser() {
        System.out.print("Enter user account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String pin = scanner.nextLine();  // Prompt admin to enter the PIN
        atmSystem.addUser(new User(accountNumber, pin));  // Add the new user with specified account number and PIN
        System.out.println("User added successfully.");
    }    

    // Method to delete a user
    private void deleteUser() {
        System.out.print("Enter user account number to delete: ");
        String accountNumber = scanner.nextLine();
        atmSystem.deleteUser(accountNumber); // Delete the user with specified account number
        System.out.println("User deleted successfully.");
    }

    // Method to list all users
    private void listUsers() {
        System.out.println("\nAll Users:");
        for (User user : atmSystem.getAllUsers()) {
            System.out.println("Account Number: " + user.getAccountNumber());
        }
    }

    // Method to apply interest to all savings accounts
    private void applyInterest() {
        System.out.print("Enter interest period (in months): ");
        double period = scanner.nextDouble();
        atmSystem.applyInterestToAllSavingsAccounts(period); // Apply interest to all savings accounts
        System.out.println("Interest applied to all savings accounts.");
    }
}
