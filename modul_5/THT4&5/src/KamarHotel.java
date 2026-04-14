
public class KamarHotel {
    private String  nomorKamar;
    private String  tipeKamar;
    private int     kapasitasMaksimal;
    private double  hargaPerMalam;
    private boolean isTersedia;

    public KamarHotel(String nomorKamar, String tipeKamar, int kapasitasMaksimal) {
        this.nomorKamar        = nomorKamar;
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.hargaPerMalam     = 0;       
        this.isTersedia        = true;    
        setTipeKamar(tipeKamar);
    }

    public KamarHotel(String nomorKamar, String tipeKamar, int kapasitasMaksimal,
                      double hargaPerMalam) {
        this.nomorKamar        = nomorKamar;
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.isTersedia        = true; 
        setTipeKamar(tipeKamar);
        setHargaPerMalam(hargaPerMalam);
    }


    public String  getNomorKamar()       { return nomorKamar; }
    public String  getTipeKamar()        { return tipeKamar; }
    public int     getKapasitasMaksimal(){ return kapasitasMaksimal; }
    public double  getHargaPerMalam()    { return hargaPerMalam; }
    public boolean isIsTersedia()        { return isTersedia; }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        if (tipeKamar.equalsIgnoreCase("Reguler") ||
            tipeKamar.equalsIgnoreCase("Premium") ||
            tipeKamar.equalsIgnoreCase("Suite")) {
            this.tipeKamar = tipeKamar.substring(0, 1).toUpperCase() +
                             tipeKamar.substring(1).toLowerCase();
        } else {
            System.out.println("[PERINGATAN] Tipe kamar '" + tipeKamar +
                               "' tidak dikenali. Hanya tersedia: Reguler, Premium, Suite.");
            System.out.println("[SISTEM] Tipe kamar dipaksa menjadi: Reguler");
            this.tipeKamar = "Reguler";
        }
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        if (hargaPerMalam < 50_000) {
            System.out.println("[PERINGATAN] Harga Rp " + hargaPerMalam +
                               " tidak valid (minimum Rp 50.000).");
            System.out.println("[SISTEM] Harga dipaksa menjadi: Rp 50.000");
            this.hargaPerMalam = 50_000;
        } else {
            this.hargaPerMalam = hargaPerMalam;
        }
    }

    public void setKapasitasMaksimal(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public void pesanKamar() {
        if (isTersedia) {
            isTersedia = false;
            System.out.println("[SUKSES] Kamar " + nomorKamar + " berhasil dipesan.");
        } else {
            System.out.println("[PERINGATAN] Kamar " + nomorKamar +
                               " sudah dipesan dan tidak tersedia.");
        }
    }

    public void pesanKamar(int jumlahTamu) {
        // Cek ketersediaan terlebih dahulu
        if (!isTersedia) {
            System.out.println("[PERINGATAN] Kamar " + nomorKamar +
                               " sudah dipesan dan tidak tersedia.");
            return;
        }
        // Cek kapasitas
        if (jumlahTamu > kapasitasMaksimal) {
            System.out.println("[DITOLAK] Pemesanan kamar " + nomorKamar + " GAGAL.");
            System.out.println("  Jumlah tamu (" + jumlahTamu + " orang) melebihi " +
                               "kapasitas maksimal kamar (" + kapasitasMaksimal + " orang).");
            System.out.println("  Status kamar tetap TERSEDIA. Silakan pilih kamar lain.");
            // Status kamar TIDAK diubah, tetap true
        } else {
            isTersedia = false;
            System.out.println("[SUKSES] Kamar " + nomorKamar + " berhasil dipesan untuk " +
                               jumlahTamu + " tamu.");
        }
    }

    public void batalPesan() {
        if (!isTersedia) {
            isTersedia = true;
            System.out.println("[INFO] Pemesanan kamar " + nomorKamar +
                               " dibatalkan. Kamar kembali tersedia.");
        } else {
            System.out.println("[INFO] Kamar " + nomorKamar +
                               " memang sudah berstatus tersedia. Tidak ada yang dibatalkan.");
        }
    }
    public double hitungTotalBayar(int jumlahMalam) {
        return hargaPerMalam * jumlahMalam;
    }


    public double hitungTotalBayar(int jumlahMalam, String kodeVoucher) {
        double totalNormal = hargaPerMalam * jumlahMalam;

        boolean kodeValid   = kodeVoucher.equalsIgnoreCase("PROMO");
        boolean minMalamOK  = jumlahMalam >= 3;

        if (kodeValid && minMalamOK) {
            double diskon   = totalNormal * 0.20;
            double totalDiskon = totalNormal - diskon;
            System.out.println("[VOUCHER] Kode PROMO valid! Diskon 20% diterapkan.");
            System.out.printf ("[VOUCHER] Hemat: Rp %.0f%n", diskon);
            return totalDiskon;
        } 
        else {
            if (!kodeValid) {
                System.out.println("[VOUCHER] Kode voucher '" + kodeVoucher +
                                   "' tidak dikenali. Voucher ditolak.");
            } 
            else {
                System.out.println("[VOUCHER] Kode PROMO valid, namun minimum menginap " +
                                   "3 malam tidak terpenuhi (" + jumlahMalam + " malam).");
                System.out.println("[VOUCHER] Voucher ditolak. Dikenakan tarif normal.");
            }
            return totalNormal;
        }
    }

    public void displayInfo() {

        System.out.println(" Nomor Kamar      : " + nomorKamar);
        System.out.println(" Tipe Kamar       : " + tipeKamar);
        System.out.println(" Kapasitas Maks.  : " + kapasitasMaksimal + " orang");
        System.out.printf (" Harga Per Malam  : Rp %.0f%n", hargaPerMalam);
        System.out.println(" Status           : " + (isTersedia ? "TERSEDIA ✓" : "SUDAH DIPESAN ✗"));
        System.out.println("==========================================");
    }
}