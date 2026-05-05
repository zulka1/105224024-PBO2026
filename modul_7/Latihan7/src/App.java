import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<PerangkatPintar> perangkat = new ArrayList<>();
        perangkat.add(new LampuPintar()); 
        perangkat.add(new AcPintar());   

        for (PerangkatPintar p : perangkat) {
            p.aktifkan();

            if (p instanceof AcPintar) {
                AcPintar ac = (AcPintar) p;  
                ac.aturSuhu(20);
            }
        }

        LampuPintar lampu = new LampuPintar();
        lampu.aturKecerahan(75);
        lampu.aturKecerahan(50, "hangat");
    }
}

/*
NO. 5
Error "cannot finc symbol" dapat terjadi karena referensi alat bertipe PerangkatPintar. 
Compiler hanya tahu method yang ada di PerangkatPintar dan aturKecerahan() tidak ada di sana. 
Jadi compiler langsung tolak, walaupun objek aslinya LampuPintar.

ini dapat diperbaiki dengan cara menggunakan casting:
PerangkatPintar alat = new LampuPintar();
LampuPintar lampu = (LampuPintar) alat;
lampu.aturKecerahan(75, "Putih");

*/