public interface Bookable {
    void book(Transportasi transportasi, int jumlah) throws TiketHabisException;
}
