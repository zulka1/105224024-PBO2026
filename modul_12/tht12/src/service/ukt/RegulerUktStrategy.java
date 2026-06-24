package service.ukt;

import model.Mahasiswa;

public class RegulerUktStrategy implements UktCalculationStrategy {
    private static final double BASE_UKT = 5000000.0;

    @Override
    public double calculateUkt(Mahasiswa mahasiswa) {
        // Logika penghitungan UKT reguler
        return BASE_UKT;
    }
}
