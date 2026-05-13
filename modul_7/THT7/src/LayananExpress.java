public class LayananExpress extends LayananEkspedisi{       // Subclass layanan express, mewarisi LayananEkspedisi
    public LayananExpress(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {        // Konstruktor memanggil konstruktor superclass
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Override tarif dasar Rp 30.000 per kg dari berat efektif
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 30000;
    }

    public void klaimAsuransi(double nilaiBarang) {     // Metode spesifik: klaim asuransi berdasarkan nilai barang
        if (nilaiBarang > 1000000) {                    // Asuransi VIP jika nilai barang lebih dari Rp1.000.000
            System.out.println("Klaim Asuransi VIP Rp " + nilaiBarang + " untuk resi " + this.nomorResi + " sedang diproses prioritas.");
        }
        else {                                          // Asuransi standar jika nilai barang tidak lebih dari Rp1.000.000
            System.out.println("Klaim Asuransi Standar diproses dalam 7 hari kerja.");
        }
    }
    
}
