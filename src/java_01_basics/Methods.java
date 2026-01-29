package java_01_basics;

class Methods {

    static void main(String[] args) {
        // 1. Basic method
        greet();

        // 2. Method with parameter
        greetPerson("Dilip");

        // 3. Method with return value
        int result = sum(5, 3);
        System.out.println("Sum: " + result);

        // 4. Overloaded methods
        System.out.println("Sum int: " + sum(1, 2, 3));
        System.out.println("Sum double: " + sum(2.5, 3.5));

        // 5. Recursion
        System.out.println("Factorial 5: " + factorial(5));

        // 6. Varargs
        System.out.println("SumAll: " + sumAll(1, 2, 3, 4, 5));

        // 7. Static vs Non-static
        Methods.staticMethod();
        Methods obj = new Methods();
        obj.nonStaticMethod();

        // 8. Pass by value
        int x = 10;
        changeValue(x);
        System.out.println("x after changeValue: " + x);

        Person p = new Person("Dilip");
        changeName(p);
        System.out.println("Person name: " + p.name);
    }

    static void greet() {
        System.out.println("Hello World");
    }

    static void greetPerson(String name) {
        System.out.println("Hello " + name);
    }

    static int sum(int a, int b) {
        return a + b;
    }

    static int sum(int a, int b, int c) {
        return a + b + c;
    }

    static double sum(double a, double b) {
        return a + b;
    }

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    static int sumAll(int... nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        return sum;
    }

    static void staticMethod() {
        System.out.println("Static method");
    }

    void nonStaticMethod() {
        System.out.println("Non-static method");
    }

    static void changeValue(int a) {
        a = 100;
    }

    static void changeName(Person p) {
        p.name = "Ravi";
    }
}

// Supporting class
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}
/*
Pass by Value (Primitives)
-------------------------------
Imagine you give someone a copy of a number.
They can change their copy, but your original number stays the same.
Example: int x = 10; → pass x to method → method gets copy of 10, changing it doesn’t touch x.

Objects (Reference “copy”)
-------------------------------
Imagine you give someone a copy of the address of your house.
They can go to your house and change things inside → it affects the original house.
But if they throw away the address and get a new house → your original house stays the same.
Example: Person p = new Person("Dilip"); → pass p to method → method can change p.name → affects original object.
 */

/*
“Java is always pass-by-value: primitives pass the value, objects pass a copy of the reference.”
 */