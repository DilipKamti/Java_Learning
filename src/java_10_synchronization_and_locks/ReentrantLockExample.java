package java_10_synchronization_and_locks;

// ReentrantLockExample.java
// Demonstrates ReentrantLock features vs synchronized

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class ReentrantLockExample {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(500), "Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(500), "Thread-2");

        t1.start();
        t2.start();
    }
}

// =====================================================
// Shared Resource using ReentrantLock
// =====================================================
class BankAccount {

    private int balance = 800;

    // Explicit Lock
    private final ReentrantLock lock = new ReentrantLock(true); // fairness = true

    public void withdraw(int amount) {

        try {
            // Try to acquire lock with timeout
            if (lock.tryLock(2, TimeUnit.SECONDS)) {

                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock");

                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + " processing withdrawal");
                        Thread.sleep(1000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " withdrawal successful. Remaining balance: " + balance);
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + " insufficient balance");
                    }

                } finally {
                    lock.unlock(); // MUST unlock
                    System.out.println(Thread.currentThread().getName() + " released lock");
                }

            } else {
                System.out.println(Thread.currentThread().getName()
                        + " could not acquire lock, try later");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/*
=================================================
WHAT IS ReentrantLock?
=================================================

- Explicit locking mechanism
- Part of java.util.concurrent.locks
- More powerful than synchronized
- Programmer controls lock & unlock

=================================================
WHY "REENTRANT"?
=================================================

- Same thread can acquire the lock multiple times
- Prevents self-deadlock

=================================================
KEY FEATURES (INTERVIEW GOLD)
=================================================

✔ tryLock()
✔ tryLock(timeout)
✔ Fairness policy
✔ Interruptible locking
✔ Condition variables
✔ Explicit lock/unlock

=================================================
FAIR vs UNFAIR LOCK
=================================================

new ReentrantLock(true)  -> Fair lock (FIFO)
new ReentrantLock(false) -> Unfair lock (default, faster)

=================================================
IMPORTANT RULE
=================================================

ALWAYS unlock in finally block
Otherwise → DEADLOCK

=================================================
ReentrantLock vs synchronized
=================================================

synchronized:
✔ Simple
✔ Auto unlock
❌ No timeout
❌ No fairness
❌ No tryLock

ReentrantLock:
✔ Flexible
✔ tryLock
✔ Fairness
✔ Interruptible
❌ Manual unlock

=================================================
THREAD STATES
=================================================

- RUNNABLE → trying to acquire lock
- WAITING / TIMED_WAITING → tryLock(timeout)
- RUNNABLE → lock acquired

=================================================
COMMON INTERVIEW QUESTIONS
=================================================

Q1. Is ReentrantLock reentrant?
👉 Yes

Q2. Is it faster than synchronized?
👉 Often yes, but depends

Q3. What happens if unlock() not called?
👉 Deadlock

Q4. Can we replace synchronized with ReentrantLock?
👉 Yes (with care)

Q5. Is ReentrantLock JVM or API level?
👉 API level (java.util.concurrent)

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"ReentrantLock is an explicit, reentrant mutual exclusion lock that provides advanced features like fairness and tryLock."
*/

