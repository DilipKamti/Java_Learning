package java_13_design_patterns.practice;

public class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton(){

    }

    public static DoubleCheckedSingleton getInstance(){
        if(instance==null){
            synchronized (DoubleCheckedSingleton.class){
                if(instance==null){
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
