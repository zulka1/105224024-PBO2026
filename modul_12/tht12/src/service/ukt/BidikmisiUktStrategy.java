package service.ukt;

import model.Mahasiswa;

public class BidikmisiUktStrategy implements UktCalculationStrategy {
    private static final double BIDIKMISI_ADMIN_FEE = 0.0; // Penuh beasiswa

    @Override
    public double calculateUkt(Mahasiswa mahasiswa) {
        // Jalur Bidikmisi disubsidi penuh oleh pemerintah
        return BIDIKMISI_ADMIN_FEE;
    }
}
