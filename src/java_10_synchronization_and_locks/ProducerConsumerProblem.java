package java_10_synchronization_and_locks;

/**
 * Covers:
 * - Shared resource and monitor
 * - wait() / notify() / notifyAll()
 * - Thread-safe producer-consumer pattern
 * - Deadlock avoidance
 */

public class ProducerConsumerProblem {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(5);

        Thread producerThread = new Thread(new Producer(buffer), "Producer");
        Thread consumerThread = new Thread(new Consumer(buffer), "Consumer");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Producer-Consumer demo finished.");
    }

    // Shared buffer class
    static class Buffer {
        private final int[] items;
        private int count = 0;
        private int putIndex = 0;
        private int takeIndex = 0;

        public Buffer(int size) {
            items = new int[size];
        }

        // Produce item
        public synchronized void put(int item) throws InterruptedException {
            while (count == items.length) { // buffer full
                wait(); // wait until space available
            }
            items[putIndex] = item;
            putIndex = (putIndex + 1) % items.length;
            count++;
            System.out.println(Thread.currentThread().getName() + " produced: " + item);
            notify(); // notify waiting consumer
        }

        // Consume item
        public synchronized int take() throws InterruptedException {
            while (count == 0) { // buffer empty
                wait(); // wait until item available
            }
            int item = items[takeIndex];
            takeIndex = (takeIndex + 1) % items.length;
            count--;
            System.out.println(Thread.currentThread().getName() + " consumed: " + item);
            notify(); // notify waiting producer
            return item;
        }
    }

    // Producer
    static class Producer implements Runnable {
        private final Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.put(i);
                    Thread.sleep(200); // simulate production time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Consumer
    static class Consumer implements Runnable {
        private final Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.take();
                    Thread.sleep(500); // simulate consumption time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
