package java_08_streams_advanced;

// ParallelStreams.java
// Java 8 Parallel Streams - Deep Dive with Interview Focus ✅

import java.util.*;
import java.util.stream.IntStream;

public class ParallelStreams {

    public static void main(String[] args) {

        List<Integer> numbers = IntStream.rangeClosed(1, 20)
                .boxed()
                .toList();

        // =====================================================
        // 1️⃣ Sequential Stream (Default)
        // =====================================================
        System.out.println("Sequential Stream:");
        numbers.stream()
                .forEach(n ->
                        System.out.println(n + " - " + Thread.currentThread().getName())
                );

        System.out.println("\n---------------------------------\n");

        // =====================================================
        // 2️⃣ Parallel Stream
        // =====================================================
        System.out.println("Parallel Stream:");
        numbers.parallelStream()
                .forEach(n ->
                        System.out.println(n + " - " + Thread.currentThread().getName())
                );

        // NOTE: Order is NOT guaranteed
        System.out.println("\n---------------------------------\n");

        // =====================================================
        // 3️⃣ forEach vs forEachOrdered
        // =====================================================
        System.out.println("Parallel Stream with forEachOrdered:");
        numbers.parallelStream()
                .forEachOrdered(n ->
                        System.out.println(n + " - " + Thread.currentThread().getName())
                );

        System.out.println("\n---------------------------------\n");

        // =====================================================
        // 4️⃣ Performance Example (Sequential vs Parallel)
        // =====================================================
        long startSeq = System.currentTimeMillis();

        long seqSum = numbers.stream()
                .mapToLong(n -> heavyTask(n))
                .sum();

        long endSeq = System.currentTimeMillis();

        long startPar = System.currentTimeMillis();

        long parSum = numbers.parallelStream()
                .mapToLong(n -> heavyTask(n))
                .sum();

        long endPar = System.currentTimeMillis();

        System.out.println("Sequential Sum: " + seqSum +
                " | Time: " + (endSeq - startSeq) + " ms");

        System.out.println("Parallel Sum: " + parSum +
                " | Time: " + (endPar - startPar) + " ms");
    }

    // Simulating CPU intensive task
    private static long heavyTask(int n) {
        try {
            Thread.sleep(100); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return n * n;
    }
}

/*
=================================================
THEORY – PARALLEL STREAMS
=================================================

1️⃣ What is Parallel Stream?
----------------------------
- Stream that processes elements using multiple threads
- Uses ForkJoinPool.commonPool()
- Data is split into chunks and processed concurrently

2️⃣ How to create?
------------------
collection.parallelStream()
or
stream.parallel()

3️⃣ Key Characteristics
-----------------------
✔ Multi-threaded execution
✔ Order NOT guaranteed
✔ Uses common ForkJoinPool
✔ Best for CPU-intensive tasks

=================================================
forEach vs forEachOrdered
=================================================
forEach:
- Faster
- Order not guaranteed

forEachOrdered:
- Maintains encounter order
- Slightly slower

=================================================
WHEN TO USE PARALLEL STREAMS
=================================================
✔ Large datasets
✔ CPU-intensive operations
✔ Stateless operations
✔ No shared mutable data

=================================================
WHEN NOT TO USE (VERY IMPORTANT)
=================================================
❌ Small collections
❌ I/O operations (DB, File, API)
❌ Order-sensitive logic
❌ Shared mutable state

=================================================
COMMON INTERVIEW TRAPS
=================================================
❌ Assuming parallel is always faster
❌ Modifying shared objects inside parallel stream
❌ Using synchronized blocks inside parallel stream

=================================================
INTERVIEW QUESTIONS
=================================================

Q1. Are parallel streams always faster?
👉 No. Overhead may make them slower for small tasks.

Q2. Which thread pool is used?
👉 ForkJoinPool.commonPool()

Q3. Can we control thread count?
👉 Not directly (can customize ForkJoinPool manually)

Q4. Is parallel stream thread-safe?
👉 Stream itself is safe, but operations must be stateless

Q5. Difference between parallel stream and ExecutorService?
👉 Parallel streams are higher-level and less controllable

=================================================
REAL-TIME USE CASES
=================================================
✔ Data analytics
✔ Mathematical computations
✔ Large in-memory processing
✔ Image/video processing
*/

