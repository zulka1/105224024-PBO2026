import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class SistemGudang {
    Map<String, Barang> database = new HashMap<>();
    Set<String> kategoriUnik = new HashSet<>();
    List<String> riwayat = new ArrayList<>();

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        Barang b = new Barang(id, nama, kategori, stok);
        database.put(id, b);
        kategoriUnik.add(kategori);
        riwayat.add("Barang Baru: " + id + " - " + nama + " (stok awal: " + stok + ")");
    }

    public void tambahStok(String id, int jumlah) {
        if (database.containsKey(id)) {
            database.get(id).stok += jumlah;
            riwayat.add("Barang Masuk: " + id + " ditambah " + jumlah + " unit");
        } 
        else {
            riwayat.add("Gagal tambah stok: ID " + id + " tidak ditemukan");
        }
    }

    public void kurangiStok(String id, int jumlah) {
        if (!database.containsKey(id)) {
            riwayat.add("Gagal kurangi stok: ID " + id + " tidak ditemukan");
            return;
        }
        Barang b = database.get(id);
        if (b.stok >= jumlah) {
            b.stok -= jumlah;
            riwayat.add("Barang Keluar: " + id + " dikurangi " + jumlah + " unit");
        } 
        else {
            riwayat.add("Gagal kurangi stok: " + id + " stok tidak cukup");
        }
    }

    public void cetakLaporan() {
        System.out.println("\n== Kategori ==");
        for (String k : kategoriUnik) {
            System.out.println(k);
        }

        System.out.println("\n== Stok Barang ==");
        for (Barang b : database.values()) {
            System.out.println(b.idBarang + " | " + b.namaBarang + " | stok: " + b.stok);
        }

        System.out.println("\n== Riwayat ==");
        for (String r : riwayat) {
            System.out.println(r);
        }
    }
}