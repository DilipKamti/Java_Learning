package java_collections.list;

// ListInterviewQuestions.java
// Java List - Interview Questions & Tricks ✅
// Covers: ArrayList, LinkedList, Vector, Stack, tips, tricky outputs, common mistakes

import java.util.*;

public class ListInterviewQuestions {

    // =========================================================
    // 1) Basics
    // =========================================================
    /*
        Q1) Difference between List, ArrayList, LinkedList, Vector?
        - List: interface, ordered, allows duplicates
        - ArrayList: dynamic array, fast random access, not synchronized
        - LinkedList: doubly linked list, fast insert/delete at ends, slow random access
        - Vector: synchronized, legacy, slower
    */

    static void q1Demo() {
        System.out.println("----- Q1: List Implementations -----");

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();

        arrayList.add("Java");
        linkedList.add("Python");
        vector.add("C++");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("Vector: " + vector);
    }

    // =========================================================
    // 2) Null and duplicates
    // =========================================================
    /*
        Q2) Can List contain nulls and duplicates?
        - Yes, all List implementations allow duplicates
        - null allowed in ArrayList, LinkedList, Vector
    */
    static void q2Demo() {
        System.out.println("----- Q2: Nulls and Duplicates -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("Java"); // duplicate
        list.add(null);   // null

        System.out.println("List: " + list);
    }

    // =========================================================
    // 3) Iteration tricks
    // =========================================================
    /*
        Q3) Difference between Iterator, ListIterator, enhanced for-loop?
        - Iterator: forward-only, remove() supported
        - ListIterator: forward & backward, add/set/remove supported
        - Enhanced for-loop: internally uses Iterator, read-only (cannot modify list)
    */
    static void q3Demo() {
        System.out.println("----- Q3: Iteration -----");

        List<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));

        System.out.println("Using Iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Using ListIterator (forward & backward):");
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println("Forward: " + lit.next());
        }
        while (lit.hasPrevious()) {
            System.out.println("Backward: " + lit.previous());
        }

        System.out.println("Using enhanced for-loop:");
        for (String s : list) {
            System.out.println(s);
        }
    }

    // =========================================================
    // 4) Common Tricky Output Questions
    // =========================================================
    static void trickyOutputs() {
        System.out.println("----- Q4: Tricky Output Examples -----");

        // Example 1: remove while iterating
        List<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
        System.out.println("Original List: " + list);

        // Wrong way: causes ConcurrentModificationException
        // for(String s : list) {
        //     if(s.equals("Python")) list.remove(s);
        // }

        // Correct way: using Iterator
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("Python")) it.remove();
        }
        System.out.println("After removing 'Python' safely: " + list);

        // Example 2: get vs set index
        list.add("Go");
        list.add("Rust");
        System.out.println("List after add: " + list);
        list.set(1, "Kotlin");
        System.out.println("After set(1,'Kotlin'): " + list);
    }

    // =========================================================
    // 5) ArrayList vs LinkedList vs Vector quick tips
    // =========================================================
    static void tipsDemo() {
        System.out.println("----- Q5: Quick Tips -----");

        System.out.println("ArrayList: Fast random access, slower insertion/deletion in middle");
        System.out.println("LinkedList: Fast insertion/deletion at ends, slower random access");
        System.out.println("Vector: Synchronized, use ArrayList in modern code");
        System.out.println("Stack: Legacy, use Deque(ArrayDeque) for LIFO in modern code");
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== List Interview Questions ==========\n");

        q1Demo();
        System.out.println();

        q2Demo();
        System.out.println();

        q3Demo();
        System.out.println();

        trickyOutputs();
        System.out.println();

        tipsDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Summary)
===============================

1) Difference between List, ArrayList, LinkedList, Vector?
2) Can List contain null or duplicates?
3) Difference between Iterator, ListIterator, enhanced for-loop?
4) ArrayList vs LinkedList: when to use which?
5) What happens if we remove element while using for-each loop?
6) ArrayList growth mechanism? (oldCapacity*1.5)
7) Thread-safety of ArrayList, LinkedList, Vector?
8) Difference between Stack and Deque for LIFO?
9) Time complexity of get(), add(), remove() in ArrayList and LinkedList?
10) Is List synchronized by default?
*/

