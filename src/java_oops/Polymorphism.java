package java_oops;

// Polymorphism.java
// Basic to Deep Dive (Interview Ready) ✅
// Topic: Polymorphism in Java (Compile-time + Runtime) with tips, tricks, pitfalls

public class Polymorphism {

    // =========================================================
    // 1) WHAT IS POLYMORPHISM?
    // =========================================================
    /*
        Polymorphism = "Many forms"

        Simple words:
        - Same method name, but different behavior depending on the situation.

        In Java, polymorphism is mainly of 2 types:
        1) Compile-time Polymorphism (Method Overloading)  -> decided at compile time
        2) Runtime Polymorphism (Method Overriding)        -> decided at runtime
    */

    // =========================================================
    // 2) COMPILE-TIME POLYMORPHISM (Method Overloading)
    // =========================================================
    static class Calculator {

        // Same method name "add" but different parameters => Overloading
        int add(int a, int b) {
            return a + b;
        }

        int add(int a, int b, int c) {
            return a + b + c;
        }

        double add(double a, double b) {
            return a + b;
        }

        // IMPORTANT: Overloading is based on method signature (name + parameters)
        // Return type alone cannot overload
        // Example (NOT allowed):
        // double add(int a, int b) { return a+b; } // ❌ same signature as int add(int,int)
    }

    // =========================================================
    // 3) RUNTIME POLYMORPHISM (Method Overriding)
    // =========================================================
    static class Vehicle {
        void start() {
            System.out.println("Vehicle starts");
        }

        void fuelType() {
            System.out.println("Fuel: Generic");
        }

        static void staticMethod() {
            System.out.println("Vehicle staticMethod()");
        }
    }

    static class Car extends Vehicle {

        // Overriding: same method name + same params + child provides new behavior
        @Override
        void start() {
            System.out.println("Car starts with key/button");
        }

        @Override
        void fuelType() {
            System.out.println("Fuel: Petrol/Diesel");
        }

        static void staticMethod() {
            System.out.println("Car staticMethod()");
        }

        void carOnlyFeature() {
            System.out.println("Car only feature: AC");
        }
    }

    static class ElectricCar extends Car {

        @Override
        void start() {
            System.out.println("ElectricCar starts silently");
        }

        @Override
        void fuelType() {
            System.out.println("Fuel: Battery");
        }

        void batteryInfo() {
            System.out.println("Battery capacity: 60kWh");
        }
    }

    // =========================================================
    // 4) METHOD OVERLOADING + OVERRIDING TOGETHER (Tricky)
    // =========================================================
    static class Parent {
        void show(int x) {
            System.out.println("Parent show(int): " + x);
        }
    }

    static class Child extends Parent {

        // Overloading (not overriding) because parameter is different
        void show(double x) {
            System.out.println("Child show(double): " + x);
        }

        // Overriding
        @Override
        void show(int x) {
            System.out.println("Child show(int): " + x);
        }
    }

    // =========================================================
    // 5) UPCASTING (MOST IMPORTANT FOR RUNTIME POLYMORPHISM)
    // =========================================================
    /*
        Upcasting:
        Parent reference can store child object.

        Vehicle v = new Car();

        Rule:
        - Which methods you can CALL depends on reference type (Vehicle)
        - Which method actually RUNS depends on object type (Car) => overriding
    */

    // =========================================================
    // 6) DOWNCASTING (RISKY, use carefully)
    // =========================================================
    /*
        Downcasting:
        Car c = (Car) vehicleRef;

        Only safe if object is actually Car/ElectricCar etc.

        If wrong:
        Vehicle v = new Vehicle();
        Car c = (Car) v;  // ❌ ClassCastException
    */

    // =========================================================
    // 7) INTERFACE POLYMORPHISM (REAL WORLD)
    // =========================================================
    interface Payment {
        void pay(double amount);
    }

