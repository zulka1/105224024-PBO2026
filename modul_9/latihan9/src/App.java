public class App {
    public static void main(String[] args) throws Exception {
        Dokter dokter1 = new Dokter("Budi", "Penyakit Dalam");
        Dokter dokter2 = new Dokter("Siti", "Bedah");
        Dokter dokter3 = new Dokter("Joko", "Jantung");
        Dokter dokter4 = new Dokter("Tirta", "Saraf");
        Dokter dokter5 = new Dokter("Gia", "Ortopedi");
        Pasien pasien1 = new Pasien("Andi", 30);
        Pasien pasien2 = new Pasien("Rina", 22);
 
        dokter1.periksa(pasien1);
 
        RumahSakit rs = new RumahSakit("RS Sehat Selalu");
        rs.tambahDokter(dokter1, 0);
        rs.tambahDokter(dokter2, 1);
        rs.tambahDokter(dokter3, 2);
        rs.tambahDokter(dokter4, 3);
        rs.tambahDokter(dokter5, 4);
        rs.cetakDaftarRuangan();
        rs.cetakDaftarDokter();

        rs = null;

        System.out.println("==== cek setelah rumah sakit null ====");
        System.out.println(dokter1.getNama());
        System.out.println(dokter2.getNama());
 
        System.out.println(pasien1.getNama());
        System.out.println(pasien2.getNama());
    }
}