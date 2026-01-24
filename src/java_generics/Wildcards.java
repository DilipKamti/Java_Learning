package java_generics;

// Wildcards.java
// Java Generics Wildcards - Deep Dive ✅
// Covers: ?, ? extends, ? super, use cases, and interview tips

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {

    // =========================================================
    // 1) Unbounded Wildcard (?)
    // =========================================================
    static void unboundedWildcardDemo(List<?> list) {
        System.out.println("----- Unbounded Wildcard Demo -----");
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
        // Cannot add any element except null
        // list.add("Test"); // Compile-time error
    }

    // =========================================================
    // 2) Upper Bounded Wildcard (? extends T)
    // =========================================================
    static void upperBoundedDemo(List<? extends Number> list) {
        System.out.println("----- Upper Bounded Wildcard Demo -----");
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Cannot add any element except null
        // list.add(10); // Compile-time error
    }

    // =========================================================
    // 3) Lower Bounded Wildcard (? super T)
    // =========================================================
    static void lowerBoundedDemo(List<? super Integer> list) {
        System.out.println("----- Lower Bounded Wildcard Demo -----");
        // Can add Integer or subclass
        list.add(10);
        list.add(20);

        // Cannot safely read elements as Integer, only Object
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 4) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Unbounded wildcard <?> : unknown type, read-only
        ✅ Upper bounded <? extends T> : accepts T or subclass, read-only, cannot add
        ✅ Lower bounded <? super T> : accepts T or superclass, write-allowed, reading as Object
        ✅ PECS Rule: "Producer Extends, Consumer Super"
           - Producer (read) -> use extends
           - Consumer (write) -> use super
        ✅ Useful in generic methods, APIs, collections
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Wildcards Demo ==========\n");

        // Unbounded
        List<String> strList = Arrays.asList("A", "B", "C");
        unboundedWildcardDemo(strList);
        System.out.println();

        // Upper Bounded
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        upperBoundedDemo(doubleList);
        System.out.println();

        // Lower Bounded
        List<Number> numList = new ArrayList<>();
        lowerBoundedDemo(numList);
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between ? extends and ? super?
- ? extends T: upper bounded, can read as T, cannot add elements
- ? super T: lower bounded, can write elements, read as Object

2) What is unbounded wildcard?
- ? : unknown type, read-only, cannot add elements

3) Explain PECS rule
- Producer Extends, Consumer Super
- Use extends for reading, super for writing

4) Can you add elements to List<? extends Number>?
- No, except null

5) Can you read elements from List<? super Integer> as Integer?
- No, only as Object
*/

