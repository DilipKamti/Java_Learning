package java_13_design_patterns.behavioral;
/**
 * StrategyExample.java
 *
 * Demonstrates the Strategy Pattern
 *
 * Covers:
 * - Define a family of algorithms
 * - Encapsulate each algorithm
 * - Make algorithms interchangeable at runtime
 */

public class StrategyExample {

    // ===== 1️⃣ Strategy Interface =====
    interface PaymentStrategy {
        void pay(int amount);
    }

    // ===== 2️⃣ Concrete Strategies =====
    static class CreditCardPayment implements PaymentStrategy {
        private final String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card " + cardNumber);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private final String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal account " + email);
        }
    }

    static class BitcoinPayment implements PaymentStrategy {
        private final String wallet;

        public BitcoinPayment(String wallet) {
            this.wallet = wallet;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Bitcoin wallet " + wallet);
        }
    }

    // ===== 3️⃣ Context =====
    static class PaymentContext {
        private PaymentStrategy strategy;

        public PaymentContext(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void pay(int amount) {
            strategy.pay(amount);
        }
    }

    // ===== 4️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Strategy = choose algorithm at runtime
        💡 Context uses a strategy
        💡 Each algorithm is encapsulated in its own class
    */

    // ===== 5️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Strategy and State pattern?
            - Strategy: change behavior based on algorithm (client chooses)
            - State: change behavior based on internal state (object decides)
        🔹 When to use Strategy?
            - Multiple algorithms for same task
            - Avoid if/else/switch statements
        🔹 Common interview example: Payment, Sorting, Compression, Discount calculation
    */

    // ===== 6️⃣ Test / Demo =====
    public static void main(String[] args) {
        PaymentContext payment = new PaymentContext(new CreditCardPayment("1234-5678-9876-5432"));
        payment.pay(100);

        payment.setStrategy(new PayPalPayment("john@example.com"));
        payment.pay(200);

        payment.setStrategy(new BitcoinPayment("1FfmbHfnpaZjKFvyi1okTjJJusN455paPH"));
        payment.pay(500);
    }
}

