public class CetakTiket implements Printable {

    @Override
    public void cetakKonfirmasi(Transportasi transportasi, String nama, String nik, int jumlahTiket) {
        System.out.println("\n========================================");
        System.out.println("   PEMESANAN BERHASIL!");
        System.out.println("========================================");
        System.out.println("  Tipe         : " + transportasi.getTipe());
        System.out.println("  Kereta       : " + transportasi.getNama());
        System.out.println("  Rute         : " + transportasi.getRute());
        System.out.println("  Penumpang    : " + nama);
        System.out.println("  NIK          : " + nik);
        System.out.println("  Jumlah Tiket : " + jumlahTiket);
        System.out.println("  Sisa Kursi   : " + transportasi.getSisaKursi());
        System.out.println("========================================\n");
    }
}
