package java_05_collections.intro;

// CollectionsOverview.java
// Java Collections Framework - Basic to Deep Dive ✅
// Covers: Collection vs Collections, List/Set/Map overview,
// hierarchy, interfaces, abstract classes, interview tips.

import java.util.*;

public class CollectionsOverview {

    // =========================================================
    // 1) What is Collection Framework?
    // =========================================================
    /*
        Collection Framework in Java:
        - Unified architecture to store and manipulate groups of objects.
        - Introduced in Java 1.2 (java.util package)
        - Provides:
          ✅ Interfaces: Collection, Set, List, Queue, Deque, Map
          ✅ Classes: ArrayList, LinkedList, HashSet, HashMap, etc.
          ✅ Algorithms: Collections class methods (sort, reverse, shuffle)

        Key Difference:
        - Collection (interface) -> root for List, Set, Queue
        - Map (interface) -> separate, key-value storage
    */

    // =========================================================
    // 2) Collection vs Collections (Very Common Interview)
    // =========================================================
    /*
        Collection (interface)
        ---------------------
        - Root interface for List, Set, Queue
        - Stores objects (single element per entry)
        - Cannot store key-value pairs
        - Examples: ArrayList, HashSet

        Collections (class)
        -------------------
        - Utility class with static methods
        - Methods: sort(), shuffle(), reverse(), max(), min()
        - Cannot store objects itself
        - Example usage: Collections.sort(list)
    */

    // =========================================================
    // 3) Collection Interface Hierarchy
    // =========================================================
    /*
        Collection
        ├── List
        │    ├── ArrayList
        │    ├── LinkedList
        │    └── Vector (Stack)
        ├── Set
        │    ├── HashSet
        │    ├── LinkedHashSet
        │    └── TreeSet
        └── Queue
             ├── PriorityQueue
             └── Deque (ArrayDeque, LinkedList)

        Map (separate)
        ├── HashMap
        ├── LinkedHashMap
        ├── TreeMap
        └── Hashtable
    */

    // =========================================================
    // 4) Examples of Collection Interfaces
    // =========================================================
    static void listDemo() {
        System.out.println("----- List Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Java"); // duplicates allowed

        System.out.println("List: " + list);
        System.out.println("List size: " + list.size());
    }

    static void setDemo() {
        System.out.println("----- Set Demo -----");

        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // duplicates ignored

        System.out.println("Set: " + set);
        System.out.println("Set size: " + set.size());
    }

    static void mapDemo() {
        System.out.println("----- Map Demo -----");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(2, "JavaScript"); // key overwrite

        System.out.println("Map: " + map);
        System.out.println("Map size: " + map.size());
    }

    // =========================================================
    // 5) Collections Utility Methods
    // =========================================================
    static void collectionsClassDemo() {
        System.out.println("----- Collections Utility Demo -----");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 5, 20, 15));
        System.out.println("Original List: " + numbers);

        Collections.sort(numbers);
        System.out.println("Sorted List: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffled List: " + numbers);

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max: " + max + ", Min: " + min);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Java Collections Overview ==========\n");

        listDemo();
        System.out.println();

        setDemo();
        System.out.println();

        mapDemo();
        System.out.println();

        collectionsClassDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Collection and Collections?
- Collection: interface, root of List/Set/Queue
- Collections: utility class with static methods

2) Is Map part of Collection interface?
- No, Map is separate

3) Which collection allows duplicates?
- List allows duplicates
- Set ignores duplicates

4) Which collection maintains insertion order?
- ArrayList, LinkedHashSet, LinkedHashMap

5) Difference between HashSet and TreeSet?
- HashSet: unordered, faster
- TreeSet: sorted order, slower

6) Why HashMap allows one null key but HashTable doesn't?
- HashMap handles null key internally
- HashTable is legacy, synchronized, doesn't allow null key/value

7) What is fail-fast iterator?
- Iterator that throws ConcurrentModificationException if collection modified during iteration

8) When to use ArrayList vs LinkedList?
- ArrayList: fast random access
- LinkedList: fast insertion/deletion in middle
*/

