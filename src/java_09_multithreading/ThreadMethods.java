package java_09_multithreading;

/**
 * Covers:
 * - Creating threads (extends Thread / implements Runnable / lambda)
 * - Thread states and lifecycle
 * - Thread methods: start(), run(), join(), sleep(), yield(), interrupt(), isAlive()
 * - Thread priorities
 * - Thread safety basics
 */

public class ThreadMethods {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== 1️⃣ Basic Thread Creation =====");

        // 1a. Extending Thread
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(getName() + " is running via Thread subclass");
            }
        }
        Thread t1 = new MyThread();
        t1.setName("T1-Thread");
        t1.start(); // start() invokes run() asynchronously

        // 1b. Implementing Runnable
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + " is running via Runnable");
        Thread t2 = new Thread(runnable, "T2-RunnableThread");
        t2.start();

        // 1c. Lambda directly
        Thread t3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running via Lambda"));
        t3.setName("T3-LambdaThread");
        t3.start();

        // Wait for threads to finish
        t1.join();
        t2.join();
        t3.join();

        System.out.println("\n===== 2️⃣ Thread Lifecycle & States =====");
        Thread t4 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " state during sleep: " + Thread.currentThread().getState());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted!");
            }
        }, "T4-SleepThread");

        System.out.println("State before start: " + t4.getState()); // NEW
        t4.start();
        Thread.sleep(200); // ensure thread is sleeping
        System.out.println("State during sleep: " + t4.getState()); // TIMED_WAITING
        t4.join();
        System.out.println("State after completion: " + t4.getState()); // TERMINATED

        System.out.println("\n===== 3️⃣ Important Thread Methods =====");

        Thread t5 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " count: " + i);
                Thread.yield(); // hint to scheduler
            }
        }, "T5-YieldThread");

        t5.setPriority(Thread.MAX_PRIORITY); // priority hints
        t5.start();
        t5.join();

        Thread t6 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " sleeping...");
                Thread.sleep(1000); // sleep 1 sec
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted!");
            }
        }, "T6-InterruptThread");

        t6.start();
        Thread.sleep(500);
        t6.interrupt(); // interrupts sleeping thread
        t6.join();

        System.out.println("\n===== 4️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 Thread Lifecycle: NEW -> RUNNABLE -> RUNNING -> WAITING/TIMED_WAITING/BLOCKED -> TERMINATED
            💡 Methods:
                start() -> creates OS-level thread, calls run() asynchronously
                run() -> executes thread code (do not call directly for async!)
                join() -> wait for thread to finish
                sleep(ms) -> pauses thread, TIMED_WAITING
                yield() -> hint scheduler to switch
                interrupt() -> signals thread to stop waiting/sleep
            💡 Priority is just a hint; scheduling is OS-dependent
            """);

        System.out.println("\n===== 5️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between start() and run()?
                - start() -> async execution
                - run() -> normal method call
            🔹 Thread states and transitions (NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED)
            🔹 Thread priority effects?
                - JVM may ignore; not reliable for scheduling
            🔹 Difference between sleep() and wait()?
                - sleep() -> Thread.sleep(ms), does not release lock
                - wait() -> Object.wait(ms), releases monitor
            🔹 How to interrupt a sleeping thread? 
                - t.interrupt() throws InterruptedException
            🔹 Thread safety basics:
                - use synchronized, volatile, or atomic classes for shared data
            """);
    }
}

