package java_07_8_features;

// DefaultStaticMethods.java
// Java 8 Default and Static Methods in Interfaces - Deep Dive ✅

interface MyInterface {
    void abstractMethod();

    default void defaultMethod() {
        System.out.println("Default method implementation");
    }

    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

public class DefaultStaticMethods implements MyInterface {

    @Override
    public void abstractMethod() {
        System.out.println("Implemented abstract method");
    }

    public static void main(String[] args) {
        DefaultStaticMethods obj = new DefaultStaticMethods();

        obj.abstractMethod();
        obj.defaultMethod(); // call default method

        MyInterface.staticMethod(); // call static method from interface
    }
}

/*
Interview Tips:
1) Default methods allow extending interfaces without breaking implementations.
2) Static methods in interfaces belong to interface, not instance.
3) Can override default methods in implementing classes.
*/

