package java_generics;

// GenericMethod.java
// Java Generic Methods - Deep Dive ✅
// Covers: generic method declaration, type inference, multiple type parameters, and interview tips

import java.util.Arrays;
import java.util.List;

public class GenericMethod {

    // =========================================================
    // 1) Generic Method Example
    // =========================================================
    public static <T> void printArray(T[] array) { // T is type parameter for method
        System.out.println("Printing array elements:");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 2) Generic Method with Multiple Type Parameters
    // =========================================================
    public static <K, V> void printPair(K key, V value) {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    // =========================================================
    // 3) Generic Method with Bounded Type Parameter
    // =========================================================
    public static <T extends Number> double sumArray(T[] array) {
        double sum = 0;
        for (T num : array) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // =========================================================
    // 4) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Generic methods allow type-safety at method level
        ✅ Can be static or instance methods
        ✅ Type parameter <T> comes before return type
        ✅ Multiple type parameters allowed: <K, V>
        ✅ Bounded types restrict types (e.g., <T extends Number>)
        ✅ Type inference allows calling method without explicitly specifying type
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Generic Method Demo ==========\n");

        // =========================================================
        // Example 1: Print Array
        // =========================================================
        Integer[] intArray = {1, 2, 3, 4};
        String[] strArray = {"A", "B", "C"};

        printArray(intArray);
        printArray(strArray);

        // =========================================================
        // Example 2: Print Pair
        // =========================================================
        printPair("Age", 25);
        printPair(1, "One");

        // =========================================================
        // Example 3: Sum Array with bounded type
        // =========================================================
        Double[] doubleArray = {1.5, 2.5, 3.0};
        int[] ignoredArray = {}; // Primitive arrays not allowed for generics
        System.out.println("Sum of doubleArray: " + sumArray(doubleArray));
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) How to declare a generic method?
- <T> void methodName(T param) { ... }

2) Difference between generic class and generic method?
- Generic class: type parameter in class
- Generic method: type parameter specific to method

3) Can a static method be generic?
- Yes, generic method can be static

4) Can generic method have multiple type parameters?
- Yes, e.g., <K, V> void printPair(K key, V value)

5) What is bounded type parameter in method?
- Restrict type to a subclass or interface, e.g., <T extends Number>
*/

