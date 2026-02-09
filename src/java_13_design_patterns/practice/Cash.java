package java_13_design_patterns.practice;

public class Cash implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Processing cash payment of $" + amount);
    }
}
