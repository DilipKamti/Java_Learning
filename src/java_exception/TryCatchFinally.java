package java_exception;

// TryCatchFinally.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: try-catch-finally flow, multiple catch, nested try,
// return + finally behavior, exception hierarchy, best practices,
// try-with-resources, throw vs throws, custom exception demo.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinally {

    // =========================================================
    // 1) What is Exception Handling?
    // =========================================================
    /*
        Exception Handling = Handling runtime errors so program doesn't crash.

        Keywords:
        try      -> code that may throw exception
        catch    -> handles exception
        finally  -> always runs (cleanup)
        throw    -> manually throw exception
        throws   -> declare exception in method signature

        Goal:
        - normal flow should continue
        - proper error message + cleanup
    */

    // =========================================================
    // 2) Basic try-catch
    // =========================================================
    static void basicTryCatch() {
        System.out.println("----- Basic try-catch -----");

        try {
            int a = 10;
            int b = 0;
            int result = a / b; // ArithmeticException
            System.out.println("Result: " + result); // won't execute
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        System.out.println("Program continues after catch ✅");
    }

    // =========================================================
    // 3) Multiple catch blocks
    // =========================================================
    static void multipleCatch() {
        System.out.println("----- Multiple catch -----");

        try {
            String s = null;
            System.out.println(s.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: " + e);
        } catch (Exception e) {
            // Always keep Exception at last
            System.out.println("Caught generic Exception: " + e);
        }
    }

    // =========================================================
    // 4) Multi-catch (Java 7+)
    // =========================================================
    static void multiCatchJava7() {
        System.out.println("----- Multi-catch (Java 7+) -----");

        try {
            String s = "123a";
            int num = Integer.parseInt(s); // NumberFormatException
            System.out.println(num);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Caught Exception using multi-catch: " + e);
        }
    }

    // =========================================================
    // 5) finally block (cleanup)
    // =========================================================
    static void finallyDemo() {
        System.out.println("----- finally demo -----");

        try {
            System.out.println("Inside try");
            int x = 10 / 2;
            System.out.println("Result: " + x);
        } catch (Exception e) {
            System.out.println("Inside catch");
        } finally {
            System.out.println("Inside finally (always runs) ✅");
        }
    }

    // =========================================================
    // 6) finally with exception
    // =========================================================
    static void finallyWithException() {
        System.out.println("----- finally with exception -----");

        try {
            System.out.println("Inside try");
            int x = 10 / 0; // exception
            System.out.println("Result: " + x);
        } catch (ArithmeticException e) {
            System.out.println("Inside catch: " + e.getMessage());
        } finally {
            System.out.println("finally runs even after exception ✅");
        }
    }

    // =========================================================
    // 7) return in try and finally behavior (Very Tricky Interview)
    // =========================================================
    static int returnTryFinally() {
        try {
            System.out.println("Inside try: returning 10");
            return 10;
        } finally {
            System.out.println("Inside finally: runs before method returns ✅");
        }
    }

    // =========================================================
    // 8) return in try and return in finally (Dangerous)
    // =========================================================
    /*
        If finally has return, it overrides try return.
        This is considered BAD practice.
    */
    static int returnOverrideFinally() {
        try {
            System.out.println("Try return 10");
            return 10;
        } finally {
            System.out.println("Finally return 50 (overrides try return) ❌");
            return 50;
        }
    }

    // =========================================================
    // 9) Nested try-catch
    // =========================================================
    static void nestedTryCatch() {
        System.out.println("----- Nested try-catch -----");

        try {
            System.out.println("Outer try start");

            try {
                int[] arr = {10, 20};
                System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch handled: " + e);
            }

            System.out.println("Outer try end");
        } catch (Exception e) {
            System.out.println("Outer catch: " + e);
        }
    }

    // =========================================================
    // 10) Exception hierarchy (Important)
    // =========================================================
    /*
        Throwable
           |
           |-- Error (OutOfMemoryError, StackOverflowError) -> don't handle usually
           |
           |-- Exception
                 |
                 |-- Checked Exception (compile-time)
                 |     ex: IOException, SQLException
                 |
                 |-- RuntimeException (unchecked)
                       ex: NullPointerException, ArithmeticException
    */

    // =========================================================
    // 11) try-with-resources (Java 7+) - Best Practice
    // =========================================================
    /*
        Automatically closes resources like:
        - FileReader
        - BufferedReader
        - Scanner
        - Connection
        - Streams

        Resource must implement AutoCloseable.
    */
    static void tryWithResourcesDemo() {
        System.out.println("----- Try-With-Resources Demo -----");

        // This is demo only, file may not exist in your system
        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("IOException handled: " + e.getMessage());
        }
    }

    // =========================================================
    // 12) throw vs throws
    // =========================================================
    /*
        throw  -> used to manually throw exception inside method
        throws -> used to declare exception in method signature
    */

    static void throwExample(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18+ ❌");
        }
        System.out.println("Eligible ✅");
    }

    static void throwsExample() throws IOException {
        // Checked exception must be handled or declared
        FileReader fr = new FileReader("file.txt");
        fr.close();
    }

    // =========================================================
    // 13) Custom Exception
    // =========================================================
    static class InvalidBalanceException extends Exception {
        public InvalidBalanceException(String message) {
            super(message);
        }
    }

    static void withdraw(int balance, int amount) throws InvalidBalanceException {
        if (amount > balance) {
            throw new InvalidBalanceException("Insufficient balance ❌");
        }
        System.out.println("Withdraw success ✅");
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {

        System.out.println("========== Try Catch Finally ==========\n");

        basicTryCatch();
        System.out.println();

        multipleCatch();
        System.out.println();

        multiCatchJava7();
        System.out.println();

        finallyDemo();
        System.out.println();

        finallyWithException();
        System.out.println();

        System.out.println("----- Return Try Finally -----");
        int val1 = returnTryFinally();
        System.out.println("Returned value: " + val1);
        System.out.println();

        System.out.println("----- Return Override Finally -----");
        int val2 = returnOverrideFinally();
        System.out.println("Returned value: " + val2);
        System.out.println();

        nestedTryCatch();
        System.out.println();

        // throw example
        System.out.println("----- throw Example -----");
        try {
            throwExample(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        System.out.println();

        // throws + custom exception
        System.out.println("----- Custom Exception Example -----");
        try {
            withdraw(1000, 5000);
        } catch (InvalidBalanceException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }

        System.out.println("\nProgram End ✅");
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is difference between final, finally, finalize?
- final -> keyword (constant, prevent inheritance/override)
- finally -> block that always executes
- finalize -> method called by GC (deprecated in modern Java)

2) Can finally execute without catch?
- YES (try + finally)

3) When finally will NOT execute?
- System.exit(0)
- JVM crash / power failure

4) Can we have multiple catch blocks?
- YES, but keep specific first and generic last.

5) What happens if return is in try and finally exists?
- finally executes before returning.

6) What if finally has return?
- It overrides try return (BAD practice)

7) throw vs throws?
- throw -> manually throw exception
- throws -> declare exception

8) Checked vs Unchecked exceptions?
- Checked -> compile time (IOException)
- Unchecked -> runtime (NPE)

9) Best practice to close resources?
- try-with-resources

10) Can we catch Error?
- possible but not recommended (OutOfMemoryError etc.)
*/

