package java_05_collections.comparator_comparable;

// ComparableDemo.java
// Java Comparable Interface - Deep Dive ✅
// Covers: natural ordering, compareTo(), sorting collections, interview tips

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // =========================================================
    // 1) Implement compareTo() for natural ordering
    // =========================================================
    /*
        - This defines natural order for the class
        - Must return:
            negative if this < other
            0 if this == other
            positive if this > other
    */
    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // ascending order by age
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

public class ComparableDemo {

    // =========================================================
    // 2) Sorting using Comparable
    // =========================================================
    static void sortingDemo() {
        System.out.println("----- Sorting with Comparable -----");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 25));

        System.out.println("Before sorting: " + students);

        Collections.sort(students); // uses compareTo() method
        System.out.println("After sorting by age (ascending): " + students);
    }

    // =========================================================
    // 3) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Comparable defines natural ordering of objects
        ✅ Must implement compareTo() method
        ✅ Only one natural ordering per class
        ✅ Can be used with Collections.sort() or Arrays.sort()
        ✅ Return value:
            - negative: this < other
            - 0: this == other
            - positive: this > other
        ✅ For descending order, use Comparator.reverseOrder() or custom Comparator
        ✅ Use Integer.compare(a, b) or Double.compare(a, b) for safety
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Comparable Demo ==========\n");

        sortingDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Comparable and Comparator?
- Comparable: defines natural order, class must implement Comparable
- Comparator: defines external/custom order, separate class

2) How to sort list of objects by age using Comparable?
- Implement compareTo() method comparing age
- Use Collections.sort(list)

3) Can we have multiple natural orders?
- No, only one compareTo() per class

4) What does compareTo() return?
- Negative, zero, or positive integer

5) Can Comparable be used for arrays?
- Yes, Arrays.sort(array) uses compareTo()

6) Why prefer Integer.compare(a,b) over subtraction?
- Avoid integer overflow
- Example: return Integer.compare(this.age, other.age)
*/

