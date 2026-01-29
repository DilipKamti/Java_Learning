package java_09_multithreading;

// ThreadCreation.java
// Java Multithreading - Thread Creation (Basic to Deep Dive) ✅

/*
=================================================
WAYS TO CREATE A THREAD IN JAVA
=================================================
1️⃣ Extending Thread class
2️⃣ Implementing Runnable interface (BEST PRACTICE)
3️⃣ Using Lambda expression (Java 8)
4️⃣ Using Executor Framework (Enterprise way)
*/

public class ThreadCreation {

    public static void main(String[] args) {

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        // =====================================================
        // 1️⃣ Creating thread by EXTENDING Thread class
        // =====================================================
        MyThread t1 = new MyThread();
        t1.start(); // start() creates a new thread

        // =====================================================
        // 2️⃣ Creating thread by IMPLEMENTING Runnable
        // =====================================================
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // =====================================================
        // 3️⃣ Using Lambda Expression (Java 8)
        // =====================================================
        Thread t3 = new Thread(() -> {
            System.out.println("Lambda Thread running: " +
                    Thread.currentThread().getName());
        });
        t3.start();

        // =====================================================
        // 4️⃣ Anonymous Runnable
        // =====================================================
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable Thread: " +
                        Thread.currentThread().getName());
            }
        });
        t4.start();
    }
}

// =====================================================
// 1️⃣ Thread class
// =====================================================
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread via Thread class: " +
                Thread.currentThread().getName());
    }
}

// =====================================================
// 2️⃣ Runnable interface
// =====================================================
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread via Runnable: " +
                Thread.currentThread().getName());
    }
}

/*
=================================================
VERY IMPORTANT THEORY (INTERVIEW GOLD)
=================================================

1️⃣ start() vs run()
--------------------
start():
✔ Creates new thread
✔ Calls run() internally
✔ Executes concurrently

run():
❌ No new thread
❌ Executes like normal method

=================================================
WHY Runnable IS BETTER THAN Thread
=================================================
✔ Supports multiple inheritance
✔ Separates task from thread
✔ Better design
✔ Used by Executor Framework

=================================================
THREAD LIFE CYCLE
=================================================
NEW → RUNNABLE → RUNNING → BLOCKED/WAITING → TERMINATED

=================================================
COMMON MISTAKES
=================================================
❌ Calling run() instead of start()
❌ Sharing mutable data without synchronization
❌ Creating too many threads manually

=================================================
INTERVIEW QUESTIONS (FREQUENT)
=================================================

Q1. How many ways to create a thread?
👉 Two primary ways (Thread, Runnable)

Q2. Which is better and why?
👉 Runnable (design + flexibility)

Q3. Can we restart a thread?
👉 ❌ No, IllegalThreadStateException

Q4. What happens if start() is called twice?
👉 Runtime exception

Q5. Is Thread class abstract?
👉 ❌ No

=================================================
REAL-TIME BEST PRACTICE
=================================================
✔ Avoid extending Thread
✔ Prefer Runnable or ExecutorService
✔ Use thread pools instead of manual threads

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"Runnable is preferred over Thread because it supports better design and scalability."
*/

