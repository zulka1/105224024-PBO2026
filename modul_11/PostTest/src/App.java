public class App {
    public static void main(String[] args) throws Exception {
        AkunBank[] user = new AkunBank[2];
        user[0] = new AkunBank("123456", 500000);
        user[1] = new AkunBank("654321", 1000000);

        try {
            user[0].tarikTunai(500000);
            System.out.println("Tarik tunai berhasil");
        } catch (SaldoTidakMencukupiExpection e) {
            System.out.println(e.getMessage());
        }

        try {
            user[0].transfer("654321", 5000000);
            System.out.println("Transfer berhasil");
        } catch (SaldoTidakMencukupiExpection e) {
            System.out.println(e.getMessage());
        } catch (BatasHarianTransferExpection e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Sesi transaksi ATM Anda telah dikahiri. kartu dikeluarkan otomatis");
        }

    }
}
