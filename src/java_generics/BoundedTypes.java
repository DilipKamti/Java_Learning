package java_generics;

// BoundedTypes.java
// Java Generics - Bounded Types Deep Dive ✅
// Covers: upper bounds, multiple bounds, bounded generic methods, and interview tips

// =========================================================
// 1) Generic Class with Upper Bound
// =========================================================
class NumericBox<T extends Number> { // T must be a subclass of Number
    private T number;

    public NumericBox(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
}

// =========================================================
// 2) Generic Method with Upper Bound
// =========================================================
class BoundedUtil {
    public static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    // Multiple bounds: class must extend Number & implement Comparable
    public static <T extends Number & Comparable<T>> T max(T a, T b) {
        return (a.compareTo(b) > 0) ? a : b;
    }
}

// =========================================================
// 3) Tips & Tricks (Interview Favorite)
// =========================================================
/*
    ✅ Bounded type parameters restrict the allowed types
    ✅ Single bound: <T extends Number> allows Number & subclasses
    ✅ Multiple bounds: <T extends Number & Comparable<T>> allows multiple constraints
    ✅ Interface can be used in bounds; only one class is allowed
    ✅ Useful to enable arithmetic operations or comparisons on generic types
    ✅ Bounded generic methods can be static or instance methods
*/

public class BoundedTypes {

    public static void main(String[] args) {
        System.out.println("========== Bounded Types Demo ==========\n");

        // =========================================================
        // Example 1: NumericBox
        // =========================================================
        NumericBox<Integer> intBox = new NumericBox<>(100);
        NumericBox<Double> doubleBox = new NumericBox<>(50.5);

        System.out.println("Integer Box value: " + intBox.getNumber());
        System.out.println("Double Box value: " + doubleBox.getNumber());
        System.out.println("Double Box as double: " + doubleBox.doubleValue());
        System.out.println();

        // =========================================================
        // Example 2: Generic Methods with Bounds
        // =========================================================
        double sumResult = BoundedUtil.sum(10, 20);
        System.out.println("Sum of 10 and 20: " + sumResult);

        int maxResult = BoundedUtil.max(15, 30);
        System.out.println("Max of 15 and 30: " + maxResult);

        double maxDouble = BoundedUtil.max(12.5, 7.3);
        System.out.println("Max of 12.5 and 7.3: " + maxDouble);
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is a bounded type parameter?
- Restricts generic type to a specific class/interface or its subclass

2) Can a bounded type extend multiple classes?
- No, only one class; can implement multiple interfaces

3) Syntax for multiple bounds?
- <T extends Class & Interface1 & Interface2>

4) Why use bounded types in generics?
- To allow only compatible types, enabling operations like arithmetic or comparison

5) Can generic methods also have bounds?
- Yes, e.g., <T extends Number> double sum(T a, T b)
*/
