package java_13_design_patterns.structural;

/**
 * Covers:
 * - Provide a simplified interface to a complex subsystem
 * - Hide subsystem complexities from the client
 * - Common use-cases: API wrappers, libraries, subsystem management
 */

public class FacadeExample {

    // ===== 1️⃣ Subsystems =====
    static class CPU {
        public void start() {
            System.out.println("CPU is starting...");
        }
    }

    static class Memory {
        public void load(long position, byte[] data) {
            System.out.println("Loading data into memory at position " + position);
        }
    }

    static class HardDrive {
        public byte[] read(long lba, int size) {
            System.out.println("Reading " + size + " bytes from hard drive at LBA " + lba);
            return new byte[size];
        }
    }

    // ===== 2️⃣ Facade =====
    static class ComputerFacade {
        private final CPU cpu;
        private final Memory memory;
        private final HardDrive hardDrive;

        public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.hardDrive = new HardDrive();
        }

        public void startComputer() {
            System.out.println("Starting computer using Facade...");
            cpu.start();
            byte[] bootData = hardDrive.read(0, 1024);
            memory.load(0, bootData);
            System.out.println("Computer started successfully!");
        }
    }

    // ===== 3️⃣ Memory Hook / Easy Way to Remember =====
    /*
        💡 Facade = simple interface to complex subsystem
        💡 Client interacts with Facade only
        💡 Subsystems remain hidden and encapsulated
    */

    // ===== 4️⃣ Interview Tips / Tricks =====
    /*
        🔹 Difference between Facade and Adapter?
            - Facade: simplify multiple subsystems with one interface
            - Adapter: convert interface to match client expectation
        🔹 When to use Facade?
            - Hide complexity of subsystem
            - Provide easy-to-use API
        🔹 Common interview example: Computer startup, Library API, Banking system API
        🔹 Often asked: implement Facade for subsystem initialization
    */

    // ===== 5️⃣ Test / Demo =====
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}

