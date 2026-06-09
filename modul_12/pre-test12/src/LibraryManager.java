class Manager {
      String[] judulBuku;

public void cariJudulBuku(String keyJudul) {
    for (String judul : this.judulBuku) {
        if (judul.contains(keyJudul)) {
            System.out.println("Judul buku: " + judul);
        }
    }
}

    public void peminjamanBuku(String judulBuku) {
        System.out.println("Judul buku: " + judulBuku);
    }

}  