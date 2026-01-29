package java_13_design_patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Covers:
 * - Define a one-to-many dependency
 * - When subject changes, all observers are notified automatically
 * - Common use-cases: GUI listeners, event systems, notifications
 */

public class ObserverExample {

    // ===== 1️⃣ Observer Interface =====
    interface Observer {
        void update(String message);
    }

    // ===== 2️⃣ Concrete Observers =====
    static class EmailSubscriber implements Observer {
        private final String email;

        public EmailSubscriber(String email) {
            this.email = email;
        }

        @Override
        public void update(String message) {
            System.out.println("Email to " + email + ": " + message);
        }
    }

    static class SMSSubscriber implements Observer {
        private final String phone;

        public SMSSubscriber(String phone) {
            this.phone = phone;
        }

        @Override
        public void update(String message) {
            System.out.println("SMS to " + phone + ": " + message);
        }
    }

    // ===== 3️⃣ Subject =====
    static class NotificationService {
        private final List<Observer> observers = new ArrayList<>();

        public void addObserver(Observer observer) {
            observers.add(observer);
        }

        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers(String message) {
            for (Observer o : observers) {
                o.update(message);
            }
        }
    }

    // ===== 4️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Observer = subject + observers
        💡 Subject notifies all observers automatically on state change
        💡 One-to-many dependency
    */

    // ===== 5️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Observer and Listener?
            - Observer is a design pattern; Listener is a concrete implementation
        🔹 When to use Observer?
            - Event-driven systems, GUI updates, messaging notifications
        🔹 Common interview example: Stock price update, Chat message notifications
        🔹 Java built-in support: java.util.Observable (deprecated), java.beans.PropertyChangeListener
    */

    // ===== 6️⃣ Test / Demo =====
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Observer emailObs = new EmailSubscriber("john@example.com");
        Observer smsObs = new SMSSubscriber("555-1234");

        service.addObserver(emailObs);
        service.addObserver(smsObs);

        service.notifyObservers("New product launched!");
        System.out.println("--- Removing SMS Observer ---");
        service.removeObserver(smsObs);
        service.notifyObservers("Discount offer available!");
    }
}

