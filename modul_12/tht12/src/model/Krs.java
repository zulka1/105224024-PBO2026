package model;

import java.util.ArrayList;
import java.util.List;
import service.sks.SksCalculationStrategy;

public class Krs {
    private Mahasiswa mahasiswa;
    private List<MataKuliah> daftarMataKuliah;

    public Krs(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        this.daftarMataKuliah = new ArrayList<>();
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public List<MataKuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    public void tambahMataKuliah(MataKuliah mk) {
        this.daftarMataKuliah.add(mk);
    }

    // Menggunakan Strategy Pattern untuk menghitung total SKS
    public int hitungTotalSks(SksCalculationStrategy strategy) {
        return strategy.calculateTotalSks(this.daftarMataKuliah);
    }
}
