package java_oops;

class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name; // this refers to current object
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class ClassAndObject {

    static void main(String[] args) {

        // 1) Creating objects
        Student s1 = new Student("Dilip", 22);
        Student s2 = new Student("Ravi", 21);

        s1.display();
        s2.display();

        System.out.println("--------------");

        // 2) Reference copy example
        Student s3 = s1; // s3 points to same object as s1
        s3.name = "Changed Name";

        s1.display(); // will reflect changes
        s3.display();

        System.out.println("--------------");

        // 3) Anonymous object
        new Student("Anonymous", 99).display();

        System.out.println("--------------");

        // 4) Null reference example
        Student s4 = null;
        // s4.display(); // Uncomment -> NullPointerException
    }

    /*
    Q) Where object is stored?

        ✅ Object → Heap
        ✅ Reference → Stack
     */
}

