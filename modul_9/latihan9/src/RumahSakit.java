public class RumahSakit {
    private String namaRS;
    private Ruangan[] ruangan;
    private Dokter[] dokter;
    
    public RumahSakit(String namaRS) {
        this.namaRS = namaRS;
        this.ruangan = new Ruangan[2];
        this.ruangan[0] = new Ruangan("R-01", 10);
        this.ruangan[1] = new Ruangan("R-02", 15);
        this.dokter = new Dokter[10];
    }

    public void tambahDokter(Dokter d, int index) {
        if (index >= 0 && index < dokter.length) {
            dokter[index] = d;
        }
    }
 
    public void cetakDaftarRuangan() {
        System.out.println("==== Daftar Ruangan " + namaRS + " ====");
        for (Ruangan r : ruangan) {
            System.out.println("Nomor: " + r.getNomorRegistrasi() + " | Kapasitas: " + r.getPasienMaks() + " pasien");
        }
    }
 
    public void cetakDaftarDokter() {
        System.out.println("==== Dokter Bertugas di " + namaRS + " ====");
        for (Dokter d : dokter) {
            if (d != null) {
                System.out.println("Dr. " + d.getNama() + " | " + d.getSpesialis());
            }
        }
    }
}
