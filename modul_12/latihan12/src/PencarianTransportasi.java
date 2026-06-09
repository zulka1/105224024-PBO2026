import java.util.List;

public class PencarianTransportasi implements Searchable<Transportasi> {
    private List<Transportasi> daftarTransportasi;

    public PencarianTransportasi(List<Transportasi> daftarTransportasi) {
        this.daftarTransportasi = daftarTransportasi;
    }

    @Override
    public Transportasi cari(String kode) throws RuteTidakDitemukanException {
        for (Transportasi t : daftarTransportasi) {
            if (t.getKode().equalsIgnoreCase(kode)) {
                return t;
            }
        }
        throw new RuteTidakDitemukanException(
                "Kode kereta '" + kode + "' tidak ditemukan dalam sistem.");
    }
}
