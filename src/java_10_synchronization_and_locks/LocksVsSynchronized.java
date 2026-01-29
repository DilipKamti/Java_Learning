package java_10_synchronization_and_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Covers:
 * - synchronized keyword (method and block)
 * - ReentrantLock (explicit lock)
 * - tryLock(), lockInterruptibly(), fairness
 * - Differences and use-cases
 */

public class LocksVsSynchronized {

    // Shared resource
    private int counter = 0;

    // Explicit lock
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        LocksVsSynchronized example = new LocksVsSynchronized();

        System.out.println("===== 1️⃣ Synchronized Block vs Method =====");
        example.demoSynchronized();

        System.out.println("\n===== 2️⃣ ReentrantLock (Explicit Lock) =====");
        example.demoReentrantLock();

        System.out.println("\n===== 3️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 Synchronized = intrinsic lock, simpler, automatically released
            💡 ReentrantLock = explicit lock, more control (tryLock, interruptible, fairness)
            💡 Both prevent race conditions on shared resources
        """);

        System.out.println("\n===== 4️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between synchronized and ReentrantLock?
                - Synchronized: simpler, auto-release, cannot interrupt while waiting
                - ReentrantLock: more features, can use tryLock(), lockInterruptibly(), fairness
            🔹 What is a reentrant lock?
                - Thread can acquire same lock multiple times without deadlock
            🔹 Fair vs non-fair lock?
                - Fair: FIFO queue of threads
                - Non-fair: may allow thread to “cut” in line
            🔹 Can synchronized method be static?
                - Yes, locks on Class object
            🔹 Common pitfalls?
                - Forgetting to unlock explicit locks → deadlock
        """);
    }

    /**
     * Demo synchronized block vs method
     */
    public void demoSynchronized() throws InterruptedException {
        Runnable syncMethodTask = () -> incrementSynchronizedMethod();
        Runnable syncBlockTask = () -> incrementSynchronizedBlock();

        Thread t1 = new Thread(syncMethodTask, "Thread-SyncMethod");
        Thread t2 = new Thread(syncBlockTask, "Thread-SyncBlock");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    // Synchronized method
    private synchronized void incrementSynchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " entering synchronized method");
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " counter=" + counter);
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(Thread.currentThread().getName() + " leaving synchronized method");
    }

    // Synchronized block
    private void incrementSynchronizedBlock() {
        System.out.println(Thread.currentThread().getName() + " attempting synchronized block");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " inside synchronized block");
            for (int i = 0; i < 5; i++) {
                counter++;
                System.out.println(Thread.currentThread().getName() + " counter=" + counter);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
        System.out.println(Thread.currentThread().getName() + " leaving synchronized block");
    }

    /**
     * Demo ReentrantLock with try/finally
     */
    public void demoReentrantLock() throws InterruptedException {
        Runnable lockTask = () -> {
            System.out.println(Thread.currentThread().getName() + " attempting lock");
            lock.lock(); // acquire lock
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock");
                for (int i = 0; i < 5; i++) {
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " counter=" + counter);
                    try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            } finally {
                lock.unlock(); // always release lock
                System.out.println(Thread.currentThread().getName() + " released lock");
            }
        };

        Thread t1 = new Thread(lockTask, "Thread-Lock1");
        Thread t2 = new Thread(lockTask, "Thread-Lock2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        //"Synchronized = intrinsic, ReentrantLock = explicit + flexible"
    }
}

