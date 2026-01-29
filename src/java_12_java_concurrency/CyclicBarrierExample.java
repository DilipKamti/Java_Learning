package java_12_java_concurrency;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        // =========================
        // 1️⃣ Basics: Creating CyclicBarrier
        // =========================
        int numWorkers = 3;

        // Barrier action runs when all threads reach the barrier
        Runnable barrierAction = () -> System.out.println("All threads reached barrier. Barrier action executed!");

        CyclicBarrier barrier = new CyclicBarrier(numWorkers, barrierAction);

        Runnable worker = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + " is working...");
                Thread.sleep((long) (Math.random() * 3000)); // simulate work
                System.out.println(threadName + " reached barrier.");
                barrier.await(); // wait for others
                System.out.println(threadName + " passed the barrier and continues work...");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);
        for (int i = 0; i < numWorkers; i++) {
            executor.submit(worker);
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // =========================
        // 2️⃣ Deep Dive / Tips
        // =========================
        /**
         * 🔹 CyclicBarrier allows a set of threads to wait for each other repeatedly
         * 🔹 Key methods:
         *      - await() → waits until all threads reach the barrier
         *      - getNumberWaiting() → how many threads are currently waiting
         *      - getParties() → total number of threads required to trip the barrier
         * 🔹 Barrier is **reusable** after all threads reach it
         * 🔹 Useful for:
         *      - Multi-stage computation
         *      - Phased tasks where threads must sync at checkpoints
         */

        // =========================
        // 3️⃣ Memory Hooks / Easy Way to Remember
        // =========================
        /**
         * 💡 "CyclicBarrier = cyclic = reusable barrier"
         * - await() → thread waits
         * - barrier action → runs when all threads reach
         * - unlike CountDownLatch, can reuse for next cycle
         */

        // =========================
        // 4️⃣ Common Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between CountDownLatch and CyclicBarrier?
         *      → Latch is one-time, Barrier is reusable
         * 🔹 Q2: What happens if a thread is interrupted while waiting at barrier?
         *      → BrokenBarrierException is thrown, barrier is broken
         * 🔹 Q3: What is the barrier action? When does it execute?
         * 🔹 Q4: Can you use CyclicBarrier for coordinating more than two phases?
         * 🔹 Q5: How to check how many threads are waiting at the barrier?
         * 🔹 Q6: Difference between CyclicBarrier and Phaser?
         */

        // =========================
        // 5️⃣ Advanced Example: Multiple Phases
        // =========================
        int phases = 2;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numWorkers, () ->
                System.out.println("Barrier tripped! Phase complete.")
        );

        Runnable phaseTask = () -> {
            String name = Thread.currentThread().getName();
            try {
                for (int phase = 1; phase <= phases; phase++) {
                    System.out.println(name + " working on phase " + phase);
                    Thread.sleep((long) (Math.random() * 2000));
                    System.out.println(name + " reached barrier in phase " + phase);
                    cyclicBarrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        ExecutorService exec = Executors.newFixedThreadPool(numWorkers);
        for (int i = 0; i < numWorkers; i++) {
            exec.submit(phaseTask);
        }

        exec.shutdown();
        exec.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All phases completed.");

        //"CyclicBarrier = cyclic = reusable barrier"
    }
}
