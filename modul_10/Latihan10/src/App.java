import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Buku> map = new HashMap<>();
        map.put("1111", new Buku("1111", "Otonari No Tenshi"));
        map.put("2312", new Buku("2312", "Sword Art Online"));
        map.put("4353", new Buku("4353", "Fly Me To The Moon"));
        map.put("2357", new Buku("2357", "Your Name"));
        System.out.println(map.get("1111").getJudul());
        System.out.println(map.get("2312").getJudul());
        System.out.println(map.get("4353").getJudul());

        System.out.println("=================================================");

        Set<Anggota> set = new HashSet<>();
        set.add(new Anggota("1234", "Doni", "Mahasiswa"));
        set.add(new Anggota("2345", "Shiina", "Dosen"));
        set.add(new Anggota("3456", "dila", "Mahasiswa"));
        set.add(new Anggota("4567", "Asep", "Dosen"));
        set.add(new Anggota("2345", "Sindi", "Mahasiswa"));
        System.out.println(set);

        System.out.println("=================================================");

        LinkedList<String> antrean = new LinkedList<>();
        String is[] = {"1111", "2312", "4353", "2357"};
        int i = 0;
        for (Anggota a : set) {
            String data = a.getIdAnggota() + " # " + map.get(is[i]).getJudul();
            if (a.tipe.equals("Dosen")) {
                antrean.addFirst(data);
            } else {
                antrean.addLast(data);
            }
            i++;
        }
        System.out.println(antrean);

        System.out.println("=================================================");

        Map<String, String> bukuDipinjam = new HashMap<>();

        while (!antrean.isEmpty()) {
            String data = antrean.removeFirst();
            String[] bagian = data.split("#");
            String idAnggota = bagian[0].trim();
            String isbn = bagian[1].trim();

            System.out.println("Memproses: idAnggota=" + idAnggota + " | isbn= " + isbn);

            Anggota anggotaDitemukan = null;
            for (Anggota a : set) {
                if (a.idAnggota.equals(idAnggota)) {
                    anggotaDitemukan = a;
                    break;
                }
            }
            if (anggotaDitemukan == null) {
                System.out.println("idAnggota tidak terdaftar");
                continue;
            }

            if (!map.containsKey(isbn)) {
                System.out.println("isbn tidak ada di katalog");
                continue;
            }

            if (bukuDipinjam.containsKey(isbn)) {
                System.out.println(" Buku sedang dipinjam oleh " + bukuDipinjam.get(isbn));
                continue;
            }

            bukuDipinjam.put(isbn, idAnggota);
            System.out.println("  BERHASIL " + map.get(isbn).getJudul() + " dipinjam oleh " + anggotaDitemukan.nama);
        }

        System.out.println("Buku Sedang Dipinjam:");
        for (Map.Entry<String, String> entry : bukuDipinjam.entrySet()) {
            System.out.println("  " + entry.getKey() + " | " + map.get(entry.getKey()).getJudul() + " | " + entry.getValue());
        }

    }
}
