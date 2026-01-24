package java_collections.queue;

// QueueInterviewQuestions.java
// Java Queue - Interview Questions & Tricks ✅
// Covers: Queue, PriorityQueue, ArrayDeque, LinkedListQueue, common interview questions

import java.util.*;

public class QueueInterviewQuestions {

    // =========================================================
    // 1) Queue Basics
    // =========================================================
    /*
        Q1) What is a Queue?
        - A collection for holding elements prior to processing
        - Follows FIFO (First-In-First-Out) by default

        Q2) Queue implementations in Java?
        - LinkedList (FIFO, also implements Deque)
        - ArrayDeque (faster than LinkedList)
        - PriorityQueue (elements ordered by natural order or comparator)
    */

    static void basicsDemo() {
        System.out.println("----- Queue Basics -----");

        Queue<String> queue = new LinkedList<>();
        queue.add("Java");
        queue.add("Python");
        queue.add("C++");

        System.out.println("Queue elements: " + queue);
        System.out.println("Peek(): " + queue.peek());
        System.out.println("Poll(): " + queue.poll());
        System.out.println("Queue after poll(): " + queue);
    }

    // =========================================================
    // 2) PriorityQueue
    // =========================================================
    /*
        Q3) Difference between Queue and PriorityQueue?
        - Queue: FIFO
        - PriorityQueue: sorted by natural order or custom comparator
        - Iteration order in PriorityQueue is unpredictable
        - Poll() returns smallest (or according to comparator)
    */

    static void priorityQueueDemo() {
        System.out.println("----- PriorityQueue Basics -----");

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(20);
        pq.add(10);
        pq.add(30);

        System.out.println("PriorityQueue elements (iteration, unordered): " + pq);

        System.out.println("Poll elements (sorted):");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 3) Deque / ArrayDeque
    // =========================================================
    /*
        Q4) Difference between Queue and Deque?
        - Deque allows insertion/removal at both ends
        - Queue allows insertion at rear, removal from front

        Q5) Can ArrayDeque contain null?
        - No, NullPointerException

        Q6) Why prefer ArrayDeque over Stack?
        - Stack is legacy, synchronized, slower
        - ArrayDeque is faster, modern, and implements LIFO easily
    */

    static void dequeDemo() {
        System.out.println("----- ArrayDeque Basics -----");

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer("Java");
        deque.offer("Python");
        deque.offerFirst("C++"); // add at front

        System.out.println("Deque elements: " + deque);

        System.out.println("PollFirst(): " + deque.pollFirst());
        System.out.println("PollLast(): " + deque.pollLast());
        System.out.println("Deque after polls: " + deque);
    }

    // =========================================================
    // 4) Common Tricky Interview Questions
    // =========================================================
    /*
        Q7) Difference between add() and offer()?
        - add(): throws exception if queue full
        - offer(): returns false if queue full

        Q8) Difference between remove() and poll()?
        - remove(): throws exception if queue empty
        - poll(): returns null if queue empty

        Q9) Difference between element() and peek()?
        - element(): throws exception if empty
        - peek(): returns null if empty

        Q10) Time complexity of add()/offer()/poll() in PriorityQueue?
        - O(log n) (heap operations)

        Q11) Iteration order vs poll order in PriorityQueue?
        - Iteration: unpredictable
        - Poll: sorted order (min or according to comparator)

        Q12) How to implement max-heap using PriorityQueue?
        - Use Comparator.reverseOrder() or custom comparator

        Q13) Can Queue/Deque contain duplicates?
        - Yes

        Q14) Which is faster for Queue operations: LinkedList or ArrayDeque?
        - ArrayDeque
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Queue Interview Questions ==========\n");

        basicsDemo();
        System.out.println();

        priorityQueueDemo();
        System.out.println();

        dequeDemo();
        System.out.println();
    }
}

/*
===============================
SUMMARY (Interview Cheat Sheet)
===============================

1) Queue: FIFO, LinkedList, ArrayDeque
2) PriorityQueue: sorted, poll() returns smallest or comparator order
3) ArrayDeque: faster than LinkedList, LIFO/FIFO
4) Null elements not allowed in PriorityQueue/ArrayDeque
5) add()/remove() vs offer()/poll() vs element()/peek()
6) Time complexity: LinkedList/ArrayDeque (O(1) for add/remove at ends), PriorityQueue O(log n)
7) Iteration order in PriorityQueue: unpredictable
8) Max-heap: Comparator.reverseOrder()
9) Duplicates allowed in all Queue implementations
10) Prefer interfaces (Queue/Deque) in method signatures
*/

