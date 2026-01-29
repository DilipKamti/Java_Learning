package java_08_streams_advanced;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return name + " (" + dept + ", " + salary + ")";
    }
}

public class StreamCollectors {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", 60000),
                new Employee(2, "Ravi", "HR", 40000),
                new Employee(3, "Neha", "IT", 75000),
                new Employee(4, "Priya", "Finance", 50000),
                new Employee(5, "Kiran", "HR", 45000)
        );

        // =====================================================
        // 1️⃣ collect() – Convert Stream to List
        // =====================================================
        List<String> names = employees.stream()
                .map(e -> e.name)
                .collect(Collectors.toList());
        System.out.println("Names: " + names);

        // =====================================================
        // 2️⃣ toSet()
        // =====================================================
        Set<String> departments = employees.stream()
                .map(e -> e.dept)
                .collect(Collectors.toSet());
        System.out.println("Departments: " + departments);

        // =====================================================
        // 3️⃣ toMap()
        // =====================================================
        Map<Integer, String> empMap = employees.stream()
                .collect(Collectors.toMap(e -> e.id, e -> e.name));
        System.out.println("Employee Map: " + empMap);

        // =====================================================
        // 4️⃣ groupingBy()
        // =====================================================
        Map<String, List<Employee>> empByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(e -> e.dept));
        System.out.println("Employees by Dept: " + empByDept);

        // =====================================================
        // 5️⃣ counting()
        // =====================================================
        Map<String, Long> deptCount =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.dept,
                                Collectors.counting()
                        ));
        System.out.println("Dept Count: " + deptCount);

        // =====================================================
        // 6️⃣ summingDouble()
        // =====================================================
        double totalSalary =
                employees.stream()
                        .collect(Collectors.summingDouble(e -> e.salary));
        System.out.println("Total Salary: " + totalSalary);

        // =====================================================
        // 7️⃣ averagingDouble()
        // =====================================================
        double avgSalary =
                employees.stream()
                        .collect(Collectors.averagingDouble(e -> e.salary));
        System.out.println("Average Salary: " + avgSalary);

        // =====================================================
        // 8️⃣ maxBy() / minBy()
        // =====================================================
        Optional<Employee> maxSalaryEmp =
                employees.stream()
                        .collect(Collectors.maxBy(
                                Comparator.comparingDouble(e -> e.salary)
                        ));
        System.out.println("Max Salary Employee: " + maxSalaryEmp.get());

        // =====================================================
        // 9️⃣ joining()
        // =====================================================
        String joinedNames =
                employees.stream()
                        .map(e -> e.name)
                        .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + joinedNames);

        // =====================================================
        // 🔟 partitioningBy()
        // =====================================================
        Map<Boolean, List<Employee>> salaryPartition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.salary > 50000
                        ));
        System.out.println("Salary Partition: " + salaryPartition);
    }
}
