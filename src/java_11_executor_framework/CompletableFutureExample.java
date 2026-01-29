package java_11_executor_framework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 1. Run async task without result
        CompletableFuture<Void> future1 =
                CompletableFuture.runAsync(() ->
                        System.out.println("Async task without result"), executor);

        // 2. Supply async task with result
        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(() -> {
                    sleep();
                    return 10;
                }, executor);

        // 3. Transform result
        CompletableFuture<Integer> future3 =
                future2.thenApply(result -> result * 2);

        // 4. Consume result
        future3.thenAccept(result ->
                System.out.println("Final Result: " + result));

        // 5. Combine two futures
        CompletableFuture<Integer> combined =
                CompletableFuture.supplyAsync(() -> 5)
                        .thenCombine(
                                CompletableFuture.supplyAsync(() -> 7),
                                Integer::sum
                        );

        combined.thenAccept(sum ->
                System.out.println("Combined Result: " + sum));

        // Keep JVM alive briefly
        sleep();

        executor.shutdown();
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
=================================================
WHAT IS CompletableFuture?
=================================================

- Part of java.util.concurrent (Java 8+)
- Asynchronous, non-blocking programming
- Extension of Future

=================================================
WHY CompletableFuture?
=================================================

Future problems:
❌ Blocking get()
❌ No chaining
❌ No callbacks

CompletableFuture:
✔ Non-blocking
✔ Callback-based
✔ Chainable
✔ Combine multiple tasks

=================================================
CREATION METHODS
=================================================

runAsync()     -> no result
supplyAsync() -> returns result

=================================================
COMMON TRANSFORMATIONS
=================================================

thenApply()   -> transform result
thenAccept()  -> consume result
thenRun()     -> no input/output

=================================================
ASYNC vs SYNC
=================================================

thenApply()        -> same thread
thenApplyAsync()   -> different thread

=================================================
COMBINING FUTURES
=================================================

thenCombine()
thenCompose()
allOf()
anyOf()

=================================================
EXCEPTION HANDLING
=================================================

exceptionally()
handle()
whenComplete()

=================================================
THREAD POOLS
=================================================

- Default: ForkJoinPool.commonPool()
- Custom executor recommended in production

=================================================
CompletableFuture vs Future
=================================================

Future:
❌ Blocking
❌ Manual coordination

CompletableFuture:
✔ Functional style
✔ Better readability
✔ Non-blocking

=================================================
COMMON INTERVIEW QUESTIONS
=================================================

Q1. Is CompletableFuture blocking?
👉 No (unless get() used)

Q2. Difference between thenApply & thenCompose?
👉 Compose flattens nested futures

Q3. Which thread executes callbacks?
👉 Same or async depending on method

Q4. Is CompletableFuture thread-safe?
👉 Yes

Q5. Default thread pool?
👉 ForkJoinPool.commonPool()

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"CompletableFuture enables non-blocking, asynchronous computation with powerful composition and callback mechanisms."

🧠 Easy Memory Hook
Future = wait
CompletableFuture = react

*/

