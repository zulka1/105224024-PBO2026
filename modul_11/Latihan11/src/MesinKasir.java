public class MesinKasir {
    int uangDiberikan;
    int totalBiaya;

    public MesinKasir(int uangDiberikan, int totalBiaya) {
        this.uangDiberikan = uangDiberikan;
        this.totalBiaya = totalBiaya;
    }

    public void bayar(int totalBiaya, int uangDiberikan) throws UangKurangExpection {
        if (totalBiaya > uangDiberikan) {
            throw new UangKurangExpection("Uang diberikan tidak cukup!");
        } 
        else {
            int kembalian = uangDiberikan - totalBiaya;
            System.out.println("Kembalian: " + kembalian);
        }
    }

    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (!statusPrinter) {
            throw new Exception("Printer error: Kertas struk habis!");
        }

        System.out.println("Struk berhasil dicetak.");
    }
}
