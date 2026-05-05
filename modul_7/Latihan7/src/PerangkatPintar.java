public class PerangkatPintar {
    void aktifkan(){
        System.out.println("Perangkat pintar diaktifkan");
    }
}

class LampuPintar extends PerangkatPintar {
    @Override
    public void aktifkan() {
        System.out.println("Lampu menyala dengan tingkat kecerahan standar");
    }

    public void aturKecerahan(int level) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "%");
    }

    public void aturKecerahan(int level, String warna) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "% dengan warna cahaya " + warna);
    }
}

class AcPintar extends PerangkatPintar {
    @Override
    public void aktifkan() {
        System.out.println("AC menyala dan mulai mendinginkan ruangan");
    }

    public void aturSuhu(int suhu) {
        System.out.println("Suhu ruangan diatur menjadi " + suhu + " derajat");
    }
}
