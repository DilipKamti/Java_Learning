package java_12_java_concurrency;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        // =========================
        // 1️⃣ Basics: Creating CountDownLatch
        // =========================
        int numWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numWorkers);

        Runnable worker = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " is working...");
                Thread.sleep((long) (Math.random() * 3000)); // simulate work
                System.out.println(threadName + " finished work.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // decrement the latch
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);
        for (int i = 0; i < numWorkers; i++) {
            executor.submit(worker);
        }

        // Main thread waits until all workers finish
        System.out.println("Main thread waiting for workers to finish...");
        latch.await(); // blocks until count reaches 0
        System.out.println("All workers finished. Main thread proceeding.");

        executor.shutdown();

        // =========================
        // 2️⃣ Deep Dive / Tips
        // =========================
        /**
         * 🔹 CountDownLatch allows one or more threads to wait for a set of operations to complete
         * 🔹 Key methods:
         *      - countDown() → decrement the count
         *      - await() → wait until count reaches 0
         * 🔹 Once count reaches 0, latch cannot be reused (not resettable)
         * 🔹 Useful for:
         *      - Waiting for multiple services to start
         *      - Waiting for multiple threads to finish before continuing
         */

        // =========================
        // 3️⃣ Memory Hooks / Easy Way to Remember
        // =========================
        /**
         * 💡 "Latch = Countdown = wait for others to finish"
         * - countDown() → like pulling down a lever
         * - await() → blocks until all levers pulled
         * - cannot reset → for reusable, use CyclicBarrier
         */

        // =========================
        // 4️⃣ Common Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between CountDownLatch and CyclicBarrier?
         *      → CountDownLatch cannot reset, CyclicBarrier can reuse
         * 🔹 Q2: What happens if await() is called after count reaches 0?
         *      → Returns immediately
         * 🔹 Q3: Can CountDownLatch count go below 0?
         *      → No, it stays at 0
         * 🔹 Q4: Use case in microservices / thread coordination?
         * 🔹 Q5: Difference between CountDownLatch and Semaphore?
         *      → Latch waits for completion, Semaphore controls access to resources
         */

        // =========================
        // 5️⃣ Advanced Example: Multiple Latches
        // =========================
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(2);

        Runnable task = () -> {
            try {
                startLatch.await(); // wait for start signal
                String name = Thread.currentThread().getName();
                System.out.println(name + " started task...");
                Thread.sleep(1000);
                System.out.println(name + " finished task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneLatch.countDown();
            }
        };

        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(task);
        exec.submit(task);

        System.out.println("Releasing tasks...");
        startLatch.countDown(); // start all tasks
        doneLatch.await(); // wait for all tasks to finish
        System.out.println("All tasks completed.");

        exec.shutdown();
    }
}
