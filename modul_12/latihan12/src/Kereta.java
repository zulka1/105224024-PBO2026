public class Kereta extends Transportasi {

    public Kereta(String kode, String nama, String rute, int kapasitas) {
        super(kode, nama, rute, kapasitas);
    }

    @Override
    public String getTipe() {
        return "Kereta Api";
    }
}
