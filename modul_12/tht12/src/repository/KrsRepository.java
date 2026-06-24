package repository;

import model.Krs;

public interface KrsRepository {
    void save(Krs krs);
    Krs findByNim(String nim);
}
