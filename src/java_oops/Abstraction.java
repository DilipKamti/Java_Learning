package java_oops;

// Abstraction.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: Abstraction, Abstract class, Interface, methods/variables supported, tips & tricky questions

public class Abstraction {

    // =========================================================
    // 1) WHAT IS ABSTRACTION?
    // =========================================================
    /*
        Abstraction = "Hiding implementation details and showing only necessary things"

        Simple words:
        - You show WHAT to do, not HOW to do.
        - User only knows the feature, not the internal code.

        Real-life example:
        - You press "Start" button on car
        - You don't care about engine internal working

        Java provides Abstraction mainly using:
        1) Abstract Class
        2) Interface
    */

    // =========================================================
    // 2) ABSTRACT CLASS (MOST COMMON ABSTRACTION)
    // =========================================================
    /*
        Abstract class:
        - Can have abstract methods (no body)
        - Can have concrete methods (with body)
        - Cannot create object directly
        - Supports partial abstraction (some methods abstract, some concrete)

        Syntax:
        abstract class A { abstract void m1(); }
    */

    // Example: Abstract class for Bank Account
    static abstract class BankAccount {

        // ==========================
        // VARIABLES in Abstract Class
        // ==========================
        /*
            Abstract class supports:
            ✅ instance variables
            ✅ static variables
            ✅ final variables
            ❌ cannot create object of abstract class directly
        */

        // instance variable (each object has its own copy)
        protected String accountHolderName;

        // final variable (constant)
        protected final String bankName = "SBI";

        // static variable (shared among all objects)
        protected static String IFSC_CODE = "SBIN0001234";

        // Constructor allowed in abstract class
        public BankAccount(String accountHolderName) {
            this.accountHolderName = accountHolderName;
        }

        // ==========================
        // METHODS in Abstract Class
        // ==========================
        /*
            Abstract class supports:
            ✅ abstract methods (no body)
            ✅ concrete methods (with body)
            ✅ static methods
            ✅ final methods
            ✅ constructor
            ❌ cannot be instantiated directly
        */

        // abstract method -> forces child classes to implement
        abstract void withdraw(double amount);

