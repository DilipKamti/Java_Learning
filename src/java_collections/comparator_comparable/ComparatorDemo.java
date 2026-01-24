package java_collections.comparator_comparable;

// ComparatorDemo.java
// Java Comparator Interface - Deep Dive ✅
// Covers: custom ordering, multiple criteria, lambda expressions, interview tips

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + "(" + age + ", $" + salary + ")";
    }
}

public class ComparatorDemo {

    // =========================================================
    // 1) Sorting with Comparator - Traditional
    // =========================================================
    static void traditionalComparatorDemo() {
        System.out.println("----- Sorting with Comparator (Traditional) -----");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 23, 50000));
        employees.add(new Employee("Bob", 21, 60000));
        employees.add(new Employee("Charlie", 25, 55000));

        // Sort by salary ascending
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.salary, e2.salary);
            }
        });

        System.out.println("Sorted by salary (ascending): " + employees);
    }

    // =========================================================
    // 2) Sorting with Comparator - Lambda Expression
    // =========================================================
    static void lambdaComparatorDemo() {
        System.out.println("----- Sorting with Comparator (Lambda) -----");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 23, 50000));
        employees.add(new Employee("Bob", 21, 60000));
        employees.add(new Employee("Charlie", 25, 55000));

        // Sort by age ascending
        employees.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        System.out.println("Sorted by age (ascending): " + employees);

        // Sort by name descending
        employees.sort((e1, e2) -> e2.name.compareTo(e1.name));
        System.out.println("Sorted by name (descending): " + employees);
    }

    // =========================================================
    // 3) Multiple Sorting Criteria
    // =========================================================
    static void multipleCriteriaDemo() {
        System.out.println("----- Multiple Sorting Criteria -----");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 23, 50000));
        employees.add(new Employee("Bob", 21, 50000));
        employees.add(new Employee("Charlie", 25, 55000));
        employees.add(new Employee("David", 23, 50000));

        // Sort by salary ascending, then age ascending
        employees.sort(Comparator.comparingDouble((Employee e) -> e.salary)
                .thenComparingInt(e -> e.age));

        System.out.println("Sorted by salary, then age: " + employees);
    }

    // =========================================================
    // 4) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Comparator allows multiple/custom orders for same class
        ✅ Can use lambda expressions or method references
        ✅ Use Comparator.comparing(), thenComparing() for readability
        ✅ Can sort by any attribute without modifying class
        ✅ Can reverse order using Comparator.reversed()
        ✅ Preferred when you need multiple sort logics
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Comparator Demo ==========\n");

        traditionalComparatorDemo();
        System.out.println();

        lambdaComparatorDemo();
        System.out.println();

        multipleCriteriaDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Comparable and Comparator?
- Comparable: defines natural order, class implements Comparable
- Comparator: defines custom order, can have multiple comparators

2) Can we sort by multiple criteria?
- Yes, using Comparator.thenComparing()

3) How to sort in descending order?
- Use Comparator.reversed() or reverse order in lambda

4) Can we use Comparator without modifying class?
- Yes, unlike Comparable, class doesn't need to implement anything

5) What are advantages of lambda expressions here?
- Concise, readable, avoids anonymous inner classes

6) How to sort list of objects by salary then name?
- employees.sort(Comparator.comparingDouble(Employee::getSalary)
                            .thenComparing(Employee::getName));
*/

