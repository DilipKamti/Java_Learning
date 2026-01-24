package java_collections.stream_with_collections;

// StreamMapFilterReduce.java
// Java Streams: map, filter, reduce - Deep Dive ✅
// Covers: functional transformations, filtering, aggregation, and interview tips

import java.util.Arrays;
import java.util.List;

public class StreamMapFilterReduce {

    // =========================================================
    // 1) Map Operation - Transform elements
    // =========================================================
    static void mapDemo() {
        System.out.println("----- Map Demo -----");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Convert all names to uppercase
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // =========================================================
    // 2) Filter Operation - Select elements based on condition
    // =========================================================
    static void filterDemo() {
        System.out.println("----- Filter Demo -----");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Keep only even numbers
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    // =========================================================
    // 3) Map + Filter combined
    // =========================================================
    static void mapFilterDemo() {
        System.out.println("----- Map + Filter Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");

        // Length of words starting with J
        words.stream()
                .filter(w -> w.startsWith("J"))
                .map(String::length)
                .forEach(System.out::println);
    }

    // =========================================================
    // 4) Reduce Operation - Aggregate elements
    // =========================================================
    static void reduceDemo() {
        System.out.println("----- Reduce Demo -----");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum of all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // Product of all numbers
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
    }

    // =========================================================
    // 5) Optional Reduce Example
    // =========================================================
    static void optionalReduceDemo() {
        System.out.println("----- Optional Reduce Demo -----");

        List<Integer> emptyList = Arrays.asList();

        // Reduce returns Optional if no identity provided
        emptyList.stream()
                .reduce(Integer::sum)
                .ifPresentOrElse(
                        v -> System.out.println("Sum: " + v),
                        () -> System.out.println("No elements to reduce")
                );
    }

    // =========================================================
    // 6) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ map(): transforms elements
        ✅ filter(): selects elements
        ✅ reduce(): aggregates elements
        ✅ Can chain map, filter, reduce for powerful data processing
        ✅ Avoid side effects in streams
        ✅ Terminal operation (forEach, reduce) triggers evaluation
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Stream Map, Filter, Reduce Demo ==========\n");

        mapDemo();
        System.out.println();

        filterDemo();
        System.out.println();

        mapFilterDemo();
        System.out.println();

        reduceDemo();
        System.out.println();

        optionalReduceDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between map() and filter()?
- map(): transforms each element
- filter(): selects elements matching a condition

2) What is reduce() used for?
- Aggregating elements into a single value (sum, product, concatenation)

3) Can reduce() return Optional?
- Yes, if no identity value provided

4) Difference between map() and flatMap()?
- map(): transforms elements one-to-one
- flatMap(): flattens nested streams

5) Can stream operations be chained?
- Yes, map(), filter(), sorted(), reduce(), collect(), etc.
*/

