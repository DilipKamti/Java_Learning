package java_09_multithreading;

// VolatileExample.java
// Java volatile keyword - Visibility vs Atomicity (Interview Gold) ✅

public class VolatileExample {

    // Without volatile, thread may never see updated value
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started...");
            while (!flag) {
                // busy waiting
            }
            System.out.println("Worker thread detected flag change!");
        });

        worker.start();

        // Simulate some work
        Thread.sleep(2000);

        System.out.println("Main thread updating flag...");
        flag = true;
    }
}

/*
=================================================
WHAT IS volatile?
=================================================

volatile ensures:
✔ Visibility
✔ Ordering (happens-before)

volatile does NOT ensure:
❌ Atomicity
❌ Mutual exclusion

=================================================
WHY volatile IS NEEDED
=================================================

- Threads may cache variables locally
- Updates may not be visible to other threads
- volatile forces read/write from main memory

=================================================
VISIBILITY vs ATOMICITY
=================================================

Visibility:
- Other threads SEE updated value
- Provided by volatile

Atomicity:
- Operation completes as one unit
- NOT provided by volatile

Example:
count++ ❌ NOT atomic even if volatile

=================================================
WHEN TO USE volatile
=================================================
✔ Flags
✔ State indicators
✔ One-write-many-read scenarios

=================================================
WHEN NOT TO USE volatile
=================================================
❌ Counters
❌ Compound operations
❌ Critical sections

=================================================
volatile vs synchronized
=================================================

volatile:
✔ Lightweight
✔ No blocking
❌ No atomicity

synchronized:
✔ Atomicity + visibility
❌ Slower (locking)

=================================================
INTERVIEW QUESTIONS (VERY IMPORTANT)
=================================================

Q1. Does volatile guarantee atomicity?
👉 ❌ No

Q2. Can volatile replace synchronized?
👉 ❌ No

Q3. Is volatile thread-safe?
👉 Partial – visibility only

Q4. Where is volatile stored?
👉 Main memory (forces visibility)

Q5. Can we use volatile with objects?
👉 Yes, but only reference visibility

=================================================
REAL-TIME USE CASES
=================================================
✔ Shutdown flags
✔ Configuration refresh
✔ State monitoring

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"volatile guarantees visibility, not atomicity."
*/

