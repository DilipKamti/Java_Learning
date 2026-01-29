package java_07_8_features;

// StreamsBasics.java
// Java 8 Streams Basics - Deep Dive ✅

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsBasics {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Filter even numbers
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);

        // Map: square of numbers
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Reduce: sum of numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}

/*
Interview Tips:
1) Stream operations: filter, map, sorted, distinct, reduce, collect, forEach.
2) Streams are lazy; terminal operations trigger execution.
3) Use method references (::) for cleaner code.
*/

