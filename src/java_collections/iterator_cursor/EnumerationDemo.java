package java_collections.iterator_cursor;

// EnumerationDemo.java
// Java Enumeration - Deep Dive ✅
// Covers: legacy iteration, differences with Iterator, tips for interview

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationDemo {

    // =========================================================
    // 1) What is Enumeration?
    // =========================================================
    /*
        - Enumeration is a legacy interface in java.util
        - Used to traverse Vector, Hashtable (pre-JDK 1.2)
        - Methods:
            boolean hasMoreElements()
            E nextElement()
        - Does NOT support remove()
        - Not fail-fast
    */

    // =========================================================
    // 2) Using Enumeration with Vector
    // =========================================================
    static void vectorDemo() {
        System.out.println("----- Enumeration with Vector -----");

        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");

        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(en.nextElement());
        }
    }

    // =========================================================
    // 3) Using Enumeration with Hashtable
    // =========================================================
    static void hashtableDemo() {
        System.out.println("----- Enumeration with Hashtable -----");

        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "One");
        table.put(2, "Two");
        table.put(3, "Three");

        Enumeration<Integer> keys = table.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            System.out.println(key + " -> " + table.get(key));
        }

        Enumeration<String> values = table.elements();
        System.out.println("Values in Hashtable:");
        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }
    }

    // =========================================================
    // 4) Differences: Enumeration vs Iterator
    // =========================================================
    /*
        ✅ Enumeration: legacy, only has hasMoreElements() & nextElement()
        ✅ Iterator: modern, has hasNext(), next(), remove(), fail-fast
        ✅ Enumeration: not fail-fast
        ✅ Iterator: can remove elements safely during iteration
        ✅ Prefer Iterator for new code
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Enumeration Demo ==========\n");

        vectorDemo();
        System.out.println();

        hashtableDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Which collections support Enumeration?
- Vector, Hashtable

2) Can Enumeration remove elements?
- No, remove() not supported

3) Is Enumeration fail-fast?
- No

4) Difference between Enumeration and Iterator?
- Enumeration: legacy, forward only, no remove
- Iterator: modern, fail-fast, supports remove

5) Why use Iterator instead of Enumeration?
- Iterator provides safer, modern traversal, supports remove, fail-fast behavior
*/

