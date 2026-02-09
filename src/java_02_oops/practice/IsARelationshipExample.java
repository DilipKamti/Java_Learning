package java_02_oops.practice;

class animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class dog extends animal {
}

class cat extends animal {

    @Override
    void eat() {
        System.out.println("Cat eats");
    }

}


public class IsARelationshipExample {
    public static void main(String args[]) {

        animal a= new animal();
        a.eat();

        dog d= new dog();
        d.eat();

        cat c= new cat();
        c.eat();

        animal cat= new cat();
        cat.eat();

        animal dog= new dog();
        dog.eat();



    }
}
