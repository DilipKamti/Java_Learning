package java_13_design_patterns.practice;

public class NetBanking implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Processing net banking payment of $" + amount);
    }
}
