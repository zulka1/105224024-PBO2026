class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;
 
    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }
 
    @Override
    public void prosesPembayaran() {
        double biayaAdmin = nominal * 0.02;
        double total = nominal + biayaAdmin;
        System.out.println("Biaya Admin : Rp" + biayaAdmin);
        System.out.println("Total Tagihan : Rp" + total);
    }
 
    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN Kartu Kredit berhasil.");
        return true;
    }
}