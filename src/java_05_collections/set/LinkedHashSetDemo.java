package java_05_collections.set;

// LinkedHashSetDemo.java
// Java LinkedHashSet - Deep Dive ✅
// Covers: creation, insertion order, iteration, differences vs HashSet/TreeSet, interview tips

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

    // =========================================================
    // 1) What is LinkedHashSet?
    // =========================================================
    /*
        - Implements Set interface
        - Maintains insertion order
        - Does NOT allow duplicates
        - Allows one null
        - Not synchronized
        - Backed by HashMap + linked list of entries
        - Faster iteration than HashSet due to predictable order
    */

    // =========================================================
    // 2) Creating LinkedHashSet
    // =========================================================
    static void createLinkedHashSetDemo() {
        System.out.println("----- LinkedHashSet Creation -----");

        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("Java");
        lhs.add("Python");
        lhs.add("C++");
        lhs.add("Java"); // duplicate ignored
        lhs.add(null);   // one null allowed

        System.out.println("LinkedHashSet: " + lhs);
        System.out.println("Size: " + lhs.size());
    }

    // =========================================================
    // 3) Iteration
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iteration -----");

        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("Java");
        lhs.add("Python");
        lhs.add("C++");

        // Enhanced for-loop
        System.out.println("Enhanced for-loop:");
        for (String s : lhs) {
            System.out.println(s);
        }

        // Iterator
        System.out.println("Iterator:");
        Iterator<String> it = lhs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // =========================================================
    // 4) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("Java");
        lhs.add("Python");
        lhs.add("C++");

        lhs.remove("Python");
        System.out.println("After remove('Python'): " + lhs);

        // Safe remove while iterating
        Iterator<String> it = lhs.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("C++")) {
                it.remove();
            }
        }
        System.out.println("After removing 'C++' safely: " + lhs);
    }

    // =========================================================
    // 5) LinkedHashSet vs HashSet vs TreeSet
    // =========================================================
    /*
        Feature         | HashSet      | LinkedHashSet | TreeSet
        ------------------------------------------------------------
        Order           | Unordered    | Insertion     | Sorted
        Duplicates      | Not allowed  | Not allowed   | Not allowed
        Null allowed    | 1            | 1             | Not allowed
        Performance     | Fast         | Slightly slower | Slower (log n)
        Use-case        | Lookup only  | Maintain order | Sorted order
    */

    // =========================================================
    // 6) Tricky Example
    // =========================================================
    static void trickyExample() {
        System.out.println("----- Tricky Output Example -----");

        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("B");
        lhs.add("A");
        lhs.add("C");
        lhs.add("B"); // duplicate ignored

        System.out.println("LinkedHashSet maintains insertion order: " + lhs);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== LinkedHashSet Demo ==========\n");

        createLinkedHashSetDemo();
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

1) Difference between HashSet and LinkedHashSet?
- HashSet: unordered
- LinkedHashSet: maintains insertion order

2) Can LinkedHashSet contain duplicates or null?
- Duplicates ignored
- One null allowed

3) Difference between LinkedHashSet and TreeSet?
- TreeSet: sorted, no nulls
- LinkedHashSet: insertion order, allows one null

4) Time complexity of add(), remove(), contains()?
- O(1) average (like HashSet)

5) When to use LinkedHashSet?
- When uniqueness + insertion order matters

6) Internal implementation?
- HashMap + doubly linked list of entries
*/

