package java_8_features;

// FunctionalInterfaces.java
// Java 8 Functional Interfaces - Deep Dive ✅

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface MyFunctional {
    void doSomething();
}

public class FunctionalInterfaces {

    public static void main(String[] args) {

        // =========================================================
        // Using Custom Functional Interface
        // =========================================================
        MyFunctional f = () -> System.out.println("Doing something...");
        f.doSomething();

        // =========================================================
        // Using Built-in Functional Interfaces
        // =========================================================
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Java': " + stringLength.apply("Java"));
    }
}

/*
Interview Tips:
1) A functional interface has exactly one abstract method.
2) Can have multiple default or static methods.
3) Examples: Runnable, Callable, Comparator, Consumer, Function, Predicate, Supplier.
*/

