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

        
        this.bukuMutasi = new BukuMutasi(nomorRekening);        // BukuMutasi langsung dibuat di sini, bukan dikirim dari luar
        this.bukuMutasi.catatAktivitas("Rekening dibuka dengan saldo awal Rp" + saldoAwal);
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

    @Override
    public boolean verifikasiPIN(String pinInput) {         //implementasi verifikasiPIN dari interface
        return this.pin.equals(pinInput);       //true jika cocok
    }

    public void setor(double jumlah) {          // Metode setor 
        if (jumlah <= 0) {          // Validasi apakah jumlah setoran lebih dari 0
            System.out.println("Jumlah setoran harus lebih dari 0.");
            return;
        }
        saldo += jumlah;
        System.out.println("  Setoran berhasil. Saldo bertambah Rp" + jumlah);
        bukuMutasi.catatAktivitas("Setor", jumlah, saldo);      // Catat ke buku mutasi (komposisi — akses internal)
    }

    /*
    Metode abstract tarik() 
    metode abstarct digunakan karena setiap jenis rekening punya aturan penarikan berbeda.
     */
    public abstract void tarik(double jumlah);

    protected void kurangiSaldo(double jumlah) {    // Metode untuk melakukan pengurangan saldo aktual
        saldo -= jumlah;
    }

    // Menampilkan info rekening secara ringkas.
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik   : " + namaPemilik);
        System.out.println("Jenis Rekening : " + getClass().getSimpleName());
        System.out.println("Saldo          : Rp" + saldo);
    }
}
