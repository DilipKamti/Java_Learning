package java_05_collections.set;

// HashSetDemo.java
// Java HashSet - Deep Dive ✅
// Covers: creation, methods, internal mechanics, duplicates, null, iteration, interview tips

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

    // =========================================================
    // 1) What is HashSet?
    // =========================================================
    /*
        - Implements Set interface
        - Backed by HashMap internally
        - Does NOT allow duplicates
        - Does NOT maintain insertion order
        - Allows one null element
        - Not synchronized
        - Constant-time performance for add, remove, contains (O(1) average)
    */

    // =========================================================
    // 2) Creating HashSet
    // =========================================================
    static void createHashSetDemo() {
        System.out.println("----- HashSet Creation -----");

        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // duplicate ignored
        set.add(null);   // one null allowed

        System.out.println("HashSet: " + set);
        System.out.println("Size: " + set.size());
    }

    // =========================================================
    // 3) Access & Iteration
    // =========================================================
    static void accessIterationDemo() {
        System.out.println("----- Access & Iteration -----");

        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");

        // Cannot access by index
        // System.out.println(set.get(0)); // ❌ Not allowed

        // Iteration using enhanced for-loop
        System.out.println("Enhanced for-loop:");
        for (String s : set) {
            System.out.println(s);
        }

        // Iteration using Iterator
        System.out.println("Iterator:");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // =========================================================
    // 4) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");

        set.remove("Python");
        System.out.println("After remove('Python'): " + set);

        // Remove while iterating (safe)
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("C++")) {
                it.remove();
            }
        }
        System.out.println("After removing 'C++' safely: " + set);
    }

    // =========================================================
    // 5) Internal Mechanics (Interview Favorite)
    // =========================================================
    /*
        - Uses HashMap internally (key = element, value = PRESENT Object)
        - Duplicates ignored because HashMap keys are unique
        - hashCode() and equals() determine uniqueness
        - Capacity & Load Factor:
          Default capacity = 16
          Default load factor = 0.75
          When threshold exceeded, HashSet rehashes (doubles capacity)
    */

    // =========================================================
    // 6) HashSet Tips & Tricks
    // =========================================================
    /*
        ✅ Fast lookups: contains(), add(), remove() ~ O(1)
        ✅ Order not guaranteed: use LinkedHashSet for insertion order
        ✅ Use TreeSet for sorted order
        ✅ Null allowed once
        ✅ Iterators are fail-fast
        ✅ Always override equals() and hashCode() for custom objects
    */

    // =========================================================
    // 7) Tricky Output Example
    // =========================================================
    static void trickyExample() {
        System.out.println("----- Tricky Output Example -----");

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(10);
        set.add(5);
        set.add(null);
        set.add(null); // duplicate null ignored

        System.out.println("HashSet elements (unordered): " + set);

        // Check contains
        System.out.println("Contains 20? " + set.contains(20));
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== HashSet Demo ==========\n");

        createHashSetDemo();
        System.out.println();

        accessIterationDemo();
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

1) Can HashSet contain duplicates?
- No, duplicates ignored

2) Can HashSet contain null?
- Yes, one null allowed

3) Difference between HashSet, LinkedHashSet, TreeSet?
- HashSet: unordered
- LinkedHashSet: insertion order
- TreeSet: sorted

4) Why hashCode() and equals() important in HashSet?
- Determines uniqueness of elements

5) Time complexity of add(), remove(), contains()?
- O(1) average, O(n) worst-case

6) Is HashSet synchronized?
- No, use Collections.synchronizedSet() for thread safety

7) Can we access elements by index?
- No, Set doesn’t support get(index)
*/

