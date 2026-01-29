package java_11_executor_framework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Covers:
 * - thenApply() → transform result
 * - thenAccept() → consume result
 * - thenCompose() → flatten dependent async tasks
 * - thenCombine() → combine two futures
 */

public class CompletableFutureChaining {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("===== 1️⃣ thenApply() Example =====");

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(x -> x * 2) // transform result
                .thenApply(x -> x + 5);

        System.out.println("Result after thenApply chain: " + future1.get());

        System.out.println("\n===== 2️⃣ thenAccept() Example =====");

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(msg -> System.out.println("Consumed message: " + msg));

        Thread.sleep(500); // allow async task to complete

        System.out.println("\n===== 3️⃣ thenCompose() Example =====");

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 5)
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> x * 10));

        System.out.println("Result after thenCompose: " + future2.get());

        System.out.println("\n===== 4️⃣ thenCombine() Example =====");

        CompletableFuture<Integer> futureA = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> futureB = CompletableFuture.supplyAsync(() -> 30);

        CompletableFuture<Integer> combinedFuture = futureA.thenCombine(futureB, Integer::sum);

        System.out.println("Result after thenCombine: " + combinedFuture.get());

        System.out.println("\n===== 5️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 thenApply() = transform result → returns new value
            💡 thenAccept() = consume result → void
            💡 thenCompose() = dependent async task → flatten nested CompletableFuture
            💡 thenCombine() = combine two independent futures → result of both
        """);

        System.out.println("\n===== 6️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 thenApply vs thenCompose?
                - thenApply = transforms result, returns value
                - thenCompose = returns a new CompletableFuture, avoids nested futures
            🔹 thenCombine vs thenAcceptBoth?
                - thenCombine = combine two futures, returns result
                - thenAcceptBoth = combine two futures, consumes result (void)
            🔹 Always handle exceptions using exceptionally() in chained pipelines
            🔹 Chaining allows non-blocking async transformations
        """);
    }
}

