import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Pembayaran> transaksi = new ArrayList<Pembayaran>();
        transaksi.add(new KartuKredit("Andi", 100000, "1234567890"));
        transaksi.add(new EWallet("Siti", 200000, "08123456789"));
        
        for (Pembayaran p : transaksi) {
            p.tampilkanDetail();
            if (p instanceof Keamanan) {
                boolean aman = ((Keamanan) p).autentikasi();
                if(aman) {
                    p.prosesPembayaran();
                }
            }
        }
    }
}
