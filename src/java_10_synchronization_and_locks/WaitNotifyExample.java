package java_10_synchronization_and_locks;

/**
 * Covers:
 * - wait() pauses a thread until notified
 * - notify() wakes up one waiting thread
 * - notifyAll() wakes all waiting threads
 * - Importance of synchronized block
 */

public class WaitNotifyExample {

    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();

        Thread waiter = new Thread(new Waiter(message), "Waiter");
        Thread notifier = new Thread(new Notifier(message), "Notifier");

        waiter.start();
        Thread.sleep(500); // ensure waiter runs first
        notifier.start();

        waiter.join();
        notifier.join();

        System.out.println("Wait/Notify demo finished.");
    }

    // Shared message object
    static class Message {
        private String content;
        private boolean hasMessage = false;
    }

    // Waiter thread waits until message is available
    static class Waiter implements Runnable {
        private final Message message;

        public Waiter(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            synchronized (message) {
                while (!message.hasMessage) { // always use while to handle spurious wakeups
                    try {
                        System.out.println(Thread.currentThread().getName() + " is waiting for message...");
                        message.wait(); // releases lock and waits
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " received message: " + message.content);
            }
        }
    }

    // Notifier thread sets the message and notifies waiter
    static class Notifier implements Runnable {
        private final Message message;

        public Notifier(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            synchronized (message) {
                message.content = "Hello from Notifier!";
                message.hasMessage = true;
                System.out.println(Thread.currentThread().getName() + " is notifying waiting thread...");
                message.notify(); // wakes up one waiting thread
                // message.notifyAll(); // optional, wakes all waiting threads
            }
        }
    }
}

