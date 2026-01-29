package java_05_collections.comparator_comparable;

// InterviewQuestions.java
// Java Interview Questions - Quick Reference ✅
// Covers: OOP, Collections, Exception Handling, Threads, Java 8+, and general core Java topics

public class InterviewQuestions {

    /*
    =========================================================
    1) OOP Concepts
    =========================================================
    Q1) What are the main OOP concepts in Java?
    - Encapsulation, Inheritance, Polymorphism, Abstraction

    Q2) Difference between overloading and overriding?
    - Overloading: same method name, different parameters, compile-time polymorphism
    - Overriding: same method signature in subclass, runtime polymorphism

    Q3) Can constructors be overridden?
    - No, only overloaded

    Q4) Difference between abstract class and interface?
    - Abstract class: can have fields, constructors, methods
    - Interface: only abstract methods (before Java 8), default/static methods (Java 8+)

    Q5) Diamond problem in Java?
    - Multiple inheritance of behavior via interfaces can cause conflicts
    - Resolved using default methods and explicit implementation

    =========================================================
    2) Exception Handling
    =========================================================
    Q6) Difference between checked and unchecked exceptions?
    - Checked: must be handled or declared (IOException)
    - Unchecked: RuntimeException, optional handling

    Q7) Difference between throw and throws?
    - throw: throw a single exception instance
    - throws: declares exception(s) in method signature

    Q8) Can finally block be skipped?
    - Only if System.exit() is called or JVM crashes

    Q9) Custom exceptions?
    - Extend Exception (checked) or RuntimeException (unchecked)

    =========================================================
    3) Collections Framework
    =========================================================
    Q10) Difference between List, Set, Queue?
    - List: ordered, allows duplicates
    - Set: unordered, no duplicates
    - Queue: FIFO, can be priority-based

    Q11) Difference between HashMap, LinkedHashMap, TreeMap, Hashtable, ConcurrentHashMap?
    - HashMap: unordered, 1 null key, multiple null values, not synchronized
    - LinkedHashMap: insertion/order or access order, 1 null key, multiple null values
    - TreeMap: sorted by key, no null key
    - Hashtable: synchronized, no null key/value
    - ConcurrentHashMap: thread-safe, no null key/value, better than Hashtable

    Q12) Difference between Comparable and Comparator?
    - Comparable: natural order, implements compareTo()
    - Comparator: custom order, multiple ways, external

    Q13) How to implement LRU cache using LinkedHashMap?
    - Constructor with accessOrder=true + override removeEldestEntry()

    =========================================================
    4) Java 8+ Features
    =========================================================
    Q14) What is Lambda expression?
    - Anonymous function, concise syntax for functional interfaces

    Q15) What is Stream API?
    - Functional-style operations on collections: filter, map, reduce, etc.

    Q16) Default and static methods in interface?
    - Default: provide default implementation
    - Static: accessible via interface name

    Q17) Optional class usage?
    - Avoid NullPointerException, represents optional value

    Q18) Functional interfaces?
    - Interface with single abstract method: Runnable, Comparator, Predicate

    =========================================================
    5) Threads & Concurrency
    =========================================================
    Q19) Difference between Thread and Runnable?
    - Thread: extend Thread class
    - Runnable: implement Runnable interface

    Q20) Difference between synchronized and Lock?
    - synchronized: block-level or method-level lock
    - Lock: more flexible, explicit lock/unlock

    Q21) Difference between wait(), notify(), notifyAll()?
    - wait(): release lock and wait
    - notify(): wakes one waiting thread
    - notifyAll(): wakes all waiting threads

    Q22) Difference between HashMap and ConcurrentHashMap?
    - HashMap: not thread-safe
    - ConcurrentHashMap: thread-safe, better concurrency than Hashtable

    =========================================================
    6) String & Wrapper Classes
    =========================================================
    Q23) Difference between String, StringBuilder, StringBuffer?
    - String: immutable
    - StringBuilder: mutable, not synchronized
    - StringBuffer: mutable, synchronized

    Q24) Auto-boxing and unboxing?
    - Conversion between primitive and wrapper automatically

    Q25) Why Wrapper classes are used?
    - To use primitives in Collections, utility methods, type conversion

    =========================================================
    7) Misc Core Java
    =========================================================
    Q26) Difference between == and equals()?
    - == : reference equality
    - equals(): content equality (override in class)

    Q27) Difference between final, finally, and finalize()?
    - final: keyword (class, method, variable)
    - finally: block for cleanup
    - finalize(): method called by GC before object removal

    Q28) What are immutable classes? Example?
    - Objects whose state cannot change after creation
    - Example: String, wrapper classes

    Q29) Difference between shallow copy and deep copy?
    - Shallow: copies object reference
    - Deep: copies object content

    =========================================================
    8) Tips & Tricks for Interviews
    =========================================================
    - Always mention time complexity
    - Be clear about null handling in collections
    - Understand thread-safety and synchronization differences
    - Know OOP concepts and Java 8 features well
    - Be able to write short code snippets quickly

    */

    public static void main(String[] args) {
        System.out.println("========== Java Interview Questions ==========");
        System.out.println("Refer comments in the code for a comprehensive list of Q&A.");
    }
}

