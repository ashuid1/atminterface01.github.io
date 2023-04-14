package ATMinterface;

import java.util.*;

public class ATM {
    // Map to store user information
    private static Map<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create some test users
        User user1 = new User("John", "Doe", "johndoe", "1234");
        User user2 = new User("Jane", "Doe", "janedoe", "5678");
        users.put(user1.getUsername(), user1);
        users.put(user2.getUsername(), user2);

        // Main program loop
        while (true) {
            // Ask user to enter username and PIN
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            // Check if user exists and PIN is correct
            if (!users.containsKey(username)) {
                System.out.println("User does not exist.");
            } else if (!users.get(username).getPin().equals(pin)) {
                System.out.println("Incorrect PIN.");
            } else {
                // User is authenticated, display menu
                User currentUser = users.get(username);
                System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
                displayMenu(currentUser);
            }
        }
    }
    private static void displayMenu(User user) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. View transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    user.viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    user.withdraw(amount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    user.deposit(amount);
                    break;
                case 4:
                    System.out.print("Enter recipient username: ");
                    String recipient = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    user.transfer(recipient, amount);
                    break;
                case 5:
                    return; // Exit program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to deposit money into the user's account

    // Method to transfer money from the user's account to another user's account

    // Method to view the user's transaction history


}



