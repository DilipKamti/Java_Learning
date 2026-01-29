package java_13_design_patterns.creational;

/**
 * Covers:
 * - Ensures only one instance exists
 * - Thread-safe, lazy initialization
 * - Common interview questions: eager vs lazy, double-checked locking
 */

public class SingletonExample {

    // ===== 1️⃣ Lazy initialization with double-checked locking =====
    private static volatile SingletonExample instance; // volatile ensures visibility across threads

    private SingletonExample() {
        // private constructor prevents external instantiation
    }

    public static SingletonExample getInstance() {
        if (instance == null) { // first check (no locking)
            synchronized (SingletonExample.class) {
                if (instance == null) { // second check (with locking)
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }

    // ===== 2️⃣ Sample method =====
    public void showMessage() {
        System.out.println("Hello from Singleton! Instance hashCode: " + this.hashCode());
    }

    // ===== 3️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Singleton = Single instance globally
        💡 Lazy initialization = create when first needed
        💡 Double-checked locking = thread-safe without too much overhead
    */

    // ===== 4️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between eager vs lazy initialization?
            - Eager: instance created at class load time
            - Lazy: instance created when needed
        🔹 Why volatile needed with double-checked locking?
            - Prevents half-initialized object visibility to other threads
        🔹 How to break Singleton via reflection?
            - Reflection can call private constructor → solve with enum Singleton
        🔹 Enum Singleton = best way in modern Java for thread-safety & serialization
    */

    // ===== 5️⃣ Modern Enum Singleton (Interview favorite) =====
    public enum EnumSingleton {
        INSTANCE;

        public void showMessage() {
            System.out.println("Hello from Enum Singleton! Instance hashCode: " + this.hashCode());
        }
    }

    // ===== 6️⃣ Quick Test =====
    public static void main(String[] args) {
        SingletonExample s1 = SingletonExample.getInstance();
        SingletonExample s2 = SingletonExample.getInstance();

        s1.showMessage();
        s2.showMessage();

        System.out.println("Are both instances same? " + (s1 == s2));

        // Enum Singleton
        EnumSingleton e1 = EnumSingleton.INSTANCE;
        EnumSingleton e2 = EnumSingleton.INSTANCE;
        e1.showMessage();
        e2.showMessage();
        System.out.println("Are enum instances same? " + (e1 == e2));
    }
}

