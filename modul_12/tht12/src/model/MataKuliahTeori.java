package model;

public class MataKuliahTeori extends MataKuliah {
    public MataKuliahTeori(String kode, String nama, int sks) {
        super(kode, nama, sks);
    }

    public MataKuliahTeori(String kode, String nama, int sks, String prereqKode) {
        super(kode, nama, sks, prereqKode);
    }
}
