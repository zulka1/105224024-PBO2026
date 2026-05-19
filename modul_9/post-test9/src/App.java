public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Produksi Ban ---");
        Ban ban1 = new Ban(1, "Bridgestone", 17);
        Ban ban2 = new Ban(2, "Michelin", 17);
        Ban ban3 = new Ban(3, "Dunlop", 17);
        Ban ban4 = new Ban(4, "Bridgestone", 17);

        System.out.println("=== Perakitan Mobil ===");
        Mobil mobil = new Mobil("MOB-001", "Merah", "V6 DOHC", 2500);

        System.out.println("=== Pemasangan Ban ===");
        Ban[] setBan = {ban1, ban2, ban3, ban4};
        mobil.pasangSetBan(setBan);
        System.out.println("4 ban berhasil dipasang.");

        Montir montir = new Montir("MTR-01", "Budi");
        montir.lakukanQualityControl(mobil);

        System.out.println("=== SKENARIO: Mobil Gagal Inspeksi → Dihancurkan ===");
        mobil.hancurkan(); 
        mobil = null;

        System.out.println("=== BUKTI Aggregation ===");
        ban1.tampilkanInfo(); 
        ban4.tampilkanInfo();
        System.out.println("Montir " + montir.getNama() + " masih bisa bekerja untuk mobil lain.");
    }
}
