package service.ukt;

import model.Mahasiswa;

public class InternasionalUktStrategy implements UktCalculationStrategy {
    private static final double BASE_UKT = 15000000.0;

    @Override
    public double calculateUkt(Mahasiswa mahasiswa) {
        // Logika penghitungan UKT internasional (termasuk biaya fasilitas global)
        return BASE_UKT;
    }
}
