public class Ruangan {
    private String nomorRegistrasi;
    private int pasienMaks;

    public Ruangan(String nomorRegistrasi, int pasienMaks) {
        this.nomorRegistrasi = nomorRegistrasi;
        this.pasienMaks = pasienMaks;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public int getPasienMaks() {
        return pasienMaks;
    }
}
