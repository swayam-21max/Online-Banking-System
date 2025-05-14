package service;

import model.Account;
import model.Transaction;
import model.User;
import util.IDGenerator;

import java.util.*;

public class BankService {

    // Data storage
    private final Map<String, User> users = new HashMap<>();         // userId -> User
    private final Map<String, Account> accounts = new HashMap<>();   // accountId -> Account
    private final Map<String, String> loginCredentials = new HashMap<>(); // email -> password
    private User currentUser = null;
    private Account currentAccount = null;

    // Register a new user
    public void register(String name, String email, String password) {
        if (loginCredentials.containsKey(email)) {
            System.out.println("Email already registered.");
            return;
        }

        String userId = IDGenerator.generateID();
        User newUser = new User(userId, name, email, password);
        users.put(userId, newUser);
        loginCredentials.put(email, password);
        System.out.println("Registration successful. Your user ID is: " + userId);
    }

    // Login user
    public boolean login(String email, String password) {
        if (!loginCredentials.containsKey(email) || !loginCredentials.get(email).equals(password)) {
            System.out.println("Invalid credentials.");
            return false;
        }

        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                currentUser = user;

                // 🟢 Load associated account if exists
                for (Account account : accounts.values()) {
                    if (account.getUserId().equals(currentUser.getUserId())) {
                        currentAccount = account;
                        break;
                    }
                }

                System.out.println("Login successful. Welcome, " + user.getName() + "!");
                return true;
            }
        }
        return false;
    }

    // Create bank account
    public void createAccount() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }

        String accountId = IDGenerator.generateID();
        Account account = new Account(accountId, currentUser.getUserId());
        accounts.put(accountId, account);
        currentAccount = account;
        System.out.println("Account created successfully. Account ID: " + accountId);
    }

    // Deposit money
    public void deposit(double amount) {
        if (currentAccount == null) {
            System.out.println("No active account. Please create one.");
            return;
        }

        currentAccount.setBalance(currentAccount.getBalance() + amount);
        currentAccount.getTransactionHistory().add(new Transaction("Deposit", amount));
        System.out.println("Amount deposited: ₹" + amount);
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (currentAccount == null) {
            System.out.println("No active account.");
            return;
        }

        if (currentAccount.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        currentAccount.setBalance(currentAccount.getBalance() - amount);
        currentAccount.getTransactionHistory().add(new Transaction("Withdraw", amount));
        System.out.println("Amount withdrawn: ₹" + amount);
    }

    // Transfer money
    public void transfer(String toAccountId, double amount) {
        if (currentAccount == null) {
            System.out.println("No active account. Please login and create an account first.");
            return;
        }

        if (!accounts.containsKey(toAccountId)) {
            System.out.println("Recipient account not found.");
            return;
        }

        if (currentAccount.getAccountId().equals(toAccountId)) {
            System.out.println("Cannot transfer to the same account.");
            return;
        }

        Account receiver = accounts.get(toAccountId);

        if (currentAccount.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        // Perform transfer
        currentAccount.setBalance(currentAccount.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        // Add transaction to sender
        currentAccount.getTransactionHistory().add(
                new Transaction("Transfer to " + toAccountId, amount)
        );

        // Add transaction to receiver
        receiver.getTransactionHistory().add(
                new Transaction("Transfer from " + currentAccount.getAccountId(), amount)
        );

        System.out.println("₹" + amount + " transferred successfully to Account ID: " + toAccountId);
    }


    // Show account balance
    public void showBalance() {
        if (currentAccount == null) {
            System.out.println("No active account.");
            return;
        }

        System.out.println("Current Balance: ₹" + currentAccount.getBalance());
    }

    // Show transaction history
    public void showTransactions() {
        if (currentAccount == null) {
            System.out.println("No active account.");
            return;
        }

        List<Transaction> history = currentAccount.getTransactionHistory();
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        System.out.println("Transaction History:");
        for (Transaction t : history) {
            System.out.println(t.getTimestamp() + " | " + t.getType() + " | ₹" + t.getAmount());
        }
    }

    // Show all account holders
    public void showAllAccountHolders() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("===== List of Account Holders =====");
        for (Account account : accounts.values()) {
            String userId = account.getUserId();
            User user = users.get(userId);
            if (user != null) {
                System.out.println("Name: " + user.getName() +
                        ", Email: " + user.getEmail() +
                        ", Account ID: " + account.getAccountId() +
                        ", Balance: ₹" + account.getBalance());
            }
        }
    }

    // Show account owner by account ID
    public void showAccountOwner(String accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        User user = users.get(account.getUserId());
        if (user == null) {
            System.out.println("User not found for this account.");
            return;
        }

        System.out.println("===== Account Owner Details =====");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Balance: ₹" + account.getBalance());
    }
    // Delete Account Method
    // Delete Account by Account ID
    public void deleteAccount(String accountId) {
        // Check if the account exists in the accounts map
        if (!accounts.containsKey(accountId)) {
            System.out.println("Account not found.");
            return;
        }

        // Get the account and its associated user
        Account accountToDelete = accounts.get(accountId);
        String userId = accountToDelete.getUserId();
        User userToDelete = users.get(userId);

        // Remove the account from the accounts map
        accounts.remove(accountId);

        // Logout after deletion
        logout();

        System.out.println("Account deleted successfully.");
    }

    // Generate Bank Statement Method
    public void generateBankStatement() {
        if (currentAccount == null) {
            System.out.println("No active account. Please login first.");
            return;
        }

        // Get the account details
        Account account = accounts.get(accountId);
        List<Transaction> transactionHistory = account.getTransactionHistory();

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        // Display Bank Statement
        System.out.println("\n========== Bank Statement ==========");
        System.out.println("Account ID: " + accountId);
        System.out.println("User ID: " + account.getUserId());
        System.out.println("Current Balance: ₹" + account.getBalance());
        System.out.println("\nTransaction History:");

        // Print each transaction in the history
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getTimestamp() + " | " + transaction.getType() + " | ₹" + transaction.getAmount());
        }

        System.out.println("=====================================");
    }

    // Logout
    public void logout() {
        currentUser = null;
        currentAccount = null;
        System.out.println("Logged out successfully.");
    }
    // Show all account holders
    public void showAllAccountHolders() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("===== List of Account Holders =====");
        for (Account account : accounts.values()) {
            String userId = account.getUserId();
            User user = users.get(userId);
            if (user != null) {
                System.out.println("Name: " + user.getName() +
                        ", Email: " + user.getEmail() +
                        ", Account ID: " + account.getAccountId() +
                        ", Balance: ₹" + account.getBalance());
            }
        }
    }

    // Show account owner by account ID
    public void showAccountOwner(String accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        User user = users.get(account.getUserId());
        if (user == null) {
            System.out.println("User not found for this account.");
            return;
        }

        System.out.println("===== Account Owner Details =====");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("User ID: " + user.getUserId());
        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Balance: ₹" + account.getBalance());
    }

}
