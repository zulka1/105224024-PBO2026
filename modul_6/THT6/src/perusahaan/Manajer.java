package perusahaan;

public class Manajer extends Karyawan {     // Subclass Manajer mewarisi superclass Karyawan
    private String divisi;              //atribut private
    private int jumlahAnggotaTim;

    public Manajer(String idKaryawan, String nama, int tahunMasuk, double gajiPokok, double ratingKinerja, String divisi, int jumlahAnggotaTim) {      
        super(idKaryawan, nama, tahunMasuk, gajiPokok, ratingKinerja);      // Delegasikan inisialisasi atribut Karyawan ke superclass   
        this.divisi           = divisi;
        this.jumlahAnggotaTim = jumlahAnggotaTim;
    }

    
    public String getDivisi(){      // Getter & Setter
        return divisi; 
    }        
    public int    getJumlahAnggotaTim()   { return jumlahAnggotaTim; }
    public void   setDivisi(String divisi)                  { this.divisi = divisi; }
    public void   setJumlahAnggotaTim(int jumlahAnggotaTim) { this.jumlahAnggotaTim = jumlahAnggotaTim; }

    @Override
    public double hitungGajiTotal() {
        double totalGaji = super.hitungGajiTotal();
        totalGaji += jumlahAnggotaTim * 300_000;    // tambahan gaji per anggota tim

        if (getRatingKinerja() > 4.5) {
            totalGaji += totalGaji * 0.15; // tambahan 15% dari gaji sementara
        }

        return totalGaji;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Posisi        : Manajer Divisi " + divisi);     // Tambahkan info spesifik Manajer
        System.out.println("Jumlah Tim    : " + jumlahAnggotaTim + " anggota");
    }
}
