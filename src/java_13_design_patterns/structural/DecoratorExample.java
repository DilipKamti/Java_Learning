package java_13_design_patterns.structural;

/**
 * Covers:
 * - Add responsibilities to objects dynamically
 * - Avoid subclass explosion
 * - Common use-cases: Java I/O streams, logging, UI components
 */

public class DecoratorExample {

    // ===== 1️⃣ Component Interface =====
    interface Coffee {
        String getDescription();
        double getCost();
    }

    // ===== 2️⃣ Concrete Component =====
    static class SimpleCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "Simple Coffee";
        }

        @Override
        public double getCost() {
            return 5.0;
        }
    }

    // ===== 3️⃣ Decorator Abstract Class =====
    static abstract class CoffeeDecorator implements Coffee {
        protected final Coffee coffee;

        public CoffeeDecorator(Coffee coffee) {
            this.coffee = coffee;
        }

        public String getDescription() {
            return coffee.getDescription();
        }

        public double getCost() {
            return coffee.getCost();
        }
    }

    // ===== 4️⃣ Concrete Decorators =====
    static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return coffee.getDescription() + ", Milk";
        }

        @Override
        public double getCost() {
            return coffee.getCost() + 2.0;
        }
    }

    static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }

        @Override
        public String getDescription() {
            return coffee.getDescription() + ", Sugar";
        }

        @Override
        public double getCost() {
            return coffee.getCost() + 1.0;
        }
    }

    // ===== 5️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Decorator = wrap object to add responsibilities dynamically
        💡 Avoid subclass explosion
        💡 Can chain multiple decorators
    */

    // ===== 6️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Decorator and Adapter?
            - Decorator: adds responsibilities dynamically
            - Adapter: changes interface to match client expectation
        🔹 When to use Decorator?
            - Add features dynamically without changing original class
            - Example: Java I/O streams, Logging, GUI components
        🔹 Common interview question: Coffee/Tea example, wrap features dynamically
    */

    // ===== 7️⃣ Test / Demo =====
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " Cost: " + simpleCoffee.getCost());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " Cost: " + milkCoffee.getCost());

        Coffee milkSugarCoffee = new SugarDecorator(milkCoffee);
        System.out.println(milkSugarCoffee.getDescription() + " Cost: " + milkSugarCoffee.getCost());
    }
}

