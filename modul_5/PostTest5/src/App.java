public class App {
    public static void main(String[] args) throws Exception {
        Barang barang = new Barang();
        barang.inBarang(1, "Smart phone");
        barang.stok = 50;           //ini tidak boleh, karena stok private
        barang.tambahStok(-50);
        barang.kurangiStok(20);
        barang.sethargaSatuan(-50000);
        barang.tampilkanDetailBarang();
    }
}
