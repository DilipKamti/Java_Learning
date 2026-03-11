package java_04_exception_handling;

class BussinessValidationException extends Exception{

    public BussinessValidationException(String message){
        super(message);
    }
}

class ResourceNotFoundExcpetion extends RuntimeException {
    ResourceNotFoundExcpetion(String message){
        super(message);
    }
}


public class ExceptionPractice {

    public static void main(String[] args) {
        try {
            validateUser(17);
        } catch (BussinessValidationException e) {
            System.out.println("Caught Business Validation Exception: " + e.getMessage());
        }

        try {
            findResource("nonexistent.txt");
        } catch (ResourceNotFoundExcpetion e) {
            System.out.println("Caught Resource Not Found Exception: " + e.getMessage());
        }
    }

    static void validateUser(int age) throws BussinessValidationException {
        if (age < 18) {
            throw new BussinessValidationException("User must be at least 18 years old.");
        }
    }

    static void findResource(String resourceName) {
        throw new ResourceNotFoundExcpetion("Resource '" + resourceName + "' not found.");
    }
}