        // concrete method -> common logic for all child classes
        void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit amount must be > 0");
                return;
            }
            System.out.println(accountHolderName + " deposited: " + amount);
        }

        // final method -> child cannot override
        final void showBankDetails() {
            System.out.println("Bank: " + bankName + ", IFSC: " + IFSC_CODE);
        }

        // static method -> belongs to class not object
        static void bankRules() {
            System.out.println("Rule: Maintain minimum balance.");
        }
    }

    // Child class 1
    static class SavingsAccount extends BankAccount {

        private double balance;

        public SavingsAccount(String name, double balance) {
            super(name);
            this.balance = balance;
        }

        @Override
        void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdraw amount must be > 0");
                return;
            }
            if (amount > balance) {
                System.out.println("Insufficient balance in SavingsAccount");
                return;
            }
            balance -= amount;
            System.out.println(accountHolderName + " withdrew: " + amount + " | Balance: " + balance);
        }
    }

    // Child class 2
    static class CurrentAccount extends BankAccount {

        private double balance;
        private double overdraftLimit = 5000;

        public CurrentAccount(String name, double balance) {
            super(name);
            this.balance = balance;
        }

        @Override
        void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdraw amount must be > 0");
                return;
            }
            if (amount > balance + overdraftLimit) {
                System.out.println("Overdraft limit exceeded in CurrentAccount");
                return;
            }
            balance -= amount;
            System.out.println(accountHolderName + " withdrew: " + amount + " | Balance: " + balance);
        }
    }

    // =========================================================
    // 3) INTERFACE (FULL ABSTRACTION + MULTIPLE INHERITANCE)
    // =========================================================
    /*
        Interface:
        - Best for abstraction in real projects
        - Supports multiple inheritance
        - Used for "contract"

        Interface supports methods:
        ✅ abstract methods (implicitly public abstract)
        ✅ default methods (Java 8)
        ✅ static methods (Java 8)
        ✅ private methods (Java 9) -> helper methods inside interface

        Interface supports variables:
        ✅ public static final variables ONLY (constants)
        ❌ no instance variables allowed
    */

    interface Payment {

        // interface variable => always public static final
        int MAX_LIMIT = 100000; // constant

        // abstract method => always public abstract
        void pay(double amount);

        // default method => has body (Java 8 feature)
        default void receipt(double amount) {
            System.out.println("Receipt generated for amount: " + amount);
        }

        // static method => belongs to interface
        static void paymentInfo() {
            System.out.println("Payment methods supported: UPI, CARD, NETBANKING");
        }

        // private method => Java 9 (helper method used inside interface)
        private void validate(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be > 0");
            }
        }

        // default method can call private helper method
        default void safePay(double amount) {
            validate(amount);
            pay(amount);
        }
    }

    static class UpiPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using UPI");
        }
    }

    static class CardPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Card");
        }
    }

    // =========================================================
    // 4) IMPORTANT DIFFERENCE: ABSTRACT CLASS vs INTERFACE
    // =========================================================
    /*
        Abstract Class:
        - "IS-A" relationship
        - Can have state (instance variables)
        - Can have constructor
        - Single inheritance only

        Interface:
        - "CAN-DO" relationship
        - No instance state (only constants)
        - No constructor
        - Multiple inheritance allowed
    */

    // =========================================================
    // 5) TIPS & TRICKS (INTERVIEW FAVORITES)
    // =========================================================
    /*
        🔥 Trick 1: Can abstract class have constructor?
        ✅ YES, but you can't create object directly.
        Constructor is used when child object is created.

        🔥 Trick 2: Can abstract class have static methods?
        ✅ YES.

        🔥 Trick 3: Can abstract class have final methods?
        ✅ YES (final methods cannot be overridden).

        🔥 Trick 4: Can abstract class have main method?
        ✅ YES (you can run it, but still can't create object).

        🔥 Trick 5: Can interface have variables?
        ✅ YES but only public static final constants.

        🔥 Trick 6: Can interface have method body?
        ✅ YES using default/static/private methods (Java 8+).

        🔥 Trick 7: Why default methods introduced?
        - To add new methods in interface without breaking old classes.

        🔥 Trick 8: Can we create object of interface?
        ❌ Directly NO.
        ✅ But using anonymous class / lambda (functional interface).
    */

    // =========================================================
    // 6) INTERVIEW OUTPUT BASED QUESTIONS (VERY IMPORTANT)
    // =========================================================
    static abstract class Demo {
        abstract void test();

        void normal() {
            System.out.println("Normal method in abstract class");
        }

        static void staticDemo() {
            System.out.println("Static method in abstract class");
        }
    }

    static class DemoChild extends Demo {
        @Override
        void test() {
            System.out.println("Implemented abstract method test()");
        }
    }

    public static void main(String[] args) {

        System.out.println("========== Abstract Class Abstraction ==========");
        BankAccount.bankRules(); // static method call

        BankAccount acc1 = new SavingsAccount("Dilip", 10000); // upcasting
        acc1.deposit(2000);
        acc1.withdraw(5000);
        acc1.showBankDetails();

        BankAccount acc2 = new CurrentAccount("Rahul", 2000);
        acc2.withdraw(6000);
        acc2.showBankDetails();

        System.out.println("\n========== Interface Abstraction ==========");
        Payment.paymentInfo(); // static method call

        Payment p1 = new UpiPayment();
        p1.safePay(500);
        p1.receipt(500);
        System.out.println("MAX_LIMIT = " + Payment.MAX_LIMIT);

        Payment p2 = new CardPayment();
        p2.safePay(1200);

        System.out.println("\n========== Abstract class methods ==========");
        Demo d = new DemoChild();
        d.test();
        d.normal();
        Demo.staticDemo();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is Abstraction?
- Hiding implementation details and showing only essential features.

2) How to achieve abstraction in Java?
- Abstract class and Interface.

3) Abstract class vs Interface?
Abstract class:
- Can have instance variables + constructor + abstract + non-abstract methods
- Single inheritance

Interface:
- Only constants (public static final)
- Supports multiple inheritance
- abstract + default + static + private methods

4) Can abstract class have constructor?
- Yes

5) Can abstract class have static/final methods?
- Yes

6) Can interface have method body?
- Yes (default/static/private methods)

7) Can we create object of abstract class/interface?
- No direct object creation
- But child object can be created and stored in parent reference

8) Why default methods introduced in Java 8?
- To add new methods in interface without breaking old implementations.
*/

