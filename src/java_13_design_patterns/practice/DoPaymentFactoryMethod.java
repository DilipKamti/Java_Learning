package java_13_design_patterns.practice;

public class DoPaymentFactoryMethod {

    public Payment getPaymentMethod(String paymentType){
        if(paymentType == null) return null;
        switch (paymentType){
            case "Cash": return new Cash();
            case "NetBanking": return new NetBanking();
            case "UPI": return new Upi();
            default: return null;
        }

    }
}
