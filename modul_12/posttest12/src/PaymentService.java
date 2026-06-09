public class PaymentService {

    private final Payable paymentMethod;

    public PaymentService(Payable paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}
