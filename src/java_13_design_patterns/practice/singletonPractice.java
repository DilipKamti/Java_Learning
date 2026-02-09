package java_13_design_patterns.practice;

public class singletonPractice {

    private static singletonPractice instanece;

    private singletonPractice() {
    }

    public static singletonPractice getInstance(){
        if(instanece==null){
            return new singletonPractice();
        }

        return instanece;
    }
}
