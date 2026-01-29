package java_11_executor_framework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPool {

    public static void main(String[] args) {

        // 1. Create Fixed Thread Pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 2. Submit multiple tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            executor.submit(() -> {
                System.out.println(
                        Thread.currentThread().getName() + " executing Task-" + taskId);
                sleep();
            });
        }

        // 3. Shutdown executor
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
WHAT IS FIXED THREAD POOL?
=================================================

- Thread pool with FIXED number of threads
- Created using Executors.newFixedThreadPool(n)
- Threads are reused

=================================================
HOW IT WORKS INTERNALLY
=================================================

- Max threads = n
- Uses:
  ✔ LinkedBlockingQueue (unbounded)
- Extra tasks wait in queue

=================================================
EXECUTION FLOW
=================================================

Tasks submitted:
1️⃣ First n tasks → execute immediately
2️⃣ Remaining tasks → queued
3️⃣ Threads pick tasks from queue

=================================================
WHEN TO USE FIXED THREAD POOL?
=================================================

✔ CPU-intensive tasks
✔ Controlled concurrency
✔ Stable workload

=================================================
WHEN NOT TO USE?
=================================================

❌ High number of tasks
❌ Unknown load (queue may grow infinitely)

=================================================
FIXED THREAD POOL vs CACHED
=================================================

Fixed:
✔ Controlled threads
❌ Unbounded queue

Cached:
✔ Unbounded threads
❌ Risk of thread explosion

=================================================
IMPORTANT INTERVIEW TRAPS
=================================================

Q1. Does FixedThreadPool create new threads if busy?
👉 ❌ No (tasks are queued)

Q2. Is queue bounded?
👉 ❌ No (LinkedBlockingQueue)

Q3. Can threads die?
👉 ✔ Yes, but replaced automatically

Q4. Is it suitable for IO tasks?
👉 ⚠️ Usually NO

=================================================
REAL-WORLD EXAMPLE
=================================================

- Processing user requests
- Batch processing
- Data computation

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"FixedThreadPool maintains a fixed number of threads and queues excess tasks for controlled execution."
*/

