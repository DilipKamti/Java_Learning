package java_05_collections.queue;

// QueueBasics.java
// Java Queue - Deep Dive ✅
// Covers: Queue interface, implementations, basic operations, iteration, interview tips

import java.util.*;

public class QueueBasics {

    // =========================================================
    // 1) What is Queue?
    // =========================================================
    /*
        - Queue is a collection designed for holding elements prior to processing.
        - Follows FIFO (First-In-First-Out) principle by default.
        - Main implementations:
            ✅ LinkedList (implements Queue & Deque)
            ✅ PriorityQueue (elements ordered naturally or by Comparator)
            ✅ ArrayDeque (resizable array, faster than LinkedList)
        - Common methods:
            offer(), poll(), peek(), add(), remove()
    */

    // =========================================================
    // 2) Creating Queue using LinkedList
    // =========================================================
    static void linkedListQueueDemo() {
        System.out.println("----- LinkedList Queue Demo -----");

        Queue<String> queue = new LinkedList<>();

        queue.add("Java");     // add throws exception if full
        queue.offer("Python"); // offer returns false if full
        queue.add("C++");

        System.out.println("Queue: " + queue);

        // Access front element
        System.out.println("Peek(): " + queue.peek()); // null if empty
        System.out.println("Element(): " + queue.element()); // throws exception if empty

        // Remove elements
        System.out.println("Poll(): " + queue.poll()); // null if empty
        System.out.println("Remove(): " + queue.remove()); // throws exception if empty

        System.out.println("Queue after removals: " + queue);
    }

    // =========================================================
    // 3) PriorityQueue
    // =========================================================
    static void priorityQueueDemo() {
        System.out.println("----- PriorityQueue Demo -----");

        Queue<Integer> pq = new PriorityQueue<>(); // natural ordering (min-heap)

        pq.add(50);
        pq.add(20);
        pq.add(10);
        pq.add(30);

        System.out.println("PriorityQueue (natural order): " + pq);

        // Remove elements (poll always removes smallest)
        System.out.println("Poll(): " + pq.poll());
        System.out.println("Poll(): " + pq.poll());
        System.out.println("PriorityQueue after polls: " + pq);

        // Custom Comparator (max-heap)
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(Arrays.asList(50, 20, 10, 30));
        System.out.println("PriorityQueue (max-heap): " + maxHeap);
    }

    // =========================================================
    // 4) ArrayDeque as Queue
    // =========================================================
    static void arrayDequeDemo() {
        System.out.println("----- ArrayDeque Demo -----");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer("Java");
        deque.offer("Python");
        deque.offerFirst("C++"); // add at front
        deque.offerLast("Go");   // add at end

        System.out.println("ArrayDeque: " + deque);

        System.out.println("PollFirst(): " + deque.pollFirst());
        System.out.println("PollLast(): " + deque.pollLast());
        System.out.println("ArrayDeque after polls: " + deque);
    }

    // =========================================================
    // 5) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ LinkedList: slow random access, fast insertion/deletion
        ✅ ArrayDeque: faster than LinkedList for queue operations
        ✅ PriorityQueue: does not maintain insertion order
        ✅ Queue methods:
            - add()/remove(): throw exception if operation fails
            - offer()/poll()/peek(): return special value (null/false) instead of exception
        ✅ Always prefer interfaces (Queue/Deque) in method signatures
        ✅ Iterators do not guarantee order for PriorityQueue
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Queue Basics Demo ==========\n");

        linkedListQueueDemo();
        System.out.println();

        priorityQueueDemo();
        System.out.println();

        arrayDequeDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Queue and Deque?
- Queue: FIFO
- Deque: double-ended, add/remove at both ends

2) Difference between add() and offer()?
- add(): throws exception if fails
- offer(): returns false if fails

3) Difference between poll() and remove()?
- poll(): returns null if empty
- remove(): throws exception if empty

4) Difference between peek() and element()?
- peek(): returns null if empty
- element(): throws exception if empty

5) PriorityQueue ordering?
- Natural order or Comparator-based, not insertion order

6) Can PriorityQueue contain null?
- No, NullPointerException

7) Which implementation is faster for normal Queue operations?
- ArrayDeque > LinkedList

8) Time complexity of offer/poll in PriorityQueue?
- O(log n) (heap operations)
*/

