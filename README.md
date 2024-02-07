# Gadatia Bank ATM System

## Overview
The Gadatia Bank ATM System is a Java program that simulates an Automated Teller Machine (ATM) system for managing user accounts and performing banking transactions. It includes functionality for both administrators and users to interact with the system.

## Features
- **Admin Features:**
  - Login with admin credentials
  - Add new user accounts
  - Delete existing user accounts
  - List all user accounts
  - Apply interest to all savings accounts

- **User Features:**
  - Login with account number and PIN
  - View checking and savings account balances
  - Deposit and withdraw funds from checking and savings accounts

## Usage
1. Clone the repository to your local machine.
2. Compile the Java files using a Java compiler.
   ```
   javac *.java
   ```
3. Run the Main class to start the ATM system.
   ```
   java Main
   ```
4. Follow the on-screen prompts to navigate through the admin and user menus.

## Technologies, Algorithms, and Concepts Used
### Technologies:
- **Java:** The program is written in Java, a widely-used programming language known for its simplicity, portability, and strong object-oriented features.
- **Serialization:** Object serialization is used to save and load user data from files, allowing for persistence of user accounts between program runs.
- **Scanner Class:** The Scanner class is utilized for user input, enabling interactive communication with the ATM system through the console.

### Algorithms:
- **HashMap:** A HashMap data structure is employed to store user accounts, allowing for efficient retrieval, addition, and deletion of user information.
- **Switch-Case Statements:** Switch-case statements are used for menu-driven navigation within the program, providing a structured way for users to interact with different features.

### Concepts:
- **Object-Oriented Programming (OOP):** The program is designed using OOP principles, including encapsulation, inheritance, and polymorphism, to model real-world entities such as users, accounts, and transactions.
- **File I/O:** File input/output operations are utilized to save and load user data, providing persistence and data management capabilities to the ATM system.
- **Authentication and Authorization:** The system implements user authentication and authorization mechanisms to ensure secure access to user accounts and sensitive banking operations.

