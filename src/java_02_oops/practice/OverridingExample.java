package java_02_oops.practice;

class Parent {
    void display() {
        System.out.println("This is the parent class.");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("This is the child class.");
    }
}

public class OverridingExample {

    public static void main(String args[]){
        Parent parent = new Parent();
        parent.display(); // Output: This is the parent class.

        Child child = new Child();
        child.display(); // Output: This is the child class.

        Parent parentRefChild = new Child();
        parentRefChild.display(); // Output: This is the child class. (Runtime Polymorphism)

        Child childRefParent = (Child) parent; // This will throw ClassCastException at runtime because parent is not an instance of Child
        childRefParent.display(); // This line will not be executed due to the exception
    }
}
