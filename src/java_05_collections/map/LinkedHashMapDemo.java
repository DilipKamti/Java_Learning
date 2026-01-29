package java_05_collections.map;

// LinkedHashMapDemo.java
// Java LinkedHashMap - Deep Dive ✅
// Covers: creation, insertion order, access order, iteration, null handling, interview tips

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    // =========================================================
    // 1) What is LinkedHashMap?
    // =========================================================
    /*
        - Extends HashMap
        - Maintains insertion order OR access order
        - Allows one null key and multiple null values
        - Not synchronized
        - Iteration predictable (insertion or access order)
        - Faster iteration than HashMap
    */

    // =========================================================
    // 2) Creating LinkedHashMap (Insertion Order)
    // =========================================================
    static void insertionOrderDemo() {
        System.out.println("----- Insertion Order Demo -----");

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "C++");
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(4, null); // null value
        map.put(null, "NullKey"); // null key

        System.out.println("LinkedHashMap (insertion order): " + map);
    }

    // =========================================================
    // 3) Iteration
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iteration Demo -----");

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        // Using entrySet()
        System.out.println("Using entrySet():");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Using keySet()
        System.out.println("Using keySet():");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // Using Iterator
        System.out.println("Using Iterator:");
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // =========================================================
    // 4) Access Order (Optional for LRU Cache)
    // =========================================================
    static void accessOrderDemo() {
        System.out.println("----- Access Order Demo (LRU Example) -----");

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");

        System.out.println("Before access: " + map);
        map.get(1); // Access key 1
        map.get(2); // Access key 2
        System.out.println("After access: " + map); // Order changes based on access
    }

    // =========================================================
    // 5) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("Java", "JVM");
        map.put("Python", "Interpreter");
        map.put("C++", "Compiler");

        map.remove("Python");
        System.out.println("After removing 'Python': " + map);
    }

    // =========================================================
    // 6) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Preserves insertion order by default
        ✅ Can preserve access order (useful for LRU caches)
        ✅ Null key/value allowed
        ✅ Iteration faster and predictable than HashMap
        ✅ Can override removeEldestEntry() to implement fixed-size cache
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== LinkedHashMap Demo ==========\n");

        insertionOrderDemo();
        System.out.println();

        iterationDemo();
        System.out.println();

        accessOrderDemo();
        System.out.println();

        removeDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between HashMap and LinkedHashMap?
- HashMap: unordered
- LinkedHashMap: maintains insertion or access order

2) Can LinkedHashMap contain null keys or values?
- Yes, one null key, multiple null values

3) Difference between insertion order and access order?
- Insertion order: elements remain in insertion sequence
- Access order: recently accessed elements move to end (used in LRU cache)

4) How to implement LRU cache using LinkedHashMap?
- Use constructor LinkedHashMap(initialCapacity, loadFactor, accessOrder=true)
- Override removeEldestEntry()

5) Time complexity of get(), put(), remove()?
- Average: O(1)

6) When to prefer LinkedHashMap over HashMap?
- When iteration order matters

7) Difference between LinkedHashMap and TreeMap?
- TreeMap: sorted order by keys
- LinkedHashMap: insertion/access order
*/

