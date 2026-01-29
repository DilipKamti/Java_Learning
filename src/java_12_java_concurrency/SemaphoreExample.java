package java_12_java_concurrency;

import java.util.concurrent.*;

public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {
        // =========================
        // 1️⃣ Basics: Creating a Semaphore
        // =========================
        int permits = 2; // maximum concurrent threads
        Semaphore semaphore = new Semaphore(permits);

        Runnable worker = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + " is waiting for a permit...");
                semaphore.acquire(); // acquire a permit
                System.out.println(threadName + " acquired a permit, working...");
                Thread.sleep((long) (Math.random() * 3000)); // simulate work
                System.out.println(threadName + " finished work and released permit.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // release permit
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(worker);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // =========================
        // 2️⃣ Deep Dive / Tips
        // =========================
        /**
         * 🔹 Semaphore controls access to a shared resource using permits
         * 🔹 Key methods:
         *      - acquire() → blocks until a permit is available
         *      - release() → releases a permit
         *      - tryAcquire() → non-blocking attempt to get permit
         * 🔹 Can be used for:
         *      - Limiting number of concurrent threads accessing a resource
         *      - Implementing producer-consumer or rate limiting
         * 🔹 Fair semaphore: new Semaphore(permits, true) → FIFO order
         */

        // =========================
        // 3️⃣ Memory Hooks / Easy Way to Remember
        // =========================
        /**
         * 💡 "Semaphore = gatekeeper = N permits"
         * - acquire() → ask for a pass
         * - release() → return the pass
         * - maximum threads working concurrently = number of permits
         */

        // =========================
        // 4️⃣ Common Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between Semaphore and CountDownLatch?
         *      → Semaphore controls access (permits), CountDownLatch waits for events
         * 🔹 Q2: Difference between Semaphore and Mutex/Lock?
         *      → Mutex = single permit semaphore (binary), Semaphore can have multiple permits
         * 🔹 Q3: Fair vs Non-fair semaphore?
         * 🔹 Q4: Can you reuse a Semaphore?
         * 🔹 Q5: How to implement resource pool using Semaphore?
         */

        // =========================
        // 5️⃣ Advanced Example: Resource Pool
        // =========================
        Semaphore resourcePool = new Semaphore(3); // 3 resources
        Runnable resourceTask = () -> {
            String name = Thread.currentThread().getName();
            try {
                resourcePool.acquire();
                System.out.println(name + " acquired a resource.");
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println(name + " released the resource.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                resourcePool.release();
            }
        };

        ExecutorService exec = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            exec.submit(resourceTask);
        }

        exec.shutdown();
        exec.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("All tasks completed.");

        //"Semaphore = gatekeeper = N permits"
    }
}

