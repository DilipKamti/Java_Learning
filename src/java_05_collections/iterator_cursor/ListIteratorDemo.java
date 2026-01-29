package java_05_collections.iterator_cursor;

// ListIteratorDemo.java
// Java ListIterator - Deep Dive ✅
// Covers: forward/backward iteration, add, remove, set, and interview tips

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

    // =========================================================
    // 1) Forward and Backward Iteration
    // =========================================================
    static void traversalDemo() {
        System.out.println("----- Forward & Backward Traversal -----");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> listIt = list.listIterator();

        System.out.println("Forward iteration:");
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        System.out.println("Backward iteration:");
        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }
    }

    // =========================================================
    // 2) Adding Elements during Iteration
    // =========================================================
    static void addDemo() {
        System.out.println("----- Adding Elements -----");

        List<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String val = it.next();
            if ("Y".equals(val)) {
                it.add("D"); // Add after Y
            }
        }

        System.out.println("After adding 'D': " + list);
    }

    // =========================================================
    // 3) Modifying Elements using set()
    // =========================================================
    static void setDemo() {
        System.out.println("----- Modifying Elements -----");

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String val = it.next();
            if ("Banana".equals(val)) {
                it.set("Blueberry"); // Replace element
            }
        }

        System.out.println("After modification: " + list);
    }

    // =========================================================
    // 4) Removing Elements using remove()
    // =========================================================
    static void removeDemo() {
        System.out.println("----- Removing Elements -----");

        List<String> list = new ArrayList<>();
        list.add("Dog");
        list.add("Cat");
        list.add("Rabbit");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            if ("Cat".equals(it.next())) {
                it.remove(); // Remove Cat
            }
        }

        System.out.println("After removal: " + list);
    }

    // =========================================================
    // 5) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ ListIterator can iterate both forward and backward
        ✅ Can add, remove, and modify elements during iteration safely
        ✅ Iterator only supports forward traversal and remove
        ✅ Index-related methods: nextIndex() and previousIndex()
        ✅ Always use listIterator() on List, not Set
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== ListIterator Demo ==========\n");

        traversalDemo();
        System.out.println();

        addDemo();
        System.out.println();

        setDemo();
        System.out.println();

        removeDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Iterator and ListIterator?
- Iterator: forward only, supports remove()
- ListIterator: forward & backward, supports add(), remove(), set()

2) Can ListIterator modify elements during iteration?
- Yes, using set() and add()

3) Which collections support ListIterator?
- Only List implementations: ArrayList, LinkedList, Vector

4) Methods to get index while iterating?
- nextIndex(), previousIndex()

5) Difference between listIterator() and iterator()?
- listIterator(): bidirectional, allows modification
- iterator(): unidirectional, remove only
*/

