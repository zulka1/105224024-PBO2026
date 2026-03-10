import java.util.Scanner;

public class posttest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== SISTEM PAYROLL PERUSAHAAN ===");
        System.out.print("Nama Karyawan : ");
        String nama = input.nextLine();

        System.out.print("Gaji Pokok (Rp) : ");
        double gajiPokok = input.nextDouble();

        System.out.print("Jumlah Jam Lembur : ");
        int jamLembur = input.nextInt();
        double upahLemburPerJam = gajiPokok / 173;
        double totalUangLembur = jamLembur * upahLemburPerJam;
        double gajiBruto = gajiPokok + totalUangLembur;
        double pajak = 0.05 * gajiBruto;
        double bpjs = 0.01 * gajiPokok;
        double gajiBersih = gajiBruto - pajak - bpjs;

        System.out.println("\n=== SLIP GAJI ===");
        System.out.println("Karyawan : " + nama);
        System.out.printf("Upah Lembur/Jam : Rp %.2f%n", upahLemburPerJam);
        System.out.printf("Total Uang Lembur : Rp %.2f%n", totalUangLembur);
        System.out.printf("Gaji Bruto : Rp %.2f%n", gajiBruto);

        System.out.println("---------------------------------");
        System.out.printf("Potongan Pajak : Rp %.2f%n", pajak);
        System.out.printf("Potongan BPJS : Rp %.2f%n", bpjs);
        System.out.println("---------------------------------");

        System.out.printf("GAJI BERSIH : Rp %.2f%n", gajiBersih);
        System.out.println("=================================");

        input.close();
    }
}