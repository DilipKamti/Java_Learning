package java_10_synchronization_and_locks;

// ReadWriteLockExample.java
// Demonstrates ReadWriteLock using ReentrantReadWriteLock

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        // Multiple readers
        Runnable readTask = () -> {
            for (int i = 0; i < 2; i++) {
                data.read();
            }
        };

        // Writer
        Runnable writeTask = () -> {
            for (int i = 0; i < 2; i++) {
                data.write();
            }
        };

        Thread r1 = new Thread(readTask, "Reader-1");
        Thread r2 = new Thread(readTask, "Reader-2");
        Thread w1 = new Thread(writeTask, "Writer-1");

        r1.start();
        r2.start();
        w1.start();
    }
}

// =====================================================
// Shared resource protected by ReadWriteLock
// =====================================================
class SharedData {

    private int value = 0;

    // ReadWriteLock implementation
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true); // fair lock

    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()
                    + " reading value: " + value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        lock.writeLock().lock();
        try {
            value++;
            System.out.println(Thread.currentThread().getName()
                    + " writing value: " + value);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

/*
=================================================
WHAT IS ReadWriteLock?
=================================================

- A lock that allows:
  ✔ Multiple readers at the same time
  ✔ Only ONE writer at a time
- Writer blocks both readers and writers

=================================================
WHY DO WE NEED IT?
=================================================

- Improves performance in read-heavy systems
- Avoids unnecessary blocking of readers

Real-world examples:
✔ Cache systems
✔ Configuration data
✔ In-memory databases

=================================================
READ LOCK BEHAVIOR
=================================================

✔ Multiple threads can hold read lock
❌ Cannot read when write lock is held

=================================================
WRITE LOCK BEHAVIOR
=================================================

✔ Exclusive lock
❌ No readers allowed
❌ No other writers allowed

=================================================
FAIR vs UNFAIR ReadWriteLock
=================================================

new ReentrantReadWriteLock(true)  -> Fair
new ReentrantReadWriteLock(false) -> Unfair (default, faster)

Fair:
✔ Prevents writer starvation
❌ Slightly slower

=================================================
REENTRANT NATURE
=================================================

- Both read & write locks are reentrant
- Same thread can re-acquire lock

=================================================
UPGRADING & DOWNGRADING
=================================================

✔ Write → Read (downgrading allowed)
❌ Read → Write (can cause deadlock)

=================================================
ReadWriteLock vs synchronized
=================================================

synchronized:
❌ One thread at a time

ReadWriteLock:
✔ Multiple readers
✔ Better scalability

=================================================
ReadWriteLock vs ReentrantLock
=================================================

ReentrantLock:
✔ Simple mutual exclusion

ReadWriteLock:
✔ Optimized for read-heavy workloads

=================================================
COMMON INTERVIEW QUESTIONS
=================================================

Q1. Can multiple threads read simultaneously?
👉 Yes

Q2. Can a thread upgrade from read to write lock?
👉 No (risk of deadlock)

Q3. Is ReadWriteLock reentrant?
👉 Yes

Q4. What problem does it solve?
👉 Reader contention

Q5. When NOT to use it?
👉 Write-heavy systems

=================================================
ONE-LINE INTERVIEW ANSWER
=================================================
"ReadWriteLock allows multiple concurrent readers but exclusive writes to improve performance in read-heavy scenarios."
*/

