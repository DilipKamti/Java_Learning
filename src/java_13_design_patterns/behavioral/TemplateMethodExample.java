package java_13_design_patterns.behavioral;

/**
 * Covers:
 * - Define skeleton of an algorithm in base class
 * - Subclasses override specific steps
 * - Promotes code reuse and consistent workflow
 */

public class TemplateMethodExample {

    // ===== 1️⃣ Abstract Class (Template) =====
    static abstract class DataProcessor {
        // template method (final to prevent override)
        public final void process() {
            readData();
            processData();
            saveData();
            hook(); // optional step
        }

        protected abstract void readData();
        protected abstract void processData();
        protected abstract void saveData();

        // optional hook method
        protected void hook() {
            // default implementation (can be overridden)
        }
    }

    // ===== 2️⃣ Concrete Class 1 =====
    static class CSVDataProcessor extends DataProcessor {
        @Override
        protected void readData() {
            System.out.println("Reading data from CSV file");
        }

        @Override
        protected void processData() {
            System.out.println("Processing CSV data");
        }

        @Override
        protected void saveData() {
            System.out.println("Saving CSV data to database");
        }
    }

    // ===== 3️⃣ Concrete Class 2 =====
    static class XMLDataProcessor extends DataProcessor {
        @Override
        protected void readData() {
            System.out.println("Reading data from XML file");
        }

        @Override
        protected void processData() {
            System.out.println("Processing XML data");
        }

        @Override
        protected void saveData() {
            System.out.println("Saving XML data to database");
        }

        @Override
        protected void hook() {
            System.out.println("Optional: validate XML schema");
        }
    }

    // ===== 4️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Template Method = define algorithm skeleton in base class
        💡 Subclasses implement specific steps
        💡 Promotes code reuse + consistent workflow
    */

    // ===== 5️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Template Method and Strategy?
            - Template Method = base class defines skeleton, subclasses override steps
            - Strategy = interchangeable algorithms, chosen at runtime
        🔹 When to use Template Method?
            - Multiple classes share same algorithm structure but vary in steps
        🔹 Common interview examples: File parsing, Data processing, Workflow engines
        🔹 Often asked: implement Template Method for CSV/XML processor
    */

    // ===== 6️⃣ Test / Demo =====
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        DataProcessor xmlProcessor = new XMLDataProcessor();

        System.out.println("=== CSV Processing ===");
        csvProcessor.process();

        System.out.println("\n=== XML Processing ===");
        xmlProcessor.process();
    }
}

