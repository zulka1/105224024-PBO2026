package service.sks;

import java.util.List;
import model.MataKuliah;
import model.MataKuliahLapangan;

public class MbkmSksCalculator implements SksCalculationStrategy {
    @Override
    public int calculateTotalSks(List<MataKuliah> daftarMataKuliah) {
        int total = 0;
        for (MataKuliah mk : daftarMataKuliah) {
            if (mk instanceof MataKuliahLapangan) {
                // Berdasarkan regulasi MBKM, kuliah lapangan/magang dikonversi setara 20 SKS
                total += 20;
            } else {
                total += mk.getSks();
            }
        }
        return total;
    }
}
