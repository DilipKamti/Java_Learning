package java_02_oops.practice;

interface MyInterface{
    void abstarctMethod();
    default void defaultMethod(){
        System.out.println("This is a default method in the interface.");
    }

    static void staticMethod(){
        System.out.println("This is a static method in the interface.");
    }
}

class MyClass implements  MyInterface{

    @Override
    public void abstarctMethod() {
        System.out.println("This is the implementation of the abstract method.");
    }

}

class MyClass2 implements MyInterface{

    @Override
    public void abstarctMethod() {
        System.out.println("This is the implementation of the abstract method in MyClass2.");
    }

    @Override
    public void defaultMethod() {
        MyInterface.super.defaultMethod();
    }
}

public class DefaultAndStaticMethodExample {

    static void main(String args[]){
        MyClass myclass = new MyClass();

        myclass.abstarctMethod();
        myclass.defaultMethod();

        MyInterface.staticMethod();

        MyClass2 myclass2 = new MyClass2();
        myclass2.abstarctMethod();
        myclass2.defaultMethod();
    }
}
