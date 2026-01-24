package java_collections.intro;

// ListVsSetVsQueue.java
// Java Collections Deep Dive ✅
// Covers: List, Set, Queue differences, examples, hierarchy, interview questions.

import java.util.*;

public class ListVsSetVsQueue {

    // =========================================================
    // 1) List Interface
    // =========================================================
    /*
        - Ordered (insertion order)
        - Allows duplicates
        - Access by index
        - Common implementations: ArrayList, LinkedList, Vector
    */
    static void listDemo() {
        System.out.println("----- List Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Java"); // duplicate allowed

        System.out.println("List: " + list);

        // Access element by index
        System.out.println("Element at index 2: " + list.get(2));

        // Iteration
        System.out.println("Iterating List:");
        for (String s : list) {
            System.out.println(s);
        }
    }

    // =========================================================
    // 2) Set Interface
    // =========================================================
    /*
        - Unordered (except LinkedHashSet maintains insertion order)
        - Does NOT allow duplicates
        - Common implementations: HashSet, LinkedHashSet, TreeSet
    */
    static void setDemo() {
        System.out.println("----- Set Demo -----");

        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // duplicate ignored

        System.out.println("HashSet (unordered, no duplicates): " + set);

        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Java");
        linkedSet.add("Python");
        linkedSet.add("C++");
        linkedSet.add("Java");
        System.out.println("LinkedHashSet (insertion order): " + linkedSet);

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Java");
        treeSet.add("Python");
        treeSet.add("C++");
        treeSet.add("Java");
        System.out.println("TreeSet (sorted order): " + treeSet);
    }

    // =========================================================
    // 3) Queue Interface
    // =========================================================
    /*
        - FIFO (First-In-First-Out)
        - Supports add, offer, poll, peek, remove
        - Implementations: LinkedList, PriorityQueue, ArrayDeque
    */
    static void queueDemo() {
        System.out.println("----- Queue Demo -----");

        Queue<String> queue = new LinkedList<>();
        queue.add("Java");
        queue.add("Python");
        queue.add("C++");

        System.out.println("Queue: " + queue);

        System.out.println("Peek (front element): " + queue.peek());
        System.out.println("Poll (remove front element): " + queue.poll());
        System.out.println("Queue after poll: " + queue);
    }

    // =========================================================
    // 4) Key Differences (Interview Favourite)
    // =========================================================
    /*
        Feature        | List        | Set             | Queue
        ------------------------------------------------------------
        Order          | Insertion  | Unordered/Sorted| FIFO (priority-based optional)
        Duplicates     | Allowed    | Not allowed     | Allowed
        Access by idx  | Yes        | No              | No
        Implementations| ArrayList, LinkedList, Vector | HashSet, TreeSet, LinkedHashSet | LinkedList, PriorityQueue, ArrayDeque
        Null allowed   | Yes        | HashSet/LinkedHashSet allows 1 null, TreeSet not allowed | Yes (LinkedList, ArrayDeque)
    */

    // =========================================================
    // 5) List vs Set vs Queue Summary
    // =========================================================
    /*
        ✅ List: Ordered, duplicates allowed, random access
        ✅ Set: No duplicates, unordered or sorted
        ✅ Queue: FIFO, used for scheduling, tasks, buffers
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== List vs Set vs Queue ==========\n");

        listDemo();
        System.out.println();

        setDemo();
        System.out.println();

        queueDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between List, Set, Queue?
- List: ordered, duplicates allowed
- Set: unordered, no duplicates
- Queue: FIFO order

2) Which Set maintains insertion order?
- LinkedHashSet

3) Which Set is sorted automatically?
- TreeSet (sorted based on natural order or Comparator)

4) Can List contain null values?
- Yes

5) Can Set contain null values?
- HashSet, LinkedHashSet allow 1 null
- TreeSet does not allow null (natural ordering)

6) Which Queue implementation is priority-based?
- PriorityQueue

7) What happens if duplicate element added to Set?
- Ignored, not stored

8) Can List be used as Queue?
- Yes, e.g., LinkedList implements List and Queue
*/
