/**
Kelas Nasabah

Nasabah dapat memiliki hingga 3 Rekening. Rekening-rekening ini adalah entitas
MANDIRI yang bisa ada di luar nasabah (misalnya, tercatat di database pusat).
Jika profil nasabah di-set null / dihapus dari memori, rekening-rekeningnya
TIDAK ikut hancur selama ada referensi lain yang menunjuk ke objek Rekening tersebut.
 */
public class Nasabah {
    private String idNasabah;
    private String namaLengkap;
    private String nomorTelepon;
    private Rekening[] daftarRekening;      // Array untuk menampung Rekening, maks 3 rekening per nasabah
    private int jumlahRekening; // penghitung rekening aktif

    // Constructor Nasabah.
    public Nasabah(String idNasabah, String namaLengkap, String nomorTelepon) {
        this.idNasabah = idNasabah;
        this.namaLengkap = namaLengkap;
        this.nomorTelepon = nomorTelepon;

        this.daftarRekening = new Rekening[3];      // Array 3 slot untuk rekening
        this.jumlahRekening = 0;

        System.out.println("Profil nasabah '" + namaLengkap + "' berhasil dibuat.");
    }

    // Getter
    public String getIdNasabah() {
        return idNasabah;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public int getJumlahRekening() {
        return jumlahRekening;
    }

    public Rekening getRekening(int index) {
        if (index < 0 || index >= jumlahRekening) {          // Jika index tidak valid (index yang valid adalah 0-2)
            return null;
        }
        return daftarRekening[index];
    }

    // Menambahkan rekening yang sudah ada ke profil nasabah.
    public boolean tambahRekening(Rekening rekening) {
        if (jumlahRekening >= 3) {              // Jika sudah memiliki 3 rekening
            System.out.println("Nasabah sudah memiliki 3 rekening (batas maksimal).");
            return false;
        }
        daftarRekening[jumlahRekening] = rekening;
        jumlahRekening++;
        System.out.println("  Rekening " + rekening.getNomorRekening() + " berhasil ditambahkan ke profil nasabah.");
        return true;
    }

    public Rekening cariRekening(String nomorRekening) {        // Mencari rekening berdasarkan nomor rekening.
        for (int i = 0; i < jumlahRekening; i++) {
            if (daftarRekening[i].getNomorRekening().equals(nomorRekening)) {
                return daftarRekening[i];
            }
        }
        return null;
    }

    public void tampilkanSemuaRekening() {      // Menampilkan semua rekening milik nasabah ini.
        if (jumlahRekening == 0) {
            System.out.println("  Nasabah belum memiliki rekening.");
            return;
        }
        for (int i = 0; i < jumlahRekening; i++) {
            System.out.println("\n  --- Rekening " + (i + 1) + " ---");
            daftarRekening[i].tampilkanInfo();
        }
    }

    public void laporKeluhan(CustomerService cs, String keluhan) {      // untuk melapor keluhan ke customer service.
        cs.terimaKeluhan(this.namaLengkap, keluhan);        // CS menerima nama nasabah sebagai parameter, bukan menyimpan objek Nasabah
    }

    public void tampilkanProfil() {     // Menampilkan info profil nasabah.
        System.out.println("  ID Nasabah     : " + idNasabah);
        System.out.println("  Nama           : " + namaLengkap);
        System.out.println("  No. Telepon    : " + nomorTelepon);
        System.out.println("  Jumlah Rekening: " + jumlahRekening);
    }
}
