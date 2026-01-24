package java_core;

// ImmutableClassExample.java
// Basic to Deep Dive (Interview Ready) ✅
// Covers: What is immutability, how to create immutable class,
// rules, defensive copying, final keyword, common mistakes.

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImmutableClassExample {

    // =========================================================
    // 1) What is an Immutable Class?
    // =========================================================
    /*
        Immutable class means:
        Once an object is created, its state cannot be changed.

        Examples of immutable classes in Java:
        ✅ String
        ✅ Integer, Long, Double (Wrapper classes)
        ✅ LocalDate, LocalDateTime (Java 8 Date-Time API)

        Benefits:
        1) Thread-safe
        2) Safe for caching
        3) No unexpected changes
        4) Safe to use as HashMap keys
    */

    // =========================================================
    // 2) Rules to Create Immutable Class (Most Important)
    // =========================================================
    /*
        1) Make class final (so no one can extend it)
        2) Make all fields private final
        3) Do NOT provide setters
        4) Initialize all fields using constructor only
        5) If fields are mutable objects -> use Defensive Copying
           - copy inside constructor
           - return copy in getter
    */

    // =========================================================
    // Immutable Class Example (Student)
    // =========================================================
    static final class Student {

        // private final fields
        private final int id;
        private final String name;

        // Mutable objects (must be handled carefully)
        private final Date dob;              // Date is mutable
        private final List<String> skills;   // List is mutable

        public Student(int id, String name, Date dob, List<String> skills) {
            this.id = id;
            this.name = name;

            // Defensive Copy (to prevent external modification)
            this.dob = new Date(dob.getTime());

            // Defensive Copy for list
            this.skills = new ArrayList<>(skills);
        }

        // Getters only (no setters)
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        // Return defensive copy (to prevent modification)
        public Date getDob() {
            return new Date(dob.getTime());
        }

        public List<String> getSkills() {
            return new ArrayList<>(skills);
        }

        @Override
        public String toString() {
            return "Student{id=" + id +
                    ", name='" + name + '\'' +
                    ", dob=" + dob +
                    ", skills=" + skills +
                    '}';
        }
    }

    // =========================================================
    // Example of WRONG Immutable Class (Common Mistake)
    // =========================================================
    /*
        Problem:
        - Returning direct reference of mutable objects
        - Accepting mutable objects without copying
    */
    static final class WrongStudent {
        private final int id;
        private final Date dob; // mutable

        public WrongStudent(int id, Date dob) {
            this.id = id;
            this.dob = dob; // ❌ no defensive copy
        }

        public Date getDob() {
            return dob; // ❌ returns direct reference
        }
    }

    // =========================================================
    // MAIN
    // =========================================================
    public static void main(String[] args) {

        System.out.println("========== Immutable Class Example ==========");

        Date dob = new Date(); // mutable object
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("DSA");

        Student s1 = new Student(101, "Dilip", dob, skills);

        System.out.println("Before modification attempt:");
        System.out.println(s1);

        // Trying to modify original objects
        dob.setTime(0); // changes external Date
        skills.add("Spring Boot"); // changes external list

        System.out.println("\nAfter modifying external objects:");
        System.out.println(s1);
        System.out.println("👉 Student object NOT changed (immutable safe) ✅");

        // Trying to modify via getter objects
        Date gotDob = s1.getDob();
        gotDob.setTime(0); // modify returned Date copy

        List<String> gotSkills = s1.getSkills();
        gotSkills.add("AWS"); // modify returned List copy

        System.out.println("\nAfter modifying getter returned objects:");
        System.out.println(s1);
        System.out.println("👉 Still NOT changed (defensive copy works) ✅");

        // Wrong example
        System.out.println("\n========== Wrong Immutable Example ==========");

        Date d = new Date();
        WrongStudent ws = new WrongStudent(1, d);

        System.out.println("WrongStudent DOB before change: " + ws.getDob());
        ws.getDob().setTime(0); // modifies internal state ❌
        System.out.println("WrongStudent DOB after change: " + ws.getDob());
        System.out.println("👉 WrongStudent is NOT immutable ❌");
    }
}

/*
===============================
INTERVIEW QUESTIONS (Quick)
===============================

1) What is immutable class?
- Object state cannot be changed after creation.

2) Why immutability is important?
- Thread-safe, caching, safe sharing, HashMap key stability.

3) Rules to create immutable class?
- class final
- fields private final
- no setters
- initialize via constructor
- defensive copy for mutable objects

4) Why defensive copying is required?
- To protect internal state from external modification.

5) Can we make immutable class without final class?
- Possible but risky because child class can add setters or override methods.

6) Why String is immutable?
- Security, pooling, thread safety, hash-based collections.

7) What happens if getter returns direct mutable reference?
- Object becomes mutable (breaks immutability).
*/

