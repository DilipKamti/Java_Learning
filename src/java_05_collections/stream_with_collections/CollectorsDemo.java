package java_05_collections.stream_with_collections;

// CollectorsDemo.java
// Java Stream Collectors - Deep Dive ✅
// Covers: collecting stream results using Collectors.toList(), toSet(), joining(), groupingBy(), counting(), and more

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsDemo {

    // =========================================================
    // 1) Collecting into List
    // =========================================================
    static void collectToListDemo() {
        System.out.println("----- Collect to List Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");

        List<String> list = words.stream()
                .filter(w -> w.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println("Words starting with J: " + list);
    }

    // =========================================================
    // 2) Collecting into Set
    // =========================================================
    static void collectToSetDemo() {
        System.out.println("----- Collect to Set Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "Java", "C++", "Python");

        Set<String> set = words.stream()
                .collect(Collectors.toSet());

        System.out.println("Unique words: " + set);
    }

    // =========================================================
    // 3) Joining Strings
    // =========================================================
    static void joiningDemo() {
        System.out.println("----- Joining Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "C++");

        String joined = words.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Joined String: " + joined);
    }

    // =========================================================
    // 4) Counting Elements
    // =========================================================
    static void countingDemo() {
        System.out.println("----- Counting Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "C++", "Java");

        long count = words.stream()
                .filter(w -> w.startsWith("J"))
                .collect(Collectors.counting());

        System.out.println("Count of words starting with J: " + count);
    }

    // =========================================================
    // 5) Grouping By
    // =========================================================
    static void groupingByDemo() {
        System.out.println("----- Grouping By Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");

        Map<Integer, List<String>> groupByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Words grouped by length: " + groupByLength);
    }

    // =========================================================
    // 6) Partitioning By
    // =========================================================
    static void partitioningByDemo() {
        System.out.println("----- Partitioning By Demo -----");

        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");

        Map<Boolean, List<String>> partitioned = words.stream()
                .collect(Collectors.partitioningBy(w -> w.length() > 3));

        System.out.println("Partitioned (length>3): " + partitioned);
    }

    // =========================================================
    // 7) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Collectors.toList(): collects elements into List
        ✅ Collectors.toSet(): collects unique elements into Set
        ✅ Collectors.joining(): concatenates strings with optional delimiter
        ✅ Collectors.counting(): counts elements
        ✅ Collectors.groupingBy(): groups elements based on classifier function
        ✅ Collectors.partitioningBy(): splits elements into true/false groups
        ✅ Collectors can be chained with downstream collectors
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Stream Collectors Demo ==========\n");

        collectToListDemo();
        System.out.println();

        collectToSetDemo();
        System.out.println();

        joiningDemo();
        System.out.println();

        countingDemo();
        System.out.println();

        groupingByDemo();
        System.out.println();

        partitioningByDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between toList() and toSet()?
- toList(): preserves order, allows duplicates
- toSet(): unique elements, order not guaranteed

2) Difference between groupingBy() and partitioningBy()?
- groupingBy(): groups elements by classifier function
- partitioningBy(): splits elements into true/false map

3) Can Collectors be used with custom objects?
- Yes, using method references for properties

4) How to join strings with a delimiter?
- Collectors.joining(", ")

5) How to count elements using streams?
- Collectors.counting() or stream.count()
*/

