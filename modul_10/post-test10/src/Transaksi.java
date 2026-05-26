public class Transaksi {
    private String namaPemesan;
    private Film film;
    private String nomorKursi;

    public Transaksi(String namaPemesan, Film film, String nomorKursi) {
        this.namaPemesan = namaPemesan;
        this.film = film;
        this.nomorKursi = nomorKursi;
    }

    @Override
    public String toString() {
        return "Film: " + film.getJudul() + " | Kursi: " + nomorKursi + " | Harga: Rp" + film.getHarga();
    }
}
