package java_collections.collections_class;

// SynchronizedCollections.java
// Java Synchronized Collections - Deep Dive ✅
// Covers: making collections thread-safe using Collections.synchronizedXXX()

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SynchronizedCollections {

    // =========================================================
    // 1) Why Synchronized Collections?
    // =========================================================
    /*
        - Collections are not thread-safe by default
        - Multiple threads modifying a collection can cause data inconsistency
        - Collections.synchronizedXXX() wrappers provide basic thread safety
    */

    // =========================================================
    // 2) Synchronized List
    // =========================================================
    static void synchronizedListDemo() {
        System.out.println("----- Synchronized List Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Wrap list to make it synchronized
        List<String> syncList = Collections.synchronizedList(list);

        // Access must be synchronized manually when iterating
        synchronized (syncList) {
            for (String s : syncList) {
                System.out.println(s);
            }
        }

        // Modifications are thread-safe
        syncList.add("Go");
        System.out.println("After adding 'Go': " + syncList);
    }

    // =========================================================
    // 3) Synchronized Map
    // =========================================================
    static void synchronizedMapDemo() {
        System.out.println("----- Synchronized Map Demo -----");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        // Wrap map to make it synchronized
        Map<Integer, String> syncMap = Collections.synchronizedMap(map);

        // Access iteration must be synchronized
        synchronized (syncMap) {
            for (Map.Entry<Integer, String> entry : syncMap.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        syncMap.put(3, "Three");
        System.out.println("After adding 3->Three: " + syncMap);
    }

    // =========================================================
    // 4) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Collections.synchronizedXXX() provides basic thread-safety
        ✅ Iteration must be done inside synchronized block
        ✅ Use Concurrent Collections (ConcurrentHashMap, CopyOnWriteArrayList) for better performance
        ✅ Synchronized wrappers lock the entire collection for each operation (may cause contention)
        ✅ Useful for legacy code requiring thread-safe collections
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Synchronized Collections Demo ==========\n");

        synchronizedListDemo();
        System.out.println();

        synchronizedMapDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between synchronized collection and ConcurrentHashMap?
- Synchronized: wraps collection, locks entire collection
- ConcurrentHashMap: finer-grained locking, better concurrency

2) Can you iterate a synchronized collection safely?
- Yes, but iteration must be inside synchronized block

3) What happens if multiple threads modify ArrayList without synchronization?
- Data inconsistency, possible ConcurrentModificationException

4) Examples of synchronized collections?
- Collections.synchronizedList(), Collections.synchronizedMap(), Collections.synchronizedSet()
*/

