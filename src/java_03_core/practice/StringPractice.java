package java_03_core.practice;

public class StringPractice {

    static void main(String args[]){
        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println(str1 == str2); // true, because string literals are interned by the Java compiler
        System.out.println(str1.equals(str2)); // true, because the equals() method compares the content of the strings

        String str3 = new String("Hello");
        System.out.println(str1 == str3); // false, because str3 is a new object in memory
        System.out.println(str1.equals(str3)); // true, because the equals() method compares the content of the strings

        String str4 = "Hello World";
        str1=str1 + " World"; // str1 now references a new string object "Hello World"
        System.out.println(str1 == str4); // false, because str1 now references a new object in memory
        System.out.println(str1.equals(str4)); // true, because the equals() method compares the content of the strings

        str2 = str2.concat(" World"); // str2 now references a new string object "Hello World"
        System.out.println(str2 == str4); // false, because str2 now references a new object in memory
        System.out.println(str2.equals(str4)); // true, because the equals() method compares the content of the strings
    }


}
