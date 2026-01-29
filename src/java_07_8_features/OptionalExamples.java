package java_07_8_features;

// OptionalExamples.java
// Java 8 Optional - Deep Dive ✅

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {

        Optional<String> nonEmpty = Optional.of("Hello");
        Optional<String> empty = Optional.empty();

        // Check presence
        System.out.println("nonEmpty isPresent? " + nonEmpty.isPresent());

        // Get value
        System.out.println("Value: " + nonEmpty.get());

        // orElse
        System.out.println("Value or default: " + empty.orElse("Default"));

        // ifPresent
        nonEmpty.ifPresent(val -> System.out.println("IfPresent: " + val));
    }
}

/*
Interview Tips:
1) Optional is used to avoid null checks.
2) Methods: isPresent(), get(), orElse(), orElseGet(), ifPresent(), map(), flatMap().
3) Don’t use Optional for fields; mainly for return types.
*/

