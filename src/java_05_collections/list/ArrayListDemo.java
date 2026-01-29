package java_05_collections.list;

// ArrayListDemo.java
// Java ArrayList - Basic to Deep Dive ✅
// Covers: creation, methods, iteration, internal mechanics, resizing, performance tips, interview Q&A

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    // =========================================================
    // 1) What is ArrayList?
    // =========================================================
    /*
        - Resizable array implementation of List interface
        - Part of java.util package
        - Maintains insertion order
        - Allows duplicates, allows null
        - Not synchronized (use Collections.synchronizedList() for thread safety)
        - Supports random access: get(index) is O(1)
    */

    // =========================================================
    // 2) Creating ArrayList
    // =========================================================
    static void createArrayListDemo() {
        System.out.println("----- ArrayList Creation -----");

        // Generic type ArrayList
        List<String> list = new ArrayList<>();

        // Adding elements
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Java"); // duplicates allowed
        list.add(null);   // null allowed

        System.out.println("ArrayList: " + list);

        // Adding element at specific index
        list.add(2, "JavaScript");
        System.out.println("After adding at index 2: " + list);
    }

    // =========================================================
    // 3) Accessing elements
    // =========================================================
    static void accessElementsDemo() {
        System.out.println("----- Accessing Elements -----");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "Python", "C++", "JavaScript");

        // get by index
        System.out.println("Element at index 2: " + list.get(2));

        // iterate using for-loop
        System.out.println("Iterating using for-loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        // iterate using enhanced for-loop
        System.out.println("Iterating using enhanced for-loop:");
        for (String s : list) {
            System.out.println(s);
        }

        // iterate using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // =========================================================
    // 4) Modifying elements
    // =========================================================
    static void modifyElementsDemo() {
        System.out.println("----- Modifying Elements -----");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "Python", "C++");

        // set(index, element)
        list.set(1, "Go");
        System.out.println("After set(1, 'Go'): " + list);

        // remove(element)
        list.remove("C++");
        System.out.println("After remove('C++'): " + list);

        // remove by index
        list.remove(0);
        System.out.println("After remove index 0: " + list);

        // contains
        System.out.println("Contains Go? " + list.contains("Go"));
    }

    // =========================================================
    // 5) Bulk Operations
    // =========================================================
    static void bulkOperationsDemo() {
        System.out.println("----- Bulk Operations -----");

        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "Java", "Python", "C++");

        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "Go", "Python");

        // addAll
        list1.addAll(list2);
        System.out.println("After addAll: " + list1);

        // removeAll
        list1.removeAll(list2);
        System.out.println("After removeAll(list2): " + list1);

        // retainAll
        list1.addAll(list2);
        list1.retainAll(list2);
        System.out.println("After retainAll(list2): " + list1);
    }

    // =========================================================
    // 6) ArrayList Internal Mechanics (Interview Favorite)
    // =========================================================
    /*
        - Internally backed by Object[] array
        - Default initial capacity = 10
        - When capacity exceeded, array grows: newCapacity = oldCapacity * 1.5
        - get(index) = O(1), add(element) amortized O(1)
        - add(index, element) = O(n) (elements shifted)
        - remove(index) = O(n) (elements shifted)
    */

    // =========================================================
    // 7) Tips & Tricks
    // =========================================================
    /*
        ✅ Use ArrayList for fast random access
        ✅ Use LinkedList if frequent insertions/deletions in middle
        ✅ Use Collections.unmodifiableList() for immutable list
        ✅ Use Collections.synchronizedList() for thread-safe list
        ✅ Avoid storing primitives directly (use wrapper classes)
        ✅ Always prefer generic type <T> to avoid ClassCastException
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== ArrayList Demo ==========\n");

        createArrayListDemo();
        System.out.println();

        accessElementsDemo();
        System.out.println();

        modifyElementsDemo();
        System.out.println();

        bulkOperationsDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Default capacity of ArrayList?
- 10 (resizable array)

2) Is ArrayList synchronized?
- No, not synchronized by default

3) Can ArrayList store null?
- Yes, multiple nulls allowed

4) Difference between ArrayList and LinkedList?
- ArrayList: fast random access, slow insertion/deletion in middle
- LinkedList: slow random access, fast insertion/deletion

5) Time complexity: get(), add(), remove()
- get(index): O(1)
- add(element): amortized O(1)
- add(index, element): O(n)
- remove(index): O(n)

6) How to make ArrayList thread-safe?
- Collections.synchronizedList(new ArrayList<>())

7) How does ArrayList grow internally?
- New capacity = oldCapacity * 1.5

8) Can ArrayList store primitives?
- No, use wrapper classes like Integer, Double, etc.
*/

