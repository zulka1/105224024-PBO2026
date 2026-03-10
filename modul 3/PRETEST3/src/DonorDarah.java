import java.util.Scanner;

public class DonorDarah {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan Usia: ");
        int usia = input.nextInt();
        System.out.println("Masukkan Berat Badan: ");
        float BB = input.nextFloat();
        System.out.println("Masukkan Kadar Homoglobin: ");
        float KH = input.nextFloat();
        input.close();

        if((usia >= 17 && usia <= 65)&& BB >= 45 && (KH >= 12.5 && KH <= 17)){
            System.out.println("Kriteria ini layak untuk mendonorkan darah");
        }
        else{
            System.out.println("Kriteria ini tidak layak untuk mendonorkan darah");
        }
    }
}
