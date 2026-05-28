// Kelas CustomerService
public class CustomerService {
    private String namaCS;
    private String idCS;

    // Constructor CustomerService
    public CustomerService(String idCS, String namaCS) {
        this.idCS = idCS;
        this.namaCS = namaCS;
    }

    // Getter
    public String getNamaCS() {
        return namaCS;
    }

    public String getIdCS() {
        return idCS;
    }

    // Methode Menerima dan memproses laporan keluhan dari nasabah
    public void terimaKeluhan(String namaNasabah, String keluhan) {
        System.out.println("\n  ======================================");
        System.out.println("  [CUSTOMER SERVICE - " + idCS + "] " + namaCS);
        System.out.println("  ======================================");
        System.out.println("  Nasabah      : " + namaNasabah);
        System.out.println("  Keluhan      : " + keluhan);
        System.out.println("  ======================================\n");
    }
}
