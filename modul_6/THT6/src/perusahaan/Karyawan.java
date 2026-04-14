package perusahaan;

public class Karyawan {     // Class Karyawan
    private String idKaryawan;      //Atribut private
    private String nama;
    private int tahunMasuk;
    private double gajiPokok;
    private double ratingKinerja; // Skala 1.0 - 5.0

    public Karyawan(String idKaryawan, String nama, int tahunMasuk, double gajiPokok, double ratingKinerja) { // Contructor
        this.idKaryawan  = idKaryawan;
        this.nama        = nama;
        this.tahunMasuk  = tahunMasuk;
        this.gajiPokok   = gajiPokok;

        
        if (ratingKinerja < 1.0 || ratingKinerja > 5.0) {       // Validasi rating: harus berada di antara 1.0 dan 5.0
            System.out.println("[PERINGATAN] Rating tidak valid untuk " + nama + ". Disetel ke default 3.0");
            this.ratingKinerja = 3.0;
        } else {
            this.ratingKinerja = ratingKinerja;
        }
    }

    public String getIdKaryawan(){      //Getter
        return idKaryawan; 
    }     
    public String getNama(){
        return nama; 
    }
    public int    getTahunMasuk(){ 
        return tahunMasuk; 
    }
    public double getGajiPokok(){ 
        return gajiPokok; 
    }
    public double getRatingKinerja(){ 
        return ratingKinerja; 
    }

    public void setIdKaryawan(String idKaryawan){           // Setter dengan validari rating
        this.idKaryawan = idKaryawan; 
    }        
    public void setNama(String nama){ 
        this.nama = nama; 
    }
    public void setTahunMasuk(int tahunMasuk){ 
        this.tahunMasuk = tahunMasuk; 
    }
    public void setGajiPokok(double gajiPokok){ 
        this.gajiPokok = gajiPokok; 
    }

    public void setRatingKinerja(double ratingKinerja) {
        if (ratingKinerja < 1.0 || ratingKinerja > 5.0) {       // Setter juga memvalidasi agar rating tidak bisa diubah ke nilai tidak valid
            System.out.println("[PERINGATAN] Rating tidak valid. Tidak diubah.");
        } else {
            this.ratingKinerja = ratingKinerja;
        }
    }

    public double hitungGajiTotal() {
        int tahunSekarang = 2026;
        int masaKerja = tahunSekarang - tahunMasuk;

        double bonusLoyalitas = gajiPokok * 0.05 * masaKerja;       // Bonus loyalitas: 5% dari gaji pokok × masa kerja
        double totalGaji = gajiPokok + bonusLoyalitas;

       
        if (ratingKinerja < 2.5) {          // Penalti kinerja: jika rating di bawah 2.5, dipotong 10%
            totalGaji = totalGaji * 0.90;       // dikurangi 10%
        }

        return totalGaji;
    }


    public void displayInfo() {
        System.out.println("========================================");
        System.out.println("ID Karyawan   : " + idKaryawan);
        System.out.println("Nama          : " + nama);
        System.out.println("Tahun Masuk   : " + tahunMasuk);
        System.out.println("Rating Kinerja: " + ratingKinerja);
        System.out.printf ("Gaji Pokok    : Rp %.2f%n", gajiPokok);
    }
}
