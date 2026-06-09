import java.util.List;

public class Reservasi {
    private List<Transportasi> daftarTransportasi;
    private Validatable validator;          
    private Searchable<Transportasi> pencari; 
    private Bookable booker;              
    private Printable printer;            

    // Constructor dengan Dependency Injection
    public Reservasi(Validatable validator, Searchable<Transportasi> pencari, Bookable booker, Printable printer, List<Transportasi> daftarTransportasi) {
        this.validator = validator;
        this.pencari = pencari;
        this.booker = booker;
        this.printer = printer;
        this.daftarTransportasi = daftarTransportasi;
    }

    public List<Transportasi> getDaftarTransportasi() {
        return daftarTransportasi;
    }

    public void pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket) throws RuteTidakDitemukanException, TiketHabisException, DataPenumpangTidakValidException {
        validator.validate(nik, namaPenumpang);
        Transportasi transportasi = pencari.cari(kodeKereta);
        booker.book(transportasi, jumlahTiket);
        printer.cetakKonfirmasi(transportasi, namaPenumpang, nik, jumlahTiket);
    }
}
