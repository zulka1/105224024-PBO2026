class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    double nilaiBarang; // package-private agar bisa diakses saat casting di Main
 
    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh,
                           String nomorPenerbangan, double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.nomorPenerbangan = nomorPenerbangan;
        this.nilaiBarang = nilaiBarang;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
    }
 
    @Override
    public double hitungOngkosKirim() {
        return (beratBarang * 25000) + (jarakTempuh * 5000);
    }
 
    @Override
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03;
    }
 
    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }
 
    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}