package java_collections.queue;

// PriorityQueueDemo.java
// Java PriorityQueue - Deep Dive ✅
// Covers: natural ordering, custom comparator, methods, iteration, interview tips

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    // =========================================================
    // 1) What is PriorityQueue?
    // =========================================================
    /*
        - Implements Queue interface
        - Stores elements in sorted order (natural or custom Comparator)
        - Not thread-safe
        - Allows duplicates
        - Null elements NOT allowed
        - Default: min-heap (natural ordering)
    */

    // =========================================================
    // 2) Natural Ordering (Min-Heap)
    // =========================================================
    static void naturalOrderDemo() {
        System.out.println("----- Natural Order PriorityQueue -----");

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(20);
        pq.add(10);
        pq.add(30);

        System.out.println("PriorityQueue: " + pq); // internal heap, not fully sorted

        System.out.println("Poll elements (ascending order):");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // smallest element removed first
        }
        System.out.println();
    }

    // =========================================================
    // 3) Custom Comparator (Max-Heap)
    // =========================================================
    static void customComparatorDemo() {
        System.out.println("----- Custom Comparator (Max-Heap) -----");

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(50);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);

        System.out.println("Max-Heap PriorityQueue: " + maxHeap);

        System.out.println("Poll elements (descending order):");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 4) Iteration Quirks
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iteration -----");

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);

        System.out.println("PriorityQueue elements (iteration, unordered):");
        for (Integer i : pq) {
            System.out.print(i + " "); // iteration order NOT sorted
        }
        System.out.println();

        System.out.println("Poll elements (sorted):");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // always sorted
        }
        System.out.println();
    }

    // =========================================================
    // 5) Methods Overview
    // =========================================================
    /*
        - add()/offer(): add element
        - peek()/element(): view head element
        - poll()/remove(): remove head element
        - contains(): check if element exists
        - size(): number of elements
    */

    // =========================================================
    // 6) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ PriorityQueue does NOT maintain insertion order
        ✅ Iteration order is not sorted, only poll() returns sorted order
        ✅ Null not allowed (NullPointerException)
        ✅ For max-heap, provide Comparator.reverseOrder()
        ✅ Duplicate elements allowed
        ✅ Time complexity: offer/poll = O(log n)
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== PriorityQueue Demo ==========\n");

        naturalOrderDemo();
        System.out.println();

        customComparatorDemo();
        System.out.println();

        iterationDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between PriorityQueue and normal Queue?
- PriorityQueue: elements sorted (natural or comparator)
- Normal Queue: FIFO

2) Can PriorityQueue contain null?
- No, throws NullPointerException

3) Does PriorityQueue maintain insertion order?
- No

4) How to create max-heap using PriorityQueue?
- Provide Comparator.reverseOrder() or custom Comparator

5) Time complexity of add()/offer()/poll()?
- O(log n)

6) Iteration order vs poll order?
- Iteration: unpredictable
- Poll: sorted order

7) Can PriorityQueue contain duplicates?
- Yes

8) What happens if we poll from empty PriorityQueue?
- Returns null if using poll(), throws exception if remove()
*/

