package model;

import java.util.ArrayList;
import java.util.List;

public class Mahasiswa {
    private String nim;
    private String nama;
    private JalurMasuk jalurMasuk;
    private List<String> riwayatMataKuliah; // List kode mata kuliah yang sudah lulus

    public Mahasiswa(String nim, String nama, JalurMasuk jalurMasuk) {
        this.nim = nim;
        this.nama = nama;
        this.jalurMasuk = jalurMasuk;
        this.riwayatMataKuliah = new ArrayList<>();
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public JalurMasuk getJalurMasuk() {
        return jalurMasuk;
    }

    public List<String> getRiwayatMataKuliah() {
        return riwayatMataKuliah;
    }

    public void tambahRiwayat(String kodeMataKuliah) {
        this.riwayatMataKuliah.add(kodeMataKuliah);
    }

    public boolean sudahLulus(String kodeMataKuliah) {
        return riwayatMataKuliah.contains(kodeMataKuliah);
    }
}

