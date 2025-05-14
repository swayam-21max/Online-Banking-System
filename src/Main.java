import service.BankService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n========== Online Banking System ==========");
            System.out.printf("%-5s %-25s %-5s %-25s%n", "1.", "Register", "2.", "Login");
            System.out.printf("%-5s %-25s %-5s %-25s%n", "3.", "Create Account", "4.", "Deposit");
            System.out.printf("%-5s %-25s %-5s %-25s%n", "5.", "Withdraw", "6.", "Transfer");
            System.out.printf("%-5s %-25s %-5s %-25s%n", "7.", "Show Balance", "8.", "Transaction History");
            System.out.printf("%-5s %-25s %-5s %-25s%n", "9.", "Logout", "10.", "List of Account Holders");
            System.out.printf("%-5s %-25s %-5s %-25s%n", "11.", "Search By Account ID", "12.", "Delete Account");
            System.out.printf("%-5s %-25s%n", "13.", "Generate Bank Statement", "14.", "Exit");
            System.out.println("===========================================");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    bankService.register(name, email, password);
                    break;

                case 2:
                    System.out.print("Enter email: ");
                    email = sc.nextLine();
                    System.out.print("Enter password: ");
                    password = sc.nextLine();
                    bankService.login(email, password);
                    break;

                case 3:
                    bankService.createAccount();
                    break;

                case 4:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    bankService.deposit(depositAmount);
                    break;

                case 5:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    bankService.withdraw(withdrawAmount);
                    break;

                case 6:
                    System.out.print("Enter recipient Account ID: ");
                    String toAccount = sc.nextLine();
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = sc.nextDouble();
                    bankService.transfer(toAccount, transferAmount);
                    break;

                case 7:
                    bankService.showBalance();
                    break;

                case 8:
                    bankService.showTransactions();
                    break;

                case 9:
                    bankService.logout();
                    break;

                case 10:
                    bankService.showAllAccountHolders();
                    break;
                case 11:
                    System.out.print("Enter Account ID: ");
                    String accId = sc.nextLine();
                    bankService.showAccountOwner(accId);
                    break;
                case 12:
                    bankService.deleteAccount();
                    break;

                case 13:
                    bankService.generateBankStatement();
                    break;

                case 14:
                    System.out.println("Thank you for using the Online Banking System.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
