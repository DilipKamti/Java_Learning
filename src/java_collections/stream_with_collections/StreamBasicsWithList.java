package java_collections.stream_with_collections;

// StreamBasicsWithList.java
// Java Streams with List - Deep Dive ✅
// Covers: basic stream operations, filter, map, sorted, collect, and interview tips

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasicsWithList {

    // =========================================================
    // 1) Creating Streams from List
    // =========================================================
    static void createStreamDemo() {
        System.out.println("----- Create Stream Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");

        // Stream using stream() method
        list.stream().forEach(System.out::println);

        // Parallel Stream
        System.out.println("Using parallel stream:");
        list.parallelStream().forEach(System.out::println);
    }

    // =========================================================
    // 2) Filter and Map Operations
    // =========================================================
    static void filterMapDemo() {
        System.out.println("----- Filter & Map Demo -----");

        List<String> list = List.of("Java", "Python", "C++", "JavaScript");

        // Filter strings starting with "J"
        List<String> filtered = list.stream()
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println("Filtered (starts with J): " + filtered);

        // Map to uppercase
        List<String> upper = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase List: " + upper);
    }

    // =========================================================
    // 3) Sorting & Distinct
    // =========================================================
    static void sortDistinctDemo() {
        System.out.println("----- Sort & Distinct Demo -----");

        List<String> list = List.of("Java", "Python", "Java", "C++", "Python");

        // Distinct elements
        List<String> distinctList = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Elements: " + distinctList);

        // Sorted elements
        List<String> sortedList = distinctList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Elements: " + sortedList);
    }

    // =========================================================
    // 4) Counting & Matching
    // =========================================================
    static void countMatchDemo() {
        System.out.println("----- Count & Match Demo -----");

        List<String> list = List.of("Java", "Python", "C++", "JavaScript");

        long countJ = list.stream().filter(s -> s.startsWith("J")).count();
        System.out.println("Count of strings starting with J: " + countJ);

        boolean anyJava = list.stream().anyMatch(s -> s.equals("Java"));
        System.out.println("Any Java present? " + anyJava);

        boolean allStartWithJ = list.stream().allMatch(s -> s.startsWith("J"));
        System.out.println("All start with J? " + allStartWithJ);
    }

    // =========================================================
    // 5) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Stream operations are lazy; terminal operation triggers processing
        ✅ Use filter, map, distinct, sorted, limit, skip, forEach, collect
        ✅ Use method references (::) for cleaner code
        ✅ Avoid modifying source collection inside streams
        ✅ Use parallelStream() for parallel processing
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Stream Basics with List Demo ==========\n");

        createStreamDemo();
        System.out.println();

        filterMapDemo();
        System.out.println();

        sortDistinctDemo();
        System.out.println();

        countMatchDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Stream and Collection?
- Stream: sequence of elements with functional operations, lazy
- Collection: stores elements, eager

2) Difference between intermediate and terminal operations?
- Intermediate: filter, map, distinct, sorted (lazy)
- Terminal: forEach, collect, count, reduce (triggers processing)

3) Can streams be reused?
- No, streams are single-use

4) Difference between stream() and parallelStream()?
- stream(): sequential processing
- parallelStream(): parallel processing using multiple threads

5) How to convert Stream back to List?
- Use collect(Collectors.toList())
*/

