package java_05_collections.collections_class;

// UnmodifiableCollections.java
// Java Unmodifiable Collections - Deep Dive ✅
// Covers: creating read-only collections, examples, and interview tips

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class UnmodifiableCollections {

    // =========================================================
    // 1) Why Unmodifiable Collections?
    // =========================================================
    /*
        - Protect collection from modification
        - Useful for thread-safety, API design, or constants
        - Any attempt to modify throws UnsupportedOperationException
    */

    // =========================================================
    // 2) Creating Unmodifiable List
    // =========================================================
    static void unmodifiableListDemo() {
        System.out.println("----- Unmodifiable List Demo -----");

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        List<String> unmodifiableList = Collections.unmodifiableList(list);

        System.out.println("Original list: " + unmodifiableList);

        try {
            unmodifiableList.add("Go"); // Throws exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception caught: Cannot modify unmodifiable list");
        }

        // Original list can still be modified directly
        list.add("Go");
        System.out.println("Original list after adding 'Go': " + list);
    }

    // =========================================================
    // 3) Creating Unmodifiable Map
    // =========================================================
    static void unmodifiableMapDemo() {
        System.out.println("----- Unmodifiable Map Demo -----");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(map);

        System.out.println("Original map: " + unmodifiableMap);

        try {
            unmodifiableMap.put(3, "Three"); // Throws exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception caught: Cannot modify unmodifiable map");
        }

        // Original map can still be modified directly
        map.put(3, "Three");
        System.out.println("Original map after adding 3->Three: " + map);
    }

    // =========================================================
    // 4) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Collections.unmodifiableXXX() creates read-only view
        ✅ Underlying collection changes reflect in unmodifiable view
        ✅ Any modification via unmodifiable collection throws UnsupportedOperationException
        ✅ Useful for returning read-only collections from methods
        ✅ In Java 9+, can use List.of(), Map.of() for immutable collections
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Unmodifiable Collections Demo ==========\n");

        unmodifiableListDemo();
        System.out.println();

        unmodifiableMapDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between immutable and unmodifiable collections?
- Unmodifiable: cannot modify via wrapper, but underlying collection may change
- Immutable: cannot be modified at all (e.g., List.of(), Map.of())

2) What happens if you try to add to unmodifiable list?
- Throws UnsupportedOperationException

3) How to make a read-only map in Java 8?
- Collections.unmodifiableMap(map)

4) How to create truly immutable collection in Java 9+?
- List<String> list = List.of("A", "B", "C")
- Map<Integer,String> map = Map.of(1,"One", 2,"Two")

5) Why use unmodifiable collections in API design?
- Protect internal data from external modifications
*/

