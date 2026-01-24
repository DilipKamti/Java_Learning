package java_basics;

public class Loops {

    public static void main(String[] args) {

        // 1. For loop
        System.out.println("For loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("-------------------");

        // 2. While loop
        System.out.println("While loop:");
        int j = 1;
        while (j <= 5) {
            System.out.println("j = " + j);
            j++;
        }

        System.out.println("-------------------");

        // 3. Do-while loop
        System.out.println("Do-while loop:");
        int k = 6;
        do {
            System.out.println("k = " + k);
            k++;
        } while (k <= 5);

        System.out.println("-------------------");

        // 4. Nested loop
        System.out.println("Nested loop:");
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                System.out.print(a + "" + b + " ");
            }
            System.out.println();
        }

        System.out.println("-------------------");

        // 5. Break and continue
        System.out.println("Break example:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) break;
            System.out.print(i + " ");
        }

        System.out.println("\nContinue example:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            System.out.print(i + " ");
        }

        System.out.println("\n-------------------");

        // 6. For loop with multiple variables
        System.out.println("For loop multiple variables:");
        j = 5;
        for (int i = 0; i < 5; i++, j--) {
            System.out.println(i + " " + j);
        }

        System.out.println("-------------------");

        // 7. Break with label
        System.out.println("Break with label:");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j2 = 1; j2 <= 3; j2++) {
                if (i * j2 == 4) break outer;
                System.out.println(i + " " + j2);
            }
        }

        System.out.println("-------------------");

        // 8. Pattern printing
        System.out.println("Pattern:");
        for (int i = 1; i <= 5; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------");

        // 9. Loops with arrays
        int[] arr = {10, 20, 30, 40};
        System.out.println("Array loop:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("Enhanced for loop:");
        for (int val : arr) {
            System.out.println(val);
        }

        // Interviwer questions
        int i = 0;
        for (; i < 5; ) {
            System.out.print(i++ + " ");
        }
        // o/p -> 0 1 2 3 4

        i = 0;
        for (; i < 5; ) {
            System.out.print(++i + " ");
        }
        // o/p -> 1 2 3 4 5

        i = 0;
        for (; i < 5; i--) {
            System.out.println(i);
        }
        // O/P -> Infinite negative numbers

        i = 5;
        do {
            System.out.print(i + " ");
            i++;
        } while (i < 5);
        // O/P -> 5

    }
}

