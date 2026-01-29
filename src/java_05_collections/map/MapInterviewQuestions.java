package java_05_collections.map;

// MapInterviewQuestions.java
// Java Map - Interview Questions & Tricks ✅
// Covers: HashMap, LinkedHashMap, TreeMap, Hashtable, ConcurrentHashMap

import java.util.*;

public class MapInterviewQuestions {

    // =========================================================
    // 1) Basic Map Questions
    // =========================================================
    /*
        Q1) What is Map in Java?
        - A collection of key-value pairs
        - Keys are unique, values can be duplicate

        Q2) Common implementations?
        - HashMap, LinkedHashMap, TreeMap, Hashtable, ConcurrentHashMap
    */

    // =========================================================
    // 2) Null Keys and Null Values
    // =========================================================
    /*
        Q3) Which Maps allow null key and null values?
        - HashMap: 1 null key, multiple null values
        - LinkedHashMap: 1 null key, multiple null values
        - TreeMap: null key NOT allowed, values allowed
        - Hashtable: null key/value NOT allowed
        - ConcurrentHashMap: null key/value NOT allowed
    */

    // =========================================================
    // 3) Order / Sorting
    // =========================================================
    /*
        Q4) Difference in order of elements?
        - HashMap: unordered
        - LinkedHashMap: insertion or access order
        - TreeMap: sorted by key (natural or custom comparator)
        - Hashtable: unordered
        - ConcurrentHashMap: unordered
    */

    // =========================================================
    // 4) Synchronization / Thread-safety
    // =========================================================
    /*
        Q5) Which maps are thread-safe?
        - Hashtable: synchronized
        - ConcurrentHashMap: concurrent operations supported
        - HashMap/LinkedHashMap/TreeMap: NOT synchronized
    */

    // =========================================================
    // 5) Performance / Time Complexity
    // =========================================================
    /*
        Q6) Time complexity of get(), put(), remove()?
        - HashMap, LinkedHashMap, Hashtable, ConcurrentHashMap: O(1) average
        - TreeMap: O(log n)
    */

    // =========================================================
    // 6) Iteration Methods
    // =========================================================
    /*
        Q7) Ways to iterate over Map?
        - Using keySet()
        - Using values()
        - Using entrySet()
        - Using Iterator over entrySet()
        - Using forEach (Java 8)
    */

    // =========================================================
    // 7) Tricky / Common Interview Questions
    // =========================================================
    /*
        Q8) Difference between HashMap and Hashtable?
        - HashMap: non-synchronized, allows null, modern
        - Hashtable: synchronized, no nulls, legacy

        Q9) Difference between HashMap and LinkedHashMap?
        - HashMap: unordered
        - LinkedHashMap: maintains insertion/access order

        Q10) Difference between HashMap and TreeMap?
        - HashMap: unordered
        - TreeMap: sorted by key

        Q11) Can we use custom object as key?
        - Yes, override equals() and hashCode() for HashMap/LinkedHashMap
        - For TreeMap, key must implement Comparable or provide Comparator

        Q12) Difference between ConcurrentHashMap and Hashtable?
        - Both are thread-safe
        - ConcurrentHashMap uses segment locking, better performance
        - Hashtable synchronizes all methods (slower)

        Q13) Default capacity and load factor of HashMap?
        - Default capacity: 16
        - Load factor: 0.75

        Q14) How does HashMap handle collisions?
        - Using linked list (<=8 nodes) or tree (>8 nodes) in bucket

        Q15) How to implement LRU cache using LinkedHashMap?
        - Use constructor with accessOrder = true
        - Override removeEldestEntry()
    */

    // =========================================================
    // 8) Quick Code Snippets (for Interview)
    // =========================================================
    static void quickCodeSnippets() {
        System.out.println("----- Map Code Snippets -----");

        // HashMap null key/value
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put(null, "NullKey");
        hashMap.put("Java", null);
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap insertion order
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(2, "Python");
        linkedMap.put(1, "Java");
        linkedMap.put(3, "C++");
        System.out.println("LinkedHashMap (insertion order): " + linkedMap);

        // TreeMap natural order
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C++");
        treeMap.put(1, "Java");
        treeMap.put(2, "Python");
        System.out.println("TreeMap (sorted keys): " + treeMap);

        // Hashtable (no nulls)
        Map<Integer, String> table = new Hashtable<>();
        table.put(1, "Java");
        table.put(2, "Python");
        System.out.println("Hashtable: " + table);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Map Interview Questions ==========\n");

        quickCodeSnippets();
        System.out.println();

        System.out.println("Refer comments in code for detailed Q&A and interview tips.");
    }
}

/*
===============================
MAP INTERVIEW CHEAT SHEET
===============================

1) HashMap: unordered, null key/value allowed
2) LinkedHashMap: insertion/access order, null key/value allowed
3) TreeMap: sorted keys, null key NOT allowed
4) Hashtable: synchronized, no null key/value
5) ConcurrentHashMap: thread-safe, no null key/value, better than Hashtable
6) Use entrySet() iteration for efficiency
7) Override equals() & hashCode() for custom key objects
8) LRU cache: LinkedHashMap with accessOrder = true + removeEldestEntry()
9) HashMap default capacity/load factor: 16, 0.75
10) Collision handling: linked list or tree
*/

