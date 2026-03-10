import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int ba = 25500;
        int bb = 14200;
        System.out.println("Barang A : Rp. 25.500 ");
        System.out.println("Barang B : Rp. 14.200 ");
        System.out.print("Masukkan jumlah barang A : ");
        int jumlahA = input.nextInt();
        System.out.print("Masukkan jumlah barang B : ");
        int jumlahB = input.nextInt();
        int total = (ba * jumlahA) + (bb * jumlahB);
        System.out.println("Total Harga : " + (total + (total * 0.11)));
        System.out.print("jumlah uang : ");
        int uang = input.nextInt();
        input.close();
        int uang1 = uang - total;
        System.out.println("Kembalian 50000: " + (uang1 / 50000));
        System.out.println("Kembalian 10000: " + ((uang1 % 50000) / 10000));
    }
}
