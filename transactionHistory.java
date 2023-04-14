package ATMinterface;

import java.util.ArrayList;
import java.util.List;

public class transactionHistory {
    private List<String> transactions;

    public transactionHistory() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(String transaction) {
        this.transactions.add(transaction);
    }

    public void clearHistory() {
        this.transactions.clear();
    }

    public void printHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
    }
}
