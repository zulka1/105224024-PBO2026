package service.ukt;

import model.Mahasiswa;

public class KaryawanUktStrategy implements UktCalculationStrategy {
    private static final double BASE_UKT = 7500000.0;

    @Override
    public double calculateUkt(Mahasiswa mahasiswa) {
        // Logika penghitungan UKT jalur karyawan (lebih tinggi karena kelas malam/akhir pekan)
        return BASE_UKT;
    }
}
