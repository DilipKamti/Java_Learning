package java_09_multithreading;

// ThreadSafetyBasics.java
// Java Multithreading - Thread Safety Basics (Deep Dive) ✅

public class ThreadSafetyBasics {

    private static int counter = 0; // shared mutable state ❌

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> increment());
        Thread t2 = new Thread(() -> increment());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + counter);
    }

    // NOT thread-safe
    private static void increment() {
        for (int i = 0; i < 100000; i++) {
            counter++; // read-modify-write (race condition)
        }
    }
}

/*
=================================================
WHAT IS THREAD SAFETY?
=================================================

Thread safety means:
✔ Program behaves correctly when accessed by multiple threads
✔ No data corruption
✔ No unexpected results

=================================================
WHY THREAD SAFETY IS IMPORTANT
=================================================

- Multiple threads share memory
- Operations may interleave unpredictably
- Leads to race conditions

=================================================
COMMON THREAD SAFETY PROBLEMS
=================================================

1️⃣ Race Condition
------------------
Multiple threads modify shared data concurrently.

2️⃣ Visibility Issues
--------------------
Thread does not see latest value.

3️⃣ Atomicity Issues
--------------------
Compound operations are interrupted.

=================================================
HOW TO MAKE CODE THREAD-SAFE
=================================================

1️⃣ synchronized keyword
2️⃣ volatile keyword (visibility only)
3️⃣ Atomic classes (AtomicInteger)
4️⃣ Locks (ReentrantLock)
5️⃣ Immutability
6️⃣ Thread-local variables

=================================================
THREAD-SAFE vs NON-THREAD-SAFE
=================================================

Non-thread-safe:
❌ ArrayList
❌ HashMap
❌ Simple counters

Thread-safe:
✔ Vector
✔ Hashtable
✔ ConcurrentHashMap
✔ AtomicInteger

=================================================
INTERVIEW QUESTIONS (VERY IMPORTANT)
=================================================

Q1. Is counter++ thread-safe?
👉 ❌ No

Q2. Is volatile enough for thread safety?
👉 ❌ No (only visibility)

Q3. Best way to make shared counter thread-safe?
👉 AtomicInteger or synchronized

Q4. What is race condition?
👉 Unpredictable result due to concurrent access

Q5. Does synchronized guarantee visibility?
👉 ✔ Yes

=================================================
REAL-TIME BEST PRACTICES
=================================================

✔ Avoid shared mutable state
✔ Prefer immutability
✔ Use concurrent collections
✔ Keep synchronization minimal

=================================================
ONE-LINE INTERVIEW SUMMARY
=================================================
Thread safety means correct behavior under concurrency.
*/
