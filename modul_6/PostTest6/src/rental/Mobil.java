package rental;

public class Mobil extends kendaraan {
    int kapasitasPenumpang;
    public Mobil(String nomorPolisi, String merk, int tahunProduksi, double hargaSewaDasar, int kapasitasPenumpang) {
        super(nomorPolisi, merk, tahunProduksi, hargaSewaDasar);
        this.kapasitasPenumpang = kapasitasPenumpang;
    }
    
    @Override
    public void hitunghargaSewa(int hari) {
        double hargaSewa;
        if(tahunProduksi < 2015) {
            hargaSewaDasar = hargaSewaDasar * 0.10;
        }
        hargaSewa = (hargaSewaDasar * hari) + (50000 * hari);

        if(kapasitasPenumpang > 5) {
            hargaSewa = hargaSewa + 50000;
        }
        System.out.println("Harga Sewa: " + hargaSewa);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nomor Polisi: " + nomorPolisi);
        System.out.println("Merk: " + merk);
        System.out.println("Tahun Produksi: " + tahunProduksi);
        System.out.println("Harga Sewa Dasar: " + hargaSewaDasar);
        System.out.println("Kapasitas Penumpang: " + kapasitasPenumpang);
    }   
    
}
