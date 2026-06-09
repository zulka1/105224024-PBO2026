public class OVO implements Payable, Refundable {

    @Override
    public void pay(double amount) {
        System.out.println("Memproses pembayaran via OVO sebesar Rp" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Memproses refund ke saldo OVO sebesar Rp" + amount);
    }
}
