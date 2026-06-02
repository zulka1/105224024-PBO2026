import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Masukkan pembilang: ");
            int pembilang = sc.nextInt();
            System.out.println("Masukkan penyebut:");
            int penyebut = sc.nextInt();

            System.out.println(pembilang / penyebut);     
        } 
        catch (ArithmeticException e) {
            System.out.println("Penyebut tidak boleh 0");
        }
        catch (InputMismatchException e) {
            System.out.println("hanat bisa input karakter numerik");
        } 
        finally {
            sc.close();
            System.out.println("Proses kalkukasi selesai dan resource memori telah dibersihkan");
        }
    }
}
