public class Karyawan {
    private int idKaryawan;                 //No.1
    private String namaKaryawan;
    private double gajiPokok;       //No.2
    private String departemen;      //No.3

    public void karyawan(int idKaryawan, String namaKaryawan) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        System.out.println("Karyawan berhasil ditambahkan");
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public double getGajiPokok() {          //No.2
        return gajiPokok;
    }

    public String getDepartemen() {         //No.3
        return departemen;
    }

    public void setGajiPokok(double gajiPokok) {        //No.2
        if (gajiPokok < 0) {
            System.out.println("Gaji tidak boleh negatif");
            return;
        }
        this.gajiPokok = gajiPokok;
        System.out.println("Gaji berhasil diubah");
    }

    public void setDepartemen(String departemen) {       //No.3
        this.departemen = departemen;
        System.out.println("Departemen berhasil diubah");
    }

    public void tampilkanDataKaryawan() {
        System.out.println("ID Karyawan: " + idKaryawan);
        System.out.println("Nama Karyawan: " + namaKaryawan);
        System.out.println("Gaji Pokok: " + gajiPokok);
        System.out.println("Departemen: " + departemen);
    }
}