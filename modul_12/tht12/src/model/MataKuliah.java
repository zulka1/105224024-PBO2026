package model;

public abstract class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private String prereqKode; // Kode mata kuliah prasyarat (null jika tidak ada)

    public MataKuliah(String kode, String nama, int sks) {
        this(kode, nama, sks, null);
    }

    public MataKuliah(String kode, String nama, int sks, String prereqKode) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.prereqKode = prereqKode;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public String getPrereqKode() {
        return prereqKode;
    }

    public boolean hasPrereq() {
        return prereqKode != null && !prereqKode.isEmpty();
    }

    @Override
    public String toString() {
        return nama + " (" + kode + ", " + sks + " SKS)";
    }
}
