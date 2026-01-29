package java_10_synchronization_and_locks;

/**
 * Key points:
 * - synchronized method locks the whole object (or class if static)
 * - synchronized block locks only a part of code, more granular
 * - Helps improve performance by reducing lock contention
 */

public class SynchronizedBlockVsMethod {

    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedBlockVsMethod example = new SynchronizedBlockVsMethod();

        System.out.println("===== 1️⃣ Synchronized Method Example =====");
        example.demoSynchronizedMethod();

        System.out.println("\n===== 2️⃣ Synchronized Block Example =====");
        example.demoSynchronizedBlock();

        System.out.println("\n===== 3️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 Synchronized Method:
                - Locks entire object (or class if static)
                - Simple but may reduce concurrency
            💡 Synchronized Block:
                - Locks only critical section
                - More granular, improves performance
        """);

        System.out.println("\n===== 4️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 When to use synchronized block instead of method?
                - When only part of the method modifies shared data
                - Reduces contention and improves concurrency
            🔹 Can synchronized method call another synchronized method?
                - Yes, reentrant locks allow same thread to acquire multiple locks
            🔹 Static synchronized method locks on class object
            🔹 Instance synchronized method locks on this object
            🔹 Key difference: granularity and scope of lock
        """);
    }

    /**
     * Demo synchronized method
     */
    public void demoSynchronizedMethod() throws InterruptedException {
        Runnable task = this::incrementSynchronizedMethod;

        Thread t1 = new Thread(task, "Thread-Method1");
        Thread t2 = new Thread(task, "Thread-Method2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private synchronized void incrementSynchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " entered synchronized method");
        for (int i = 0; i < 5; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " counter=" + counter);
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(Thread.currentThread().getName() + " exiting synchronized method");
    }

    /**
     * Demo synchronized block
     */
    public void demoSynchronizedBlock() throws InterruptedException {
        Runnable task = this::incrementSynchronizedBlock;

        Thread t1 = new Thread(task, "Thread-Block1");
        Thread t2 = new Thread(task, "Thread-Block2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private void incrementSynchronizedBlock() {
        System.out.println(Thread.currentThread().getName() + " before synchronized block");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " entered synchronized block");
            for (int i = 0; i < 5; i++) {
                counter++;
                System.out.println(Thread.currentThread().getName() + " counter=" + counter);
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            System.out.println(Thread.currentThread().getName() + " exiting synchronized block");
        }
        System.out.println(Thread.currentThread().getName() + " after synchronized block");
    }
}

