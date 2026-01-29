package java_07_8_features;

// LambdaExamples.java
// Java 8 Lambda Expressions - Deep Dive ✅

import java.util.Arrays;
import java.util.List;

public class LambdaExamples {

    public static void main(String[] args) {
        System.out.println("----- Lambda Expressions Demo -----");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Traditional for loop
        System.out.println("Traditional for loop:");
        for (String name : names) {
            System.out.println(name);
        }

        // Lambda expression
        System.out.println("\nLambda forEach:");
        names.forEach(name -> System.out.println(name));

        // Lambda with method reference
        System.out.println("\nLambda with method reference:");
        names.forEach(System.out::println);
    }
}

/*
Interview Tips:
1) Lambdas are used to implement functional interfaces.
2) Syntax: (parameters) -> expression/body
3) Can replace anonymous inner classes for cleaner code.
*/

