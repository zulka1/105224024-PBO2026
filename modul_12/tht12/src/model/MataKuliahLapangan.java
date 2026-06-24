package model;

public class MataKuliahLapangan extends MataKuliah {
    private String lokasi;

    public MataKuliahLapangan(String kode, String nama, int sks, String lokasi) {
        super(kode, nama, sks);
        this.lokasi = lokasi;
    }

    public MataKuliahLapangan(String kode, String nama, int sks, String prereqKode, String lokasi) {
        super(kode, nama, sks, prereqKode);
        this.lokasi = lokasi;
    }

    public String getLokasi() {
        return lokasi;
    }
}
