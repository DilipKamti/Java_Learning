package java_12_java_concurrency;

import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class AtomicExamples {

    public static void main(String[] args) throws InterruptedException {
        // =========================
        // 1️⃣ Basics: AtomicInteger
        // =========================
        AtomicInteger atomicInt = new AtomicInteger(0);
        System.out.println("Initial AtomicInteger: " + atomicInt.get());

        // Increment atomically
        atomicInt.incrementAndGet(); // +1
        System.out.println("After increment: " + atomicInt.get());

        // Add value atomically
        atomicInt.addAndGet(5); // +5
        System.out.println("After add 5: " + atomicInt.get());

        // Compare and set
        boolean success = atomicInt.compareAndSet(6, 100);
        System.out.println("CAS success? " + success + ", value now: " + atomicInt.get());

        // =========================
        // 2️⃣ AtomicLong & AtomicBoolean
        // =========================
        AtomicLong atomicLong = new AtomicLong(50);
        atomicLong.incrementAndGet();
        System.out.println("AtomicLong after increment: " + atomicLong.get());

        AtomicBoolean atomicBool = new AtomicBoolean(false);
        atomicBool.set(true);
        System.out.println("AtomicBoolean value: " + atomicBool.get());

        // =========================
        // 3️⃣ AtomicReference (Objects)
        // =========================
        AtomicReference<String> atomicRef = new AtomicReference<>("Hello");
        atomicRef.set("World");
        System.out.println("AtomicReference value: " + atomicRef.get());

        atomicRef.compareAndSet("World", "Java");
        System.out.println("After CAS on AtomicReference: " + atomicRef.get());

        // =========================
        // 4️⃣ Deep Dive: Practical Usage
        // =========================
        /**
         * 🔹 Atomic classes use **compare-and-swap (CAS)** under the hood
         * 🔹 They provide **lock-free thread safety**
         * 🔹 Always better for **highly contended counters** than synchronized
         * 🔹 Useful in concurrent algorithms, caches, counters, flags
         */

        // Example: Concurrent increment using AtomicInteger
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        };

        for (int i = 0; i < 5; i++) {
            executor.submit(incrementTask);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Final counter value (should be 5000): " + counter.get());

        // =========================
        // 5️⃣ Memory Hooks / Tips
        // =========================
        /**
         * 💡 Memory Hooks:
         * - AtomicInteger / AtomicLong = integer counters (lock-free)
         * - AtomicBoolean = flags (lock-free)
         * - AtomicReference = object references (lock-free)
         * - All methods are **thread-safe without synchronized**
         * - CAS may retry internally if there is contention
         */

        // =========================
        // 6️⃣ Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between AtomicInteger and synchronized int?
         * 🔹 Q2: How does compareAndSet work internally?
         * 🔹 Q3: When to use AtomicReference over volatile?
         * 🔹 Q4: Are atomic classes always faster than locks?
         * 🔹 Q5: How to implement a thread-safe counter with AtomicInteger?
         * 🔹 Q6: Can you use AtomicReference for immutable objects safely?
         */
    }
}

