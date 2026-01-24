package java_generics;

// GenericClass.java
// Java Generics - Generic Class Deep Dive ✅
// Covers: generic class, type parameters, multiple parameters, and interview tips

// =========================================================
// 1) Generic Class Example
// =========================================================
class Box<T> { // T is a type parameter
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Box{" + "content=" + content + '}';
    }
}

// =========================================================
// 2) Generic Class with Multiple Type Parameters
// =========================================================
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

// =========================================================
// 3) Tips & Tricks (Interview Favorite)
// =========================================================
/*
    ✅ Generic classes allow type-safety at compile time
    ✅ Use meaningful type parameter names (T, K, V, E)
    ✅ Can have multiple type parameters
    ✅ Can use bounded types: class Box<T extends Number> { ... }
    ✅ Avoid using raw types (Box box = new Box())
    ✅ Useful for creating reusable and type-safe classes
    ✅ Works well with Collections
*/

public class GenericClass {

    public static void main(String[] args) {
        System.out.println("========== Generic Class Demo ==========\n");

        // =========================================================
        // Example 1: Single type parameter
        // =========================================================
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello Generics");
        System.out.println("String Box: " + stringBox);

        Box<Integer> intBox = new Box<>();
        intBox.setContent(123);
        System.out.println("Integer Box: " + intBox);

        // =========================================================
        // Example 2: Multiple type parameters
        // =========================================================
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair);

        Pair<String, String> pair2 = new Pair<>("Name", "Dilip");
        System.out.println("Pair2: " + pair2);
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is a generic class?
- A class with type parameters allowing type-safe operations

2) Difference between generic class and generic method?
- Generic class: type parameter in class declaration
- Generic method: type parameter in method declaration

3) Can we have multiple type parameters?
- Yes, e.g., class Pair<K, V> { ... }

4) What is a bounded type parameter?
- Restrict type parameter to a certain type: <T extends Number>

5) Why avoid raw types?
- Raw types bypass type-safety and can cause runtime exceptions
*/

