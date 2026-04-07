import rental.kendaraan;
import rental.Motor;
import rental.Mobil;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<kendaraan> koleksi = new ArrayList<>();

        // Tambah objek ke ArrayList
        koleksi.add(new Mobil("B 4019 LOL", "Toyota Kijang Innova V", 2012, 250000, 7));
        koleksi.add(new Mobil("B 2026 R", "Honda Civic Type R", 2026, 300000, 5));
        koleksi.add(new Motor("B 44 RR", "Kawasaki Ninja ZX-6R", 2023, 650000, 636));
        koleksi.add(new Motor("B 5682 W", "Vario 125", 2022, 85000, 125));

        // Looping + polimorfisme
        for (kendaraan k : koleksi) {
            k.displayInfo();
            System.out.print("Total Biaya Sewa selama 5 Hari: ");
            k.hitunghargaSewa(5);
            System.out.println("---------------------------");
        }
    }
}