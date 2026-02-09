package java_13_design_patterns.practice;

public class ThreadSafeSingletonExample {

    private static  ThreadSafeSingletonExample Instance;

    private ThreadSafeSingletonExample() {
    }

    public static synchronized ThreadSafeSingletonExample getInstance(){
        if(Instance==null){
            Instance = new ThreadSafeSingletonExample();
        }

        return Instance;
    }
}
