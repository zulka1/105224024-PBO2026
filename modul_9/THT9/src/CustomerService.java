/**
 * Kelas CustomerService
 * 
 * Entitas yang menangani keluhan dan pertanyaan nasabah.
 * 
 * Konsep OOP: ASOSIASI UMUM (General Association)
 * 
 * CustomerService TIDAK memiliki Nasabah, dan Nasabah TIDAK memiliki CustomerService.
 * Keduanya berdiri sendiri sebagai entitas independen.
 * Interaksi terjadi hanya saat ada kebutuhan (melapor keluhan) — hubungan sementara,
 * bukan kepemilikan. Ini berbeda dengan komposisi/agregasi.
 * 
 * Analogi: Kamu pergi ke bank → ketemu CS → selesai → bubar. Tidak ada "kepemilikan".
 */
public class CustomerService {

    private String namaCS;
    private String idCS;

    /**
     * Constructor CustomerService.
     * 
     * @param idCS   ID unik CS
     * @param namaCS nama lengkap CS
     */
    public CustomerService(String idCS, String namaCS) {
        this.idCS = idCS;
        this.namaCS = namaCS;
    }

    public String getNamaCS() {
        return namaCS;
    }

    public String getIdCS() {
        return idCS;
    }

    /**
     * Menerima dan memproses laporan keluhan dari nasabah.
     * 
     * ASOSIASI: Nasabah diterima sebagai PARAMETER, bukan disimpan sebagai field.
     * Ini membuktikan bahwa CS tidak "memiliki" nasabah — hanya berinteraksi sesaat.
     * Setelah metode selesai, tidak ada referensi tersisa di CS ke objek Nasabah.
     * 
     * @param namaNasabah nama nasabah yang melapor
     * @param keluhan     isi keluhan
     */
    public void terimaKeluhan(String namaNasabah, String keluhan) {
        System.out.println("\n  ======================================");
        System.out.println("  [CUSTOMER SERVICE - " + idCS + "] " + namaCS);
        System.out.println("  ======================================");
        System.out.println("  Nasabah      : " + namaNasabah);
        System.out.println("  Keluhan      : " + keluhan);
        System.out.println("  Status       : Diterima. Akan diproses dalam 1x24 jam.");
        System.out.println("  Nomor Tiket  : TKT-" + System.currentTimeMillis() % 100000);
        System.out.println("  ======================================\n");
    }
}
