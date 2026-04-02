public class Barang {
    private int idBarang;
    private String namaBarang;
    private int stok;
    private int hargaSatuan;
    private String kategori;

    public void inBarang(int idBarang, String namaBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.stok = 0;
        this.hargaSatuan = 0;
        System.out.println("Barang berhasil ditambahkan");
    }

    public void tambahStok(int stok) {
        if(stok <= 0){
            System.out.println("penambah harus lebih besar dari 0");
            return;
        }
        this.stok += stok;
        System.out.println("stok berhasil ditambahkan");
    }

    public void kurangiStok(int stok) {
        if(stok <= 0){
            System.out.println("pengurang harus lebih besar dari 0");
            return;
        }
        else if(this.stok < stok){
            System.out.println("stok tidak cukup");
            return;
        }
        this.stok -= stok;
        System.out.println("stok berhasil dikurangi");
    }

    public void tampilkanDetailBarang() {
        System.out.println("ID Barang: " + this.idBarang);    
        System.out.println("Nama Barang: " + this.namaBarang);    
        System.out.println("Stok: " + this.stok);    
        System.out.println("Harga: " + this.hargaSatuan);
    }

    public int getstok() {
        return stok;
    }

    public void setstok(int stok) {
        if(stok < 0){
            return;
        }
        this.stok = stok;
    }

    public int gethargaSatuan() {
        return hargaSatuan;
    }

    public void sethargaSatuan(int hargaSatuan) {
        if(hargaSatuan <= 0){
            System.out.println("harga harus lebih besar dari 0");
            return;
        }
        this.hargaSatuan = hargaSatuan;
    }
    
    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }   

    
}
