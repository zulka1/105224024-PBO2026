public class BookingService implements Bookable {

    @Override
    public void book(Transportasi transportasi, int jumlah) throws TiketHabisException {
        if (jumlah > transportasi.getSisaKursi()) {
            throw new TiketHabisException(
                    "Tiket tidak mencukupi untuk pemesanan ini.",
                    transportasi.getNama(),
                    transportasi.getSisaKursi());
        }
        transportasi.kurangiKursi(jumlah);
    }
}
