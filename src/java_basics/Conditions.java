package java_basics;

public class Conditions {
    public static void main(String[] args) {
        // 1. if statement
        int age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        }

        // 2. if-else
        age = 15;
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }

        // 3. if-else-if ladder
        int marks = 85;
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 50) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }

        // 4. Nested if
        boolean hasLicense = true;
        if (age >= 18) {
            if (hasLicense) {
                System.out.println("Can drive");
            } else {
                System.out.println("Need a license");
            }
        } else {
            System.out.println("Too young to drive");
        }

        // Old Switch Expression
        int day = 3;
        String dayname;

        switch (day) {
            case 1:
                dayname = "Monday";
                break;
            case 2:
                dayname = "Tuesday";
                break;
            case 3:
                dayname = "Wednesday";
                break;
            case 4:
                dayname = "Thursday";
                break;
            case 5:
                dayname = "Friday";
                break;
            case 6:
            case 7:
                dayname = "Weekend";
                break;
            default:
                dayname = "Invalid";
        }
        System.out.println(dayname);


        // 5. Classic switch
        String Day = "FRIDAY";
        switch (Day) {
            case "MONDAY" -> System.out.println("Start of week");
            case "FRIDAY" -> System.out.println("End of week");
            case "SATURDAY", "SUNDAY" -> System.out.println("Weekend");
            default -> System.out.println("Midweek");
        }

        // 6. Switch expression (Java 14+)
        int dayNum = 3;
        String dayName = switch (dayNum) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };
        System.out.println(dayName);

        int days = 3;

        String daysName = switch (days) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> {
                // multiple statements allowed
                System.out.println("Midweek processing...");
                int x = 100; // some calculation
                yield "Wednesday"; // must yield a value
            }
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };

        System.out.println(dayName);


        // 7. Ternary operator
        marks = 65;
        String result = (marks >= 50) ? "Pass" : "Fail";
        System.out.println(result);

        // 8. Nested if vs logical operators
        boolean canDrive = (age >= 18 && hasLicense);
        System.out.println("Can drive: " + canDrive);
    }
}

