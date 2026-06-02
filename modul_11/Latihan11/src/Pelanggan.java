public class Pelanggan {
    int umur;
    int stokKopi = 5;

    public Pelanggan(int umur) {
        if (umur < 17) {
            throw new IllegalArgumentException("Maaf, umur Anda belum mencukupi untuk menjadi member VIP!");
        }
        else {
            this.umur = umur;
        }
    }

    public void pesanKopi(int jumlahpesanan) {
        if (jumlahpesanan > stokKopi) {
            throw new KopiHabisExpection("Stok kopi habis!");
        }
        else {
            stokKopi -= jumlahpesanan;
        }
    }
}
