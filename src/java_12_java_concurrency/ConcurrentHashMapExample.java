package java_12_java_concurrency;

import java.util.concurrent.*;
import java.util.Map;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {
        // =========================
        // 1️⃣ Basics: Creating ConcurrentHashMap
        // =========================
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Add elements
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        System.out.println("Initial Map: " + map);

        // Get elements
        int appleCount = map.get("Apple");
        System.out.println("Apple count: " + appleCount);

        // Remove element
        map.remove("Banana");
        System.out.println("After removing Banana: " + map);

        // =========================
        // 2️⃣ Atomic Operations
        // =========================
        // putIfAbsent → adds only if key is missing
        map.putIfAbsent("Mango", 50);
        System.out.println("After putIfAbsent Mango: " + map);

        // compute → atomically update a value
        map.compute("Apple", (k, v) -> v == null ? 0 : v + 5);
        System.out.println("After compute Apple +5: " + map);

        // merge → add to existing or insert if absent
        map.merge("Orange", 10, Integer::sum);
        System.out.println("After merge Orange +10: " + map);

        // =========================
        // 3️⃣ Iteration (Thread-safe)
        // =========================
        System.out.println("Iterating map:");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        // =========================
        // 4️⃣ Deep Dive / Tips
        // =========================
        /**
         * 🔹 ConcurrentHashMap allows **thread-safe access without locking the whole map**
         * 🔹 Uses **internal segment locks** (Java 8+ uses CAS + synchronized per bin)
         * 🔹 Key methods:
         *      - putIfAbsent → atomic insert if missing
         *      - compute / computeIfAbsent / computeIfPresent → atomic updates
         *      - merge → atomically combine values
         *      - forEach / reduce / search → supports parallel-friendly operations
         * 🔹 Avoid using synchronized(map) around ConcurrentHashMap → defeats purpose
         */

        // =========================
        // 5️⃣ Example: Multi-threaded update
        // =========================
        ConcurrentHashMap<String, Integer> counterMap = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counterMap.merge("Counter", 1, Integer::sum); // atomic increment
            }
        };

        for (int i = 0; i < 4; i++) {
            executor.submit(task);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Final Counter value (should be 4000): " + counterMap.get("Counter"));

        // =========================
        // 6️⃣ Memory Hooks / Tricks
        // =========================
        /**
         * 💡 Memory Hooks:
         * - CHM = "thread-safe HashMap with lock-free reads"
         * - use merge/compute for atomic updates
         * - for multi-thread counters, always use atomic ops (avoid get+put)
         * - allows high concurrency (better than synchronized HashMap)
         */

        // =========================
        // 7️⃣ Interview Questions / Tricks
        // =========================
        /**
         * 🔹 Q1: Difference between HashMap, Hashtable, ConcurrentHashMap?
         * 🔹 Q2: Is ConcurrentHashMap thread-safe for iteration?
         * 🔹 Q3: Can you put null key or value?
         * 🔹 Q4: How does ConcurrentHashMap achieve thread-safety internally?
         * 🔹 Q5: Difference between computeIfAbsent and putIfAbsent?
         * 🔹 Q6: When to use ConcurrentHashMap vs synchronized HashMap?
         */
    }
}

