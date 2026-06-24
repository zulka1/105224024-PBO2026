package service.sks;

import java.util.List;
import model.MataKuliah;

public interface SksCalculationStrategy {
    int calculateTotalSks(List<MataKuliah> daftarMataKuliah);
}
