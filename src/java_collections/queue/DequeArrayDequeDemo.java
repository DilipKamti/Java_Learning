package java_collections.queue;

// DequeArrayDequeDemo.java
// Java Deque using ArrayDeque - Deep Dive ✅
// Covers: ArrayDeque, queue & stack operations, iteration, interview tips

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeArrayDequeDemo {

    // =========================================================
    // 1) What is Deque?
    // =========================================================
    /*
        - Deque = Double-Ended Queue
        - Allows insertion/removal from both ends
        - Implements Queue and Stack functionality
        - ArrayDeque is a resizable array implementation
        - Faster than LinkedList for queue operations
        - Not thread-safe
        - Null elements NOT allowed
    */

    // =========================================================
    // 2) Queue Operations (FIFO)
    // =========================================================
    static void queueOperationsDemo() {
        System.out.println("----- Deque as Queue (FIFO) -----");

        Deque<String> deque = new ArrayDeque<>();
        deque.offer("Java");   // add at end
        deque.offer("Python");
        deque.offer("C++");

        System.out.println("Deque: " + deque);

        System.out.println("Peek(): " + deque.peek());   // front element
        System.out.println("Poll(): " + deque.poll());   // remove front
        System.out.println("Deque after poll(): " + deque);
    }

    // =========================================================
    // 3) Stack Operations (LIFO)
    // =========================================================
    static void stackOperationsDemo() {
        System.out.println("----- Deque as Stack (LIFO) -----");

        Deque<String> stack = new ArrayDeque<>();
        stack.push("Java");    // add at front
        stack.push("Python");
        stack.push("C++");

        System.out.println("Stack: " + stack);

        System.out.println("Peek(): " + stack.peek());   // top element
        System.out.println("Pop(): " + stack.pop());     // remove top
        System.out.println("Stack after pop(): " + stack);
    }

    // =========================================================
    // 4) Iteration
    // =========================================================
    static void iterationDemo() {
        System.out.println("----- Iteration -----");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(10);
        deque.offer(20);
        deque.offer(30);

        System.out.println("Forward iteration:");
        for (Integer i : deque) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Iterator iteration:");
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    // =========================================================
    // 5) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ ArrayDeque is faster than LinkedList for Deque operations
        ✅ Can be used as Queue (FIFO) or Stack (LIFO)
        ✅ Null not allowed
        ✅ Methods:
            - addFirst()/addLast() or offerFirst()/offerLast()
            - removeFirst()/removeLast() or pollFirst()/pollLast()
            - getFirst()/getLast() or peekFirst()/peekLast()
        ✅ Avoid using legacy Stack class; prefer ArrayDeque for LIFO
        ✅ Iterators are fail-fast
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Deque using ArrayDeque Demo ==========\n");

        queueOperationsDemo();
        System.out.println();

        stackOperationsDemo();
        System.out.println();

        iterationDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Deque and Queue?
- Deque allows insertion/removal at both ends
- Queue allows insertion at rear and removal at front only

2) Can ArrayDeque contain null?
- No

3) Difference between push/pop and addFirst/removeFirst?
- push/pop = stack operations (LIFO)
- addFirst/removeFirst = deque operations (front end)

4) ArrayDeque vs LinkedList as Deque?
- ArrayDeque: faster, resizable array
- LinkedList: slower, uses nodes

5) Iteration order vs poll order?
- Iteration order: insertion order
- Poll/Pop: depends on method (FIFO/LIFO)

6) Why prefer ArrayDeque over Stack?
- Stack is legacy, synchronized, slower
- ArrayDeque is faster and modern
*/
