package java_10_synchronization_and_locks;

// SynchronizedKeyword.java
// Java synchronized keyword - Deep Dive with Examples ✅

public class SynchronizedKeyword {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> counter.increment());
        Thread t2 = new Thread(() -> counter.increment());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + counter.getCount());
    }
}

// =====================================================
// Shared Resource
// =====================================================
class Counter {

    private int count = 0;

    // =====================================================
    // 1️⃣ Synchronized instance method (Object lock)
    // =====================================================
    public synchronized void increment() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    public synchronized int getCount() {
        return count;
    }
}

/*
=================================================
WHAT IS synchronized?
=================================================

- Ensures only ONE thread accesses critical section at a time
- Provides:
  ✔ Mutual exclusion
  ✔ Visibility
  ✔ Atomicity

=================================================
TYPES OF synchronized
=================================================

1️⃣ Instance method synchronized
--------------------------------
Lock: Current object (this)

2️⃣ Static method synchronized
------------------------------
Lock: Class object (ClassName.class)

3️⃣ Synchronized block
----------------------
Lock: Any object

Example:
synchronized(lockObject) {
    // critical section
}

=================================================
OBJECT LOCK vs CLASS LOCK
=================================================

Object Lock:
- Applies per instance
- Different objects → different locks

Class Lock:
- Applies to entire class
- Shared across all instances

=================================================
WHY synchronized WORKS
=================================================

- Uses intrinsic monitor lock
- Only one thread holds lock
- Others move to BLOCKED state

=================================================
COMMON INTERVIEW TRAPS
=================================================

❌ synchronized does NOT mean faster
❌ Deadlock possible with multiple locks
❌ Locking too much code hurts performance

=================================================
synchronized vs volatile
=================================================

synchronized:
✔ Atomicity + visibility
❌ Blocking

volatile:
✔ Visibility only
❌ No atomicity

=================================================
INTERVIEW QUESTIONS (FREQUENT)
=================================================

Q1. Can synchronized be used with static methods?
👉 ✔ Yes (class-level lock)

Q2. Can synchronized block lock any object?
👉 ✔ Yes

Q3. Is synchronized reentrant?
👉 ✔ Yes (same thread can re-acquire lock)

Q4. Can two threads enter different synchronized methods?
👉 Depends on lock object

Q5. Is synchronized fair?
👉 ❌ No

=================================================
REAL-TIME BEST PRACTICES
=================================================

✔ Keep synchronized blocks small
✔ Avoid nested locks
✔ Prefer concurrent utilities when possible

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"synchronized ensures atomicity, visibility, and mutual exclusion."
*/

