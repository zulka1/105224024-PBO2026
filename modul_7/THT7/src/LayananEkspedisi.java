public class LayananEkspedisi {         // Superclass layanan ekspedisi
    //atribut LayananEkspedisi
    protected String nomorResi;
    protected double beratAktualKg;
    protected double panjang;
    protected double lebar;
    protected double tinggi;

    public LayananEkspedisi(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {      // Konstruktor untuk menginisialisasi semua atribut
        this.nomorResi = nomorResi;
        this.beratAktualKg = beratAktualKg;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public double hitungBeratEfektif() {        // Metode untuk menghitung berat efektif
        return (panjang * lebar * tinggi) / 6000;   
    }

    public void cetakResi() {                   // Metode untuk mencetak resi
        System.out.println("Nomor Resi: " + this.nomorResi);
        System.out.println("Berat Efektif: " + this.hitungBeratEfektif());
    }

    public double hitungOngkir() {              // Metode untuk menghitung ongkir
        return 0.0;                             // Metode polymorphic, akan di-override oleh subclass
    }
}
