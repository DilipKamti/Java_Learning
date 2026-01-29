package java_09_multithreading;

// RunnableCallable.java
// Java Multithreading - Runnable vs Callable (Deep Dive) ✅

import java.util.concurrent.*;

public class RunnableCallable {

    public static void main(String[] args) throws Exception {

        // =====================================================
        // 1️⃣ Runnable – No return value, no checked exception
        // =====================================================
        Runnable runnableTask = () -> {
            System.out.println("Runnable running in: " +
                    Thread.currentThread().getName());
        };

        Thread t1 = new Thread(runnableTask);
        t1.start();

        // =====================================================
        // 2️⃣ Callable – Returns value, can throw exception
        // =====================================================
        Callable<Integer> callableTask = () -> {
            System.out.println("Callable running in: " +
                    Thread.currentThread().getName());
            return 42;
        };

        // =====================================================
        // 3️⃣ ExecutorService with Runnable
        // =====================================================
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(runnableTask); // fire-and-forget

        // =====================================================
        // 4️⃣ ExecutorService with Callable
        // =====================================================
        Future<Integer> future = executor.submit(callableTask);

        Integer result = future.get(); // blocks until result available
        System.out.println("Callable result: " + result);

        executor.shutdown();
    }
}

/*
=================================================
RUNNABLE vs CALLABLE (MOST ASKED)
=================================================

Runnable:
----------
✔ run() method
✔ No return value
✔ Cannot throw checked exception
✔ Older (Java 1.0)
✔ Used with Thread & Executor

Callable:
----------
✔ call() method
✔ Returns value
✔ Can throw checked exception
✔ Introduced in Java 5
✔ Used with ExecutorService

=================================================
FUTURE
=================================================
- Represents result of async computation
- get() blocks until result is ready
- Can cancel task

Methods:
✔ get()
✔ isDone()
✔ cancel()

=================================================
COMMON INTERVIEW TRAPS
=================================================
❌ Expecting Runnable to return value
❌ Calling Future.get() without timeout
❌ Forgetting executor.shutdown()

=================================================
INTERVIEW QUESTIONS
=================================================

Q1. Can Runnable return value?
👉 ❌ No

Q2. How to get result from thread?
👉 Callable + Future

Q3. Can Callable throw checked exception?
👉 ✔ Yes

Q4. Difference between submit() and execute()?
👉 submit() returns Future, execute() does not

Q5. Which is preferred in real projects?
👉 Callable with ExecutorService

=================================================
REAL-TIME USE CASES
=================================================
✔ API calls
✔ Parallel computations
✔ Background jobs
✔ Batch processing

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"Runnable is fire-and-forget, Callable returns a result."
*/

