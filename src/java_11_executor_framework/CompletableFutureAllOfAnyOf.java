package java_11_executor_framework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Covers:
 * - allOf() → wait for all futures to complete
 * - anyOf() → wait for first future to complete
 * - Combining results from multiple futures
 * - Async parallel execution
 */

public class CompletableFutureAllOfAnyOf {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("===== 1️⃣ CompletableFuture.allOf() Example =====");

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Result-1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "Result-2";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            sleep(1500);
            return "Result-3";
        });

        // Wait for all futures to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.join(); // blocks until all complete

        System.out.println("All futures completed:");
        System.out.println("future1: " + future1.get());
        System.out.println("future2: " + future2.get());
        System.out.println("future3: " + future3.get());

        System.out.println("\n===== 2️⃣ CompletableFuture.anyOf() Example =====");

        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            return "First Result";
        });
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "Second Result";
        });

        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(futureA, futureB);
        System.out.println("First completed result: " + anyFuture.get());

        System.out.println("\n===== 3️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 allOf() = wait for ALL futures to complete → join() or get()
            💡 anyOf() = wait for FIRST future to complete → returns first completed result
            💡 Useful for parallel async tasks
        """);

        System.out.println("\n===== 4️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between allOf() and anyOf()?
                - allOf = wait for all tasks, void, use futures to get individual results
                - anyOf = wait for first completed task, returns Object
            🔹 allOf() returns CompletableFuture<Void> → use individual futures to retrieve values
            🔹 Combining with thenApply() or thenAccept() allows further async processing
            🔹 Common use-case: parallel API calls, process fastest first (anyOf)
        """);
    }

    private static void sleep(long millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

