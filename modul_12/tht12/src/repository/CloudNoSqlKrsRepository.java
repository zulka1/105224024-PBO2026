package repository;

import java.util.HashMap;
import java.util.Map;
import model.Krs;

public class CloudNoSqlKrsRepository implements KrsRepository {
    private Map<String, Krs> documentStore = new HashMap<>();

    @Override
    public void save(Krs krs) {
        documentStore.put(krs.getMahasiswa().getNim(), krs);
        System.out.println("Data KRS mahasiswa " + krs.getMahasiswa().getNama() + " (" + krs.getMahasiswa().getNim() + ") berhasil disimpan ke database Cloud NoSQL.");
    }

    @Override
    public Krs findByNim(String nim) {
        return documentStore.get(nim);
    }
}
