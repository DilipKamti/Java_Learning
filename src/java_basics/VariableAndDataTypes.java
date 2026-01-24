package java_basics;


public class VariableAndDataTypes {

    public static void main(String[] args) {

        // =====================================================
        // 1) VARIABLES (Basic Idea)
        // =====================================================

        // Variable = container to store a value in memory
        int age = 22;                // int stores whole numbers
        double salary = 50000.75;    // double stores decimal values
        char grade = 'A';            // char stores a single character
        boolean isJavaFun = true;    // boolean stores true/false

        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Is Java Fun? " + isJavaFun);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 2) PRIMITIVE DATA TYPES (8 Types)
        // =====================================================

        byte b = 127;        // range: -128 to 127
        short s = 32000;     // range: -32768 to 32767
        int i = 100000;      // range: approx -2B to +2B
        long l = 9999999999L; // must use L for long literals

        float f = 10.5f;     // must use f for float literals
        double d = 99.99;    // default decimal type in Java

        char c = 'Z';        // stored as Unicode
        boolean flag = false;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + flag);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 3) DEFAULT VALUES (Important Concept)
        // =====================================================
        // NOTE: Local variables (inside main) must be initialized before use.
        // But instance variables get default values automatically.

        // Example of local variable rule:
        // int x;
        // System.out.println(x); // ❌ error: variable x might not have been initialized

        System.out.println("Local variables must be initialized before use.");

        System.out.println("------------------------------------------------");

        // =====================================================
        // 4) TYPE CASTING (Conversion between types)
        // =====================================================

        // 4.1 Widening Casting (Automatic)
        // smaller type -> larger type
        int num = 100;
        long bigNum = num;      // int -> long (automatic)
        double bigDecimal = num; // int -> double (automatic)

        System.out.println("Widening casting:");
        System.out.println("int num = " + num);
        System.out.println("long bigNum = " + bigNum);
        System.out.println("double bigDecimal = " + bigDecimal);

        System.out.println("------------------------------------------------");

        // 4.2 Narrowing Casting (Manual)
        // larger type -> smaller type (data loss possible)
        double price = 199.99;
        int roundedPrice = (int) price; // explicit casting

        System.out.println("Narrowing casting:");
        System.out.println("double price = " + price);
        System.out.println("int roundedPrice = " + roundedPrice + " (decimal lost)");

        System.out.println("------------------------------------------------");

        // =====================================================
        // 5) CHAR + ASCII/UNICODE (Deep Understanding)
        // =====================================================

        char ch = 'A';  // Unicode value = 65
        int asciiValue = ch; // char can be stored as int (widening)

        System.out.println("char ch = " + ch);
        System.out.println("int asciiValue = " + asciiValue);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 6) FINAL VARIABLES (Constants)
        // =====================================================

        final double PI = 3.14159;
        // PI = 3.14; // ❌ not allowed (final variable cannot be reassigned)

        System.out.println("Constant PI = " + PI);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 7) REFERENCE DATA TYPES (Non-Primitive)
        // =====================================================

        String name = "Dilip"; // String is a reference type
        int[] numbers = {1, 2, 3, 4, 5}; // array is also reference type

        System.out.println("String name = " + name);
        System.out.println("Array first element = " + numbers[0]);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 8) DIFFERENCE: PRIMITIVE vs REFERENCE (Deep)
        // =====================================================

        // Primitive stores value directly
        int a = 10;
        int copyA = a; // value copied
        copyA = 20;

        System.out.println("Primitive example:");
        System.out.println("a = " + a);
        System.out.println("copyA = " + copyA);

        System.out.println("------------------------------------------------");

        // Reference stores address of object
        int[] arr1 = {10, 20, 30};
        int[] arr2 = arr1; // reference copied (both point to same array)

        arr2[0] = 999; // changes arr1 too

        System.out.println("Reference example:");
        System.out.println("arr1[0] = " + arr1[0]);
        System.out.println("arr2[0] = " + arr2[0]);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 9) AUTOBOXING & UNBOXING (Primitive <-> Wrapper)
        // =====================================================

        Integer wrapper = 100; // autoboxing (int -> Integer)
        int primitive = wrapper; // unboxing (Integer -> int)

        System.out.println("Autoboxing/Unboxing:");
        System.out.println("Integer wrapper = " + wrapper);
        System.out.println("int primitive = " + primitive);

        System.out.println("------------------------------------------------");

        // =====================================================
        // 10) BEST PRACTICES (Industry Standard)
        // =====================================================

        // Use meaningful variable names
        int studentAge = 21;

        // Use camelCase
        double monthlySalary = 45000.50;

        // Use final for constants
        final int MAX_USERS = 100;

        System.out.println("Best Practices Example:");
        System.out.println("studentAge = " + studentAge);
        System.out.println("monthlySalary = " + monthlySalary);
        System.out.println("MAX_USERS = " + MAX_USERS);
    }
}
