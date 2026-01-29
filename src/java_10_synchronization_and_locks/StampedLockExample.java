package java_10_synchronization_and_locks;

import java.util.concurrent.locks.StampedLock;

/**
 * Covers:
 * - Read lock, Write lock
 * - Optimistic read lock
 * - Try/finally pattern
 * - Use-cases vs ReentrantReadWriteLock
 */

public class StampedLockExample {

    public static void main(String[] args) throws InterruptedException {
        Point point = new Point(0, 0);

        System.out.println("===== 1️⃣ Write Lock Example =====");
        Thread writer = new Thread(() -> {
            point.move(10, 20);
        }, "Writer");
        writer.start();
        writer.join();

        System.out.println("\n===== 2️⃣ Read Lock Example =====");
        Thread reader1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " distance: " + point.distanceFromOrigin());
        }, "Reader1");

        Thread reader2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " distance: " + point.distanceFromOrigin());
        }, "Reader2");

        reader1.start();
        reader2.start();
        reader1.join();
        reader2.join();

        System.out.println("\n===== 3️⃣ Optimistic Read Example =====");
        Thread optimisticReader = new Thread(() -> {
            double distance = point.distanceOptimistic();
            System.out.println(Thread.currentThread().getName() + " optimistic distance: " + distance);
        }, "OptimisticReader");

        optimisticReader.start();
        optimisticReader.join();

        System.out.println("\n===== 4️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 StampedLock = more advanced ReadWriteLock
            💡 Write Lock = exclusive, only one thread
            💡 Read Lock = shared, multiple threads can read
            💡 Optimistic Read = non-blocking, validate stamp after reading
        """);

        System.out.println("\n===== 5️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference from ReentrantReadWriteLock?
                - StampedLock can do optimistic reads
                - Not reentrant
            🔹 When to use optimistic read?
                - Reads are frequent, writes are rare
            🔹 Always validate stamp after optimistic read
            🔹 Always release lock in finally block
        """);
    }

    /**
     * Point class using StampedLock
     */
    static class Point {
        private double x, y;
        private final StampedLock lock = new StampedLock();

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Write lock example
        public void move(double deltaX, double deltaY) {
            long stamp = lock.writeLock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired write lock");
                x += deltaX;
                y += deltaY;
                System.out.println(Thread.currentThread().getName() + " moved point to (" + x + "," + y + ")");
            } finally {
                lock.unlockWrite(stamp);
                System.out.println(Thread.currentThread().getName() + " released write lock");
            }
        }

        // Read lock example
        public double distanceFromOrigin() {
            long stamp = lock.readLock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired read lock");
                return Math.sqrt(x * x + y * y);
            } finally {
                lock.unlockRead(stamp);
                System.out.println(Thread.currentThread().getName() + " released read lock");
            }
        }

        // Optimistic read example
        public double distanceOptimistic() {
            long stamp = lock.tryOptimisticRead();
            double currentX = x;
            double currentY = y;

            // validate stamp
            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    lock.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }
    }
}

