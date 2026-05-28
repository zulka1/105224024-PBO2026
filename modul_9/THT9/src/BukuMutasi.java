/*
Kelas BukuMutasi
Bertugas mencatat log setiap aktivitas transaksi pada sebuah rekening.
*/
public class BukuMutasi {
    private String nomorRekening;       // Nomor rekening pemilik, untuk identifikasi di setiap log

    public BukuMutasi(String nomorRekening) {       // Constructor BukuMutasi.
        this.nomorRekening = nomorRekening;
        System.out.println("Buku mutasi untuk rekening " + nomorRekening + " telah diinisialisasi.");
    }

    public void catatAktivitas(String jenis, double nominal, double saldoAkhir) {       //Mencatat aktivitas ke log mutasi.
        System.out.println(" Mutasi: " + nomorRekening + " | Jenis: " + jenis + " | Nominal: Rp" + nominal + " | Saldo Akhir: Rp" + saldoAkhir);
        // Output berupa nomor rekening, jenis transaksi, nominal, dan saldo akhir
    }

    // Mencatat aktivitas tanpa nominal
    public void catatAktivitas(String keterangan) {
        System.out.println("MUTASI - " + nomorRekening + " | " + keterangan);
    }
}
