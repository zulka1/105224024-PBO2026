public class Kereta {
    private String kode;
    private String nama;
    private String rute;
    private int sisaKursi;

    public Kereta(String kode, String nama, String rute, int kapasitas) {
        this.kode = kode;
        this.nama = nama;
        this.rute = rute;
        this.sisaKursi = kapasitas;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public String getRute() { return rute; }
    public int getSisaKursi() { return sisaKursi; }

    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }

    @Override
    public String toString() {
        return String.format(kode + " | " + nama + " | " + rute + " | " + sisaKursi);
    }
}
