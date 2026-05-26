import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Film> jadwalFilm = new HashMap<>();
        jadwalFilm.put("F01", new Film("Your Name", 45000));
        jadwalFilm.put("F02", new Film("cosmic princess kaguya", 55000));
        jadwalFilm.put("F03", new Film("merah putih", 40000));

        System.out.println("=== Jadwal Film ===");
        for (Map.Entry<String, Film> e : jadwalFilm.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }

        Set<String> kursiTerpesan = new HashSet<>();
        List<Transaksi> riwayat = new ArrayList<>();
        System.out.println("=== Proses Pemesanan ===");
        pesan("Zulka",   "F01", "A1", jadwalFilm, kursiTerpesan, riwayat);
        pesan("Rafi",    "F01", "B3", jadwalFilm, kursiTerpesan, riwayat);
        pesan("Nadia",   "F02", "A1", jadwalFilm, kursiTerpesan, riwayat); 
        pesan("Kevin",   "F01", "A1", jadwalFilm, kursiTerpesan, riwayat); 
        pesan("Dita",    "F01", "C5", jadwalFilm, kursiTerpesan, riwayat); 
        pesan("Unknown", "F99", "D1", jadwalFilm, kursiTerpesan, riwayat); 

        System.out.println("=== Riwayat Transaksi ===");
        if (riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Transaksi t : riwayat) {
                System.out.println(t);
            }
        }
        System.out.println("Total transaksi sukses: " + riwayat.size());
    }

    static void pesan(String nama, String kodeFilm,String kursi, Map<String, Film> jadwal, Set<String> kursiTerpesan, List<Transaksi> riwayat) {
        System.out.printf("memesan kursi untuk film ", nama, kursi, kodeFilm);

        if (!jadwal.containsKey(kodeFilm)) {
            System.out.println("Kode film tidak ditemukan");
            return;
        }

        if (!kursiTerpesan.add(kursi)) {
            System.out.println("Kursi " + kursi + " sudah dipesan");
            return;
        }

        Film film = jadwal.get(kodeFilm);
        riwayat.add(new Transaksi(nama, film, kursi));
        System.out.println("Berhasil");
    }
}
