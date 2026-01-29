package java_13_design_patterns.creational;

/**
 * Covers:
 * - Constructing complex objects step-by-step
 * - Immutable objects creation
 * - Fluent interface for readability
 * - Common interview examples: Person, Car, House
 */

public class BuilderExample {

    // ===== 1️⃣ Product class =====
    static class Person {
        private final String firstName;  // required
        private final String lastName;   // required
        private final int age;           // optional
        private final String address;    // optional
        private final String phone;      // optional

        private Person(PersonBuilder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.age = builder.age;
            this.address = builder.address;
            this.phone = builder.phone;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    // ===== 2️⃣ Builder class =====
    static class PersonBuilder {
        private final String firstName;  // required
        private final String lastName;   // required
        private int age;                 // optional
        private String address;          // optional
        private String phone;            // optional

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    // ===== 3️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Builder = step-by-step object creation
        💡 Useful for immutable and complex objects
        💡 Fluent interface = readable, chainable methods
    */

    // ===== 4️⃣ Interview Tips / Tricks =====
    /*
        🔹 When to use Builder over constructor?
            - Too many parameters, optional params
            - Improves readability and maintainability
        🔹 Difference vs Factory?
            - Factory = creates object, usually simpler
            - Builder = constructs complex object step-by-step
        🔹 Immutable objects + Builder = best practice
        🔹 Common interview example: Person, Car, House
    */

    // ===== 5️⃣ Test / Demo =====
    public static void main(String[] args) {
        Person person1 = new PersonBuilder("John", "Doe")
                .age(30)
                .address("123 Main St")
                .phone("555-1234")
                .build();

        Person person2 = new PersonBuilder("Jane", "Smith")
                .age(25)
                .build(); // only required params

        System.out.println(person1);
        System.out.println(person2);
    }
}

