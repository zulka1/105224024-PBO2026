public interface Searchable<T> {
    T cari(String kode) throws RuteTidakDitemukanException;
}
