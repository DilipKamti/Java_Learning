package java_11_executor_framework;

import java.util.concurrent.*;

public class ScheduledExecutorExample {

    public static void main(String[] args) throws InterruptedException {
        // =========================
        // 1️⃣ Basics: Create Scheduler
        // =========================
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable simpleTask = () -> System.out.println("Simple Task at: " + java.time.LocalTime.now());

        // Schedule once after 2 seconds
        scheduler.schedule(simpleTask, 2, TimeUnit.SECONDS);

        // =========================
        // 2️⃣ Fixed Rate vs Fixed Delay
        // =========================
        Runnable fixedRateTask = () -> System.out.println("FixedRate Task at: " + java.time.LocalTime.now());
        Runnable fixedDelayTask = () -> {
            System.out.println("FixedDelay Task started at: " + java.time.LocalTime.now());
            try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }
        };

        // Initial delay = 1s, then every 3s (start-to-start)
        scheduler.scheduleAtFixedRate(fixedRateTask, 1, 3, TimeUnit.SECONDS);

        // Initial delay = 1s, then 3s after previous task finishes
        scheduler.scheduleWithFixedDelay(fixedDelayTask, 1, 3, TimeUnit.SECONDS);

        // =========================
        // 3️⃣ Deep Dive / Tips
        // =========================
        /**
         * 💡 Key Tips & Memory Hooks:
         * - schedule() → runs once after delay
         * - scheduleAtFixedRate() → strict periodic execution (start-to-start)
         * - scheduleWithFixedDelay() → consistent gap between end of task and next start
         * - shutdown() → graceful shutdown
         * - shutdownNow() → immediate shutdown (interrupts running tasks)
         *
         * Memory Hooks:
         * - "Rate starts the stopwatch at the start"
         * - "Delay waits after finishing"
         */

        // =========================
        // 4️⃣ CompletableFuture + Scheduler Trick
        // =========================
        Runnable cfTask = () -> System.out.println("CompletableFuture + Scheduler at: " + java.time.LocalTime.now());
        CompletableFuture<Void> future = CompletableFuture.runAsync(cfTask, scheduler);
        // Useful for async + periodic scheduling combined

        // =========================
        // 5️⃣ Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between scheduleAtFixedRate and scheduleWithFixedDelay?
         * 🔹 Q2: What happens if a task takes longer than the period in scheduleAtFixedRate?
         *      → Next execution runs immediately after previous finishes (does not skip)
         * 🔹 Q3: How to gracefully shutdown scheduler?
         * 🔹 Q4: Difference between single-threaded vs thread pool scheduler
         * 🔹 Q5: Can you use CompletableFuture with ScheduledExecutorService?
         * 🔹 Q6: How to handle exceptions in periodic tasks?
         *      → Wrap Runnable in try-catch; uncaught exceptions stop future executions
         */

        // =========================
        // 6️⃣ Auto shutdown after 15s demo
        // =========================
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler...");
            scheduler.shutdown();
        }, 15, TimeUnit.SECONDS);

        // Keep main thread alive to see scheduled tasks
        scheduler.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("Main thread exiting");
    }
}

