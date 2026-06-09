import java.util.ArrayList;
import java.util.List;

public class Reservasi {
    private List<Kereta> daftarKereta;

    public Reservasi() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public List<Kereta> getDaftarKereta() {
        return daftarKereta;
    }

    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket)
            throws RuteTidakDitemukanException, TiketHabisException {

        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                    "NIK harus 16 karakter. NIK yang dimasukkan: " + nik.length() + " karakter.");
        }
        for (char c : nik.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new DataPenumpangTidakValidException(
                        "NIK tidak boleh mengandung huruf atau karakter selain angka.");
            }
        }

        Kereta kereta = null;
        for (Kereta k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kodeKereta)) {
                kereta = k;
                break;
            }
        }

        if (kereta == null) {
            throw new RuteTidakDitemukanException(
                    "Kode kereta '" + kodeKereta + "' tidak ditemukan dalam sistem.");
        }

        if (jumlahTiket > kereta.getSisaKursi()) {
            throw new TiketHabisException(
                    "Tiket tidak mencukupi untuk pemesanan ini.",
                    kereta.getNama(),
                    kereta.getSisaKursi());
        }

        kereta.kurangiKursi(jumlahTiket);
        System.out.println("\n========================================");
        System.out.println("   PEMESANAN BERHASIL!");
        System.out.println("========================================");
        System.out.println("  Kereta       : " + kereta.getNama());
        System.out.println("  Rute         : " + kereta.getRute());
        System.out.println("  Penumpang    : " + namaPenumpang);
        System.out.println("  NIK          : " + nik);
        System.out.println("  Jumlah Tiket : " + jumlahTiket);
        System.out.println("  Sisa Kursi   : " + kereta.getSisaKursi());
        System.out.println("========================================\n");
    }
}
