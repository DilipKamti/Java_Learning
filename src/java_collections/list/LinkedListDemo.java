package java_collections.list;

// LinkedListDemo.java
// Java LinkedList - Basic to Deep Dive ✅
// Covers: creation, methods, internal structure, differences vs ArrayList, tips, interview Q&A

import java.util.*;

public class LinkedListDemo {

    // =========================================================
    // 1) What is LinkedList?
    // =========================================================
    /*
        - Doubly linked list implementation of List & Deque interfaces
        - Maintains insertion order
        - Allows duplicates and null values
        - Not synchronized
        - Supports:
          ✅ List operations (add, get, remove)
          ✅ Queue operations (offer, poll, peek)
          ✅ Deque operations (addFirst, addLast, removeFirst, removeLast)
    */

    // =========================================================
    // 2) Creating LinkedList
    // =========================================================
    static void createLinkedListDemo() {
        System.out.println("----- LinkedList Creation -----");

        LinkedList<String> ll = new LinkedList<>();
        ll.add("Java");
        ll.add("Python");
        ll.add("C++");
        ll.add("Java"); // duplicates allowed
        ll.add(null);   // null allowed

        System.out.println("LinkedList: " + ll);

        // Adding at first and last
        ll.addFirst("Go");
        ll.addLast("JavaScript");
        System.out.println("After addFirst & addLast: " + ll);
    }

    // =========================================================
    // 3) Accessing elements
    // =========================================================
    static void accessElementsDemo() {
        System.out.println("----- Accessing Elements -----");

        LinkedList<String> ll = new LinkedList<>();
        Collections.addAll(ll, "Java", "Python", "C++");

        System.out.println("First element: " + ll.getFirst());
        System.out.println("Last element: " + ll.getLast());
        System.out.println("Element at index 1: " + ll.get(1));

        // Iterating using for-loop
        System.out.println("Iterating using for-loop:");
        for (int i = 0; i < ll.size(); i++) {
            System.out.println("Index " + i + ": " + ll.get(i));
        }

        // Iterating using enhanced for-loop
        System.out.println("Iterating using enhanced for-loop:");
        for (String s : ll) {
            System.out.println(s);
        }

        // Iterating using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> it = ll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // =========================================================
    // 4) Modifying elements
    // =========================================================
    static void modifyElementsDemo() {
        System.out.println("----- Modifying Elements -----");

        LinkedList<String> ll = new LinkedList<>();
        Collections.addAll(ll, "Java", "Python", "C++");

        ll.set(1, "Go");
        System.out.println("After set(1,'Go'): " + ll);

        ll.remove("C++");
        System.out.println("After remove('C++'): " + ll);

        ll.removeFirst();
        ll.removeLast();
        System.out.println("After removeFirst & removeLast: " + ll);
    }

    // =========================================================
    // 5) Queue/Deque operations
    // =========================================================
    static void dequeDemo() {
        System.out.println("----- Queue/Deque Operations -----");

        LinkedList<String> ll = new LinkedList<>();
        Collections.addAll(ll, "Java", "Python", "C++");

        // Queue methods
        ll.offer("Go"); // add at end
        System.out.println("After offer('Go'): " + ll);

        System.out.println("Poll: " + ll.poll()); // remove first
        System.out.println("After poll(): " + ll);

        System.out.println("Peek: " + ll.peek()); // first element
        System.out.println("After peek(): " + ll);

        // Deque methods
        ll.addFirst("Rust");
        ll.addLast("Kotlin");
        System.out.println("After addFirst & addLast: " + ll);

        System.out.println("removeFirst(): " + ll.removeFirst());
        System.out.println("removeLast(): " + ll.removeLast());
        System.out.println("After removeFirst & removeLast: " + ll);
    }

    // =========================================================
    // 6) Internal Mechanics (Interview Favorite)
    // =========================================================
    /*
        - Uses doubly linked nodes (Node<E> prev, E data, Node<E> next)
        - get(index) = O(n) (linear time)
        - add/remove at ends = O(1)
        - add/remove in middle = O(n) (need to traverse)
        - Iteration is efficient with Iterator
    */

    // =========================================================
    // 7) ArrayList vs LinkedList (Quick Comparison)
    // =========================================================
    /*
        Feature          | ArrayList      | LinkedList
        -------------------------------------------------
        Data structure   | Dynamic array  | Doubly linked list
        Random access    | O(1)           | O(n)
        Insert/Delete    | O(n)           | O(1) at ends, O(n) middle
        Memory overhead  | Less           | More (extra prev/next pointers)
        Iteration        | Faster         | Slower (if not iterator)
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== LinkedList Demo ==========\n");

        createLinkedListDemo();
        System.out.println();

        accessElementsDemo();
        System.out.println();

        modifyElementsDemo();
        System.out.println();

        dequeDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between ArrayList and LinkedList?
- ArrayList: fast random access, slow insertion/deletion
- LinkedList: fast insertion/deletion at ends, slow random access

2) Can LinkedList contain null values?
- Yes, multiple nulls allowed

3) Which interfaces does LinkedList implement?
- List, Queue, Deque

4) Which method adds element at end of queue?
- offer(), add()

5) Difference between poll() and remove()?
- poll(): returns null if empty
- remove(): throws NoSuchElementException if empty

6) Difference between peek() and getFirst()?
- peek(): returns null if empty
- getFirst(): throws NoSuchElementException if empty

7) Time complexity: get(index), addFirst(), addLast()
- get(index): O(n)
- addFirst(), addLast(): O(1)
*/

