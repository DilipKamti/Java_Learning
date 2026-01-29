package java_01_basics;

public class Operators {

    public static void main(String[] args) {

        // =====================================================
        // 1) ARITHMETIC OPERATORS (+ - * / %)
        // =====================================================

        int a = 10;
        int b = 3;

        System.out.println("Arithmetic Operators:");
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3 (integer division)
        System.out.println("a % b = " + (a % b)); // 1 (remainder)

        System.out.println("---------------------------------------------");

        // IMPORTANT: Integer Division (Deep Concept)
        // When both numbers are int, result is int (decimal part lost)
        System.out.println("10 / 3 = " + (10 / 3)); // 3
        System.out.println("10 / 3.0 = " + (10 / 3.0)); // 3.333...

        System.out.println("---------------------------------------------");

        // =====================================================
        // 2) UNARY OPERATORS (++ -- + - !)
        // =====================================================

        int x = 5;

        System.out.println("Unary Operators:");
        System.out.println("x = " + x);

        // Pre-increment: increment first, then use
        System.out.println("++x = " + (++x)); // 6

        // Post-increment: use first, then increment
        System.out.println("x++ = " + (x++)); // 6 (but x becomes 7 after this line)
        System.out.println("x after x++ = " + x); // 7

        // Pre-decrement and Post-decrement
        System.out.println("--x = " + (--x)); // 6
        System.out.println("x-- = " + (x--)); // 6
        System.out.println("x after x-- = " + x); // 5

        System.out.println("---------------------------------------------");

        // Logical NOT operator (!)
        boolean isJavaEasy = true;
        System.out.println("isJavaEasy = " + isJavaEasy);
        System.out.println("!isJavaEasy = " + (!isJavaEasy));

        System.out.println("---------------------------------------------");

        // =====================================================
        // 3) ASSIGNMENT OPERATORS (= += -= *= /= %=)
        // =====================================================

        int num = 10;
        System.out.println("Assignment Operators:");
        System.out.println("num = " + num);

        num += 5; // num = num + 5
        System.out.println("num += 5 -> " + num);

        num -= 3; // num = num - 3
        System.out.println("num -= 3 -> " + num);

        num *= 2; // num = num * 2
        System.out.println("num *= 2 -> " + num);

        num /= 4; // num = num / 4
        System.out.println("num /= 4 -> " + num);

        num %= 3; // num = num % 3
        System.out.println("num %= 3 -> " + num);

        System.out.println("---------------------------------------------");

        // =====================================================
        // 4) RELATIONAL / COMPARISON OPERATORS (== != > < >= <=)
        // =====================================================

        int p = 10;
        int q = 20;

        System.out.println("Relational Operators:");
        System.out.println("p == q -> " + (p == q)); // false
        System.out.println("p != q -> " + (p != q)); // true
        System.out.println("p > q -> " + (p > q));   // false
        System.out.println("p < q -> " + (p < q));   // true
        System.out.println("p >= q -> " + (p >= q)); // false
        System.out.println("p <= q -> " + (p <= q)); // true

        System.out.println("---------------------------------------------");

        // =====================================================
        // 5) LOGICAL OPERATORS (&& || !)
        // =====================================================
        // Used mostly in conditions (if/while)

        int age = 22;
        boolean hasVoterId = true;

        System.out.println("Logical Operators:");

        // AND (&&): true only if both conditions are true
        System.out.println("age >= 18 && hasVoterId -> " + (age >= 18 && hasVoterId));

        // OR (||): true if any one condition is true
        System.out.println("age < 18 || hasVoterId -> " + (age < 18 || hasVoterId));

        System.out.println("---------------------------------------------");

        // IMPORTANT: Short Circuiting (Deep Concept)
        // && stops checking if first condition is false
        // || stops checking if first condition is true

        int z = 10;

        System.out.println("Short Circuit Demo:");

        // Here (z > 20) is false, so second part is NOT executed
        boolean result1 = (z > 20) && (++z > 10);
        System.out.println("result1 = " + result1);
        System.out.println("z after result1 = " + z); // still 10

        // Here (z == 10) is true, so second part is NOT executed
        boolean result2 = (z == 10) || (++z > 10);
        System.out.println("result2 = " + result2);
        System.out.println("z after result2 = " + z); // still 10

        System.out.println("---------------------------------------------");

        // =====================================================
        // 6) BITWISE OPERATORS (& | ^ ~)
        // =====================================================
        // Work at binary level (0 and 1)

        int m = 5;  // binary: 0101
        int n = 3;  // binary: 0011

        System.out.println("Bitwise Operators:");
        System.out.println("m = " + m + ", n = " + n);

        System.out.println("m & n = " + (m & n)); // 1  (0001)
        System.out.println("m | n = " + (m | n)); // 7  (0111)
        System.out.println("m ^ n = " + (m ^ n)); // 6  (0110)

        // ~ (bitwise NOT): flips bits
        System.out.println("~m = " + (~m)); // tricky due to 2's complement

        System.out.println("---------------------------------------------");

        // =====================================================
        // 7) SHIFT OPERATORS (<< >> >>>)
        // =====================================================

        int value = 8; // binary: 1000

        System.out.println("Shift Operators:");

        // Left shift (<<): multiply by 2^n
        System.out.println("value << 1 = " + (value << 1)); // 16

        // Right shift (>>): divide by 2^n (keeps sign)
        System.out.println("value >> 1 = " + (value >> 1)); // 4

        // Unsigned right shift (>>>): fills with 0 (used for negative numbers)
        int negative = -8;
        System.out.println("negative = " + negative);
        System.out.println("negative >> 1 = " + (negative >> 1));
        System.out.println("negative >>> 1 = " + (negative >>> 1));

        System.out.println("---------------------------------------------");

        // =====================================================
        // 8) TERNARY OPERATOR (?:)
        // =====================================================
        // Short form of if-else

        int marks = 75;

        String status = (marks >= 40) ? "PASS" : "FAIL";
        System.out.println("Ternary Operator:");
        System.out.println("Marks = " + marks + " -> " + status);

        System.out.println("---------------------------------------------");

        // =====================================================
        // 9) instanceof OPERATOR
        // =====================================================

        String str = "Java";
        System.out.println("instanceof Operator:");
        System.out.println("str instanceof String -> " + (str instanceof String));

        System.out.println("---------------------------------------------");

        // =====================================================
        // 10) STRING + OPERATOR TRICK (VERY IMPORTANT)
        // =====================================================
        // + is overloaded for String concatenation

        System.out.println("String Concatenation Tricks:");

        System.out.println("10 + 20 = " + (10 + 20));   // 30
        System.out.println("10 + 20 = " + 10 + 20);     // "10 + 20 = 1020" (string concatenation)
        System.out.println(10 + 20 + " result");        // "30 result"
        System.out.println("result " + 10 + 20);        // "result 1020"

        System.out.println("---------------------------------------------");

        // =====================================================
        // 11) OPERATOR PRECEDENCE (Deep Concept)
        // =====================================================
        // Order of execution matters:
        // *, /, % happens before +, -
        // Use brackets to avoid confusion

        int calc = 10 + 2 * 5; // 10 + 10 = 20
        System.out.println("Operator Precedence:");
        System.out.println("10 + 2 * 5 = " + calc);

        int calc2 = (10 + 2) * 5; // 12 * 5 = 60
        System.out.println("(10 + 2) * 5 = " + calc2);

    }
}