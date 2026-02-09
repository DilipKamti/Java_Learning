package java_02_oops.practice;

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

/*
*   Car has an Engine, so it is a "has-a" relationship
*   Child clas can not exist without parent class, but parent class can exist without child class
*
*   Composition (Strong HAS-A)
*   --------------------------
*   Composition is a design principle in object-oriented programming where one class contains an instance of another class as a member variable.
*   It represents a "has-a" relationship between the classes, where the containing class (the "whole") is composed of one or more instances
*   of the contained class (the "part"). In composition, the lifecycle of the contained class is typically managed by the containing class,
*   meaning that when the containing class is destroyed, the contained class is also destroyed. This allows for better encapsulation and
*   modularity in code design.
*
* */
class VolvoCar {
    private Engine e = new Engine(); // VolvoCar has an Engine, so it is a "has-a" relationship

    void start() {
        e.start();
        System.out.println("Car started");
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

/*
*   BMWCar has a Driver, so it is a "has-a" relationship
*   Child can exist independently
*
*   Aggregation (Weak HAS-A)
*   ----------------------
*   Aggregation is a design principle in object-oriented programming where one class contains a reference to another
*   class as a member variable, but the lifecycle of the contained class is not managed by the containing class.
*   In aggregation, the contained class can exist independently of the containing class, meaning that when the
*   containing class is destroyed, the contained class can still exist. This allows for more flexibility in code design,
*   as the contained class can be shared among multiple containing classes or can exist on its own without being tied
*   to a specific containing class.
*
* */

class BMWCar {
    private Driver driver; // BMWCar has a Driver, so it is a "has-a" relationship

    BMWCar(Driver driver) {
        this.driver = driver;
    }
}


public class HasARelationshipExample {

    public static void main(String args[]){

    }
}
