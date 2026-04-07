package rental;

public class kendaraan {
    String nomorPolisi;
    String merk;
    int tahunProduksi;
    double hargaSewaDasar;

    public kendaraan(String nomorPolisi, String merk, int tahunProduksi, double hargaSewaDasar) {
        this.nomorPolisi = nomorPolisi;
        this.merk = merk;
        this.tahunProduksi = tahunProduksi;
        this.hargaSewaDasar = hargaSewaDasar;
    }

    public void displayInfo() {
        System.out.println("Nomor Polisi: " + nomorPolisi);
        System.out.println("Merk: " + merk);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga Sewa Dasar: " + hargaSewaDasar);
    }
    public void hitunghargaSewa(int hari) {
        double hargaSewa;
        if(tahunProduksi < 2015) {
            hargaSewaDasar = hargaSewaDasar * 0.10;
        }
        hargaSewa = hargaSewaDasar * hari;
        System.out.println("Harga Sewa: " + hargaSewa);
    }

}
