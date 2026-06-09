public class BankTransfer implements Payable, Refundable {

    @Override
    public void pay(double amount) {
        System.out.println("Memproses transfer bank sebesar Rp" + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Memproses refund via transfer bank sebesar Rp" + amount);
    }
}
