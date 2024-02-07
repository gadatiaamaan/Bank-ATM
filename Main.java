import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize ATMSystem and Admin objects
        ATMSystem atmSystem = new ATMSystem();
        Admin admin = new Admin(atmSystem);

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        // Main menu loop
        while (!exit) {
            // Display main menu options
            System.out.println("Welcome to Gadatia Bank ATM");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Switch based on user choice
            switch (choice) {
                case 1:
                    // Admin login
                    admin.login();
                    break;
                case 2:
                    // User login
                    User user = userLogin(atmSystem);
                    if (user != null) {
                        user.login(); // User menu
                    } else {
                        System.out.println("Invalid account number or PIN. Exiting...");
                    }
                    break;
                case 3:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to handle user login
    private static User userLogin(ATMSystem atmSystem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();
        User user = atmSystem.getUser(accountNumber);
        if (user != null && user.getPin().equals(pin)) {
            return user; // Return the user if credentials are valid
        }
        return null; // Return null if credentials are invalid
    }
}
