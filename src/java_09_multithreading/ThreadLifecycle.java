package java_09_multithreading;

// ThreadLifecycle.java
// Java Thread Life Cycle - Deep Dive with Examples ✅

public class ThreadLifecycle {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread State: " +
                Thread.currentThread().getState());

        Thread t = new Thread(() -> {
            try {
                System.out.println("Thread State (Inside run - START): " +
                        Thread.currentThread().getState());

                // TIMED_WAITING
                Thread.sleep(1000);

                System.out.println("Thread State (After sleep): " +
                        Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // =====================================================
        // NEW
        // =====================================================
        System.out.println("Thread State (After creation): " + t.getState());

        // =====================================================
        // RUNNABLE
        // =====================================================
        t.start();
        System.out.println("Thread State (After start): " + t.getState());

        // =====================================================
        // WAITING for thread to finish
        // =====================================================
        t.join();

        // =====================================================
        // TERMINATED
        // =====================================================
        System.out.println("Thread State (After completion): " + t.getState());
    }
}

/*
=================================================
THREAD LIFE CYCLE STATES
=================================================

1️⃣ NEW
-------
- Thread object created
- start() not yet called

2️⃣ RUNNABLE
------------
- Thread is ready or running
- JVM controls actual execution

3️⃣ BLOCKED
-----------
- Waiting for monitor lock
- Happens with synchronized blocks

4️⃣ WAITING
-----------
- Waiting indefinitely
- join(), wait()

5️⃣ TIMED_WAITING
-----------------
- Waiting for fixed time
- sleep(), join(timeout)

6️⃣ TERMINATED
--------------
- Execution finished
- Cannot be restarted

=================================================
STATE TRANSITIONS
=================================================

NEW -> start() -> RUNNABLE
RUNNABLE -> sleep() -> TIMED_WAITING
RUNNABLE -> wait() / join() -> WAITING
RUNNABLE -> finish -> TERMINATED

=================================================
COMMON INTERVIEW TRAPS
=================================================

❌ RUNNABLE does NOT mean running always
❌ BLOCKED is NOT sleeping
❌ A terminated thread CANNOT be restarted
❌ JVM decides scheduling, not developer

=================================================
INTERVIEW QUESTIONS (FREQUENT)
=================================================

Q1. How many states are there?
👉 6 (NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED)

Q2. Difference between WAITING and TIMED_WAITING?
👉 WAITING: no time limit
👉 TIMED_WAITING: fixed time

Q3. When does thread go to BLOCKED state?
👉 When waiting for synchronized lock

Q4. Is RUNNABLE always executing?
👉 No, may be waiting for CPU

Q5. Can a thread move from TERMINATED to RUNNABLE?
👉 ❌ No

=================================================
REAL-TIME EXAMPLES
=================================================
✔ Web server threads
✔ Background workers
✔ Scheduled jobs
✔ Producer-consumer models

=================================================
ONE-LINE INTERVIEW SUMMARY
=================================================
Thread life cycle is controlled by JVM, not programmer.
*/

