public class Film {
    private String judul;
    private double harga;

    public Film(String judul, double harga) {
        this.judul = judul;
        this.harga = harga;
    }

    public String getJudul() { 
        return judul; 
    }
    public double getHarga() { 
        return harga; 
    }

    @Override
    public String toString() {
        return judul + " | Rp" + harga;
    }
}
