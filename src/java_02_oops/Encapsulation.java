package java_02_oops;

class BankAccount {

    // 1) private data members (data hiding)
    private String accountHolderName;
    private double balance;

    // 2) Constructor (optional but useful)
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;

        // validation
        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    // 3) Getter (read-only access)
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // 4) Setter (controlled write access)
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.isBlank()) {
            this.accountHolderName = accountHolderName;
        } else {
            System.out.println("Invalid name! Not updating.");
        }
    }

    // 5) Business methods (recommended)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount!");
        }
    }
}

public class Encapsulation {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Dilip", 1000);

        // Reading values using getters
        System.out.println("Account Holder: " + acc.getAccountHolderName());
        System.out.println("Balance: " + acc.getBalance());

        System.out.println("-------------------");

        // Updating values using setter
        acc.setAccountHolderName("Dilip Kumar");
        System.out.println("Updated Name: " + acc.getAccountHolderName());

        System.out.println("-------------------");

        // Deposit and withdraw
        acc.deposit(500);
        System.out.println("Balance: " + acc.getBalance());

        acc.withdraw(300);
        System.out.println("Balance: " + acc.getBalance());

        System.out.println("-------------------");

        // Invalid cases
        acc.deposit(-100);
        acc.withdraw(50000);
        acc.setAccountHolderName("");
    }
    /*
        “Encapsulation is wrapping data and methods together, hiding data using private variables and giving controlled access through getters/setters.”

        🔹 What is Encapsulation?
            Encapsulation = Data Hiding + Controlled Access

            👉 Means:
            Keep variables private
            Access them using public getter/setter methods

            📌 Simple words:
            “Don’t allow direct access to data. Give access only through methods.”

            ✅ Why Encapsulation?
            ✅ Benefits
            Data Security (no direct access)
            Validation possible (example: age cannot be negative)
            Control over modification
            Maintainable code
            Industry standard practice
     */
}

