package java_02_oops;

public class Inheritance {

    // =========================
    // 1) Single Inheritance
    // =========================
    static class Parent {
        String familyName = "Kumar";

        Parent() {
            System.out.println("Parent constructor called");
        }

        void house() {
            System.out.println("Parent has a house");
        }

        void car() {
            System.out.println("Parent has a car");
        }
    }

    static class Child extends Parent {

        Child() {
            super(); // calls Parent constructor
            System.out.println("Child constructor called");
        }

        // Method Overriding (Runtime Polymorphism)
        @Override
        void car() {
            System.out.println("Child has a sports car");
        }

        void bike() {
            System.out.println("Child has a bike");
        }
    }

    // =========================
    // 2) Multilevel Inheritance
    // =========================
    static class A {
        void showA() {
            System.out.println("A");
        }
    }

    static class B extends A {
        void showB() {
            System.out.println("B");
        }
    }

    static class C extends B {
        void showC() {
            System.out.println("C");
        }
    }

    // =========================
    // 3) Hierarchical Inheritance
    // =========================
    static class Animal {
        void eat() {
            System.out.println("Animal eats");
        }
    }

    static class Dog extends Animal {
        void bark() {
            System.out.println("Dog barks");
        }
    }

    static class Cat extends Animal {
        void meow() {
            System.out.println("Cat meows");
        }
    }

    // =========================
    // 4) Diamond Problem Fix using Interfaces
    // =========================
    interface IA {
        default void show() {
            System.out.println("IA show()");
        }
    }

    interface IB {
        default void show() {
            System.out.println("IB show()");
        }
    }

    static class DiamondFix implements IA, IB {
        @Override
        public void show() {
            System.out.println("DiamondFix resolves conflict");
            IA.super.show();
            IB.super.show();
        }
    }

    public static void main(String[] args) {

        System.out.println("---- Single Inheritance + Overriding ----");
        Child c1 = new Child();
        c1.house(); // inherited
        c1.car();   // overridden
        c1.bike();  // child method
        System.out.println("Family Name: " + c1.familyName);

        System.out.println("\n---- Upcasting (Parent ref, Child object) ----");
        Parent p = new Child();
        p.house();
        p.car(); // Child version runs (runtime polymorphism)
        // p.bike(); // ❌ not allowed

        System.out.println("\n---- Multilevel Inheritance ----");
        C obj = new C();
        obj.showA();
        obj.showB();
        obj.showC();

        System.out.println("\n---- Hierarchical Inheritance ----");
        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();

        System.out.println("\n---- Diamond Problem (Interfaces) ----");
        DiamondFix df = new DiamondFix();
        df.show();
    }
}

