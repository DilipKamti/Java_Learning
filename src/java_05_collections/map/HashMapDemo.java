package java_05_collections.map;

// HashMapDemo.java
// Java HashMap - Deep Dive ✅
// Covers: creation, basic operations, iteration, null keys/values, internal mechanics, interview tips

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    // =========================================================
    // 1) What is HashMap?
    // =========================================================
    /*
        - Implements Map<K,V> interface
        - Stores key-value pairs
        - Keys must be unique
        - Values can be duplicate
        - Allows one null key and multiple null values
        - Not synchronized
        - Backed by hash table (array of buckets + linked list or tree for collisions)
        - Average time complexity: O(1) for get(), put(), remove()
    */

    // =========================================================
    // 2) Creating HashMap
    // =========================================================
    static void createHashMapDemo() {
        System.out.println("----- HashMap Creation -----");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(4, "Go");
        map.put(2, "Kotlin"); // duplicate key replaced
        map.put(null, "NullKey"); // one null key allowed
        map.put(5, null);        // null value allowed

        System.out.println("HashMap: " + map);
        System.out.println("Size: " + map.size());
    }

    // =========================================================
    // 3) Accessing Values
    // =========================================================
    static void accessDemo() {
        System.out.println("----- Accessing Values -----");

        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        System.out.println("Value for key 'Python': " + map.get("Python"));
        System.out.println("Value for key 'Go' (absent): " + map.get("Go")); // returns null

        System.out.println("Contains key 'Java'? " + map.containsKey("Java"));
        System.out.println("Contains value 3? " + map.containsValue(3));
    }

    // =========================================================
    // 4) Iteration over HashMap
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iterating HashMap -----");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");

        // Iterate using keySet
        System.out.println("Using keySet():");
        for (Integer key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // Iterate using entrySet
        System.out.println("Using entrySet():");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // =========================================================
    // 5) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        Map<String, String> map = new HashMap<>();
        map.put("Java", "JVM");
        map.put("Python", "Interpreter");
        map.put("C++", "Compiler");

        map.remove("Python");
        System.out.println("After removing 'Python': " + map);

        // Conditional remove
        map.remove("C++", "JVM"); // does nothing, value mismatch
        System.out.println("After conditional remove (C++, JVM): " + map);
    }

    // =========================================================
    // 6) Internal Mechanics (Interview Favorite)
    // =========================================================
    /*
        - HashMap uses hashCode() of key to determine bucket
        - In case of collision: linked list (<=8 nodes), converted to Red-Black tree (>8 nodes)
        - Default capacity: 16, load factor: 0.75
        - Rehash occurs when size exceeds threshold (capacity * load factor)
        - Key equality determined using equals()
    */

    // =========================================================
    // 7) Tips & Tricks
    // =========================================================
    /*
        ✅ HashMap is unordered (no insertion order guarantee)
        ✅ Use LinkedHashMap if insertion order matters
        ✅ Use TreeMap if sorted order of keys needed
        ✅ Null key allowed once, multiple null values allowed
        ✅ Prefer Map interface in method signature
        ✅ Iterators are fail-fast
    */

    // =========================================================
    // 8) Tricky Example
    // =========================================================
    static void trickyExample() {
        System.out.println("----- Tricky Example -----");

        Map<String, String> map = new HashMap<>();
        map.put(null, "NullKey");
        map.put("Java", null);
        map.put("Python", null);

        System.out.println("HashMap with null key & values: " + map);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== HashMap Demo ==========\n");

        createHashMapDemo();
        System.out.println();

        accessDemo();
        System.out.println();

        iterationDemo();
        System.out.println();

        removeDemo();
        System.out.println();

        trickyExample();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Can HashMap contain null key or null value?
- Yes, one null key, multiple null values

2) Difference between HashMap, LinkedHashMap, TreeMap?
- HashMap: unordered
- LinkedHashMap: insertion order
- TreeMap: sorted order

3) Time complexity of get(), put(), remove()?
- Average: O(1), Worst-case: O(n)

4) How does HashMap handle collisions?
- Uses linked list or tree in bucket

5) Difference between keySet(), values(), entrySet() iteration?
- keySet(): iterate keys
- values(): iterate values
- entrySet(): iterate key-value pairs efficiently

6) How to avoid ConcurrentModificationException?
- Use iterator.remove() for safe removal
- Or use ConcurrentHashMap for thread-safe operations

7) Default capacity and load factor?
- 16, 0.75

8) Difference between HashMap and Hashtable?
- Hashtable: synchronized, legacy
- HashMap: non-synchronized, modern
*/
