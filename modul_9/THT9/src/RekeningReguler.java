/**
 * Kelas RekeningReguler
 * 
 * Subclass konkret dari Rekening untuk nasabah regular.
 * 
 * Konsep OOP:
 * 1. PEWARISAN    — extends Rekening, mewarisi semua field dan metode parent
 * 2. POLIMORFISME — override metode tarik() dengan perilaku spesifik: 
 *                   setiap penarikan dikenakan BIAYA ADMIN tetap
 */
public class RekeningReguler extends Rekening {

    // Biaya admin tetap yang dikenakan setiap kali penarikan
    private static final double BIAYA_ADMIN = 7500.0;

    /**
     * Constructor RekeningReguler.
     * Memanggil constructor parent (Rekening) via super().
     * BukuMutasi otomatis dibuat di constructor parent (komposisi).
     * 
     * @param nomorRekening nomor rekening
     * @param namaPemilik   nama pemilik
     * @param saldoAwal     saldo awal pembukaan
     * @param pin           PIN keamanan
     */
    public RekeningReguler(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
        System.out.println("  [RekeningReguler] Rekening reguler berhasil dibuat.");
    }

    /**
     * Override tarik() — POLIMORFISME.
     * 
     * Aturan RekeningReguler:
     * - Setiap penarikan dikenakan biaya admin Rp7.500 (flat)
     * - Total yang dikurangi dari saldo = jumlah tarik + biaya admin
     * - Saldo tidak boleh kurang dari 0 setelah penarikan
     * 
     * @param jumlah jumlah yang ingin ditarik (belum termasuk biaya admin)
     */
    @Override
    public void tarik(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("  [ERROR] Jumlah penarikan harus lebih dari 0.");
            return;
        }

        double totalPenarikan = jumlah + BIAYA_ADMIN;

        // Validasi: saldo mencukupi untuk nominal + biaya admin?
        if (totalPenarikan > getSaldo()) {
            System.out.println("  [GAGAL] Saldo tidak mencukupi.");
            System.out.println("  Dibutuhkan: Rp" + String.format("%,.0f", totalPenarikan)
                    + " (Rp" + String.format("%,.0f", jumlah) + " + biaya admin Rp" + String.format("%,.0f", BIAYA_ADMIN) + ")");
            System.out.println("  Saldo saat ini: Rp" + String.format("%,.0f", getSaldo()));
            return;
        }

        // Kurangi saldo via metode protected di parent (enkapsulasi terjaga)
        kurangiSaldo(totalPenarikan);

        System.out.println("  Penarikan berhasil.");
        System.out.println("  Nominal tarik   : Rp" + String.format("%,.0f", jumlah));
        System.out.println("  Biaya admin     : Rp" + String.format("%,.0f", BIAYA_ADMIN));
        System.out.println("  Total dipotong  : Rp" + String.format("%,.0f", totalPenarikan));
        System.out.println("  Sisa saldo      : Rp" + String.format("%,.0f", getSaldo()));

        // Catat ke buku mutasi milik parent (akses via getter protected)
        getBukuMutasi().catatAktivitas("TARIK (+ Biaya Admin)", totalPenarikan, getSaldo());
    }
}
