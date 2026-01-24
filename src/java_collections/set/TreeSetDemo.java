package java_collections.set;

// TreeSetDemo.java
// Java TreeSet - Deep Dive ✅
// Covers: creation, natural ordering, custom Comparator, internal mechanics, interview tips

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class TreeSetDemo {

    // =========================================================
    // 1) What is TreeSet?
    // =========================================================
    /*
        - Implements Set and NavigableSet interfaces
        - Stores elements in sorted order (natural or custom Comparator)
        - Does NOT allow duplicates
        - Does NOT allow null (NullPointerException for compareTo)
        - Not synchronized
        - Backed by Red-Black tree
        - O(log n) time complexity for add, remove, contains
    */

    // =========================================================
    // 2) Creating TreeSet (Natural Order)
    // =========================================================
    static void naturalOrderDemo() {
        System.out.println("----- TreeSet Natural Order -----");

        Set<String> ts = new TreeSet<>();
        ts.add("Java");
        ts.add("Python");
        ts.add("C++");
        ts.add("Go");
        ts.add("Java"); // duplicate ignored

        System.out.println("TreeSet (natural order): " + ts);
    }

    // =========================================================
    // 3) Creating TreeSet (Custom Comparator)
    // =========================================================
    static void customOrderDemo() {
        System.out.println("----- TreeSet Custom Order (Descending) -----");

        Set<Integer> ts = new TreeSet<>(Comparator.reverseOrder());
        ts.add(10);
        ts.add(5);
        ts.add(20);
        ts.add(15);
        ts.add(10); // duplicate ignored

        System.out.println("TreeSet (descending order): " + ts);
    }

    // =========================================================
    // 4) Iteration
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iteration -----");

        Set<String> ts = new TreeSet<>();
        ts.add("Java");
        ts.add("Python");
        ts.add("C++");

        System.out.println("Iterator:");
        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Enhanced for-loop:");
        for (String s : ts) {
            System.out.println(s);
        }
    }

    // =========================================================
    // 5) Removing Elements
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        Set<String> ts = new TreeSet<>();
        ts.add("Java");
        ts.add("Python");
        ts.add("C++");

        ts.remove("Python");
        System.out.println("After remove('Python'): " + ts);
    }

    // =========================================================
    // 6) Internal Mechanics (Interview Favorite)
    // =========================================================
    /*
        - Uses Red-Black Tree internally
        - Keeps elements sorted (natural ordering or Comparator)
        - Time complexity: O(log n) for add(), remove(), contains()
        - Duplicates ignored
        - Null not allowed (NullPointerException if compareTo called)
    */

    // =========================================================
    // 7) Tricky Output Example
    // =========================================================
    static void trickyExample() {
        System.out.println("----- Tricky Output Example -----");

        Set<String> ts = new TreeSet<>();
        ts.add("B");
        ts.add("A");
        ts.add("C");
        ts.add("B"); // duplicate ignored

        System.out.println("TreeSet maintains sorted order: " + ts);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== TreeSet Demo ==========\n");

        naturalOrderDemo();
        System.out.println();

        customOrderDemo();
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

1) Difference between HashSet, LinkedHashSet, TreeSet?
- HashSet: unordered
- LinkedHashSet: insertion order
- TreeSet: sorted order (natural or custom Comparator)

2) Can TreeSet contain duplicates?
- No, duplicates ignored

3) Can TreeSet contain null?
- No, NullPointerException

4) Time complexity of add(), remove(), contains()?
- O(log n)

5) Internal implementation of TreeSet?
- Red-Black Tree

6) How to use custom order in TreeSet?
- Provide Comparator to constructor

7) Which method maintains insertion order in Set?
- LinkedHashSet, not TreeSet

8) When to use TreeSet over HashSet?
- When you need sorted order of elements
*/

