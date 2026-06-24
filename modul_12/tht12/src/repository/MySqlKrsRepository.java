package repository;

import java.util.HashMap;
import java.util.Map;
import model.Krs;

public class MySqlKrsRepository implements KrsRepository {
    private Map<String, Krs> dbMock = new HashMap<>();

    @Override
    public void save(Krs krs) {
        dbMock.put(krs.getMahasiswa().getNim(), krs);
        System.out.println("Data KRS mahasiswa " + krs.getMahasiswa().getNama() + " (" + krs.getMahasiswa().getNim() + ") berhasil disimpan ke database MySQL.");
    }

    @Override
    public Krs findByNim(String nim) {
        return dbMock.get(nim);
    }
}
