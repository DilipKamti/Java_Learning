package java_collections.map;

// TreeMapDemo.java
// Java TreeMap - Deep Dive ✅
// Covers: creation, natural ordering, custom comparator, iteration, null handling, interview tips

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class TreeMapDemo {

    // =========================================================
    // 1) What is TreeMap?
    // =========================================================
    /*
        - Implements NavigableMap interface
        - Stores key-value pairs in sorted order (natural or custom comparator)
        - Keys must be unique
        - Values can be duplicate
        - Null key NOT allowed (throws NullPointerException)
        - Allows multiple null values
        - Backed by Red-Black tree
        - O(log n) time complexity for get(), put(), remove()
    */

    // =========================================================
    // 2) Creating TreeMap (Natural Order)
    // =========================================================
    static void naturalOrderDemo() {
        System.out.println("----- TreeMap Natural Order -----");

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "C++");
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(4, null); // null value allowed

        System.out.println("TreeMap (natural order of keys): " + map);
    }

    // =========================================================
    // 3) Creating TreeMap (Custom Comparator)
    // =========================================================
    static void customOrderDemo() {
        System.out.println("----- TreeMap Custom Comparator (Descending Keys) -----");

        TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(3, "C++");
        map.put(1, "Java");
        map.put(2, "Python");

        System.out.println("TreeMap (descending keys): " + map);
    }

    // =========================================================
    // 4) Iteration
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iterating TreeMap -----");

        TreeMap<String, Integer> map = new TreeMap<>();
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
    }

    // =========================================================
    // 5) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        TreeMap<String, String> map = new TreeMap<>();
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
        ✅ Keys must be comparable or use custom comparator
        ✅ Null key not allowed (NullPointerException)
        ✅ Values can be null
        ✅ Maintains sorted order by key
        ✅ Use TreeMap when sorted keys needed
        ✅ Iteration is predictable and sorted
        ✅ NavigableMap methods: firstKey(), lastKey(), ceilingKey(), floorKey()
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== TreeMap Demo ==========\n");

        naturalOrderDemo();
        System.out.println();

        customOrderDemo();
        System.out.println();

        iterationDemo();
        System.out.println();

        removeDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between HashMap, LinkedHashMap, TreeMap?
- HashMap: unordered
- LinkedHashMap: insertion order
- TreeMap: sorted order (natural or comparator)

2) Can TreeMap contain null key or null value?
- Null key: NOT allowed
- Null values: allowed

3) Time complexity of get(), put(), remove()?
- O(log n)

4) Difference between natural ordering and custom comparator?
- Natural: keys must implement Comparable
- Custom: provide Comparator

5) Which Map to use for sorted keys?
- TreeMap

6) NavigableMap methods?
- firstKey(), lastKey(), ceilingKey(), floorKey(), subMap()

7) Difference between LinkedHashMap and TreeMap?
- LinkedHashMap: insertion order
- TreeMap: sorted keys
*/

