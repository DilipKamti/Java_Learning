package java_11_executor_framework;

import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Callable task (returns result)
        Callable<Integer> task = () -> {
            System.out.println(Thread.currentThread().getName() + " computing...");
            Thread.sleep(2000);
            return 42;
        };

        // Submit task and get Future
        Future<Integer> future = executor.submit(task);

        try {
            System.out.println("Is task done? " + future.isDone());

            // Blocking call
            Integer result = future.get();  // waits until task completes

            System.out.println("Result from Future: " + result);
            System.out.println("Is task done? " + future.isDone());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

/*
=================================================
WHAT IS Future?
=================================================

- Represents the result of an asynchronous computation
- Returned by ExecutorService.submit()

=================================================
WHY DO WE NEED Future?
=================================================

- To retrieve result from background thread
- To check task status
- To cancel task

=================================================
IMPORTANT METHODS
=================================================

get()            -> waits indefinitely
get(timeout)     -> waits for limited time
isDone()         -> task completed?
isCancelled()    -> task cancelled?
cancel(true)     -> interrupt task

=================================================
BLOCKING NATURE
=================================================

future.get():
❌ Blocks calling thread

=================================================
EXCEPTION HANDLING
=================================================

- Exceptions inside Callable are wrapped in:
  👉 ExecutionException

=================================================
FUTURE LIMITATIONS (INTERVIEW HOT)
=================================================

❌ Blocking API
❌ No chaining
❌ No callbacks
❌ Hard to combine multiple futures

→ Solved by CompletableFuture

=================================================
FUTURE vs RUNNABLE
=================================================

Runnable:
❌ No return value

Callable:
✔ Returns value
✔ Throws checked exception

=================================================
FUTURE vs COMPLETABLEFUTURE
=================================================

Future:
❌ Blocking
❌ Manual coordination

CompletableFuture:
✔ Non-blocking
✔ Callback-based
✔ Functional style

=================================================
COMMON INTERVIEW QUESTIONS
=================================================

Q1. Is future.get() blocking?
👉 Yes

Q2. Can Future return null?
👉 Yes (Callable returns null)

Q3. How to stop a running task?
👉 future.cancel(true)

Q4. Can we reuse Future?
👉 No

Q5. Does submit(Runnable) return Future?
👉 Yes (result = null)

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"Future represents the result of an asynchronous computation and provides methods to retrieve, cancel, or check its status."
*/

