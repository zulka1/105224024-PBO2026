package model;

public class MataKuliahPraktikum extends MataKuliah implements AsistenLabAllocatable, PeralatanCheckable {
    private String namaLab;
    private int jumlahAsisten;
    private boolean peralatanSiap;

    public MataKuliahPraktikum(String kode, String nama, int sks, String namaLab) {
        super(kode, nama, sks);
        this.namaLab = namaLab;
        this.jumlahAsisten = 0;
        this.peralatanSiap = false;
    }

    public MataKuliahPraktikum(String kode, String nama, int sks, String prereqKode, String namaLab) {
        super(kode, nama, sks, prereqKode);
        this.namaLab = namaLab;
        this.jumlahAsisten = 0;
        this.peralatanSiap = false;
    }

    @Override
    public void alokasiAsistenLab() {
        this.jumlahAsisten = 2; // Simulating allocation of 2 assistants
        System.out.println("Berhasil mengalokasikan " + jumlahAsisten + " asisten lab untuk " + getNama() + " di " + namaLab);
    }

    @Override
    public void cekPeralatanPraktikum() {
        this.peralatanSiap = true; // Simulating successful equipment check
        System.out.println("Peralatan praktikum di " + namaLab + " untuk " + getNama() + " diperiksa: SIAP");
    }

    public String getNamaLab() {
        return namaLab;
    }

    public int getJumlahAsisten() {
        return jumlahAsisten;
    }

    public boolean isPeralatanSiap() {
        return peralatanSiap;
    }
}
