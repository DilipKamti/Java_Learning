package java_02_oops;

// InnerClasses.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: Types of Inner Classes, usage, rules, access, interview tricks, outputs

public class InnerClasses {

    /*
        ============================
        1) What are Inner Classes?
        ============================
        Inner class = A class declared inside another class.

        Why we use?
        - Better encapsulation (hide helper logic inside main class)
        - Logical grouping (class is used only inside another class)
        - Access outer class members easily
        - Used in frameworks, callbacks, event handling

        Types of Inner Classes in Java:
        1) Non-static Inner Class (Member Inner Class)
        2) Static Nested Class
        3) Local Inner Class (inside a method)
        4) Anonymous Inner Class (no name, used for one-time use)
    */

    // Outer class variable
    private String outerName = "OuterClass";
    private static String outerStatic = "OuterStatic";

    // =============================================
    // 2) Member Inner Class (Non-static inner class)
    // =============================================
    /*
        Member Inner Class:
        - Non-static
        - Needs outer object to create inner object
        - Can access ALL members of outer class (private also)
        - Cannot have static members (except static final constants)
    */
    class MemberInner {
        void show() {
            System.out.println("MemberInner accessing outerName: " + outerName);
            System.out.println("MemberInner accessing outerStatic: " + outerStatic);
        }
    }

    // =============================================
    // 3) Static Nested Class (static inner class)
    // =============================================
    /*
        Static Nested Class:
        - Declared static inside outer class
        - Does NOT need outer object to create
        - Can access only static members of outer class directly
        - Cannot access non-static outer variables without outer object
    */
    static class StaticNested {
        void show() {
            System.out.println("StaticNested accessing outerStatic: " + outerStatic);

            // Cannot access outerName directly because it's non-static
            // System.out.println(outerName); // ❌ not allowed
        }
    }

    // =============================================
    // 4) Local Inner Class (inside a method)
    // =============================================
    /*
        Local Inner Class:
        - Defined inside a method/block
        - Scope only inside that method
        - Can access outer class members
        - Can access local variables ONLY if they are final or effectively final
    */
    void localInnerDemo() {

        int x = 10; // effectively final (not changing)

        class LocalInner {
            void show() {
                System.out.println("LocalInner accessing outerName: " + outerName);
                System.out.println("LocalInner local variable x: " + x);
            }
        }

        LocalInner li = new LocalInner();
        li.show();

        // If you change x after inner class uses it -> error
        // x = 20; // ❌ not allowed because x must be effectively final
    }

    // =============================================
    // 5) Anonymous Inner Class
    // =============================================
    /*
        Anonymous Inner Class:
        - No class name
        - Used for one-time implementation
        - Mostly used with interfaces/abstract classes
        - Before Java 8, used heavily for callbacks
        - Java 8+ replaced mostly by Lambda for Functional Interfaces
    */

    interface Greeting {
        void sayHello();
    }

    abstract static class Animal {
        abstract void sound();

        void sleep() {
            System.out.println("Animal sleeping...");
        }
    }

    void anonymousInnerDemo() {

        // Anonymous class implementing interface
        Greeting g = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };
        g.sayHello();

        // Anonymous class extending abstract class
        Animal a = new Animal() {
            @Override
            void sound() {
                System.out.println("Dog says: Bark Bark");
            }
        };
        a.sound();
        a.sleep();
    }

    // =============================================
    // 6) Common Interview Tricks
    // =============================================
    /*
        🔥 Trick 1: Member inner class object creation syntax
        Outer outer = new Outer();
        Outer.MemberInner inner = outer.new MemberInner();

        🔥 Trick 2: Static nested class object creation
        Outer.StaticNested obj = new Outer.StaticNested();

        🔥 Trick 3: Can inner class access private members of outer?
        ✅ YES (compiler creates synthetic bridge)

        🔥 Trick 4: Can member inner class have static method?
        ❌ No (except static final constants)

        🔥 Trick 5: Local inner class can access local variables only if effectively final
        ✅ yes

        🔥 Trick 6: Anonymous inner class cannot have constructor
        ❌ because it has no name
    */

    // =============================================
    // MAIN METHOD: RUN EVERYTHING
    // =============================================
    public static void main(String[] args) {

        System.out.println("========== Member Inner Class ==========");
        InnerClasses outer = new InnerClasses();
        InnerClasses.MemberInner mi = outer.new MemberInner();
        mi.show();

        System.out.println("\n========== Static Nested Class ==========");
        InnerClasses.StaticNested sn = new InnerClasses.StaticNested();
        sn.show();

        System.out.println("\n========== Local Inner Class ==========");
        outer.localInnerDemo();

        System.out.println("\n========== Anonymous Inner Class ==========");
        outer.anonymousInnerDemo();

        System.out.println("\n========== Anonymous Inner Class Output Trick ==========");
        // Anonymous class overrides toString()
        Object obj = new Object() {
            @Override
            public String toString() {
                return "I am Anonymous Object";
            }
        };
        System.out.println(obj); // prints overridden toString()
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What are Inner Classes?
- A class inside another class.

2) Types of inner classes?
- Member inner class (non-static)
- Static nested class
- Local inner class
- Anonymous inner class

3) Can inner class access private members of outer class?
- Yes

4) Difference: Member inner vs Static nested?
Member inner:
- needs outer object
- can access outer instance members

Static nested:
- no outer object needed
- can access only outer static members directly

5) Can member inner class have static members?
- No (except static final constants)

6) What is "effectively final"?
- A local variable not changed after initialization.
- Local inner class can access only final/effectively final variables.

7) Anonymous inner class vs Lambda?
- Lambda works only for Functional Interfaces (single abstract method).
- Anonymous class can implement any interface/abstract class.
*/

