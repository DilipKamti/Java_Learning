package java_basics;

import java.util.Scanner;
import java.io.*;

public class InputOutput {

    static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 1. Reading int, double, String
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        sc.nextLine(); // consume leftover newline
        System.out.print("Enter your full name: ");
        String name = sc.nextLine();

        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);

        // 2. Reading array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Array elements: ");
        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();

        // 3. BufferedReader example
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter city: ");
        String city = br.readLine();
        System.out.println("City: " + city);

        // 4. Formatted output
        System.out.printf("Name: %s, Age: %d, Salary: %.2f%n", name, age, salary);
    }
}

