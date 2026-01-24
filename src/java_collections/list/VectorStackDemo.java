package java_collections.list;

// VectorStackDemo.java
// Java Vector & Stack - Deep Dive ✅
// Covers: legacy collection, synchronization, Stack operations, internal mechanics, interview questions

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class VectorStackDemo {

    // =========================================================
    // 1) Vector - Legacy Collection
    // =========================================================
    /*
        - Part of java.util, introduced before Java 2
        - Thread-safe (synchronized)
        - Dynamically resizable array
        - Maintains insertion order
        - Allows duplicates and null
        - Methods similar to ArrayList
        - Slightly slower than ArrayList due to synchronization
    */
    static void vectorDemo() {
        System.out.println("----- Vector Demo -----");

        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");
        vector.add("Java"); // duplicate allowed
        vector.add(null);   // null allowed

        System.out.println("Vector: " + vector);
        System.out.println("Size: " + vector.size());

        // Access elements
        System.out.println("Element at index 2: " + vector.get(2));

        // Iteration using for-loop
        System.out.println("Iterating using for-loop:");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }

        // Iteration using Enumeration (legacy)
        System.out.println("Iterating using Enumeration:");
        Enumeration<String> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        // Iteration using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> it = vector.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // =========================================================
    // 2) Stack - Legacy Class (LIFO)
    // =========================================================
    /*
        - Extends Vector
        - Last-In-First-Out (LIFO) behavior
        - Common methods: push(), pop(), peek(), empty(), search()
    */
    static void stackDemo() {
        System.out.println("----- Stack Demo -----");

        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");

        System.out.println("Stack: " + stack);

        // peek: look top element without removing
        System.out.println("Peek: " + stack.peek());

        // pop: remove top element
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // search: position from top (1-based)
        System.out.println("Position of 'Java': " + stack.search("Java"));

        // empty: check if stack is empty
        System.out.println("Is stack empty? " + stack.empty());
    }

    // =========================================================
    // 3) Key Differences
    // =========================================================
    /*
        Feature        | ArrayList      | Vector          | Stack
        -------------------------------------------------------------
        Thread-safe    | No             | Yes (synchronized)| Yes (extends Vector)
        Access         | O(1)           | O(1)            | O(1) (top element)
        Duplicate      | Yes            | Yes             | Yes
        Null allowed   | Yes            | Yes             | Yes
        Legacy?        | No             | Yes             | Yes
        Iterator       | Fail-fast      | Fail-fast       | Fail-fast
    */

    // =========================================================
    // 4) Tips & Tricks
    // =========================================================
    /*
        ✅ Prefer ArrayList over Vector for new projects (faster, non-synchronized)
        ✅ Use Stack for LIFO requirements, but consider Deque (ArrayDeque) in modern Java
        ✅ Enumeration is legacy, Iterator is preferred
        ✅ Vector doubles its capacity when exceeded (legacy growth)
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Vector & Stack Demo ==========\n");

        vectorDemo();
        System.out.println();

        stackDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between ArrayList and Vector?
- Vector is synchronized, ArrayList is not
- Vector is legacy, ArrayList is modern
- Performance: ArrayList faster

2) Why Stack extends Vector?
- Legacy design, Stack inherits synchronized behavior

3) Is Stack thread-safe?
- Yes, because Vector is synchronized

4) Can Vector store null?
- Yes, multiple nulls allowed

5) Difference between pop() and remove() in Stack?
- pop(): removes top element, throws EmptyStackException if empty
- remove(): inherited from Vector, remove by index

6) Why Enumeration is considered legacy?
- Introduced in JDK 1.0, lacks remove() method
- Iterator is modern alternative (fail-fast)
*/

