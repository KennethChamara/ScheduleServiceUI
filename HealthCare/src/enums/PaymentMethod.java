package enums;

public enum PaymentMethod {
    PayPal("Paypal"),
    OnlineBanking("Online Banking"),
    CreditCard("Credit Card");
    private final  String name;

    private PaymentMethod(String name){
        this.name=name;
    }
}
