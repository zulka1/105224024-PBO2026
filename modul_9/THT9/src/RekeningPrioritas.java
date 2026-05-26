/**
 * Kelas RekeningPrioritas
 * 
 * Subclass konkret dari Rekening untuk nasabah prioritas (premium).
 * 
 * Konsep OOP:
 * 1. PEWARISAN    — extends Rekening
 * 2. POLIMORFISME — override metode tarik() dengan perilaku spesifik:
 *                   BEBAS biaya admin, NAMUN ada batas minimum saldo yang ketat
 *                   dan penarikan minimum Rp500.000
 */
public class RekeningPrioritas extends Rekening {

    // Batas minimum saldo yang harus tersisa setelah penarikan (lebih ketat)
    private static final double SALDO_MINIMUM = 5_000_000.0;

    // Minimum nominal penarikan per transaksi
    private static final double TARIK_MINIMUM = 500_000.0;

    /**
     * Constructor RekeningPrioritas.
     * Memanggil constructor parent (Rekening) via super().
     * 
     * @param nomorRekening nomor rekening
     * @param namaPemilik   nama pemilik
     * @param saldoAwal     saldo awal (minimal harus di atas SALDO_MINIMUM)
     * @param pin           PIN keamanan
     */
    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
        System.out.println("  [RekeningPrioritas] Rekening prioritas berhasil dibuat.");
        System.out.println("  Info: Bebas biaya admin. Saldo minimum Rp" + String.format("%,.0f", SALDO_MINIMUM));
    }

    /**
     * Override tarik() — POLIMORFISME.
     * 
     * Aturan RekeningPrioritas:
     * - Tidak ada biaya admin (gratis)
     * - Minimum penarikan Rp500.000 per transaksi
     * - Saldo setelah penarikan TIDAK BOLEH di bawah Rp5.000.000
     * 
     * @param jumlah jumlah yang ingin ditarik
     */
    @Override
    public void tarik(double jumlah) {
        // Validasi: jumlah harus positif
        if (jumlah <= 0) {
            System.out.println("  [ERROR] Jumlah penarikan harus lebih dari 0.");
            return;
        }

        // Validasi: jumlah harus memenuhi minimum penarikan
        if (jumlah < TARIK_MINIMUM) {
            System.out.println("  [GAGAL] Penarikan minimum untuk rekening prioritas adalah Rp"
                    + String.format("%,.0f", TARIK_MINIMUM));
            return;
        }

        // Validasi: saldo setelah penarikan tidak boleh di bawah saldo minimum
        double saldoSetelahTarik = getSaldo() - jumlah;
        if (saldoSetelahTarik < SALDO_MINIMUM) {
            System.out.println("  [GAGAL] Saldo setelah penarikan akan menjadi Rp"
                    + String.format("%,.0f", saldoSetelahTarik));
            System.out.println("  Saldo minimum rekening prioritas: Rp" + String.format("%,.0f", SALDO_MINIMUM));
            System.out.println("  Maksimal yang bisa ditarik saat ini: Rp"
                    + String.format("%,.0f", getSaldo() - SALDO_MINIMUM));
            return;
        }

        // Lakukan penarikan (tanpa biaya admin — gratis untuk prioritas)
        kurangiSaldo(jumlah);

        System.out.println("  Penarikan berhasil. (Bebas biaya admin)");
        System.out.println("  Nominal tarik   : Rp" + String.format("%,.0f", jumlah));
        System.out.println("  Sisa saldo      : Rp" + String.format("%,.0f", getSaldo()));

        // Catat ke buku mutasi
        getBukuMutasi().catatAktivitas("TARIK (Bebas Admin)", jumlah, getSaldo());
    }
}
