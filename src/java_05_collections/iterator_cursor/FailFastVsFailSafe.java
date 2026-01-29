package java_05_collections.iterator_cursor;

// FailFastVsFailSafe.java
// Java Fail-Fast vs Fail-Safe Iterators - Deep Dive ✅
// Covers: behavior of iterators, examples with Collections, thread-safety, interview tips

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafe {

    // =========================================================
    // 1) Fail-Fast Iterator Example
    // =========================================================
    static void failFastDemo() {
        System.out.println("----- Fail-Fast Iterator Demo -----");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String val = it.next();
                System.out.println(val);
                // Modifying list during iteration -> causes ConcurrentModificationException
                if ("B".equals(val)) {
                    list.add("D");
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception caught: " + e);
        }

        System.out.println("List after fail-fast modification attempt: " + list);
    }

    // =========================================================
    // 2) Fail-Safe Iterator Example
    // =========================================================
    static void failSafeDemo() {
        System.out.println("----- Fail-Safe Iterator Demo -----");

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String val = it.next();
            System.out.println(val);
            // Safe to modify list during iteration
            if ("Y".equals(val)) {
                list.add("W");
            }
        }

        System.out.println("List after fail-safe modification: " + list);
    }

    // =========================================================
    // 3) Key Differences
    // =========================================================
    /*
        ✅ Fail-Fast Iterators (ArrayList, HashMap, HashSet):
            - Throw ConcurrentModificationException if collection modified during iteration
            - Faster
            - Example: ArrayList.iterator(), HashMap.keySet().iterator()

        ✅ Fail-Safe Iterators (CopyOnWriteArrayList, ConcurrentHashMap):
            - Do not throw exception if collection modified
            - Work on clone/copy of data
            - Slower
            - Example: CopyOnWriteArrayList.iterator(), ConcurrentHashMap.iterator()
    */

    // =========================================================
    // 4) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Mention fail-fast vs fail-safe explicitly in interviews
        ✅ Fail-fast iterators: ArrayList, HashMap, HashSet
        ✅ Fail-safe iterators: CopyOnWriteArrayList, ConcurrentHashMap
        ✅ Fail-safe iterator modifications do not affect the current iterator
        ✅ Always prefer fail-safe in multi-threaded environments
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Fail-Fast vs Fail-Safe Demo ==========\n");

        failFastDemo();
        System.out.println();

        failSafeDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between fail-fast and fail-safe iterators?
- Fail-Fast: throws ConcurrentModificationException if collection modified
- Fail-Safe: allows modification, works on clone/copy

2) Which collections provide fail-fast iterators?
- ArrayList, HashMap, HashSet, LinkedList

3) Which collections provide fail-safe iterators?
- CopyOnWriteArrayList, ConcurrentHashMap

4) Can fail-fast iterators remove elements safely?
- Yes, using iterator.remove()

5) Which is faster, fail-fast or fail-safe?
- Fail-fast is faster; fail-safe is slower due to copying
*/
