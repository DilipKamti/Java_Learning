package java_11_executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceBasics {

    public static void main(String[] args) {

        // 1. Create ExecutorService (Thread Pool)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 2. Submit tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println(
                        Thread.currentThread().getName() + " executing Task-" + taskId);
                sleep();
            });
        }

        // 3. Shutdown ExecutorService
        executor.shutdown();

        try {
            // 4. Wait for tasks to complete
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // force shutdown
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
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
WHAT IS ExecutorService?
=================================================

- Part of java.util.concurrent
- Manages a pool of worker threads
- Separates:
  ✔ Task submission
  ✔ Task execution

=================================================
WHY DO WE NEED IT?
=================================================

Problems with Thread:
❌ Manual thread creation
❌ Poor scalability
❌ Resource wastage

ExecutorService:
✔ Reuses threads
✔ Better performance
✔ Cleaner code

=================================================
TASK TYPES
=================================================

Runnable → no return value
Callable → returns value + throws exception

=================================================
COMMON THREAD POOLS
=================================================

Executors.newFixedThreadPool(n)
Executors.newCachedThreadPool()
Executors.newSingleThreadExecutor()
Executors.newScheduledThreadPool(n)

=================================================
LIFECYCLE
=================================================

1️⃣ Created
2️⃣ Tasks submitted
3️⃣ shutdown() → graceful shutdown
4️⃣ shutdownNow() → force stop

=================================================
IMPORTANT METHODS
=================================================

submit()
execute()
shutdown()
shutdownNow()
awaitTermination()
isShutdown()
isTerminated()

=================================================
execute() vs submit()
=================================================

execute():
- No return
- Unhandled exception kills thread

submit():
- Returns Future
- Exception captured

=================================================
THREAD POOL SIZE RULE (INTERVIEW)
=================================================

CPU bound tasks:
➡ number of cores

IO bound tasks:
➡ 2 × cores

=================================================
COMMON INTERVIEW QUESTIONS
=================================================

Q1. Why not create threads manually?
👉 Heavy + expensive

Q2. Difference between submit & execute?
👉 submit returns Future

Q3. What happens if shutdown not called?
👉 JVM may not exit

Q4. Can ExecutorService reuse threads?
👉 Yes

Q5. Is ExecutorService thread-safe?
👉 Yes

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"ExecutorService is a high-level API for managing and executing tasks using a pool of reusable threads."
*/
