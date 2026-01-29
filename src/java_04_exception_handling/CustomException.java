package java_04_exception_handling;

// CustomException.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: Custom checked & unchecked exceptions,
// best practices, chaining, overriding messages,
// real-world examples + interview questions.

public class CustomException {

    // =========================================================
    // 1) What is Custom Exception?
    // =========================================================
    /*
        Custom Exception = User-defined exception class.

        Why we need it?
        ✅ To represent business problems clearly
           Example:
           - InvalidAgeException
           - InsufficientBalanceException
           - UserNotFoundException

        Instead of throwing generic exceptions like:
        - Exception
        - RuntimeException
        - IllegalArgumentException
    */

    // =========================================================
    // 2) Custom CHECKED Exception
    // =========================================================
    /*
        Checked exception:
        - Must be handled using try-catch OR declared using throws
        - Extends Exception
    */
    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    // =========================================================
    // 3) Custom UNCHECKED Exception
    // =========================================================
    /*
        Unchecked exception:
        - No need to handle or declare
        - Extends RuntimeException
    */
    static class InvalidPinException extends RuntimeException {
        public InvalidPinException(String message) {
            super(message);
        }
    }

    // =========================================================
    // 4) Business Logic Example (Checked Exception)
    // =========================================================
    static void withdraw(int balance, int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Withdraw Failed ❌ | Balance: " + balance + ", Amount: " + amount
            );
        }
        System.out.println("Withdraw Successful ✅ | Remaining Balance: " + (balance - amount));
    }

    // =========================================================
    // 5) Business Logic Example (Unchecked Exception)
    // =========================================================
    static void validatePin(int pin) {
        if (pin != 1234) {
            throw new InvalidPinException("Invalid PIN ❌ | PIN should be 1234");
        }
        System.out.println("PIN Verified ✅");
    }

    // =========================================================
    // 6) Exception Chaining (Cause) - Real Project Use
    // =========================================================
    /*
        Exception chaining means:
        storing the original exception inside new exception using "cause".

        This is useful for debugging.
    */
    static class DatabaseException extends RuntimeException {
        public DatabaseException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static void databaseCall() {
        try {
            // simulate failure
            int x = 10 / 0; // ArithmeticException
            System.out.println(x);
        } catch (Exception e) {
            throw new DatabaseException("Database operation failed ❌", e);
        }
    }

    // =========================================================
    // 7) Best Practices for Custom Exceptions
    // =========================================================
    /*
        ✅ Name should end with "Exception"
        ✅ Provide meaningful message
        ✅ Create checked for recoverable problems
        ✅ Create unchecked for programming mistakes / invalid input
        ✅ Always store cause in real apps
        ✅ Avoid using Exception directly in projects
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {

        System.out.println("========== Custom Exceptions ==========\n");

        // Checked Exception Demo
        System.out.println("----- Checked Exception Demo -----");
        try {
            withdraw(1000, 5000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();

        // Unchecked Exception Demo
        System.out.println("----- Unchecked Exception Demo -----");
        try {
            validatePin(9999);
        } catch (InvalidPinException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();

        // Exception Chaining Demo
        System.out.println("----- Exception Chaining Demo -----");
        try {
            databaseCall();
        } catch (DatabaseException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.println("Original Cause: " + e.getCause());
        }

        System.out.println("\nProgram End ✅");
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is custom exception?
- User-defined exception class for business logic errors.

2) Checked vs Unchecked custom exception?
- Checked extends Exception (must handle/declare)
- Unchecked extends RuntimeException (no need to handle/declare)

3) When to use checked exception?
- When caller can recover (ex: insufficient balance, file missing)

4) When to use unchecked exception?
- Programming mistakes / invalid input (NPE, invalid pin)

5) Why exception chaining?
- To preserve original exception cause for debugging.

6) Best practice for naming custom exception?
- End with "Exception" (UserNotFoundException)

7) Can we create custom exception without message?
- Yes, but message is recommended.

8) Why not throw generic Exception?
- Not clear, hard to debug, bad design.
*/

