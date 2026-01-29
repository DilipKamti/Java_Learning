package java_05_collections.intro;

// IterableVsCollectionVsList.java
// Java Collections Hierarchy Deep Dive ✅
// Covers: Iterable vs Collection vs List, examples, hierarchy, interview tips.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IterableVsCollectionVsList {

    // =========================================================
    // 1) Iterable Interface
    // =========================================================
    /*
        - Root of all collection classes
        - Only one method: iterator()
        - Allows us to iterate using Iterator or enhanced for-loop
        - Introduced in Java 5 for foreach loop
        - Implemented by Collection interface
    */
    static void iterableDemo() {
        System.out.println("----- Iterable Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        Iterable<String> iterable = list; // List implements Collection -> extends Iterable
        Iterator<String> it = iterable.iterator();

        while (it.hasNext()) {
            System.out.println("Element: " + it.next());
        }

        // Enhanced for loop uses Iterable internally
        System.out.println("Enhanced for-loop:");
        for (String s : iterable) {
            System.out.println(s);
        }
    }

    // =========================================================
    // 2) Collection Interface
    // =========================================================
    /*
        - Extends Iterable
        - Root interface for List, Set, Queue
        - Supports bulk operations: addAll, removeAll, containsAll, clear
        - Represents a group of objects
    */
    static void collectionDemo() {
        System.out.println("----- Collection Demo -----");

        Collection<String> coll = new ArrayList<>();
        coll.add("Java");
        coll.add("Python");
        coll.add("C++");

        System.out.println("Collection: " + coll);
        System.out.println("Contains Python? " + coll.contains("Python"));
        System.out.println("Size: " + coll.size());

        // Remove an element
        coll.remove("C++");
        System.out.println("After remove: " + coll);
    }

    // =========================================================
    // 3) List Interface
    // =========================================================
    /*
        - Extends Collection
        - Ordered (insertion order)
        - Allows duplicates
        - Supports positional access (get(index), add(index, element))
        - Common implementations: ArrayList, LinkedList, Vector
    */
    static void listDemo() {
        System.out.println("----- List Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Java"); // duplicates allowed

        System.out.println("List: " + list);
        System.out.println("Element at index 2: " + list.get(2));

        // Iterating using for loop
        System.out.println("Iterating using for-loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        // Iterating using enhanced for loop
        System.out.println("Iterating using enhanced for-loop:");
        for (String s : list) {
            System.out.println(s);
        }
    }

    // =========================================================
    // 4) Key Differences (Interview Favourite)
    // =========================================================
    /*
        Iterable vs Collection vs List:

        1) Iterable:
           - Root interface
           - Can iterate over objects using iterator()
           - No add/remove methods
           - Implemented by Collection

        2) Collection:
           - Extends Iterable
           - Represents a group of objects
           - Supports add, remove, size, contains, clear
           - Parent of List, Set, Queue

        3) List:
           - Extends Collection
           - Ordered, allows duplicates
           - Supports positional access
           - Implementations: ArrayList, LinkedList, Vector

        Quick Table:

        Interface    | Allows Duplicates | Ordered | Access by Index
        -----------------------------------------------------------
        Iterable     | Yes               | No      | No
        Collection   | Yes               | No      | No
        List         | Yes               | Yes     | Yes
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Iterable vs Collection vs List ==========\n");

        iterableDemo();
        System.out.println();

        collectionDemo();
        System.out.println();

        listDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Iterable, Collection, List?
- Iterable: root interface, allows iteration
- Collection: adds bulk operations
- List: ordered, allows duplicates, positional access

2) Can Iterable contain duplicates?
- Yes, Iterable itself has no restriction, depends on implementation

3) Can we instantiate Iterable or Collection?
- Cannot instantiate interfaces directly, need concrete classes

4) Why List allows duplicates but Set doesn't?
- Set overrides equals() check, List preserves insertion order

5) Which interface allows random access?
- List supports get(index), RandomAccess marker interface in ArrayList
*/

