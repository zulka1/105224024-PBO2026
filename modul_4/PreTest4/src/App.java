public class App {
    
    public static void main(String[] args) {
        Mahasiswa mhsBaru = new Mahasiswa();

        mhsBaru.nama         = "Jaki";
        mhsBaru.umur         = 20;
        mhsBaru.jurusanStudi = "Informatika";
    }
}

class Mahasiswa {
    String nama;
    int umur;
    String jurusanStudi;
}