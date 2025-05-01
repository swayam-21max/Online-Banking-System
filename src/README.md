# 🏦 Online Banking System — Java Console Project

[![Java](https://img.shields.io/badge/Built%20With-Java%2017+-red.svg)](https://www.oracle.com/java/)
[![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue.svg)](https://www.jetbrains.com/idea/)
[![Status](https://img.shields.io/badge/Status-Completed-brightgreen.svg)]()
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)]()

A **fully functional console-based Online Banking System** built using **Java, OOPs principles**, and **core Data Structures**. This project simulates the real-world operations of a basic banking system including user registration, login, account management, fund transfers, and complete transaction tracking.

---

## 🧠 Key Concepts Implemented

- Object-Oriented Programming (OOP)
- Abstraction, Encapsulation, Inheritance
- Java Collections (HashMap, ArrayList)
- UUID for unique user/account IDs
- Input validation & error handling
- Separation of concerns (Model, Service, UI)

---

## ✨ Features & Functionalities

### 👤 User Management
- ✅ User Registration with name, email & password
- ✅ Secure Login with validation
- ✅ Logout functionality
- ✅ Support for multiple users

### 💼 Account Management
- ✅ Create bank account per user
- ✅ Each account linked uniquely to the user
- ✅ Multiple users can have their own accounts

### 💰 Financial Operations
- ✅ Deposit money into your account
- ✅ Withdraw money (with balance check)
- ✅ View current account balance

### 🔁 Fund Transfer
- ✅ Transfer funds to another user's account using Account ID
- ✅ Transaction appears in both sender’s and receiver’s history
- ✅ Prevent transfer if insufficient balance or invalid account

### 📜 Transaction Tracking
- ✅ Full transaction history maintained per account
- ✅ Displays timestamp, type, amount, and counterparty
- ✅ Auto-updated with every deposit, withdrawal, or transfer

### 📋 Command-Line Interface
- ✅ Simple, clean, and easy-to-navigate menu
- ✅ Input-driven operation using numbers
- ✅ Clear prompts and informative messages

---

## 🧪 Sample CLI Menu

```
========== Online Banking System ==========
| 1. Register             | 2. Login           |
| 3. Create Account       | 4. Deposit         |
| 5. Withdraw             | 6. Transfer        |
| 7. Show Balance         | 8. Transaction Log |
| 9. Logout               | 10. Exit           |
===========================================
```

---

## 🛠 Project Structure

```
Online-Banking-System/
├── src/
│   ├── model/
│   │   ├── User.java           # User POJO
│   │   ├── Account.java        # Bank account POJO
│   │   └── Transaction.java    # Transaction POJO
│   ├── service/
│   │   └── BankService.java    # All core business logic
│   └── Main.java               # CLI-based user interface
├── README.md
└── .gitignore
```

---

## 📦 How to Run the Project

### ✅ Prerequisites

- Java 17 or higher installed
- IntelliJ IDEA (recommended)
- Git (optional for version control)

### 🚀 Steps

```bash
# Step 1: Clone the repo
git clone https://github.com/your-username/Online-Banking-System.git

# Step 2: Open in IntelliJ IDEA
# Step 3: Run `Main.java` to launch the app
```

---

## 📌 Future Enhancements

- 💾 Persistent storage using file I/O or a database (MySQL)
- 🔒 Password encryption using SHA-256 or BCrypt
- 🧪 Unit Testing with JUnit for service methods
- 🖥️ GUI Interface with JavaFX or Swing
- 🧑‍💼 Admin dashboard to manage users/accounts
- 📤 Export transaction history to CSV or PDF

---

## 👨‍💻 Author

**Swayam Kataria**  
📧 workswm21@gmail.com  
🌐 [GitHub](https://github.com/swayam-21max) | [LinkedIn](https://linkedin.com/in/swayam-kataria)

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Acknowledgements

Thanks to open-source communities and the Java ecosystem for enabling self-learners and students to build real-world software!

> ⚠️ If you find this project useful, give it a ⭐ star and share it with others!
