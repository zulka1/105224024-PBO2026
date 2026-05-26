/*
Abstract Class Rekening
Kelas abstrak yang menjadi fondasi (parent) dari semua jenis rekening.
Mengimplementasikan interface Otorisasi, artinya semua subclass WAJIB
mengimplementasikan verifikasiPIN().
 */
public abstract class Rekening implements Otorisasi {

    // Enkapsulasi semua atribut rekening
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;         // TIDAK BISA diakses langsung dari luar
    private String pin;     

    // Composition: BukuMutasi dibuat otomatis di dalam constructor.
    private BukuMutasi bukuMutasi;  // private, tidak bisa diakses dari luar

    /*
    Constructor Rekening.
    Menginisialisasi data rekening dan secara otomatis membuat BukuMutasi.
     */
    public Rekening(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;

        // BukuMutasi langsung dibuat di sini, bukan dikirim dari luar.
        this.bukuMutasi = new BukuMutasi(nomorRekening);
        this.bukuMutasi.catatAktivitas("Rekening dibuka dengan saldo awal Rp" + String.format("%,.0f", saldoAwal));
    }

    // Getter & setter
    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    protected BukuMutasi getBukuMutasi() {      // Protected agar hanya subclass yang bisa mengaksesnya
        return bukuMutasi;
    }

    // ===== OTORISASI: implementasi verifikasiPIN dari interface =====

    /**
     * Implementasi verifikasiPIN() dari interface Otorisasi.
     * Membandingkan PIN input dengan PIN tersimpan (secara aman).
     * 
     * @param pinInput PIN yang dimasukkan pengguna
     * @return true jika cocok
     */
    @Override
    public boolean verifikasiPIN(String pinInput) {
        return this.pin.equals(pinInput);
    }

    // ===== ENKAPSULASI: Metode untuk memodifikasi saldo (satu-satunya pintu masuk) =====

    /**
     * Menambah saldo rekening (setor dana).
     * Ini satu-satunya cara menambah saldo — menjamin integritas data.
     * 
     * @param jumlah jumlah uang yang disetor (harus positif)
     */
    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("  [ERROR] Jumlah setoran harus lebih dari 0.");
            return;
        }
        saldo += jumlah;
        System.out.println("  Setoran berhasil. Saldo bertambah Rp" + String.format("%,.0f", jumlah));
        // Catat ke buku mutasi (komposisi — akses internal)
        bukuMutasi.catatAktivitas("SETOR", jumlah, saldo);
    }

    /**
     * Metode tarik() — ABSTRACT karena setiap jenis rekening punya aturan penarikan berbeda.
     * 
     * Konsep OOP: ABSTRAKSI + POLIMORFISME
     * RekeningReguler akan override ini dengan potongan biaya admin.
     * RekeningPrioritas akan override ini dengan cek batas minimum ketat.
     * 
     * @param jumlah jumlah uang yang ingin ditarik
     */
    public abstract void tarik(double jumlah);

    /**
     * Helper protected: melakukan pengurangan saldo aktual.
     * Hanya bisa diakses subclass, bukan dari luar.
     * Dipanggil setelah validasi masing-masing subclass.
     * 
     * @param jumlah total jumlah yang dikurangkan dari saldo (sudah termasuk biaya jika ada)
     */
    protected void kurangiSaldo(double jumlah) {
        saldo -= jumlah;
    }

    /**
     * Menampilkan info rekening secara ringkas.
     */
    public void tampilkanInfo() {
        System.out.println("  Nomor Rekening : " + nomorRekening);
        System.out.println("  Nama Pemilik   : " + namaPemilik);
        System.out.println("  Jenis Rekening : " + getClass().getSimpleName());
        System.out.println("  Saldo          : Rp" + String.format("%,.0f", saldo));
    }
}
