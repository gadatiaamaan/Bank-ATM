import java.io.*;
import java.util.*;

public class ATMSystem {
    private HashMap<String, User> users; // HashMap to store users with their account numbers as keys

    // Constructor to initialize the ATMSystem with an empty HashMap of users
    public ATMSystem() {
        users = new HashMap<>();
    }

    // Method to add a user to the ATMSystem
    public void addUser(User user) {
        users.put(user.getAccountNumber(), user); // Associates the user's account number with the user object
    }

    // Method to delete a user from the ATMSystem given their account number
    public void deleteUser(String accountNumber) {
        users.remove(accountNumber); // Removes the user associated with the given account number
    }

    // Method to retrieve a user from the ATMSystem given their account number
    public User getUser(String accountNumber) {
        return users.get(accountNumber); // Retrieves the user associated with the given account number
    }

    // Method to retrieve all users from the ATMSystem
    public Collection<User> getAllUsers() {
        return users.values(); // Retrieves all users stored in the system
    }

    // Method to apply interest to all savings accounts in the ATMSystem
    public void applyInterestToAllSavingsAccounts(double period) {
        for (User user : users.values()) { // Iterates through all users in the system
            SavingsAccount savingsAccount = user.getSavingsAccount(); // Retrieves the user's savings account
            savingsAccount.applyInterest(period); // Applies interest to the savings account
        }
    }

    // Method to save the state of the ATMSystem to a file
    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(users); // Writes the HashMap of users to the specified file
        }
    }

    // Method to load the state of the ATMSystem from a file
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            users = (HashMap<String, User>) ois.readObject(); // Reads the HashMap of users from the specified file
        }
    }
}
