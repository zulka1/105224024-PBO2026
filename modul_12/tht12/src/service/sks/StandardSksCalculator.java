package service.sks;

import java.util.List;
import model.MataKuliah;

public class StandardSksCalculator implements SksCalculationStrategy {
    @Override
    public int calculateTotalSks(List<MataKuliah> daftarMataKuliah) {
        int total = 0;
        for (MataKuliah mk : daftarMataKuliah) {
            total += mk.getSks();
        }
        return total;
    }
}
