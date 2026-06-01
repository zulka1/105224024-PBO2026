public class App {
    public static void main(String[] args) throws Exception {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "Beras", "Sembako", 100);
        gudang.tambahBarangBaru("B02", "Minyak Goreng", "Sembako", 50);
        gudang.tambahBarangBaru("B03", "Laptop", "Elektronik", 10);

        gudang.tambahStok("B01", 20);         
        gudang.kurangiStok("B03", 3);         
        gudang.kurangiStok("B02", 999);       

        gudang.cetakLaporan();
    }
}

