import perusahaan.Karyawan;     //import package
import perusahaan.Developer;
import perusahaan.Manajer;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        
        ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();     // ArrayList bertipe superclass, tapi bisa menampung objek subclass

        Karyawan k1 = new Karyawan("K001", "Budi Santoso", 2020, 5_000_000, 2.0);                       //Input objek
        Developer dev1 = new Developer("D001", "Rina Wijaya", 2018, 8_000_000, 4.0, "Senior", 20);
        Developer dev2 = new Developer("D002", "Andi Prasetyo", 2024, 6_000_000, 2.8, "Mid", 15);
        Manajer mgr1 = new Manajer("M001", "Dewi Lestari", 2015,12_000_000, 4.8, "IT", 10);
        Manajer mgr2 = new Manajer("M002", "Hendra Gunawan", 2025,9_000_000, 3.5, "HR", 3);

        daftarKaryawan.add(k1);     // Masukkan semua objek ke dalam ArrayList
        daftarKaryawan.add(dev1);
        daftarKaryawan.add(dev2);
        daftarKaryawan.add(mgr1);
        daftarKaryawan.add(mgr2);
        
        double totalAnggaranGaji  = 0;      // Variabel akumulasi untuk perhitungan akhir
        double gajiBersihTertinggi = 0;
        String namaHighestEarner  = "";
        double totalRating        = 0;

        for (Karyawan karyawan : daftarKaryawan) {      // Iterasi seluruh objek karyawan
            karyawan.displayInfo();     //Menampilkan semua info karyawan
            double gajiTotal = karyawan.hitungGajiTotal();      // Hitung total gaji
            System.out.printf("Total Gaji Bulan Ini: Rp %.2f%n", gajiTotal);

            totalAnggaranGaji += gajiTotal;     // Akumulasi total anggaran gaji perusahaan
            totalRating += karyawan.getRatingKinerja();     // Akumulasi rating untuk rata-rata

            if (gajiTotal > gajiBersihTertinggi) {      // Cek apakah ini karyawan dengan gaji tertinggi sejauh ini
                gajiBersihTertinggi = gajiTotal;
                namaHighestEarner   = karyawan.getNama();
            }
        }

        
        int jumlahKaryawan = daftarKaryawan.size();         // Menghitung rata-rata rating
        double rataRataRating = totalRating / jumlahKaryawan;

        System.out.printf ("\nTotal Anggaran Gaji    : Rp %.2f%n", totalAnggaranGaji);
        System.out.println("Highest Earner         : " + namaHighestEarner);
        System.out.printf ("Gaji Bersih Tertinggi  : Rp %.2f%n", gajiBersihTertinggi);
        System.out.printf ("Rata-rata Rating Kinerja: %.2f%n", rataRataRating);
    }
}
