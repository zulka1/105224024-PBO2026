public class LayananInternasional extends LayananEkspedisi{     // Subclass layanan internasional, mewarisi LayananEkspedisi
    // menambahkan atribut b=negaraTujuan dan nilaiBarangUSD untuk LayananInternasional
    String negaraTujuan;
    double nilaiBarangUSD;

    public LayananInternasional(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi, String negaraTujuan, double nilaiBarangUSD) {      // Konstruktor memanggil konstruktor superclass
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
        this.negaraTujuan = negaraTujuan;
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    // Override tarif Rp200.000/kg + pajak 20% jika nilaiBarangUSD > 50 USD
    @Override
    public double hitungOngkir() {
        if (nilaiBarangUSD > 50){
            double ongkir = (hitungBeratEfektif() * 200000);
            return ongkir + (ongkir * 0.2);         // tambah pajak bea cukai 20%
        }
        else {
            return hitungBeratEfektif() * 200000;
        }
    }

    public void cekManifest() {         // Metode spesifik: mencetak manifest internasional
        System.out.println("Manifest Internasional ke " + this.negaraTujuan + " - Deklarasi Nilai: " + this.nilaiBarangUSD);
    }

}
