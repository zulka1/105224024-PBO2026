//Kelas RekeningReguler
public class RekeningReguler extends Rekening {

    // Biaya admin tetap yang dikenakan setiap kali penarikan
    private double biayaAdmin = 7500.0;        // Biaya admin tetap

    // Constructor RekeningReguler.
    public RekeningReguler(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);      // Memanggil constructor parent
        System.out.println("Rekening reguler berhasil dibuat.");
    }

    // Override tarik()
    @Override
    public void tarik(double jumlah) {
        if (jumlah <= 0) {                  // Saldo tidak boleh kurang dari 0 setelah penarikan
            System.out.println("Jumlah penarikan harus lebih dari 0.");
            return;
        }

        double totalPenarikan = jumlah + biayaAdmin;

        // Validasi apakah saldo mencukupi untuk nominal + biaya admin
        if (totalPenarikan > getSaldo()) {
            System.out.println("Saldo tidak mencukupi.");
            return;
        }

        // Kurangi saldo via metode protected di parent 
        kurangiSaldo(totalPenarikan);
        System.out.println("Penarikan berhasil.");
        System.out.println("Nominal tarik   : Rp" + jumlah);
        System.out.println("Biaya admin     : Rp" + biayaAdmin);
        System.out.println("Total dipotong  : Rp" + totalPenarikan);
        System.out.println("Sisa saldo      : Rp" + getSaldo());

        // Catat ke buku mutasi milik parent
        getBukuMutasi().catatAktivitas("Tarik", totalPenarikan, getSaldo());
    }
}
