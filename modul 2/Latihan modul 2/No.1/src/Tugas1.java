import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) throws Exception {
        double panjang, lebar, tinggi;
        double cat = 10;
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan panjang: ");
        panjang = input.nextDouble();
        System.out.print("Masukkan lebar: ");
        lebar = input.nextDouble();
        System.out.print("Masukkan tinggi: ");
        tinggi = input.nextDouble();
        input.close();

        double luas4sisi = 2 * ((panjang * tinggi) + (lebar * tinggi));
        System.out.println("Luas permukaan 4 sisi dinding: " + luas4sisi);
        
        System.out.println("Banyak cat yang diprlukan: " + ((int) (luas4sisi / cat)) + "liter");
    }
}
