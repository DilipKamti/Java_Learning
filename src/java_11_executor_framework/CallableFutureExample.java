package java_11_executor_framework;

import java.util.concurrent.*;

/**
 * Covers:
 * - Callable interface (returns a value)
 * - Future to retrieve result asynchronously
 * - Future.get() with timeout
 * - Handling exceptions in async tasks
 */

public class CallableFutureExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("===== 1️⃣ Callable Example =====");

        // Callable task returns a value
        Callable<Integer> callableTask = () -> {
            System.out.println(Thread.currentThread().getName() + " computing sum...");
            int sum = 0;
            for (int i = 1; i <= 5; i++) sum += i;
            Thread.sleep(1000); // simulate delay
            return sum;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(callableTask);

        System.out.println("Main thread doing other work...");

        // 2️⃣ Get result from future
        Integer result = future.get(); // blocks until callable completes
        System.out.println("Result from Callable: " + result);

        // 3️⃣ Future with timeout
        Future<Integer> futureTimeout = executor.submit(() -> {
            Thread.sleep(3000);
            return 42;
        });
        try {
            System.out.println("Trying to get result with 1 second timeout...");
            Integer val = futureTimeout.get(1, TimeUnit.SECONDS); // will throw TimeoutException
            System.out.println("Result: " + val);
        } catch (TimeoutException e) {
            System.out.println("TimeoutException caught: Task took too long!");
        }

        // 4️⃣ Handling exceptions
        Future<Integer> futureException = executor.submit(() -> {
            throw new RuntimeException("Something went wrong in callable!");
        });
        try {
            futureException.get();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException caught: " + e.getCause().getMessage());
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("\n===== 5️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 Callable = Runnable + returns value + can throw checked exception
            💡 Future = placeholder for result
            💡 future.get() blocks until result ready
            💡 future.get(timeout) can throw TimeoutException
            💡 Exceptions inside Callable are wrapped in ExecutionException
        """);

        System.out.println("\n===== 6️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between Runnable and Callable?
                - Runnable: no return, cannot throw checked exception
                - Callable: returns result, can throw checked exception
            🔹 How to handle exceptions in async tasks?
                - Use Future.get() inside try/catch
            🔹 How to cancel a task?
                - future.cancel(true) interrupts task
            🔹 Why use Future with ExecutorService?
                - Avoid creating threads manually, manage async tasks efficiently
        """);
    }
}

