import java.util.Scanner;

public class LogiCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM LOGICALC FASTSEND ===");     //input
        System.out.print("Masukkan Nama Klien : ");
        String namaKlien = scanner.nextLine();

        System.out.print("Masukkan Berat (Kg) : ");
        double beratKg = scanner.nextDouble();

        System.out.print("Masukkan Jarak (Km) : ");
        int jarakKm = scanner.nextInt();

        System.out.print("Masukkan Jumlah Box : ");
        int jumlahBox = scanner.nextInt();

        scanner.close();

        int kapasitasTruk = 150;
        int trukPenuh     = jumlahBox / kapasitasTruk;   //menejemen armada
        int sisaBox       = jumlahBox % kapasitasTruk;   

        double tarifJarak  = 15000.0;           //kalkulasi biaya
        double tarifBerat  = 5500.0;
        double dasarBiaya  = (tarifJarak * jarakKm) + (tarifBerat * beratKg);
        double asuransi    = dasarBiaya * 0.035;          
        double totalBayar  = dasarBiaya + asuransi;

        int kecepatanKmJam = 60;                        //estimasi waktu tiba
        int jam            = jarakKm / kecepatanKmJam;
        int menit          = jarakKm % kecepatanKmJam;

        System.out.println("\n=== RESI PENGIRIMAN ===");    //output
        System.out.println("Klien          : " + namaKlien);
        System.out.println("Total Box      : " + jumlahBox + " box");
        System.out.println("Kebutuhan Armada: [" + trukPenuh + "] Truk Penuh dan sisa [" + sisaBox + "] box via Pikap.");
        System.out.println("Estimasi Waktu : [" + jam + "] Jam [" + menit + "] Menit (Asumsi 60km/jam)");

        System.out.println("=== RINCIAN BIAYA ===");
        System.out.println("Dasar Biaya    : Rp [" + dasarBiaya + "]");
        System.out.println("Asuransi (3.5%): Rp [" + asuransi + "]");
        System.out.println("-----------------------------------");
        System.out.println("TOTAL BAYAR    : Rp [" + totalBayar + "]");
        System.out.println("===================================");
    }
}