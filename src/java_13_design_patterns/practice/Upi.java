package java_13_design_patterns.practice;

public class Upi implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
    }
}
