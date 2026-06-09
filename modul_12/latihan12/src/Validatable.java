public interface Validatable {
    void validate(String nik, String nama) throws DataPenumpangTidakValidException;
}
