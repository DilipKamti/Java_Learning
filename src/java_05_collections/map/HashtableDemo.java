package java_05_collections.map;

// HashtableDemo.java
// Java Hashtable - Deep Dive ✅
// Covers: creation, basic operations, synchronization, null handling, iteration, interview tips

import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Map;

public class HashtableDemo {

    // =========================================================
    // 1) What is Hashtable?
    // =========================================================
    /*
        - Implements Map<K,V> interface
        - Synchronized (thread-safe)
        - Legacy class (introduced before Java 1.2)
        - Does NOT allow null key or null value
        - Keys must be unique
        - Values can be duplicate
        - Backed by hash table
        - Iterators are NOT fail-fast, use Enumeration
    */

    // =========================================================
    // 2) Creating Hashtable
    // =========================================================
    static void createHashtableDemo() {
        System.out.println("----- Creating Hashtable -----");

        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "Java");
        table.put(2, "Python");
        table.put(3, "C++");

        System.out.println("Hashtable: " + table);

        // table.put(null, "NullKey"); // Throws NullPointerException
        // table.put(4, null);          // Throws NullPointerException
    }

    // =========================================================
    // 3) Accessing Values
    // =========================================================
    static void accessDemo() {
        System.out.println("----- Accessing Values -----");

        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("Java", 1);
        table.put("Python", 2);
        table.put("C++", 3);

        System.out.println("Value for key 'Python': " + table.get("Python"));
        System.out.println("Contains key 'Java'? " + table.containsKey("Java"));
        System.out.println("Contains value 3? " + table.containsValue(3));
    }

    // =========================================================
    // 4) Iteration
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iterating Hashtable -----");

        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "Java");
        table.put(2, "Python");
        table.put(3, "C++");

        // Using entrySet()
        System.out.println("Using entrySet():");
        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Using Enumeration (legacy)
        System.out.println("Using Enumeration of keys:");
        Enumeration<Integer> keys = table.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            System.out.println(key + " -> " + table.get(key));
        }
    }

    // =========================================================
    // 5) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        Hashtable<String, String> table = new Hashtable<>();
        table.put("Java", "JVM");
        table.put("Python", "Interpreter");
        table.put("C++", "Compiler");

        table.remove("Python");
        System.out.println("After removing 'Python': " + table);
    }

    // =========================================================
    // 6) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Legacy class, synchronized (thread-safe)
        ✅ Null keys and null values NOT allowed
        ✅ Use HashMap or ConcurrentHashMap in modern code
        ✅ Enumeration can be used to iterate (legacy)
        ✅ Iterators are fail-safe but slower than HashMap
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Hashtable Demo ==========\n");

        createHashtableDemo();
        System.out.println();

        accessDemo();
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

1) Difference between HashMap and Hashtable?
- HashMap: non-synchronized, allows null key/value
- Hashtable: synchronized, null key/value NOT allowed

2) Is Hashtable thread-safe?
- Yes, synchronized methods

3) Can Hashtable contain null key or value?
- No, throws NullPointerException

4) How to iterate over Hashtable?
- entrySet(), keySet(), values(), Enumeration

5) Time complexity of get(), put(), remove()?
- O(1) average

6) Should we use Hashtable in modern code?
- Prefer HashMap or ConcurrentHashMap
*/

