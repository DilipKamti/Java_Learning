package java_02_oops.practice;

/*
 * This program demonstrates:
 * 1. Shallow Copy using clone()
 * 2. Problem with Shallow Copy
 * 3. Deep Copy solution
 */

class Address {
    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // Copy constructor (used for Deep Copy)
    public Address(Address other) {
        this.city = other.city;
        this.state = other.state;
    }

    @Override
    public String toString() {
        return "Address{city='" + city + "', state='" + state + "'}";
    }
}

/* ---------------- SHALLOW COPY ---------------- */
class UserShallow implements Cloneable {
    String name;
    int age;
    Address address;

    public UserShallow(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // address reference is shared
    }

    @Override
    public String toString() {
        return "UserShallow{name='" + name + "', age=" + age +
                ", address=" + address + '}';
    }
}

/* ---------------- DEEP COPY ---------------- */
class UserDeep implements Cloneable {
    String name;
    int age;
    Address address;

    public UserDeep(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        UserDeep cloned = (UserDeep) super.clone();
        cloned.address = new Address(this.address); // new object
        return cloned;
    }

    @Override
    public String toString() {
        return "UserDeep{name='" + name + "', age=" + age +
                ", address=" + address + '}';
    }
}

/* ---------------- MAIN CLASS ---------------- */
public class CloneableExample {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("========== SHALLOW COPY ==========");
        Address address1 = new Address("New York", "NY");

        UserShallow user1 = new UserShallow("John", 30, address1);
        UserShallow user2 = (UserShallow) user1.clone();

        System.out.println("Before change:");
        System.out.println(user1);
        System.out.println(user2);

        // Modifying cloned object's address
        user2.address.city = "Los Angeles";

        System.out.println("\nAfter change (ISSUE):");
        System.out.println(user1); // Affected ❌
        System.out.println(user2); // Changed ❌

        System.out.println("\n========== DEEP COPY ==========");
        Address address2 = new Address("New York", "NY");

        UserDeep user3 = new UserDeep("John", 30, address2);
        UserDeep user4 = (UserDeep) user3.clone();

        System.out.println("Before change:");
        System.out.println(user3);
        System.out.println(user4);

        // Modifying cloned object's address
        user4.address.city = "Los Angeles";

        System.out.println("\nAfter change (FIXED):");
        System.out.println(user3); // Not affected ✅
        System.out.println(user4); // Changed ✅
    }
}
