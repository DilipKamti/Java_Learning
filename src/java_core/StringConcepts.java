package java_core;

// StringConcepts.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: String, immutability, pool, == vs equals, hashcode, concat, StringBuilder,
// StringBuffer, performance, important methods, tricky interview outputs.

import java.util.Arrays;

public class StringConcepts {

    // =========================================================
    // 1) What is String in Java?
    // =========================================================
    /*
        String is a sequence of characters.
        In Java, String is a class: java.lang.String

        🔥 Most Important:
        String is IMMUTABLE (cannot be changed after creation)

        If you modify a string:
        - Java creates a NEW String object
        - Old one stays same
    */

    // =========================================================
    // 2) String Creation (2 ways)
    // =========================================================
    /*
        1) String literal -> goes into String Constant Pool (SCP)
           String s = "Dilip";

        2) new keyword -> creates object in heap
           String s = new String("Dilip");

        NOTE:
        Literal uses pool for memory optimization.
    */

    // =========================================================
    // 3) String Constant Pool (SCP)
    // =========================================================
    /*
        SCP = special memory area inside heap.
        If same literal already exists, Java reuses it.

        Example:
        String a = "java";
        String b = "java";
        a and b point to SAME object in SCP.
    */

    // =========================================================
    // 4) == vs equals() (Most asked)
    // =========================================================
    /*
        == compares reference (address)
        equals() compares content (value)

        Example:
        String s1 = "abc";
        String s2 = new String("abc");

        s1 == s2   -> false (different objects)
        s1.equals(s2) -> true (same content)
    */

    // =========================================================
    // 5) Immutability Deep Reason (Why String is immutable?)
    // =========================================================
    /*
        Reasons:
        1) Security
           - String used in passwords, DB URL, file paths
           - if mutable, someone can change it and hack

        2) String Pool optimization
           - sharing objects is safe only if immutable

        3) Thread Safety
           - immutable objects are naturally thread-safe

        4) HashMap Key stability
           - String is widely used as key in HashMap
           - if content changes, hashcode changes -> map breaks
    */

    // =========================================================
    // 6) concat(), +, and new object creation
    // =========================================================
    /*
        String s = "a";
        s = s + "b";
        -> creates new string "ab"

        Internally:
        StringBuilder is used for concatenation in loops (compiler optimization)
        But still creates many objects if you do it repeatedly.
    */

    // =========================================================
    // 7) StringBuilder vs StringBuffer
    // =========================================================
    /*
        StringBuilder:
        - mutable
        - faster
        - NOT thread-safe

        StringBuffer:
        - mutable
        - thread-safe (synchronized)
        - slower than StringBuilder
    */

    // =========================================================
    // 8) intern() method (Advanced interview)
    // =========================================================
    /*
        intern() puts string into pool (or returns existing pooled reference)

        Example:
        String x = new String("java");
        String y = x.intern();

        y points to pooled "java"
    */

    // =========================================================
    // 9) Important String methods
    // =========================================================
    /*
        length()
        charAt(i)
        substring(begin, end)
        contains()
        startsWith(), endsWith()
        equalsIgnoreCase()
        toUpperCase(), toLowerCase()
        trim()
        replace()
        split()
        indexOf(), lastIndexOf()
        isEmpty()
        compareTo()
    */

    // =========================================================
    // 10) Tricky Interview Output Questions
    // =========================================================
    static void outputTricks() {
        System.out.println("----- OUTPUT TRICKS -----");

        String a = "java";
        String b = "java";
        System.out.println(a == b); // true (same pooled object)

        String c = new String("java");
        System.out.println(a == c); // false (pool vs heap)
        System.out.println(a.equals(c)); // true (content same)

        String d = c.intern();
        System.out.println(a == d); // true (both pooled)

        // Compile-time concatenation -> happens in pool
        String s1 = "ja" + "va";
        System.out.println(a == s1); // true

        // Runtime concatenation -> creates new object
        String p = "ja";
        String q = p + "va";
        System.out.println(a == q); // false

        // But intern fixes it
        String q2 = q.intern();
        System.out.println(a == q2); // true

        // null handling
        String n = null;
        // System.out.println(n.length()); // NullPointerException
        System.out.println(String.valueOf(n)); // "null" (safe)
    }

    // =========================================================
    // 11) StringBuilder usage (Performance)
    // =========================================================
    static void builderExample() {
        System.out.println("----- StringBuilder Example -----");

        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("Dilip");

        System.out.println(sb.toString()); // Hello Dilip
    }

    // =========================================================
    // 12) Reverse String (common interview)
    // =========================================================
    static String reverseManual(String s) {
        if (s == null) return null;

        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }

    // =========================================================
    // 13) String vs char[] (security question)
    // =========================================================
    /*
        Why char[] preferred for passwords over String?
        - String stays in memory until GC
        - char[] can be cleared manually after use
    */

    // =========================================================
    // MAIN METHOD
    // =========================================================
    public static void main(String[] args) {

        System.out.println("========== String Basics ==========");

        String s = "Dilip";
        System.out.println("String: " + s);
        System.out.println("Length: " + s.length());
        System.out.println("CharAt(0): " + s.charAt(0));
        System.out.println("Substring(1,4): " + s.substring(1, 4));

        System.out.println("\n========== Immutability Demo ==========");
        String x = "Hello";
        x.concat(" World"); // creates new string but not stored
        System.out.println(x); // Hello (unchanged)

        x = x.concat(" World"); // now stored
        System.out.println(x); // Hello World

        System.out.println("\n========== == vs equals ==========");
        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b);       // false
        System.out.println(a.equals(b));  // true

        System.out.println("\n========== StringBuilder ==========");
        builderExample();

        System.out.println("\n========== Reverse String ==========");
        System.out.println(reverseManual("Java")); // avaJ
        System.out.println(new StringBuilder("Java").reverse()); // avaJ

        System.out.println("\n========== Split Example ==========");
        String line = "java,python,c++";
        String[] parts = line.split(",");
        System.out.println(Arrays.toString(parts));

        System.out.println("\n========== Tricky Outputs ==========");
        outputTricks();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) Why String is immutable?
- Security, Pooling, Thread-safety, HashMap key stability.

2) Difference between == and equals()?
- == compares reference
- equals compares content

3) What is String Constant Pool?
- Special memory area to store literals for reuse.

4) StringBuilder vs StringBuffer?
- Builder: fast, not thread-safe
- Buffer: thread-safe, slower

5) What is intern()?
- Returns pooled reference of the string.

6) Why String is preferred as HashMap key?
- Immutable -> stable hashcode -> safe key.

7) Why char[] used for password instead of String?
- char[] can be cleared manually, String stays until GC.

8) How many objects created?
String s = "a" + "b";
- 1 object in pool ("ab") (compile time)
String p = "a"; String q = p + "b";
- new object created at runtime
*/

