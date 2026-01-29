package java_11_executor_framework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Covers:
 * - ForkJoinPool basics
 * - RecursiveTask for divide-and-conquer
 * - Parallel sum example
 * - Threshold for splitting tasks
 * - Join/compute pattern
 */

public class ForkJoinPoolExample {

    public static void main(String[] args) {
        System.out.println("===== 1️⃣ ForkJoinPool Basic Example =====");

        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i + 1;

        ForkJoinPool forkJoinPool = new ForkJoinPool(); // uses common pool if default

        SumTask task = new SumTask(numbers, 0, numbers.length);

        int result = forkJoinPool.invoke(task); // blocks until task completes
        System.out.println("Sum of array using ForkJoinPool: " + result);

        forkJoinPool.shutdown();

        System.out.println("\n===== 2️⃣ Memory Hook / Easy Way to Remember =====");
        System.out.println("""
            💡 ForkJoinPool = thread pool optimized for divide-and-conquer
            💡 RecursiveTask = returns a result, RecursiveAction = void
            💡 Threshold = limit below which task computes directly
            💡 Fork = split task into subtasks, Join = combine results
        """);

        System.out.println("\n===== 3️⃣ Interview Tips / Tricks =====");
        System.out.println("""
            🔹 Difference between ForkJoinPool and ExecutorService?
                - ForkJoinPool optimized for small tasks and work-stealing
                - ExecutorService general-purpose
            🔹 Threshold importance?
                - Too low = many tiny tasks, overhead
                - Too high = less parallelism
            🔹 RecursiveTask vs RecursiveAction?
                - RecursiveTask = returns value
                - RecursiveAction = no return value
            🔹 Common use-case: parallel sum, array processing, divide-and-conquer algorithms
        """);
    }

    // RecursiveTask for sum
    static class SumTask extends RecursiveTask<Integer> {
        private final int[] numbers;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 5; // below this compute directly

        public SumTask(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int length = end - start;
            if (length <= THRESHOLD) {
                int sum = 0;
                for (int i = start; i < end; i++) sum += numbers[i];
                System.out.println(Thread.currentThread().getName() + " computed sum from index " + start + " to " + (end - 1) + " = " + sum);
                return sum;
            } else {
                int mid = start + length / 2;
                SumTask leftTask = new SumTask(numbers, start, mid);
                SumTask rightTask = new SumTask(numbers, mid, end);

                leftTask.fork(); // async
                int rightResult = rightTask.compute(); // compute current thread
                int leftResult = leftTask.join(); // wait for forked task

                return leftResult + rightResult;
            }
        }
    }
}

