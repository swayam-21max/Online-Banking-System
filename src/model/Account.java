package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private String userId;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountId, String userId) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
