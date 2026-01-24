package java_collections.iterator_cursor;

// IteratorDemo.java
// Java Iterator - Deep Dive ✅
// Covers: Iterator, ListIterator, fail-fast behavior, remove operation, interview tips

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

    // =========================================================
    // 1) What is Iterator?
    // =========================================================
    /*
        - Iterator is an interface in java.util package
        - Provides a way to traverse collections (List, Set, etc.)
        - Methods:
            boolean hasNext()
            E next()
            void remove()
        - Fail-fast: detects concurrent modification
    */

    // =========================================================
    // 2) Using Iterator with List
    // =========================================================
    static void iteratorListDemo() {
        System.out.println("----- Iterator with List -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String element = it.next();
            System.out.println(element);

            // Remove element "Python" safely using iterator
            if ("Python".equals(element)) {
                it.remove();
            }
        }

        System.out.println("After removal: " + list);
    }

    // =========================================================
    // 3) Using ListIterator
    // =========================================================
    static void listIteratorDemo() {
        System.out.println("----- ListIterator Demo -----");

        List<String> list = new LinkedList<>();
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

        // Adding element at current position
        listIt = list.listIterator();
        while (listIt.hasNext()) {
            if ("B".equals(listIt.next())) {
                listIt.add("D"); // Insert after B
            }
        }

        System.out.println("After adding 'D': " + list);
    }

    // =========================================================
    // 4) Fail-Fast Behavior
    // =========================================================
    static void failFastDemo() {
        System.out.println("----- Fail-Fast Behavior -----");

        List<String> list = new ArrayList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        Iterator<String> it = list.iterator();

        try {
            while (it.hasNext()) {
                String val = it.next();
                if ("Y".equals(val)) {
                    list.add("W"); // Modify list directly during iteration
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }

    // =========================================================
    // 5) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Iterator is universal for all collections
        ✅ Iterator.remove() is safe; list.remove() during iteration throws ConcurrentModificationException
        ✅ ListIterator can iterate both directions and modify list during iteration
        ✅ Fail-fast: detects concurrent modification
        ✅ Enhanced for-loop internally uses Iterator
        ✅ For concurrent-safe iteration, use Concurrent collections or CopyOnWriteArrayList
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Iterator Demo ==========\n");

        iteratorListDemo();
        System.out.println();

        listIteratorDemo();
        System.out.println();

        failFastDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Iterator and ListIterator?
- Iterator: forward only
- ListIterator: forward & backward, can add/update elements

2) Can we remove elements while iterating a collection?
- Yes, using Iterator.remove()
- Using collection.remove() directly throws ConcurrentModificationException

3) What is fail-fast iterator?
- Detects concurrent modification and throws ConcurrentModificationException

4) Which collections support Iterator?
- All collections (List, Set, Map.keySet(), Map.values(), Map.entrySet())

5) Difference between Iterator and Enumeration?
- Enumeration: legacy, only has hasMoreElements() & nextElement()
- Iterator: remove() supported, fail-fast
*/

