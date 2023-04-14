package ATMinterface;

import java.util.*;

public class User {
    private static HashMap<String, User> users;
    // User fields
    private String firstName;
    private String lastName;
    private String username;
    private String pin;
    private double balance;
    private List<String> transactionHistory;
    //private Object ATMInterface;

    // Constructor
    public User(String firstName, String lastName, String username, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    
        public void viewTransactionHistory() {
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions to display.");
            } else {
                System.out.println("Transaction history:");
                for (String transaction : transactionHistory) {
                    System.out.println("- " + transaction);
                }
                System.out.println("Current balance: $" + balance);
            }
        }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal of $" + amount);
            System.out.println("$" + amount + " withdrawn from account.");
            System.out.println("Current balance: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit of $" + amount);
        System.out.println("$" + amount + " deposited into account.");
        System.out.println("Current balance: $" + balance);
    }

    public void transfer(String recipient, double amount) {
        if (!User.users.containsKey(recipient)) {
            System.out.println("Recipient does not exist.");
        } else if (balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory.add("Transfer of $" + amount + " to " + recipient);
            User recipientUser = (User) User.users.get(recipient);
            recipientUser.setBalance(recipientUser.getBalance() + amount);
            System.out.println("$" + amount + " transferred to " + recipientUser.getFirstName() + " " + recipientUser.getLastName() + ".");
            System.out.println("Current balance: $" + balance);
        }
    }
}
