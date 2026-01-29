package java_10_synchronization_and_locks;

// DeadlockExample.java
// Demonstrates classic deadlock scenario in Java

public class DeadlockExample {

    public static void main(String[] args) {

        final Object lockA = new Object();
        final Object lockB = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread-1 acquired lockA");

                sleep();

                synchronized (lockB) {
                    System.out.println("Thread-1 acquired lockB");
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread-2 acquired lockB");

                sleep();

                synchronized (lockA) {
                    System.out.println("Thread-2 acquired lockA");
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
=================================================
WHAT IS DEADLOCK?
=================================================

- Situation where two or more threads are blocked forever
- Each thread is waiting for a lock held by another thread

=================================================
DEADLOCK CONDITIONS (COFFMAN CONDITIONS)
=================================================

1️⃣ Mutual Exclusion
   - Resource held by one thread at a time

2️⃣ Hold and Wait
   - Thread holds one lock and waits for another

3️⃣ No Preemption
   - Lock cannot be forcibly taken

4️⃣ Circular Wait
   - Thread-1 → Thread-2 → Thread-1

ALL must be true for deadlock to occur

=================================================
HOW DEADLOCK OCCURS HERE
=================================================

Thread-1:
- Holds lockA
- Waiting for lockB

Thread-2:
- Holds lockB
- Waiting for lockA

👉 Circular wait → DEADLOCK

=================================================
THREAD STATES
=================================================

Thread-1: BLOCKED
Thread-2: BLOCKED

=================================================
HOW TO PREVENT DEADLOCK
=================================================

✔ Lock ordering (always acquire locks in same order)
✔ Use tryLock() with timeout
✔ Use single lock
✔ Avoid nested locks
✔ Use higher-level concurrency utilities

=================================================
DEADLOCK PREVENTION (LOCK ORDER FIX)
=================================================

Example:
synchronized(lockA) {
    synchronized(lockB) {
        // safe
    }
}

=================================================
DEADLOCK vs STARVATION
=================================================

Deadlock:
❌ Permanent block

Starvation:
❌ Thread waits too long but eventually runs

=================================================
INTERVIEW QUESTIONS (VERY COMMON)
=================================================

Q1. What is deadlock?
👉 Threads waiting forever for each other

Q2. What are deadlock conditions?
👉 Mutual exclusion, Hold & wait, No preemption, Circular wait
s
Q3. How to detect deadlock?
👉 jstack, thread dump, JVM tools

Q4. Can deadlock occur with one thread?
👉 No

Q5. Can synchronized cause deadlock?
👉 Yes

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"Deadlock is a state where threads are permanently blocked waiting for each other’s locks."
*/
