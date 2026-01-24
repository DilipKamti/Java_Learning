package java_collections.collections_class;

// CollectionsUtilityMethods.java
// Java Collections Utility Methods - Deep Dive ✅
// Covers: common utility methods in java.util.Collections

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilityMethods {

    // =========================================================
    // 1) Sorting a List
    // =========================================================
    static void sortDemo() {
        System.out.println("----- Sorting Demo -----");

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 5, 1, 3, 2, 4);

        System.out.println("Before sorting: " + numbers);

        Collections.sort(numbers); // Ascending order
        System.out.println("After sorting (ascending): " + numbers);

        Collections.sort(numbers, Collections.reverseOrder()); // Descending order
        System.out.println("After sorting (descending): " + numbers);
    }

    // =========================================================
    // 2) Reverse, Shuffle, and Swap
    // =========================================================
    static void reverseShuffleSwapDemo() {
        System.out.println("----- Reverse, Shuffle & Swap Demo -----");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A", "B", "C", "D");

        Collections.reverse(list);
        System.out.println("After reverse: " + list);

        Collections.shuffle(list);
        System.out.println("After shuffle: " + list);

        Collections.swap(list, 0, 2);
        System.out.println("After swap index 0 and 2: " + list);
    }

    // =========================================================
    // 3) Frequency, Max, Min, Replace
    // =========================================================
    static void frequencyMaxMinDemo() {
        System.out.println("----- Frequency, Max, Min, Replace Demo -----");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A", "B", "C", "A", "B", "A");

        int freqA = Collections.frequency(list, "A");
        System.out.println("Frequency of 'A': " + freqA);

        String max = Collections.max(list);
        String min = Collections.min(list);
        System.out.println("Max: " + max + ", Min: " + min);

        Collections.replaceAll(list, "B", "X");
        System.out.println("After replacing 'B' with 'X': " + list);
    }

    // =========================================================
    // 4) Rotate & Binary Search
    // =========================================================
    static void rotateSearchDemo() {
        System.out.println("----- Rotate & Binary Search Demo -----");

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3, 4, 5);

        Collections.rotate(numbers, 2); // Rotate 2 positions to right
        System.out.println("After rotate by 2: " + numbers);

        Collections.sort(numbers); // binarySearch requires sorted list
        int index = Collections.binarySearch(numbers, 3);
        System.out.println("Index of 3 (binary search): " + index);
    }

    // =========================================================
    // 5) Tips & Tricks (Interview Favorite)
    // =========================================================
    /*
        ✅ Collections class provides static utility methods for collections
        ✅ sort(), reverse(), shuffle(), swap() for order manipulation
        ✅ frequency(), max(), min(), replaceAll() for searching & updating
        ✅ rotate() shifts elements cyclically
        ✅ binarySearch() works only on sorted lists
        ✅ Always prefer Collections.addAll() for quick initialization
    */

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Collections Utility Methods Demo ==========\n");

        sortDemo();
        System.out.println();

        reverseShuffleSwapDemo();
        System.out.println();

        frequencyMaxMinDemo();
        System.out.println();

        rotateSearchDemo();
        System.out.println();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Difference between Collections.sort() and List.sort()?
- Collections.sort(list): legacy, works on any list, uses Comparable
- list.sort(comparator): Java 8+, uses Comparator, more flexible

2) Can Collections.binarySearch() be used on unsorted list?
- No, list must be sorted

3) How to shuffle elements in a list?
- Collections.shuffle(list)

4) How to rotate a list?
- Collections.rotate(list, distance)

5) How to count frequency of an element?
- Collections.frequency(list, element)
*/

