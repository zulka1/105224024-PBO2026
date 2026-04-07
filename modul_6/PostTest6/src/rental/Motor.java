package rental;

public class Motor extends kendaraan {
    int kapasitasMesin;
    public Motor(String nomorPolisi, String merk, int tahunProduksi, double hargaSewaDasar, int kapasitasMesin) {
        super(nomorPolisi, merk, tahunProduksi, hargaSewaDasar);
        this.kapasitasMesin = kapasitasMesin;
    }

    @Override
    public void hitunghargaSewa(int hari) {
        double hargaSewa;
        if(tahunProduksi < 2015) {
            hargaSewaDasar = hargaSewaDasar * 0.10;
        }
        hargaSewa = hargaSewaDasar * hari;

        if(kapasitasMesin >= 250) {
            hargaSewa = hargaSewa + (250000 * hari);
        }
        System.out.println("Harga Sewa: " + hargaSewa);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nomor Polisi: " + nomorPolisi);
        System.out.println("Merk: " + merk);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga Sewa Dasar: " + hargaSewaDasar);
        System.out.println("Kapasitas Mesin: " + kapasitasMesin);
    }

}
