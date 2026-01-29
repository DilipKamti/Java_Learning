package java_11_executor_framework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Covers:
 * - exceptionally()
 * - handle()
 * - whenComplete()
 * - Propagating and recovering from exceptions
 */

public class CompletableFutureExceptionHandling {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("===== 1️⃣ CompletableFuture exceptionally() Example =====");

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Error in computation!");
            return 42;
        }).exceptionally(ex -> {
            System.out.println("Exception caught: " + ex.getMessage());
            return -1; // fallback value
        });

        System.out.println("Result from exceptionally: " + future1.get());

        System.out.println("\n===== 2️⃣ CompletableFuture handle() Example =====");

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Another error!");
            return 100;
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception handled in handle(): " + ex.getMessage());
                return 0; // fallback
            } else {
                return result * 2;
            }
        });

        System.out.println("Result from handle: " + future2.get());

        System.out.println("\n===== 3️⃣ CompletableFuture whenComplete() Example =====");

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Oops error!");
            return 50;
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception observed in whenComplete(): " + ex.getMessage());
            } else {
                System.out.println("Result observed: " + result);
            }
        }).exceptionally(ex -> -999); // fallback for continuation

        System.out.println("Final result from whenComplete + exceptionally: " + future3.get());

        System.out.println("\n===== 4️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 exceptionally() = recover from exception, returns fallback
            💡 handle() = handle result or exception together, returns value
            💡 whenComplete() = observe exception/result, doesn't change result unless combined with exceptionally
        """);

        System.out.println("\n===== 5️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between exceptionally(), handle(), whenComplete()?
                - exceptionally() = only for exception, returns fallback
                - handle() = both result & exception, returns new value
                - whenComplete() = observe only, doesn't alter result
            🔹 Always combine exceptionally() to prevent unhandled exceptions
            🔹 Useful in async pipelines to prevent failing chain
            🔹 Exceptions in CompletableFuture are wrapped in CompletionException
        """);
    }
}

