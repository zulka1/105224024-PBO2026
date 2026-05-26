/**
 * Kelas Nasabah
 * 
 * Merepresentasikan profil nasabah di NeoBank.
 * 
 * Konsep OOP: AGREGASI
 * 
 * Nasabah dapat memiliki hingga 3 Rekening. Rekening-rekening ini adalah entitas
 * MANDIRI yang bisa ada di luar nasabah (misalnya, tercatat di database pusat).
 * Jika profil nasabah di-set null / dihapus dari memori, rekening-rekeningnya
 * TIDAK ikut hancur selama ada referensi lain yang menunjuk ke objek Rekening tersebut.
 * 
 * Ini berbeda dengan KOMPOSISI di mana objek bagian ikut hancur bersama pemiliknya.
 * 
 * Analogi agregasi: Seorang nasabah tutup akun → rekeningnya masih "ada" di arsip bank.
 * 
 * Konsep OOP: ASOSIASI dengan CustomerService
 * Nasabah bisa berinteraksi dengan CustomerService tanpa saling memiliki.
 */
public class Nasabah {

    private String idNasabah;
    private String namaLengkap;
    private String nomorTelepon;

    /**
     * AGREGASI: Array untuk menampung Rekening.
     * 
     * Rekening di sini adalah referensi ke objek Rekening yang SUDAH ADA / dibuat di luar.
     * Nasabah hanya "memegang" referensi, bukan menciptakan Rekening secara internal.
     * Maksimal 3 rekening per nasabah.
     */
    private Rekening[] daftarRekening;
    private int jumlahRekening; // penghitung rekening aktif

    /**
     * Constructor Nasabah.
     * Menginisialisasi profil nasabah dan array rekening kosong.
     * 
     * @param idNasabah      ID unik nasabah
     * @param namaLengkap    nama lengkap nasabah
     * @param nomorTelepon   nomor telepon nasabah
     */
    public Nasabah(String idNasabah, String namaLengkap, String nomorTelepon) {
        this.idNasabah = idNasabah;
        this.namaLengkap = namaLengkap;
        this.nomorTelepon = nomorTelepon;

        // Array 3 slot untuk rekening (AGREGASI — array siap menampung referensi eksternal)
        this.daftarRekening = new Rekening[3];
        this.jumlahRekening = 0;

        System.out.println("  [Nasabah] Profil nasabah '" + namaLengkap + "' berhasil dibuat.");
    }

    // ===== Getter =====

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

    /**
     * Mendapatkan rekening berdasarkan index (0-2).
     * 
     * @param index posisi rekening
     * @return objek Rekening atau null jika tidak ada
     */
    public Rekening getRekening(int index) {
        if (index < 0 || index >= jumlahRekening) return null;
        return daftarRekening[index];
    }

    /**
     * AGREGASI: Menambahkan rekening yang sudah ada ke profil nasabah.
     * 
     * Rekening dibuat dari LUAR (di Main) lalu "didaftarkan" ke nasabah.
     * Nasabah hanya menyimpan referensinya, bukan membuatnya.
     * Ini adalah ciri khas AGREGASI (loose-coupling / kepemilikan longgar).
     * 
     * @param rekening objek Rekening yang akan ditambahkan
     * @return true jika berhasil, false jika sudah penuh
     */
    public boolean tambahRekening(Rekening rekening) {
        if (jumlahRekening >= 3) {
            System.out.println("  [ERROR] Nasabah sudah memiliki 3 rekening (batas maksimal).");
            return false;
        }
        if (rekening == null) {
            System.out.println("  [ERROR] Rekening tidak valid.");
            return false;
        }
        daftarRekening[jumlahRekening] = rekening;
        jumlahRekening++;
        System.out.println("  Rekening " + rekening.getNomorRekening() + " berhasil ditambahkan ke profil nasabah.");
        return true;
    }

    /**
     * Mencari rekening berdasarkan nomor rekening.
     * 
     * @param nomorRekening nomor rekening yang dicari
     * @return objek Rekening jika ditemukan, null jika tidak
     */
    public Rekening cariRekening(String nomorRekening) {
        for (int i = 0; i < jumlahRekening; i++) {
            if (daftarRekening[i].getNomorRekening().equals(nomorRekening)) {
                return daftarRekening[i];
            }
        }
        return null;
    }

    /**
     * Menampilkan semua rekening milik nasabah ini.
     */
    public void tampilkanSemuaRekening() {
        if (jumlahRekening == 0) {
            System.out.println("  Nasabah belum memiliki rekening.");
            return;
        }
        for (int i = 0; i < jumlahRekening; i++) {
            System.out.println("\n  --- Rekening " + (i + 1) + " ---");
            daftarRekening[i].tampilkanInfo();
        }
    }

    /**
     * ASOSIASI: Nasabah menghubungi CustomerService untuk melapor keluhan.
     * 
     * Metode ini menerima objek CS dari luar (bukan disimpan sebagai field).
     * Hubungan ini hanya terjadi sesaat, tidak ada "kepemilikan" antara Nasabah dan CS.
     * Ini adalah bentuk ASOSIASI UMUM — keduanya bisa berdiri sendiri.
     * 
     * @param cs      objek CustomerService yang dituju
     * @param keluhan isi keluhan yang ingin disampaikan
     */
    public void laporKeluhan(CustomerService cs, String keluhan) {
        System.out.println("  Menghubungi Customer Service...");
        // CS menerima nama nasabah sebagai parameter, bukan menyimpan objek Nasabah
        cs.terimaKeluhan(this.namaLengkap, keluhan);
    }

    /**
     * Menampilkan info profil nasabah.
     */
    public void tampilkanProfil() {
        System.out.println("  ID Nasabah     : " + idNasabah);
        System.out.println("  Nama           : " + namaLengkap);
        System.out.println("  No. Telepon    : " + nomorTelepon);
        System.out.println("  Jumlah Rekening: " + jumlahRekening);
    }
}
