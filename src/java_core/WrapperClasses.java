package java_core;

// WrapperClasses.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: Wrapper classes, boxing/unboxing, caching, parse vs valueOf,
// comparisons (== vs equals), autoboxing pitfalls, null issues.

import java.util.ArrayList;

public class WrapperClasses {

    // =========================================================
    // 1) What are Wrapper Classes?
    // =========================================================
    /*
        Wrapper classes convert primitive types into objects.

        Primitive  -> Wrapper
        byte       -> Byte
        short      -> Short
        int        -> Integer
        long       -> Long
        float      -> Float
        double     -> Double
        char       -> Character
        boolean    -> Boolean

        Why needed?
        - Collections (ArrayList, HashMap) work with objects, not primitives
        - Generics require objects (T cannot be primitive)
        - Utility methods like parseInt, valueOf, compareTo
    */

    // =========================================================
    // 2) Boxing and Unboxing
    // =========================================================
    /*
        Boxing: primitive -> wrapper object
        Unboxing: wrapper object -> primitive

        Example:
        int a = 10;
        Integer obj = a;     // Autoboxing (boxing)

        Integer x = 20;
        int y = x;           // Auto-unboxing (unboxing)
    */

    // =========================================================
    // 3) Manual Boxing/Unboxing (Old style)
    // =========================================================
    static void manualBoxingUnboxing() {
        System.out.println("----- Manual Boxing/Unboxing -----");

        int a = 100;

        // Manual Boxing (old)
        Integer obj = Integer.valueOf(a);
        System.out.println("Boxed Integer: " + obj);

        // Manual Unboxing (old)
        int b = obj.intValue();
        System.out.println("Unboxed int: " + b);
    }

    // =========================================================
    // 4) Autoboxing/Unboxing (Java 5+)
    // =========================================================
    static void autoBoxingUnboxing() {
        System.out.println("----- Auto Boxing/Unboxing -----");

        int a = 200;
        Integer obj = a; // autoboxing
        System.out.println("Auto Boxed: " + obj);

        Integer x = 300;
        int y = x; // auto-unboxing
        System.out.println("Auto Unboxed: " + y);
    }

    // =========================================================
    // 5) Wrapper Caching (Most Asked Interview)
    // =========================================================
    /*
        Java caches some wrapper objects to save memory.

        Integer Cache Range: -128 to 127
        Byte: always cached (all values)
        Short: -128 to 127
        Long: -128 to 127
        Character: 0 to 127
        Boolean: true/false cached

        That’s why:
        Integer a = 100;
        Integer b = 100;
        a == b -> true (same cached object)

        Integer x = 200;
        Integer y = 200;
        x == y -> false (different objects)
    */
    static void wrapperCachingDemo() {
        System.out.println("----- Wrapper Caching Demo -----");

        Integer a = 100;
        Integer b = 100;
        System.out.println("100 == 100 ? " + (a == b)); // true (cached)

        Integer x = 200;
        Integer y = 200;
        System.out.println("200 == 200 ? " + (x == y)); // false (not cached)

        System.out.println("100 equals 100 ? " + a.equals(b)); // true
        System.out.println("200 equals 200 ? " + x.equals(y)); // true
    }

    // =========================================================
    // 6) == vs equals() for Wrapper Classes
    // =========================================================
    /*
        == compares reference (address) for objects
        equals() compares value (content)

        But caching can confuse == output.
        Always use equals() for wrapper comparison.
    */
    static void wrapperComparison() {
        System.out.println("----- Wrapper Comparison -----");

        Integer a = 127;
        Integer b = 127;
        System.out.println("a==b (127): " + (a == b)); // true (cached)

        Integer x = 128;
        Integer y = 128;
        System.out.println("x==y (128): " + (x == y)); // false

        System.out.println("x.equals(y): " + x.equals(y)); // true
    }

    // =========================================================
    // 7) parseXxx() vs valueOf()
    // =========================================================
    /*
        parseInt("123") -> returns primitive int
        valueOf("123")  -> returns Integer object

        Same for others:
        Double.parseDouble() -> double
        Double.valueOf()     -> Double
    */
    static void parseVsValueOf() {
        System.out.println("----- parse vs valueOf -----");

        String num = "123";

        int a = Integer.parseInt(num);
        Integer b = Integer.valueOf(num);

        System.out.println("parseInt -> int: " + a);
        System.out.println("valueOf -> Integer: " + b);
    }

    // =========================================================
    // 8) Null Pointer Pitfall (Super Important)
    // =========================================================
    /*
        Auto-unboxing on null causes NullPointerException.

        Example:
        Integer x = null;
        int y = x;  // NPE
    */
    static void nullUnboxingPitfall() {
        System.out.println("----- Null Unboxing Pitfall -----");

        Integer x = null;

        try {
            int y = x; // auto-unboxing -> NPE
            System.out.println(y);
        } catch (NullPointerException e) {
            System.out.println("Auto-unboxing null -> NullPointerException ❌");
        }
    }

    // =========================================================
    // 9) Wrapper with Collections (Why wrapper is needed)
    // =========================================================
    static void wrapperInCollections() {
        System.out.println("----- Wrapper in Collections -----");

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10); // autoboxing int -> Integer
        list.add(20);
        list.add(30);

        System.out.println("List: " + list);

        int sum = 0;
        for (Integer val : list) {
            sum += val; // auto-unboxing Integer -> int
        }

        System.out.println("Sum: " + sum);
    }

    // =========================================================
    // 10) Conversions
    // =========================================================
    static void conversions() {
        System.out.println("----- Conversions -----");

        // int -> Integer
        int a = 50;
        Integer obj = a;

        // Integer -> String
        String s1 = obj.toString();
        System.out.println("Integer -> String: " + s1);

        // String -> int
        int b = Integer.parseInt("999");
        System.out.println("String -> int: " + b);

        // String -> Integer
        Integer c = Integer.valueOf("888");
        System.out.println("String -> Integer: " + c);
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {
        System.out.println("========== Wrapper Classes ==========");

        manualBoxingUnboxing();
        System.out.println();

        autoBoxingUnboxing();
        System.out.println();

        wrapperCachingDemo();
        System.out.println();

        wrapperComparison();
        System.out.println();

        parseVsValueOf();
        System.out.println();

        nullUnboxingPitfall();
        System.out.println();

        wrapperInCollections();
        System.out.println();

        conversions();
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What are wrapper classes?
- Classes that wrap primitives into objects (Integer, Double, etc.)

2) Why wrapper classes needed?
- Collections + Generics + Utility methods + Object requirement

3) What is boxing and unboxing?
- Boxing: primitive -> wrapper
- Unboxing: wrapper -> primitive

4) What is autoboxing?
- Automatic conversion primitive -> wrapper (Java 5+)

5) Difference between parseInt and valueOf?
- parseInt -> int
- valueOf -> Integer object

6) Why Integer a=100; Integer b=100; a==b true?
- Because of Integer caching (-128 to 127)

7) Why Integer a=200; Integer b=200; a==b false?
- Not cached, different objects

8) Which is safer for comparing wrappers?
- equals() (always compares value)

9) What happens if we unbox null?
- NullPointerException

10) Are wrapper classes immutable?
- YES, wrapper objects are immutable
*/

