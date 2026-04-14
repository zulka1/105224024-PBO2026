package perusahaan;

public class Developer extends Karyawan {  // Subclass dari Karyawan
    private String level;        // "Junior", "Mid", atau "Senior"
    private int jumlahBugFix;

    public Developer(String idKaryawan, String nama, int tahunMasuk, double gajiPokok, double ratingKinerja, String level, int jumlahBugFix) {      // Constructor  
        super(idKaryawan, nama, tahunMasuk, gajiPokok, ratingKinerja);      // Delegasikan inisialisasi atribut Karyawan ke superclass
        this.level        = level;
        this.jumlahBugFix = jumlahBugFix;
    }

    public String getLevel(){ 
        return level; 
    }
    public int    getJumlahBugFix(){ 
        return jumlahBugFix; 
    }
    public void   setLevel(String level){ 
        this.level = level; 
    }
    public void   setJumlahBugFix(int jumlahBugFix){ 
        this.jumlahBugFix = jumlahBugFix; 
    }

    @Override
    public double hitungGajiTotal() {
        double totalGaji = super.hitungGajiTotal();

        switch (level.toLowerCase()) {      //Tunjangan level
            case "senior":
                totalGaji += 3_000_000;
                break;
            case "mid":
                totalGaji += 1_500_000;
                break;
            case "junior":
            default:
                totalGaji += 0; // Tidak ada tunjangan level untuk Junior
                break;
        }
        
        if (getRatingKinerja() >= 3.0) {        // Bonus hanya diberikan jika rating kinerja >= 3.0
            totalGaji += jumlahBugFix * 50_000;
        }
       
        return totalGaji;   
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Posisi        : Developer (" + level + ")");    // Tambahkan info spesifik Developer
        System.out.println("Jumlah Bug Fix: " + jumlahBugFix);
    }
}
