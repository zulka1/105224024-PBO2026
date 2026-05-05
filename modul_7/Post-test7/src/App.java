import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<MetodePembayaran> daftarPembayaran = new ArrayList<>();

        daftarPembayaran.add(new MetodePembayaran());
        daftarPembayaran.add(new EWallet());
        daftarPembayaran.add(new KartuKredit());

        for (MetodePembayaran metode : daftarPembayaran) {
            metode.bayar(100000);

            if (metode instanceof KartuKredit) {
                ((KartuKredit) metode).verifikasiPIN();
            }

            if (metode instanceof EWallet) {
                ((EWallet) metode).bayar(50000, "08123456789");
            }
        }
    }
}
