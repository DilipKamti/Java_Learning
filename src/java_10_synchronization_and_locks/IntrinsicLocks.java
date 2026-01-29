package java_10_synchronization_and_locks;

// IntrinsicLocks.java
// Understanding Intrinsic Locks (Monitor Locks) in Java

public class IntrinsicLocks {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.methodOne(), "Thread-1");
        Thread t2 = new Thread(() -> resource.methodTwo(), "Thread-2");

        t1.start();
        t2.start();
    }
}

// =====================================================
// Shared Resource using intrinsic lock
// =====================================================
class SharedResource {

    // -------------------------------------------------
    // Synchronized instance method
    // Lock: this (current object)
    // -------------------------------------------------
    public synchronized void methodOne() {
        System.out.println(Thread.currentThread().getName() + " entered methodOne");
        sleep();
        System.out.println(Thread.currentThread().getName() + " exiting methodOne");
    }

    // -------------------------------------------------
    // Synchronized block using same intrinsic lock
    // -------------------------------------------------
    public void methodTwo() {
        synchronized (this) {   // same lock as methodOne
            System.out.println(Thread.currentThread().getName() + " entered methodTwo");
            sleep();
            System.out.println(Thread.currentThread().getName() + " exiting methodTwo");
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
=================================================
WHAT ARE INTRINSIC LOCKS?
=================================================

- Built-in locks provided by Java
- Every Java object has ONE intrinsic lock
- Also called:
  ✔ Monitor Lock
  ✔ Implicit Lock

=================================================
HOW INTRINSIC LOCKS WORK
=================================================

- Used by synchronized keyword
- Thread must acquire lock before entering synchronized code
- Lock is released automatically when:
  ✔ Method exits
  ✔ Exception occurs

=================================================
WHERE ARE INTRINSIC LOCKS USED?
=================================================

1️⃣ synchronized instance methods
   → lock = this

2️⃣ synchronized static methods
   → lock = ClassName.class

3️⃣ synchronized blocks
   → lock = specified object

=================================================
OBJECT LOCK vs CLASS LOCK
=================================================

Object Lock:
--------------
synchronized(this)
- Each object has its own lock
- Threads on different objects do NOT block each other

Class Lock:
------------
synchronized(ClassName.class)
- Single lock per class
- Shared across all instances

=================================================
REENTRANT BEHAVIOR
=================================================

Intrinsic locks are REENTRANT

Example:
- Thread acquires lock
- Calls another synchronized method on same object
- No deadlock occurs

=================================================
THREAD STATES INVOLVED
=================================================

- RUNNABLE → tries to acquire lock
- BLOCKED → waiting for intrinsic lock
- RUNNABLE → lock acquired

=================================================
INTRINSIC LOCK LIMITATIONS
=================================================

❌ No fairness guarantee
❌ No timeout
❌ No try-lock
❌ Can cause deadlock

=================================================
INTRINSIC LOCK vs EXPLICIT LOCK
=================================================

Intrinsic Lock (synchronized):
✔ Simple
✔ JVM managed
❌ Less flexible

Explicit Lock (ReentrantLock):
✔ tryLock()
✔ fairness
✔ interruptible
❌ Manual unlock

=================================================
INTERVIEW QUESTIONS (VERY COMMON)
=================================================

Q1. Does every object have an intrinsic lock?
👉 ✔ Yes

Q2. Is intrinsic lock reentrant?
👉 ✔ Yes

Q3. Which keyword uses intrinsic locks?
👉 ✔ synchronized

Q4. Can intrinsic lock be shared?
👉 ✔ Only if same object reference is used

Q5. What happens if exception occurs?
👉 ✔ Lock is released automatically

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"Intrinsic locks are JVM-provided monitor locks associated with every object and used by synchronized."
*/

