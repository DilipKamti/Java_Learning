package java_13_design_patterns.practice;

import java_13_design_patterns.creational.SingletonExample;

public class creationalMain {

    public static void main(String args[]){
        SingletonExample s1= SingletonExample.getInstance();
        SingletonExample s2= SingletonExample.getInstance();
        System.out.println("s1 hashCode: "+s1.hashCode());
        System.out.println("s2 hashCode: "+s2.hashCode());
        System.out.println(s1==s2);

        ThreadSafeSingletonExample ts1 = ThreadSafeSingletonExample.getInstance();
        ThreadSafeSingletonExample ts2 = ThreadSafeSingletonExample.getInstance();

        System.out.println("ts1 hashCode: "+ts1.hashCode());
        System.out.println("ts2 hashCode: "+ts2.hashCode());
        System.out.println(ts1==ts2);

        DoubleCheckedSingleton d1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton d2 = DoubleCheckedSingleton.getInstance();

        System.out.println("d1 hashCode: "+d1.hashCode());
        System.out.println("d1 hashCode: "+d1.hashCode());
        System.out.println(d1==d2);

        DoPaymentFactoryMethod dopayment= new DoPaymentFactoryMethod();
        Payment p1 = dopayment.getPaymentMethod("Cash");
        Payment p2 = dopayment.getPaymentMethod("NetBanking");
        Payment p3 = dopayment.getPaymentMethod("UPI");

        p1.pay(100);
        p2.pay(200);
        p3.pay(300);

        User user = new User.Builder("Dilip", "Kumar")
                .email("dilip@test.com")
                .age(30)
                .country("India")
                .build();

        System.out.println(user);
    }
}
