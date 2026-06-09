public class CreditCard implements Payable, Refundable {

    @Override
    public void pay(double amount) {
        System.out.println("Memproses pembayaran via API Bank sebesar Rp" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Memproses refund ke kartu kredit sebesar Rp" + amount);
    }
}
