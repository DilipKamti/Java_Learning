package java_13_design_patterns.structural;

/**
 * Covers:
 * - Provide a surrogate or placeholder for another object
 * - Control access to the real object
 * - Common use-cases: lazy loading, access control, logging, caching
 */

public class ProxyExample {

    // ===== 1️⃣ Subject Interface =====
    interface Image {
        void display();
    }

    // ===== 2️⃣ Real Subject =====
    static class RealImage implements Image {
        private final String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading " + fileName + " from disk...");
        }

        @Override
        public void display() {
            System.out.println("Displaying " + fileName);
        }
    }

    // ===== 3️⃣ Proxy =====
    static class ProxyImage implements Image {
        private final String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName); // lazy loading
            }
            realImage.display();
        }
    }

    // ===== 4️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Proxy = surrogate / placeholder for real object
        💡 Controls access to the real object
        💡 Can add lazy loading, caching, logging, security
    */

    // ===== 5️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Proxy and Decorator?
            - Proxy: controls access to object, may add lazy-loading/security
            - Decorator: adds functionality dynamically
        🔹 When to use Proxy?
            - Lazy initialization
            - Access control / security
            - Logging or caching operations
        🔹 Common interview example: Image loading, Virtual Proxy, Remote Proxy
        🔹 Often asked: implement image loader with proxy for lazy loading
    */

    // ===== 6️⃣ Test / Demo =====
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("First display of image1:");
        image1.display(); // loads from disk

        System.out.println("\nSecond display of image1:");
        image1.display(); // uses cached real image

        System.out.println("\nDisplay image2:");
        image2.display(); // loads from disk
    }
}

