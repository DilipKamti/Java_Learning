package java_8_features;

// MethodReferences.java
// Java 8 Method References - Deep Dive ✅

import java.util.Arrays;
import java.util.List;

public class MethodReferences {

    public static void print(String s) {
        System.out.println("Print: " + s);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Lambda
        names.forEach(name -> System.out.println(name));

        // Static method reference
        names.forEach(MethodReferences::print);

        // Instance method reference
        MethodReferences mr = new MethodReferences();
        names.forEach(mr::instancePrint);

        // Constructor reference
        List<String> words = Arrays.asList("Java", "Python");
        words.stream().map(String::new).forEach(System.out::println);
    }

    public void instancePrint(String s) {
        System.out.println("Instance print: " + s);
    }
}

/*
Interview Tips:
1) Types: Static method reference, Instance method reference, Constructor reference.
2) Syntax: ClassName::staticMethod, object::instanceMethod, ClassName::new
3) Improves readability and concise code.
*/