    static class UpiPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " via UPI");
        }
    }

    static class CardPayment implements Payment {
        @Override
        public void pay(double amount) {
            System.out.println("Paid " + amount + " via Card");
        }
    }

    static void doPayment(Payment p, double amount) {
        // Polymorphism: same call p.pay() behaves differently for different implementations
        p.pay(amount);
    }

    // =========================================================
    // 8) IMPORTANT RULES OF OVERRIDING (INTERVIEW)
    // =========================================================
    /*
        Overriding rules:
        1) Must have same method name + same parameters
        2) Must be parent-child relationship
        3) Access modifier cannot be more restrictive
           - parent: public => child cannot be protected/private
        4) Return type:
           - same return type OR covariant return type allowed
        5) static methods are NOT overridden (they are hidden)
        6) final methods cannot be overridden
        7) private methods cannot be overridden (they are not visible)
    */

    // =========================================================
    // 9) COVARIANT RETURN TYPE (Deep Interview Point)
    // =========================================================
    static class Animal {
        Animal getAnimal() {
            return new Animal();
        }
    }

    static class Dog extends Animal {
        @Override
        Dog getAnimal() { // covariant return type (Dog is subclass of Animal)
            return new Dog();
        }
    }

    // =========================================================
    // 10) POLYMORPHISM WITH OBJECT CLASS METHODS (Deep)
    // =========================================================
    /*
        Object methods like toString(), equals() are often overridden.

        This is also runtime polymorphism because:
        Object ref = new Student();
        System.out.println(ref.toString()); // Student's toString runs (if overridden)
    */

    // =========================================================
    // 11) INTERVIEW TRICKS & OUTPUT BASED QUESTIONS
    // =========================================================
    static class A {
        void m1() {
            System.out.println("A m1()");
        }

        static void s1() {
            System.out.println("A s1()");
        }
    }

    static class B extends A {
        @Override
        void m1() {
            System.out.println("B m1()");
        }

        static void s1() {
            System.out.println("B s1()");
        }
    }

    // =========================================================
    // MAIN METHOD (RUN ALL EXAMPLES)
    // =========================================================
    public static void main(String[] args) {

        System.out.println("========== 1) Compile-time Polymorphism (Overloading) ==========");
        Calculator calc = new Calculator();
        System.out.println(calc.add(10, 20));          // 30
        System.out.println(calc.add(10, 20, 30));      // 60
        System.out.println(calc.add(10.5, 20.5));      // 31.0

        System.out.println("\n========== 2) Runtime Polymorphism (Overriding) ==========");
        Vehicle v1 = new Vehicle();
        v1.start();
        v1.fuelType();

        Vehicle v2 = new Car(); // Upcasting
        v2.start();             // Car version runs
        v2.fuelType();          // Car version runs

        Vehicle v3 = new ElectricCar(); // Upcasting
        v3.start();                    // ElectricCar version runs
        v3.fuelType();                 // ElectricCar version runs

        System.out.println("\n========== 3) Reference type decides accessible methods ==========");
        Car car = new Car();
        car.carOnlyFeature(); // allowed

        Vehicle v4 = new Car();
         //v4.carOnlyFeature(); // ❌ not allowed (reference is Vehicle)

        System.out.println("\n========== 4) Downcasting ==========");
        Vehicle v5 = new ElectricCar();
        if (v5 instanceof ElectricCar) {
            ElectricCar ec = (ElectricCar) v5;
            ec.batteryInfo(); // safe
        }

        System.out.println("\n========== 5) Interface Polymorphism ==========");
        doPayment(new UpiPayment(), 500);
        doPayment(new CardPayment(), 1200);

        System.out.println("\n========== 6) Overloading + Overriding (Tricky) ==========");
        Parent p = new Child();
        p.show(10);     // Child show(int): 10  (override)
        // p.show(10.5); // ❌ reference type Parent doesn't have show(double)

        Child ch = new Child();
        ch.show(10);    // Child show(int)
        ch.show(10.5);  // Child show(double)

        System.out.println("\n========== 7) Static method hiding (NOT overriding) ==========");
        A obj1 = new B();
        obj1.m1(); // B m1()  (runtime polymorphism)
        obj1.s1(); // A s1()  (static method depends on reference type)

        B obj2 = new B();
        obj2.s1(); // B s1()

        System.out.println("\n========== 8) Covariant Return Type ==========");
        Animal an = new Dog();
        System.out.println(an.getAnimal().getClass().getSimpleName()); // Dog
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is Polymorphism?
- Same method call behaves differently depending on object type.

2) Types of Polymorphism in Java?
- Compile-time (Overloading)
- Runtime (Overriding)

3) Overloading vs Overriding?
Overloading:
- Same class
- Same name, different parameters
- Compile-time

Overriding:
- Parent-child
- Same name, same parameters
- Runtime

4) Can we override static method?
- No, static methods are hidden not overridden.

5) Why Java uses runtime polymorphism?
- Flexibility, loose coupling, code reuse, clean design (OOP).

6) What is Upcasting?
- Parent ref = child object
- Enables runtime polymorphism

7) What is Downcasting?
- Casting parent ref to child ref (risk of ClassCastException)

8) Why return type alone cannot overload?
- Because method signature = name + params, not return type.

9) What is covariant return type?
- Child overridden method can return subclass type of parent method return type.

10) Can private methods be overridden?
- No (not visible to child)

11) Can final method be overridden?
- No

12) Which binding happens in overloading?
- Early binding (compile time)

13) Which binding happens in overriding?
- Late binding (runtime)
*/

