public class Dokter {
    String nama;
    String spesialis;

    public Dokter(String nama, String spesialis) {
        this.nama = nama;
        this.spesialis = spesialis;
    }

    public String getNama() {
        return this.nama;
    }

    public String getSpesialis() {
        return this.spesialis;
    }

    public void periksa(Pasien pasien) {
        System.out.println("Dokter " + this.nama + " dengan spesialis " + this.spesialis);
        System.out.println("Melakukan pemeriksaan terhadap pasien " + pasien.getNama() + " umur " + pasien.getUmur());
    }
}