package java_12_java_concurrency;

import java.util.concurrent.*;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        // =========================
        // 1️⃣ Basics: Creating BlockingQueue
        // =========================
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // capacity = 5

        // Producer
        Runnable producer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " producing: " + i);
                    queue.put(i); // blocks if queue is full
                    Thread.sleep(200); // simulate production delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Consumer
        Runnable consumer = () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int val = queue.take(); // blocks if queue is empty
                    System.out.println(Thread.currentThread().getName() + " consumed: " + val);
                    Thread.sleep(500); // simulate consumption delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(producer);
        executor.submit(consumer);

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // =========================
        // 2️⃣ Deep Dive / Tips
        // =========================
        /**
         * 🔹 BlockingQueue is thread-safe queue for producer-consumer patterns
         * 🔹 Common implementations:
         *      - ArrayBlockingQueue → fixed-size array
         *      - LinkedBlockingQueue → optionally bounded, linked nodes
         *      - PriorityBlockingQueue → priority-based ordering
         *      - DelayQueue → time-based delays
         * 🔹 Key methods:
         *      - put() → blocks if full
         *      - take() → blocks if empty
         *      - offer() → non-blocking insert
         *      - poll() → non-blocking remove
         */

        // =========================
        // 3️⃣ Memory Hooks / Easy Way to Remember
        // =========================
        /**
         * 💡 "BlockingQueue = safe queue = producer waits if full, consumer waits if empty"
         * - put() blocks if full
         * - take() blocks if empty
         * - perfect for producer-consumer coordination
         */

        // =========================
        // 4️⃣ Common Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between BlockingQueue and ConcurrentLinkedQueue?
         *      → BlockingQueue can block producers/consumers, concurrent queue never blocks
         * 🔹 Q2: Difference between ArrayBlockingQueue and LinkedBlockingQueue?
         * 🔹 Q3: Can BlockingQueue be used for multiple producers and consumers safely?
         * 🔹 Q4: What happens if queue is full and producer calls put()?
         * 🔹 Q5: Can we use BlockingQueue with Executors to build producer-consumer pipeline?
         */

        // =========================
        // 5️⃣ Advanced Example: Multiple Producers and Consumers
        // =========================
        BlockingQueue<String> taskQueue = new LinkedBlockingQueue<>(3);

        Runnable producerTask = () -> {
            String[] tasks = {"A", "B", "C", "D", "E"};
            for (String task : tasks) {
                try {
                    System.out.println(Thread.currentThread().getName() + " producing: " + task);
                    taskQueue.put(task);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    String task = taskQueue.take();
                    System.out.println(Thread.currentThread().getName() + " consuming: " + task);
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.submit(producerTask);
        pool.submit(producerTask);
        pool.submit(consumerTask);
        pool.submit(consumerTask);

        pool.shutdown();
        pool.awaitTermination(15, TimeUnit.SECONDS);

        System.out.println("All producer-consumer tasks completed.");

        //"BlockingQueue = safe queue; producer waits if full, consumer waits if empty"
    }
}
