package java_08_streams_advanced;

// GroupingPartitioning.java
// Java 8 Streams - groupingBy() vs partitioningBy()
// Basic to Deep Dive with Interview Focus ✅

import java.util.*;
import java.util.stream.Collectors;


public class GroupingPartitioning {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", 60000),
                new Employee(2, "Ravi", "HR", 40000),
                new Employee(3, "Neha", "IT", 75000),
                new Employee(4, "Priya", "Finance", 50000),
                new Employee(5, "Kiran", "HR", 45000)
        );

        // =====================================================
        // 1️⃣ groupingBy() – BASIC
        // =====================================================
        Map<String, List<Employee>> empByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.dept));

        System.out.println("Employees grouped by department:");
        System.out.println(empByDept);
        System.out.println();

        // =====================================================
        // 2️⃣ groupingBy() with counting()
        // =====================================================
        Map<String, Long> deptCount =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.dept,
                                Collectors.counting()
                        ));

        System.out.println("Employee count per department:");
        System.out.println(deptCount);
        System.out.println();

        // =====================================================
        // 3️⃣ groupingBy() with averagingDouble()
        // =====================================================
        Map<String, Double> avgSalaryByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.dept,
                                Collectors.averagingDouble(e -> e.salary)
                        ));

        System.out.println("Average salary per department:");
        System.out.println(avgSalaryByDept);
        System.out.println();

        // =====================================================
        // 4️⃣ groupingBy() with maxBy()
        // =====================================================
        Map<String, Optional<Employee>> highestPaidByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.dept,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(e -> e.salary)
                                )
                        ));

        System.out.println("Highest paid employee per department:");
        System.out.println(highestPaidByDept);
        System.out.println();

        // =====================================================
        // 5️⃣ partitioningBy() – BASIC
        // =====================================================
        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.salary > 50000
                        ));

        System.out.println("Partitioned by salary > 50000:");
        System.out.println(salaryPartition);
        System.out.println();

        // =====================================================
        // 6️⃣ partitioningBy() with counting()
        // =====================================================
        Map<Boolean, Long> partitionCount =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.salary > 50000,
                                Collectors.counting()
                        ));

        System.out.println("Count in each salary partition:");
        System.out.println(partitionCount);
    }
}

/*
=================================================
THEORY – VERY IMPORTANT (Interview Gold)
=================================================

1️⃣ groupingBy()
----------------
- Groups elements based on a KEY
- Can have multiple groups
- Returns: Map<K, List<T>>

Example:
Department -> Employees

Use when:
✔ Multiple categories
✔ Classification problems

2️⃣ partitioningBy()
--------------------
- Special case of grouping
- Condition MUST return boolean
- Always creates TWO groups (true & false)
- Returns: Map<Boolean, List<T>>

Use when:
✔ Yes/No conditions
✔ Pass/Fail, Eligible/Not Eligible

=================================================
groupingBy vs partitioningBy (MOST ASKED)
=================================================

groupingBy:
- Multiple keys
- Flexible
- Map<String, List<T>>

partitioningBy:
- Only boolean
- Always two groups
- Map<Boolean, List<T>>

=================================================
COMMON MISTAKES
=================================================
❌ Using partitioningBy when groupingBy is needed
❌ Forgetting downstream collectors
❌ Assuming partitioningBy can create more than 2 groups

=================================================
INTERVIEW QUESTIONS
=================================================

Q1. Is partitioningBy internally using groupingBy?
👉 Yes, partitioningBy is a special form of groupingBy.

Q2. Can groupingBy handle duplicate keys?
👉 Yes, it groups them into List.

Q3. Return type of groupingBy?
👉 Map<K, List<T>>

Q4. Return type of partitioningBy?
👉 Map<Boolean, List<T>>

Q5. Which is faster?
👉 partitioningBy (simpler logic, boolean key)

=================================================
REAL-TIME USE CASES
=================================================
✔ Group employees by department
✔ Partition students by pass/fail
✔ Group orders by status
✔ Partition users by active/inactive
*/

