package java_08_streams_advanced.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private boolean active;

    public Employee(int id, String name, String department, double salary, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}

public class StreamQuestions {

     static void main(){
        List<Integer> numbers = List.of(10,55,60,30,80,-2,1,2,20,5,90,3,4,400,5,-1,798,6,7,8,5,8,12,3,20,15,101);
        List<Integer> numbers2= List.of(20,5,90,3,4,400);
        List<String> names= List.of("Alice", "Bob", "Charlie", "David","Apple","  ","", "Eve", "Frank", "Grace","Avocado", "Heidi", "Ivan", "Judy", "Karl", "Leo", "Mallory", "Nina", "Oscar", "Peggy", "Quentin", "Rupert", "Sybil", "Trent");
        String sentence="stress";
         List<List<Integer>> listOfLists = List.of(
                 List.of(1, 2, 3),
                 List.of(4, 5),
                 List.of(6, 7, 8),
                 List.of(9)
         );

         Map<String,Integer> map = Map.of(
                 "A", 50,
                 "B", 20,
                 "C", 70,
                 "D", 10
         );

         List<String> words = List.of("eat","tea","tan","ate","nat","bat");

        List<Employee> employees = Arrays.asList(

                new Employee(1, "Amit", "IT", 60000, 28, true),
                new Employee(2, "John", "HR", 45000, 32, true),
                new Employee(3, "Sara", "Finance", 70000, 30, true),
                new Employee(4, "David", "IT", 55000, 35, false),
                new Employee(5, "Priya", "HR", 65000, 27, true),
                new Employee(6, "Rahul", "Finance", 50000, 29, false),
                new Employee(7, "Neha", "IT", 75000, 31, true),
                new Employee(8, "Arjun", "Marketing", 48000, 26, true),
                new Employee(9, "Sneha", "Marketing", 52000, 33, true),
                new Employee(10, "Karan", "IT", 80000, 38, false)

        );


        //1. Given a list of integers, filter **even numbers**.
        System.out.println(numbers.stream().filter(x-> x%2==0).toList());

        //2. Filter **numbers greater than 10** from a list.
        System.out.println(numbers.stream().filter(x-> x>10).toList());

        //3. From a list of strings, filter strings that **start with "A"**.
        System.out.println(names.stream().filter(name-> name.startsWith("A")).toList());

        //4. Filter **non-empty strings** from a list.
        System.out.println(names.stream().filter(name-> !name.isBlank()).toList());

        //5. From a list of employees, filter employees **with salary > 50,000**.
        System.out.println(employees.stream().filter(employee -> employee.getSalary()>5000).toList());
        System.out.println("============================== 1 ================================");

        //6. Convert a list of strings to **uppercase**.
        System.out.println(names.stream().map(String::toUpperCase).toList());

        //7. Convert a list of integers to **their squares**.
        System.out.println(numbers.stream().map(number-> Math.pow(number,2)).toList());

        //8. Extract **names from a list of Employee objects**.
        System.out.println(employees.stream().map(Employee::getName).toList());

        //9. Convert list of strings to **their lengths**.
        System.out.println(names.stream().map(String::length).toList());

        //10. Add **10 to every number in the list**.
        System.out.println(numbers.stream().map(number-> number+10).toList());
        System.out.println("============================== 2 ================================");

        //11. Sort a list of integers **ascending**.(Ways)
        System.out.println(numbers.stream().sorted().toList());
        System.out.println(numbers.stream()
                .sorted(Comparator.comparingInt(a -> a))
                .toList());
        System.out.println(numbers.stream()
                .sorted(Integer::compare)
                .toList());

        //12. Sort a list of integers **descending**.(Ways)
        System.out.println(numbers.stream().sorted().toList().reversed());
        System.out.println(numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList());
        System.out.println(numbers.stream()
                .sorted((a, b) -> b - a)
                .toList());
        System.out.println(numbers.stream()
                .sorted((a, b) -> Integer.compare(b, a))
                .toList());

        //13. Sort list of strings **alphabetically**.
        System.out.println(names.stream().sorted().toList());

        //14. Sort employees by **salary**.
        System.out.println(employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList());

        //15. Sort employees by **name**.
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getName)).toList());
        System.out.println("============================== 3 ================================");

        //16. Remove **duplicate numbers** from a list.
        System.out.println(numbers.stream().distinct().sorted().toList());

        //17. Get **first 5 elements** from a list.
        System.out.println(numbers.stream().distinct().sorted().limit(5).toList());

        //18. Skip **first 3 numbers** from a list.
        System.out.println(numbers.stream().distinct().sorted().skip(3).toList());

        //19. Get **top 3 highest numbers**.
        System.out.println(numbers.stream().sorted((a,b)->Integer.compare(b,a)).distinct().limit(3).toList());

        //20. Get **second highest number**.
        System.out.println(numbers.stream().sorted((a,b)->Integer.compare(b,a)).distinct().limit(2).skip(1).toList());
        System.out.println("============================== 4 ================================");

        //21. Count numbers **greater than 50**.
        System.out.println(numbers.stream().filter(number-> number>50).count());

        //22. Find **maximum number** in list.
        System.out.println(numbers.stream().max(Integer::compare).get());

        //23. Find **minimum number** in list.
        System.out.println(numbers.stream().min(Integer::compare).get());

        //24. Find employee with **the highest salary**.
        System.out.println(employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get());

        //25. Find employee with **the lowest salary**.
        System.out.println(employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).get());
        System.out.println("============================== 5 ================================");

        //26. Find **sum of all numbers** using `reduce`.
        System.out.println(numbers.stream().reduce(Integer::sum).get());

        //27. Find **product of numbers**.
        System.out.println(numbers.stream().mapToLong(Integer::longValue).reduce(1L, (a,b)->a*b));

        //28. Find **maximum number using reduce**.
        System.out.println(numbers.stream().reduce((a, b) -> a > b ? a : b).get());

        //29. Concatenate all strings in a list.
        System.out.println(names.stream().reduce("",(a,b)->(a+b)));

        //30. Find **total salary of employees**.
        System.out.println(employees.stream().map(Employee::getSalary).reduce(Double::sum).get());
        System.out.println("============================== 6 ================================");

        //31. Check if **any number > 100**.
        System.out.println(numbers.stream().anyMatch(number -> number>100));

        //32. Check if **all numbers are positive**.
        System.out.println(numbers.stream().allMatch(number-> number>0));

        //33. Check if **none of the numbers are negative**.
        System.out.println(numbers.stream().noneMatch(number-> number<0));

        //34. Check if **any employee salary > 1 lakh**.
        System.out.println(employees.stream().anyMatch(employee -> employee.getSalary()>100000));

        //35. Check if **all employees are active**.
        System.out.println(employees.stream().allMatch(Employee::isActive));
        System.out.println("============================== 7 ================================");

        //36. Find **first element** in list.
        System.out.println(numbers.stream().findFirst().orElse(null));

        //37. Find **any element** from stream.
         numbers.stream().findAny().ifPresent(System.out::println);

        //38. Find **first employee with salary > 50k**.
         System.out.println(employees.stream().filter(employee -> employee.getSalary()>50000).findFirst().orElse(null));
         System.out.println("============================== 8 ================================");

         //39. Group employees by **department**.
         System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)));

         //40. Group numbers by **even and odd**.
         System.out.println(numbers.stream().collect(Collectors.partitioningBy(number-> number%2==0)));

         //41. Group strings by **their length**.
         System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));

         //42. Count employees in each department.
         System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())));

         //43. Find **the highest salary in each department**.
         System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))));

         /*
         *  There are three types of GroupingBy collectors:
         * 1. groupingBy(classifier): This is the basic form of groupingBy. It takes a classifier function that determines how the elements are grouped.
         * The result is a Map where the keys are the result of the classifier function and the values are lists of elements that belong to each group
         * When to use : Use this when you just want to group elements and keep them as a List.
         *
         * 2. groupingBy(classifier, downstream): This form of groupingBy allows you to specify a downstream collector that is applied to the elements in each group.
         * When to use : Use this when you want to perform additional operations on the grouped elements, such as counting, averaging, or finding the maximum.
         * Example : employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
         *
         * 3. groupingBy(classifier, supplier, downstream): This form of groupingBy allows you to specify a supplier for the Map that will hold the results, as well as a downstream collector.
         * When to use : Use this when you want to customize the type of Map used for grouping (e.g., TreeMap, LinkedHashMap) or when you want to perform additional operations on the grouped elements.
         * Example : employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
         *
         * */

         System.out.println("============================== 9 ================================");

         //44. Partition numbers into **even and odd**.
         System.out.println(numbers.stream().collect(Collectors.partitioningBy(number-> number%2==0)));

         //45. Partition employees based on **salary > 50k**.
         System.out.println(employees.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary()>50000)));

         System.out.println("============================== 10 ================================");

         //46. Join list of strings into **single string separated by comma**.
         System.out.println(names.stream().collect(Collectors.joining(",")));

         //47. Convert stream to **Set**.
         System.out.println(numbers.stream().collect(Collectors.toSet()));

         //48. Convert stream to **Map**.
         System.out.println(employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName)));

         //49. Get **average of numbers**.
         System.out.println(numbers.stream().collect(Collectors.averagingInt(Integer::intValue)));

         //50. Get **summary statistics of numbers**.
         IntSummaryStatistics stats =
                 numbers.stream()
                         .mapToInt(Integer::intValue)
                         .summaryStatistics();

         System.out.println(stats);

         System.out.println("============================== 11 ================================");

         //51. Find **duplicate elements** in list.
         System.out.println(numbers.stream()
                 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                 .entrySet()
                 .stream()
                 .filter(n-> n.getValue()>1)
                 .map(Map.Entry::getKey)
                 .toList());

         //52. Find **first non-repeated character in string**.
         System.out.println(sentence.chars()
                 .mapToObj(c -> (char) c)
                 .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                 .entrySet().stream()
                 .filter(n->n.getValue()==1)
                 .map(Map.Entry::getKey)
                 .findFirst()
                 .orElse(null));

         //53. Find **frequency of each character in string**.
         Map<Character, Long> freq =
                 sentence.chars()
                         .mapToObj(c -> (char) c)
                         .collect(Collectors.groupingBy(
                                 Function.identity(),
                                 Collectors.counting()
                         ));

         System.out.println(freq);

         //54. Find **top 3 highest salaries**.
         System.out.println(employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                 .limit(3)
                 .map(Employee::getSalary)
                 .toList());

         //55. Find **second-highest number in array**.
         numbers.stream()
                         .distinct()
                         .sorted(Comparator.reverseOrder())
                         .skip(1)
                         .findFirst().ifPresent(System.out::println);

         //56. Find **longest string in list**.
         System.out.println(names.stream().max(Comparator.comparing(String::length)).get());

         //57. Find **employee with the highest salary per department**.
         System.out.println(
                 employees.stream()
                         .collect(Collectors.groupingBy(
                                 Employee::getDepartment,
                                 Collectors.collectingAndThen(
                                         Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                         Optional::get
                                 )
                         ))
         );

         // Not full object only highest salary
         System.out.println(
                 employees.stream()
                         .collect(Collectors.groupingBy(
                                 Employee::getDepartment,
                                 Collectors.collectingAndThen(
                                         Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                         e -> e.get().getSalary()
                                 )
                         ))
         );

         //58. Flatten **list of lists into single list**.
         System.out.println(listOfLists.stream().flatMap(List::stream).toList());

         //59. Convert **List<Employee> → Map<Department, List<Employee>>**.
         System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)));

         //60. Sort employees by **salary then name**.
         System.out.println(employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName)).toList());

         System.out.println("============================== 12 ================================");

         //61. Find **kth largest element using streams**.
         System.out.println(numbers.stream().sorted((a,b)->Integer.compare(b,a)).skip(3-1).findFirst().orElse(0));

         //62. Merge two lists and remove duplicates.
         //1st ways
         System.out.println(Stream.concat(numbers.stream(),numbers2.stream()).distinct().toList());

         //2nd way
         System.out.println(Stream.of(numbers,numbers2).flatMap(List::stream).distinct().toList());

         //63. Find **common elements between two lists**.
         System.out.println(numbers.stream().filter(numbers2::contains).distinct().toList());

         //64. Find **difference between two lists**.
         System.out.println(numbers.stream().filter(n-> !numbers2.contains(n)).distinct().toList());

         //65. Convert list to **Map with duplicate keys handling**.
         System.out.println(
                 employees.stream()
                         .collect(Collectors.groupingBy(
                                 Employee::getDepartment,
                                 Collectors.mapping(Employee::getName, Collectors.toList())
                         ))
         );

         //66. Find **most frequent element in list**.
         System.out.println(
                 numbers.stream()
                         .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                         .entrySet()
                         .stream()
                         .max(Map.Entry.comparingByValue())
                         .map(Map.Entry::getKey)
                         .orElse(null)
         );

         //67. Group anagrams using streams.
         System.out.println(
                 words.stream()
                         .collect(Collectors.groupingBy(
                                 word -> {
                                     char[] ch = word.toCharArray();
                                     Arrays.sort(ch);
                                     return new String(ch);
                                 }
                         ))
                         .values()
         );

         //68. Find **first repeating element**.
         Set<Integer> seen = new HashSet<>();

         System.out.println(
                 numbers.stream()
                         .filter(n -> !seen.add(n))
                         .findFirst()
                         .orElse(null)
         );

         //69. Sort map by **value using streams**.


         System.out.println(
                 map.entrySet()
                         .stream()
                         .sorted(Map.Entry.comparingByValue())
                         .collect(Collectors.toMap(
                                 Map.Entry::getKey,
                                 Map.Entry::getValue,
                                 (e1,e2)->e1,
                                 LinkedHashMap::new
                         ))
         );

         //70. Convert **Map → Sorted Map using streams**.

         System.out.println(
                 map.entrySet()
                         .stream()
                         .sorted(Map.Entry.comparingByKey())
                         .collect(Collectors.toMap(
                                 Map.Entry::getKey,
                                 Map.Entry::getValue,
                                 (e1,e2)->e1,
                                 LinkedHashMap::new
                         ))
         );







    }

}
