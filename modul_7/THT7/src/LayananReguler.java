public class LayananReguler extends LayananEkspedisi {      // Subclass layanan reguler, mewarisi LayananEkspedisi
    public LayananReguler(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi){     // Konstruktor memanggil konstruktor superclass
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Override tarif dasar Rp 15.000 per kg dari berat efektif
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 15000;
    }


    // Overloading dengan parameter member dan jarak
    public double hitungOngkir(boolean isMember, int jarakKm) {
        if (isMember) {
            return (hitungOngkir() * 0.9) + (jarakKm * 500);        // diskon 10% + surcharge jarak
        } else {
            return hitungOngkir() + (jarakKm * 500);        // tanpa diskon + surcharge jarak
        }
    }
}
