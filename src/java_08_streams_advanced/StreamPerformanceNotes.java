package java_08_streams_advanced;

// StreamPerformanceNotes.java
// Java Streams Performance – Deep Dive Notes + Examples ✅

import java.util.*;
import java.util.stream.IntStream;

public class StreamPerformanceNotes {

    public static void main(String[] args) {

        List<Integer> numbers =
                IntStream.rangeClosed(1, 1_000_000)
                        .boxed()
                        .toList();

        // =====================================================
        // 1️⃣ Traditional for-loop (Baseline)
        // =====================================================
        long startLoop = System.currentTimeMillis();

        long sum1 = 0;
        for (int n : numbers) {
            sum1 += n;
        }

        long endLoop = System.currentTimeMillis();
        System.out.println("For-loop sum: " + sum1 +
                " | Time: " + (endLoop - startLoop) + " ms");

        // =====================================================
        // 2️⃣ Sequential Stream
        // =====================================================
        long startStream = System.currentTimeMillis();

        long sum2 = numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();

        long endStream = System.currentTimeMillis();
        System.out.println("Sequential Stream sum: " + sum2 +
                " | Time: " + (endStream - startStream) + " ms");

        // =====================================================
        // 3️⃣ Parallel Stream
        // =====================================================
        long startParallel = System.currentTimeMillis();

        long sum3 = numbers.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();

        long endParallel = System.currentTimeMillis();
        System.out.println("Parallel Stream sum: " + sum3 +
                " | Time: " + (endParallel - startParallel) + " ms");
    }
}

/*
=================================================
STREAM PERFORMANCE – THEORY NOTES
=================================================

1️⃣ Streams are NOT magic
-------------------------
- Streams improve readability, not always performance
- Extra overhead: lambda creation, pipeline setup, boxing/unboxing

2️⃣ For-loop vs Stream
----------------------
For-loop:
✔ Fastest for simple logic
✔ Minimal overhead
✔ Best for performance-critical code

Stream:
✔ Cleaner code
✔ Functional style
✔ Slightly slower for simple tasks

=================================================
WHEN STREAMS ARE SLOWER
=================================================
❌ Small collections
❌ Simple operations
❌ Heavy object creation
❌ Boxing/unboxing (Integer vs int)

=================================================
PARALLEL STREAM PERFORMANCE
=================================================
✔ Good for large datasets
✔ CPU-intensive tasks only
❌ Bad for I/O (DB, File, API)
❌ Bad for synchronized/shared state

Parallel streams use:
👉 ForkJoinPool.commonPool()

=================================================
BIG-O DOES NOT CHANGE
=================================================
- Stream does NOT reduce time complexity
- O(n) stays O(n)
- Only constant factors may change

=================================================
MEMORY CONSIDERATIONS
=================================================
- Streams create intermediate objects
- Lambdas capture context
- Parallel streams increase memory pressure

=================================================
ORDER & PERFORMANCE
=================================================
forEach():
✔ Faster
❌ Order not guaranteed

forEachOrdered():
✔ Maintains order
❌ Slower

=================================================
COMMON INTERVIEW TRAPS
=================================================
❌ "Streams are always faster" → WRONG
❌ "Parallel stream is multi-core magic" → WRONG
❌ "Streams change Big-O" → WRONG

=================================================
INTERVIEW QUESTIONS (VERY IMPORTANT)
=================================================

Q1. When NOT to use streams?
👉 Small loops, performance-critical sections

Q2. Are streams lazy?
👉 Yes, intermediate operations are lazy

Q3. Are streams reusable?
👉 No, stream is single-use

Q4. Why parallel streams can be slower?
👉 Thread overhead, splitting, merging results

Q5. Should streams replace loops?
👉 No, use where readability matters

=================================================
REAL-TIME BEST PRACTICES
=================================================
✔ Use loops in low-latency code
✔ Use streams for data transformation
✔ Benchmark before using parallel streams
✔ Avoid side effects in streams

=================================================
ONE-LINE SUMMARY (INTERVIEW)
=================================================
Streams improve readability, NOT guaranteed performance.
*/

