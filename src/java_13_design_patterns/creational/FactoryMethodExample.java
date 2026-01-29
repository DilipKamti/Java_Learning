package java_13_design_patterns.creational;

/**
 * Covers:
 * - Encapsulate object creation
 * - Return different concrete objects based on input
 * - Promotes loose coupling and polymorphism
 */

public class FactoryMethodExample {

    // ===== 1️⃣ Product Interface =====
    interface Shape {
        void draw();
    }

    // ===== 2️⃣ Concrete Products =====
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    // ===== 3️⃣ Factory =====
    static class ShapeFactory {
        public Shape getShape(String shapeType) {
            if (shapeType == null) return null;
            switch (shapeType.toLowerCase()) {
                case "circle": return new Circle();
                case "rectangle": return new Rectangle();
                case "square": return new Square();
                default: return null;
            }
        }
    }

    // ===== 4️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Factory Method = create objects without exposing instantiation
        💡 Input = type / parameters, Output = polymorphic object
        💡 Promotes loose coupling: client code only uses interface
    */

    // ===== 5️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Factory Method and Abstract Factory?
            - Factory Method = one product family, returns interface
            - Abstract Factory = multiple families of products
        🔹 When to use Factory Method?
            - When creation logic is complex or dynamic
            - Avoid using `new` directly in client code
        🔹 Common interview example: Shape, Notification, Vehicle
        🔹 Frequently asked to implement simple Shape Factory in 5-10 min
    */

    // ===== 6️⃣ Test / Demo =====
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("circle");
        Shape shape2 = factory.getShape("rectangle");
        Shape shape3 = factory.getShape("square");

        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}

