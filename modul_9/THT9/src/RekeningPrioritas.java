// Kelas RekeningPrioritas
public class RekeningPrioritas extends Rekening {

    // Constructor RekeningPrioritas
    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);      // Memanggil constructor parent
        System.out.println("Rekening prioritas berhasil dibuat.");
    }

    /*
    Override tarik()

    Aturan RekeningPrioritas:
    - Tidak ada biaya admin
    - Minimum penarikan Rp500.000 per transaksi
    - Saldo setelah penarikan TIDAK BOLEH di bawah Rp5.000.000
     */
    @Override
    public void tarik(double jumlah) {
        if (jumlah <= 0) {          // Validasi apakah jumlah penarikan lebih dari 0
            System.out.println("Jumlah penarikan harus lebih dari 0.");
            return;
        }

       
        if (jumlah < 500000) {      // Validasi apakah jumlah saldo memenuhi minimum penarikan
            System.out.println("Penarikan minimum untuk rekening prioritas adalah Rp500.000");
            return;
        }

        // Saldo setelah penarikan tidak boleh di bawah saldo minimum
        double saldoSetelahTarik = getSaldo() - jumlah;
        if (saldoSetelahTarik < 5000000) {
            System.out.println("Saldo setelah penarikan akan menjadi Rp" + saldoSetelahTarik);
            System.out.println("Saldo minimum rekening prioritas: Rp5.000.000");
            return;
        }

        kurangiSaldo(jumlah);   // Penarikan
        System.out.println("  Penarikan berhasil. (Bebas biaya admin)");
        System.out.println("  Nominal tarik   : Rp" + jumlah);
        System.out.println("  Sisa saldo      : Rp" + getSaldo());

        // Catat ke buku mutasi
        getBukuMutasi().catatAktivitas("Tarik", jumlah, getSaldo());
    }
}
