import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int harga[] = new int[3];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Harga ke-" + i + " : ");
                
                harga[i] = input.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Error: Input harga harus berupa angka!");
                input.nextLine();
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erorr: Kapasitas memori harga sudah penuh!");
            }
            
        }

        input.close();

        try {
            Pelanggan pembeli = new Pelanggan(15);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Pelanggan pembeli = new Pelanggan(17);
            pembeli.pesanKopi(10);
        }
        catch (KopiHabisExpection e) {
            System.out.println(e.getMessage());
        }

        try {
            MesinKasir kasir = new MesinKasir(0, 0);
            kasir.bayar(50000, 10000);
        }
        catch (UangKurangExpection e) {
            System.out.println(e.getMessage());
        }

        try {
            MesinKasir kasir = new MesinKasir(0, 0);

            kasir.cetakStruk(false); 
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Terima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
        }
    }
}