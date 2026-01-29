package java_11_executor_framework;

import java.util.concurrent.*;

/**
 * Covers:
 * - CorePoolSize vs MaximumPoolSize
 * - WorkQueue types (LinkedBlockingQueue, SynchronousQueue)
 * - ThreadFactory
 * - RejectedExecutionHandler policies
 * - Shutdown and awaitTermination
 */

public class ThreadPoolExecutorDeepDive {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== 1️⃣ Create ThreadPoolExecutor =====");

        int corePoolSize = 2;
        int maxPoolSize = 4;
        long keepAliveTime = 5;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2); // limited queue

        // Custom thread factory
        ThreadFactory threadFactory = runnable -> new Thread(runnable, "CustomThread");

        // Rejection policy
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy(); // throws exception

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler
        );

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing task");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        };

        System.out.println("\n===== 2️⃣ Submit tasks =====");
        for (int i = 1; i <= 8; i++) { // submit more tasks than core + queue to trigger max threads
            try {
                executor.submit(task);
            } catch (RejectedExecutionException e) {
                System.out.println("Task " + i + " rejected: " + e.getMessage());
            }
        }

        System.out.println("\n===== 3️⃣ Executor stats =====");
        System.out.println("Core pool size: " + executor.getCorePoolSize());
        System.out.println("Maximum pool size: " + executor.getMaximumPoolSize());
        System.out.println("Active threads: " + executor.getActiveCount());
        System.out.println("Completed tasks: " + executor.getCompletedTaskCount());
        System.out.println("Queue size: " + executor.getQueue().size());

        System.out.println("\n===== 4️⃣ Shutdown executor =====");
        executor.shutdown(); // stop accepting new tasks
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow(); // force shutdown
        }

        System.out.println("\n===== 5️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 CorePoolSize = always keep N threads alive
            💡 MaximumPoolSize = maximum threads allowed
            💡 WorkQueue = holds tasks before threads are free
            💡 KeepAliveTime = idle threads above corePoolSize are terminated after timeout
            💡 ThreadFactory = customize thread creation
            💡 RejectedExecutionHandler = handle tasks when pool is full
        """);

        System.out.println("\n===== 6️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between corePoolSize and maximumPoolSize?
                - core threads always kept alive, max = total possible threads
            🔹 What happens when queue is full?
                - ThreadPoolExecutor uses rejection policy
            🔹 Common Rejection Policies:
                1. AbortPolicy -> throws exception
                2. CallerRunsPolicy -> runs task in calling thread
                3. DiscardPolicy -> silently discard
                4. DiscardOldestPolicy -> discard oldest task in queue
            🔹 Why use custom ThreadFactory?
                - set thread name, daemon status, priority
            🔹 Difference between submit() and execute()?
                - submit() returns Future
                - execute() void, no return
        """);
    }
}

