
public class App {

    public static void main(String[] args) {

        System.out.println("\n>>> [1] MEMBUAT OBJEK KAMAR <<<");
        System.out.println("-- Constructor Kilat (nomor, tipe, kapasitas saja) --");

        KamarHotel kamarKilat1 = new KamarHotel("K-101", "Reguler", 3);
        System.out.println("    Kamar K-101 (kilat) dibuat. Harga default: 0, Tersedia: true");

        KamarHotel kamarKilat2 = new KamarHotel("K-102", "Premium", 4);
        System.out.println("    Kamar K-102 (kilat) dibuat. Harga default: 0, Tersedia: true");

        System.out.println("\n-- Constructor Lengkap (nomor, tipe, kapasitas, harga) --");

        KamarHotel kamar1 = new KamarHotel("L-201", "Suite", 4, 500_000);
        System.out.println("    Kamar L-201 (lengkap) dibuat.");

        KamarHotel kamar2 = new KamarHotel("L-202", "Premium", 2, 350_000);
        System.out.println("    Kamar L-202 (lengkap, kapasitas 2) dibuat.");

        System.out.println("\n>>> [2] UJI SETTER TAHAN BANTING (Kamar L-201) <<<");

        System.out.println("\n-- Mencoba setTipeKamar(\"Presidential\") --");
        kamar1.setTipeKamar("Presidential");

        System.out.println("\n-- Mencoba setHargaPerMalam(-10000) --");
        kamar1.setHargaPerMalam(-10_000);

        System.out.println("\n>>> [3] UJI PEMESANAN KAMAR (Kamar L-202, kapasitas maks. 2) <<<");

        System.out.println("\n-- Percobaan pesanKamar(4): overcapacity, harus diblokir --");
        kamar2.pesanKamar(4);

        System.out.println("\n-- Percobaan pesanKamar(2): jumlah pas, harus berhasil --");
        kamar2.pesanKamar(2);

        System.out.println("\n-- Percobaan pesanKamar() tanpa parameter pada kamar yg sama --");
        kamar2.pesanKamar();

        System.out.println("\n>>> [4] UJI PERHITUNGAN TAGIHAN <<<");
        System.out.println("\n-- Kamar L-201, 2 malam, voucher \"PROMO\" (harus GAGAL, < 3 malam) --");
        double tagihan1 = kamar1.hitungTotalBayar(2, "PROMO");
        System.out.printf("   Tagihan: Rp %.0f%n", tagihan1);

        System.out.println("\n-- Kamar L-202, 4 malam, voucher \"PROMO\" (harus BERHASIL diskon 20%) --");
        double tagihan2 = kamar2.hitungTotalBayar(4, "PROMO");
        System.out.printf("   Tagihan setelah diskon: Rp %.0f%n", tagihan2);

        System.out.println("\n>>> [5] STRUK INFORMASI KONDISI AKHIR <<<");

        System.out.println("\n========== STRUK KAMAR 1 (L-201) ==========");
        kamar1.displayInfo();

        System.out.println("\n========== STRUK KAMAR 2 (L-202) ==========");
        kamar2.displayInfo();

        System.out.println("\n[DEMO SELESAI] Semua skenario pengujian telah dijalankan.");
    }
}
