package java_05_collections.set;

// SetInterviewQuestions.java
// Java Set - Interview Questions & Tricks ✅
// Covers: HashSet, LinkedHashSet, TreeSet, tricky examples, tips, internal mechanics

import java.util.*;

public class SetInterviewQuestions {

    // =========================================================
    // 1) Basics
    // =========================================================
    /*
        Q1) Difference between Set, HashSet, LinkedHashSet, TreeSet?
        - Set: interface, no duplicates, unordered
        - HashSet: unordered, backed by HashMap
        - LinkedHashSet: maintains insertion order
        - TreeSet: sorted order, Red-Black tree, no null
    */
    static void q1Demo() {
        System.out.println("----- Q1: Set Implementations -----");

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("A"); hashSet.add("B"); hashSet.add("A");
        linkedHashSet.add("A"); linkedHashSet.add("B"); linkedHashSet.add("A");
        treeSet.add("B"); treeSet.add("A"); treeSet.add("C");

        System.out.println("HashSet (unordered): " + hashSet);
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
        System.out.println("TreeSet (sorted order): " + treeSet);
    }

    // =========================================================
    // 2) Nulls & Duplicates
    // =========================================================
    /*
        Q2) Can Set contain nulls or duplicates?
        - HashSet: one null allowed
        - LinkedHashSet: one null allowed
        - TreeSet: null NOT allowed (NullPointerException)
    */
    static void q2Demo() {
        System.out.println("----- Q2: Nulls & Duplicates -----");

        Set<String> hashSet = new HashSet<>();
        hashSet.add(null);
        hashSet.add(null); // duplicate ignored
        System.out.println("HashSet with null: " + hashSet);

        try {
            Set<String> treeSet = new TreeSet<>();
            treeSet.add(null); // throws NullPointerException
        } catch (Exception e) {
            System.out.println("TreeSet cannot contain null: " + e);
        }
    }

    // =========================================================
    // 3) Iteration & Removal
    // =========================================================
    /*
        Q3) How to safely remove elements while iterating?
        - Use Iterator's remove() method, NOT for-each loop
    */
    static void q3Demo() {
        System.out.println("----- Q3: Safe Removal -----");

        Set<String> set = new HashSet<>(Arrays.asList("Java", "Python", "C++"));

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("Python")) it.remove();
        }

        System.out.println("After safe removal: " + set);
    }

    // =========================================================
    // 4) Hashing & Equals
    // =========================================================
    /*
        Q4) Why hashCode() and equals() important in Set?
        - HashSet/LinkedHashSet use hashCode() to determine bucket
        - equals() ensures uniqueness of elements
        - Without proper hashCode/equals in custom objects, Set may allow duplicates
    */
    static void q4Demo() {
        System.out.println("----- Q4: Custom Object in Set -----");

        class Person {
            String name;
            Person(String name) { this.name = name; }
            // Uncomment these for proper behavior:
            // @Override public boolean equals(Object o) { ... }
            // @Override public int hashCode() { ... }
        }

        Set<Person> set = new HashSet<>();
        set.add(new Person("Alice"));
        set.add(new Person("Alice")); // duplicate? depends on hashCode/equals

        System.out.println("Set with custom objects (without hashCode/equals): " + set);
    }

    // =========================================================
    // 5) Tricky Examples
    // =========================================================
    static void trickyExamples() {
        System.out.println("----- Q5: Tricky Examples -----");

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10); hashSet.add(20); hashSet.add(10);
        System.out.println("HashSet ignores duplicates: " + hashSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(3); linkedHashSet.add(1); linkedHashSet.add(2);
        System.out.println("LinkedHashSet maintains insertion order: " + linkedHashSet);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5); treeSet.add(2); treeSet.add(8);
        System.out.println("TreeSet sorted order: " + treeSet);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Set Interview Questions ==========\n");

        q1Demo();
        System.out.println();

        q2Demo();
        System.out.println();

        q3Demo();
        System.out.println();

        q4Demo();
        System.out.println();

        trickyExamples();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Summary)
===============================

1) Difference between HashSet, LinkedHashSet, TreeSet?
2) Can Set contain nulls and duplicates?
3) How to safely remove elements while iterating over Set?
4) Why hashCode() and equals() are important for Set?
5) Time complexity of add(), remove(), contains()?
6) Internal implementation of HashSet, LinkedHashSet, TreeSet?
7) Difference between insertion order vs sorted order in Set?
8) When to use HashSet vs LinkedHashSet vs TreeSet?
9) Can TreeSet contain null?
10) How to use custom sorting in TreeSet?
*/

