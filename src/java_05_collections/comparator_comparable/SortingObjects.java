package java_05_collections.comparator_comparable;

// SortingObjects.java
// Java Sorting Objects - Deep Dive ✅
// Demonstrates Comparable (natural order) and Comparator (custom order)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// =========================================================
// 1) Class implementing Comparable (Natural Ordering)
// =========================================================
class Students implements Comparable<Students> {
    String name;
    int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Natural order by age
    @Override
    public int compareTo(Students other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

// =========================================================
// 2) Class without Comparable (Custom Sorting using Comparator)
// =========================================================
class Employees {
    String name;
    int age;
    double salary;

    public Employees(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "(" + age + ", $" + salary + ")";
    }
}

public class SortingObjects {

    // =========================================================
    // 3) Sorting Studentss using Comparable
    // =========================================================
    static void sortStudentssDemo() {
        System.out.println("----- Sorting Studentss (Comparable) -----");

        List<Students> Studentss = new ArrayList<>();
        Studentss.add(new Students("Alice", 23));
        Studentss.add(new Students("Bob", 21));
        Studentss.add(new Students("Charlie", 25));

        System.out.println("Before sorting: " + Studentss);

        Collections.sort(Studentss); // uses compareTo()
        System.out.println("After sorting by age: " + Studentss);
    }

    // =========================================================
    // 4) Sorting Employeess using Comparator
    // =========================================================
    static void sortEmployeessDemo() {
        System.out.println("----- Sorting Employeess (Comparator) -----");

        List<Employees> Employeess = new ArrayList<>();
        Employeess.add(new Employees("Alice", 23, 50000));
        Employeess.add(new Employees("Bob", 21, 60000));
        Employeess.add(new Employees("Charlie", 25, 55000));

        // Sort by salary ascending
        Employeess.sort(Comparator.comparingDouble(e -> e.salary));
        System.out.println("Sorted by salary: " + Employeess);

        // Sort by name descending
        Employeess.sort((e1, e2) -> e2.name.compareTo(e1.name));
        System.out.println("Sorted by name descending: " + Employeess);

        // Sort by salary then age
        Employeess.sort(Comparator.comparingDouble((Employees e) -> e.salary)
                .thenComparingInt(e -> e.age));
        System.out.println("Sorted by salary then age: " + Employeess);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Sorting Objects Demo ==========\n");

        sortStudentssDemo();
        System.out.println();

        sortEmployeessDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) When to use Comparable vs Comparator?
- Comparable: single natural order, class implements Comparable
- Comparator: multiple/custom orders, external to class

2) How to sort by multiple fields?
- Use Comparator.thenComparing() or lambda expressions

3) How to sort in descending order?
- Use Comparator.reversed() or reverse in lambda

4) Can we sort objects without modifying class?
- Yes, use Comparator

5) Difference between Collections.sort(list) and list.sort(comparator)?
- Collections.sort(list): legacy, uses Comparable by default
- list.sort(comparator): modern, accepts Comparator
*/

