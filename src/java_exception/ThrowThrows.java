package java_exception;

// ThrowThrows.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: throw vs throws, checked vs unchecked,
// custom exception, rethrowing, wrapping exceptions,
// overriding rules, best practices + tricky outputs.

import java.io.FileReader;
import java.io.IOException;

public class ThrowThrows {

    // =========================================================
    // 1) throw vs throws (Super Important)
    // =========================================================
    /*
        throw  -> used INSIDE a method to manually throw an exception object
        throws -> used in METHOD SIGNATURE to declare possible exception

        Example:
        throw new IllegalArgumentException("Invalid input");  // throw
        void readFile() throws IOException { }                // throws
    */

    // =========================================================
    // 2) throw example (Unchecked exception)
    // =========================================================
    static void validateAge(int age) {
        if (age < 18) {
            // Unchecked exception (RuntimeException)
            throw new IllegalArgumentException("Age must be 18+ ❌");
        }
        System.out.println("Age is valid ✅");
    }

    // =========================================================
    // 3) throws example (Checked exception)
    // =========================================================
    /*
        IOException is CHECKED exception.
        It must be handled OR declared using throws.
    */
    static void readFile() throws IOException {
        FileReader fr = new FileReader("data.txt"); // may throw FileNotFoundException (checked)
        fr.close();
        System.out.println("File read successfully ✅");
    }

    // =========================================================
    // 4) Custom Checked Exception
    // =========================================================
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    static void withdraw(int balance, int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            // throwing checked custom exception
            throw new InsufficientBalanceException("Insufficient balance ❌");
        }
        System.out.println("Withdraw success ✅");
    }

    // =========================================================
    // 5) Custom Unchecked Exception
    // =========================================================
    static class InvalidPinException extends RuntimeException {
        public InvalidPinException(String message) {
            super(message);
        }
    }

    static void validatePin(int pin) {
        if (pin != 1234) {
            // runtime exception doesn't need throws
            throw new InvalidPinException("Invalid PIN ❌");
        }
        System.out.println("PIN correct ✅");
    }

    // =========================================================
    // 6) Rethrowing exception
    // =========================================================
    static void rethrowExample() {
        System.out.println("----- Rethrow Example -----");
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught in method: " + e.getMessage());
            throw e; // rethrow same exception
        }
    }

    // =========================================================
    // 7) Wrapping exception (Best practice for real projects)
    // =========================================================
    /*
        Sometimes we catch checked exception and convert into runtime exception
        to avoid forcing caller to handle checked exception.

        This is common in Spring Boot apps.
    */
    static void wrappingExample() {
        System.out.println("----- Wrapping Example -----");
        try {
            readFile();
        } catch (IOException e) {
            throw new RuntimeException("File operation failed ❌", e);
        }
    }

    // =========================================================
    // 8) Overriding rules with throws (Interview Favourite)
    // =========================================================
    /*
        Rule:
        - If parent method does NOT throw exception,
          child cannot throw NEW/BROADER checked exception.

        - Child can throw:
          ✅ same checked exception
          ✅ narrower checked exception
          ✅ unchecked exception (always allowed)
    */

    static class Parent {
        void show() throws IOException {
            System.out.println("Parent show()");
        }
    }

    static class Child extends Parent {
        @Override
        void show() throws IOException {
            System.out.println("Child show()");
        }

        // This is allowed:
        // void show() throws FileNotFoundException { }  // narrower exception

        // Not allowed:
        // void show() throws Exception { } // broader checked exception ❌
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {

        System.out.println("========== throw vs throws ==========\n");

        // throw example
        System.out.println("----- throw (Unchecked) -----");
        try {
            validateAge(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();

        // throws example
        System.out.println("----- throws (Checked) -----");
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
        System.out.println();

        // custom checked exception
        System.out.println("----- Custom Checked Exception -----");
        try {
            withdraw(1000, 5000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
        System.out.println();

        // custom unchecked exception
        System.out.println("----- Custom Unchecked Exception -----");
        try {
            validatePin(9999);
        } catch (InvalidPinException e) {
            System.out.println("Caught Runtime Exception: " + e.getMessage());
        }
        System.out.println();

        // rethrow example
        System.out.println("----- Rethrow Demo -----");
        try {
            rethrowExample();
        } catch (ArithmeticException e) {
            System.out.println("Caught again in main: " + e.getMessage());
        }
        System.out.println();

        // wrapping example (will throw RuntimeException)
        System.out.println("----- Wrapping Demo -----");
        try {
            wrappingExample();
        } catch (RuntimeException e) {
            System.out.println("Caught Wrapped Exception: " + e.getMessage());
            System.out.println("Original cause: " + e.getCause());
        }

        System.out.println("\nProgram End ✅");
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) throw vs throws?
- throw  -> used to throw exception manually inside method
- throws -> used to declare exception in method signature

2) Can we throw checked exception using throw?
- YES, but method must handle it OR declare using throws.

3) Is throws mandatory for RuntimeException?
- NO (unchecked exception)

4) What is checked exception?
- compile-time (IOException, SQLException)

5) What is unchecked exception?
- runtime (NullPointerException, ArithmeticException)

6) Can we throw multiple exceptions in throws?
- YES: method() throws IOException, SQLException

7) Overriding rule with throws?
- Child cannot throw broader checked exception than parent method.

8) What is exception wrapping?
- converting checked exception into RuntimeException with cause.

9) What is rethrowing?
- catching exception and throwing it again.

10) Best practice?
- Use custom exceptions + meaningful messages + wrap when needed.
*/

