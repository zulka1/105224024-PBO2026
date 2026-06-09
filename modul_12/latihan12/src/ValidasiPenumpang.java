public class ValidasiPenumpang implements Validatable {

    @Override
    public void validate(String nik, String nama) throws DataPenumpangTidakValidException {
        // Validasi NIK harus 16 karakter
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException(
                    "NIK harus 16 karakter. NIK yang dimasukkan: " + nik.length() + " karakter.");
        }

        // Validasi NIK hanya boleh berisi angka
        for (char c : nik.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new DataPenumpangTidakValidException(
                        "NIK tidak boleh mengandung huruf atau karakter selain angka.");
            }
        }

        // Validasi nama tidak boleh kosong
        if (nama == null || nama.trim().isEmpty()) {
            throw new DataPenumpangTidakValidException(
                    "Nama penumpang tidak boleh kosong.");
        }
    }
}
