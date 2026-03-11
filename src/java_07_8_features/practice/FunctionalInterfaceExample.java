package java_07_8_features.practice;

import java.util.concurrent.Callable;
import java.util.function.*;

@FunctionalInterface
interface MyFuntionalInterface<Integer> {
    int execute( int a, int b);
}

public class FunctionalInterfaceExample {

    static void main(){

        /* 1. Predicate<T> functional interface
        * Takes one input
        * Returns boolean
        * Used for conditions / filtering
        * */
        Predicate<Integer> isEven = x -> x%2 ==0;
        System.out.println("Is 10 even? " + isEven.test(10));

        /*
        * 2. Function<T,R> functional interface
        *  Takes one input
        *   Returns one output
        *   Used for transformations / mapping
        * */
        Function<String, Integer> stringlength = String::length;
        System.out.println("Length of 'Functional Interface': " + stringlength.apply("Functional Interface"));

        /*
        * 3. Consumer<T> functional interface
        *  Takes one input
        *  Returns void
        * */
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello world");

        /*
        *  4. Supplier<T> functional interface
        *  Takes no input
        *  Returns one output
        * */
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number: " + randomSupplier.get());

        /*
        * 5. BiPredicate<T,U> functional interface
        * Takes two inputs
        * Returns boolean
        * */
        BiPredicate<Integer,Integer> isGreater = (a,b) -> a > b;
        System.out.println("Is 10 greater than 5? " + isGreater.test(10,5));

        /*
        * 6. BiFunction<T,U,R> functional interface
        * Takes two inputs
        * Returns one output
        * */

        BiFunction<Integer,Integer,Integer> sum = Integer::sum;
        System.out.println("Sum of 10 and 5: " + sum.apply(10,5));

        /*
        * 7. BiConsumer<T,U> functional interface
        * Takes two inputs
        * Returns void
        * */
        BiConsumer<String,String> printFullName = (first,last) -> System.out.println(first + " " + last);
        printFullName.accept("John","Doe");

        /*
        * 8. UnaryOperator<T> functional interface
        * Takes one input
        * Returns one output of same type
         */
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5));

        /*
        * 9. BinaryOperator<T> functional interface
        * Takes two inputs
        * Returns one output of same type
        * */
        BinaryOperator<Integer> multiple = (a,b) -> a*b;
        System.out.println("Product of 10 and 5: " + multiple.apply(10,5));

        /*
        * 10. ToIntFunction<T> functional interface
        * Takes one input
        * Returns int
        * */
        ToIntFunction<String> stringToInt = String::length;
        System.out.println("Length of 'Java 8': " + stringToInt.applyAsInt("Java 8"));

        /*
        * 11. Runnable functional interface
        * Takes no input
        * Returns void
        * */

        Runnable task = () -> System.out.println("Running a task...");
        task.run();

        /*
        * 12. Callable<V> functional interface
        * Takes no input
        * Returns one output (can throw checked exception)
        * */

        Callable<Integer> callableTask = () -> {
            Thread.sleep(1000); // simulate delay
            return 42;
        };
        try {
            System.out.println("Callable result: " + callableTask.call());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        * 13. Custom functional interface
        * Can define your own functional interface with @FunctionalInterface annotation
        * */

        MyFuntionalInterface<Integer> add = (a,b) -> a + b;
        System.out.println("Sum using custom functional interface: " + add.execute(10,5));

    }

}
