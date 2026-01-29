package java_10_synchronization_and_locks;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Covers:
 * - Thread-safe queue (ArrayBlockingQueue)
 * - put() / take() methods
 * - No need for explicit wait/notify
 * - Handles multiple producers and consumers
 */

public class ProducerConsumerWithBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // shared buffer

        Thread producer1 = new Thread(new Producer(queue), "Producer1");
        Thread producer2 = new Thread(new Producer(queue), "Producer2");
        Thread consumer1 = new Thread(new Consumer(queue), "Consumer1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        // Let the threads run for some time
        Thread.sleep(5000);

        // Stop all threads (in real-world, better to use a poison pill or stop flag)
        producer1.interrupt();
        producer2.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Producer-Consumer with BlockingQueue demo finished.");
    }

    // Producer
    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;
        private int counter = 0;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    queue.put(++counter); // blocks if queue full
                    System.out.println(Thread.currentThread().getName() + " produced: " + counter);
                    Thread.sleep(200); // simulate production time
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }

    // Consumer
    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int item = queue.take(); // blocks if queue empty
                    System.out.println(Thread.currentThread().getName() + " consumed: " + item);
                    Thread.sleep(500); // simulate consumption time
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}

