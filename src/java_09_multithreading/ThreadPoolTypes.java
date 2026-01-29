package java_09_multithreading;

import java.util.concurrent.*;

/**
 * Covers:
 * - SingleThreadExecutor
 * - FixedThreadPool
 * - CachedThreadPool
 * - ScheduledThreadPool
 * - Differences and use-cases
 */

public class ThreadPoolTypes {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== 1️⃣ SingleThreadExecutor =====");
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        Runnable task1 = () -> System.out.println(Thread.currentThread().getName() + " executing task 1");
        Runnable task2 = () -> System.out.println(Thread.currentThread().getName() + " executing task 2");
        singleExecutor.submit(task1);
        singleExecutor.submit(task2);
        singleExecutor.shutdown();
        singleExecutor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("\n===== 2️⃣ FixedThreadPool =====");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3); // 3 threads
        for (int i = 1; i <= 5; i++) {
            int taskNum = i;
            fixedPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " executing fixedPool task " + taskNum);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            });
        }
        fixedPool.shutdown();
        fixedPool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n===== 3️⃣ CachedThreadPool =====");
        ExecutorService cachedPool = Executors.newCachedThreadPool(); // dynamically creates threads
        for (int i = 1; i <= 5; i++) {
            int taskNum = i;
            cachedPool.submit(() -> System.out.println(Thread.currentThread().getName() + " executing cachedPool task " + taskNum));
        }
        cachedPool.shutdown();
        cachedPool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n===== 4️⃣ ScheduledThreadPool =====");
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        scheduledPool.schedule(() -> System.out.println(Thread.currentThread().getName() + " - one-time scheduled task"), 1, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName() + " - fixedRate task"), 1, 2, TimeUnit.SECONDS);
        scheduledPool.scheduleWithFixedDelay(() -> System.out.println(Thread.currentThread().getName() + " - fixedDelay task"), 1, 2, TimeUnit.SECONDS);

        // Wait for 5 seconds and shutdown
        Thread.sleep(5000);
        scheduledPool.shutdown();
        scheduledPool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n===== 5️⃣ Memory Hooks / Easy Way to Remember =====");
        System.out.println("""
            💡 SingleThreadExecutor = 1 thread, tasks execute sequentially
            💡 FixedThreadPool = N threads, good for predictable load
            💡 CachedThreadPool = grows/shrinks dynamically, good for many short-lived tasks
            💡 ScheduledThreadPool = periodic or delayed execution
        """);

        System.out.println("\n===== 6️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between FixedPool and CachedPool?
                - FixedPool = fixed number of threads
                - CachedPool = dynamic, may create new threads as needed
            🔹 When to use SingleThreadExecutor?
                - Tasks must run sequentially, preserve order
            🔹 ScheduledThreadPool vs Timer?
                - ScheduledExecutorService is thread-safe, better than Timer
            🔹 shutdown() vs shutdownNow()?
                - shutdown() waits for tasks, shutdownNow() tries to stop immediately
            🔹 Why avoid creating your own thread every task?
                - Thread creation is expensive, use thread pools for efficiency
        """);
    }
}

