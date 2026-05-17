public class App {
    public static void main(String[] args) throws Exception {
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);
 
        darat.updateStatus("Sedang di jalan tol Cipali");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");
 
        LayananPengiriman[] pengiriman = { darat, udara };
 
        for (LayananPengiriman lp : pengiriman) {
            System.out.println("==================================================");
            lp.cetakResi();
 
            if (lp instanceof LacakKargo) {
                System.out.println("Lokasi Terakhir : " + ((LacakKargo) lp).cekLokasiTerakhir());
            }
 
            double ongkosKirim = lp.hitungOngkosKirim();
            double totalTagihan = ongkosKirim;
 
            if (lp instanceof Asuransi) {
                Asuransi a = (Asuransi) lp;
                a.cetakPolis();
                double premi = a.hitungPremi(((PengirimanUdara) lp).nilaiBarang);
                System.out.println("Premi Asuransi  : Rp" + premi);
                totalTagihan += premi;
            }
 
            System.out.println("Ongkos Kirim    : Rp" + ongkosKirim);
            System.out.println("Total Tagihan   : Rp" + totalTagihan);
        }
        System.out.println("==================================================");
    }
}
