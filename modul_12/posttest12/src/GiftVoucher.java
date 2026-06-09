public class GiftVoucher implements Payable {

    @Override
    public void pay(double amount) {
        System.out.println("Menukarkan voucher senilai Rp" + amount);
    }
}
