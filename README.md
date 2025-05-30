# **🏦 Online Banking System — Java Console Project**





A fully functional console-based Online Banking System built using Java, OOP principles, and core Data Structures. This project simulates real-world banking operations such as user management, account creation, transactions, transfers, and additional admin-style utilities.

🧠 Key Concepts Implemented

1. Object-Oriented Programming (OOP)
2. Abstraction, Encapsulation, Inheritance
3. Java Collections (HashMap, ArrayList)
4. UUID for unique user/account IDs
5. Input validation & error handling
6. Git-based version control with GitHub
7. Data Structures & Algorithms
8. (HashMap, ArrayList, Linear Search, UUID)

New: Admin-style features (search by account, delete, generate statements)

# ✨ **Features & Functionalities**


### 👤 User Management

✅ User Registration with name, email & password

✅ Secure Login with validation

✅ Logout functionality

✅ Support for multiple users

### 💼 Account Management

✅ Create bank account per user

✅ Each account uniquely linked to a user

✅ Multiple users can hold accounts

✅ Delete Account by ID (New)

### 💰 Financial Operations


✅ Deposit funds

✅ Withdraw funds with balance check

✅ View current account balance

### 🔁 Fund Transfer

✅ Transfer funds using Account ID

✅ Transaction recorded for both sender and receiver

✅ Validation for balance and account validity

### 📜 Transaction Tracking

✅ Chronological transaction history

✅ Timestamp, type, amount, and counterparty recorded

✅ Generate Bank Statement by Account ID (New)

### 📋 Command-Line Interface

✅ Menu-driven, user-friendly CLI

✅ Input-based options for all actions

✅ Clear instructions and error feedback

### 🧑‍💼 Admin-Style Utilities

✅ Show all account holders

✅ Search account by Account ID

✅ Delete account by ID

✅ Generate detailed bank statement

# 🔢 DSA Concepts Used

**HashMap**

📌 Used for storing users and accounts with O(1) access time.

📁 BankService.java

🧩 private final Map<String, User> users = new HashMap<>();

**ArrayList**

📌 Maintains the order of transactions for each account.

📁 BankService.java

🧩 currentAccount.getTransactionHistory().add(new Transaction(...));

**UUID**

📌 Generates unique IDs for users and accounts.

📁 IDGenerator.java

🧩 return UUID.randomUUID().toString();

**String**

📌 Used extensively for handling user inputs, IDs, and metadata.

📁 All files

🧩 String userId = IDGenerator.generateID();

**Linear Search**

📌 Used for matching login credentials during user authentication.

📁 BankService.java

🧩 for (User user : users.values()) { ... }



📝 Transactions are stored in insertion order. Sorting (by time, amount) can be added later.

### 🛠 Project Structure


    Online-Banking-System/

        src/

            model/

                User.java - User POJO

                Account.java - Bank account POJO

                Transaction.java - Transaction POJO

            service/

                BankService.java - All core business logic

            util/

                IDGenerator.java - UUID-based ID generator

    Main.java - CLI-based user interface

    README.md

    .gitignore


### 🧪 Sample CLI Menu

#### Option	Action

1	Register

2	Login

3	Create Account

4	Deposit

5	Withdraw

6	Transfer

7	Show Balance

8	Transaction Log

9	Logout

10	List of Account Holders

11	Search By Account ID

12	Delete Account

13	Generate Bank Statement

14	Exit



# 🚀 How to Run the Project

### ✅ Prerequisites

Java 17 or higher

IntelliJ IDEA (or any Java IDE)

Git (for version control)

### ⚙️ Steps to Run

bash

Copy

Edit
# Step 1: Clone the repo
git clone https://github.com/your-username/Online-Banking-System.git

# Step 2: Open in IntelliJ IDEA or any Java IDE

# Step 3: Run `Main.java`
### 🌐 Git & GitHub Version Control

Git commands used:

bash

Copy

Edit

git status

git add .

git commit -m "Add admin features: delete, search, statement"

git push

✔️ Your branch is now up to date with all the latest code features.

📌 Future Enhancements

💾 File or DB-based persistent storage (e.g., MySQL, SQLite)

🔐 Password hashing (e.g., SHA-256, BCrypt)

🧪 Unit testing using JUnit

🖥️ GUI version using JavaFX/Swing

🧑‍💼 Admin dashboard with user/account control

📤 Export statement to PDF or CSV

👨‍💻 Author

Swayam Kataria

📧 workswm21@gmail.com

🌐 GitHub | LinkedIn

📜 License

This project is licensed under the MIT License.

🙌 Acknowledgements

Thanks to open-source communities and Java resources that empower students to build real-world projects.

⭐ Found it helpful? Star the repo and share it with others!