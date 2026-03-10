import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan celcius: ");
        double celcius = input.nextDouble();
        input.close();
        double fahrenheit = (celcius * 9 / 5) + 32;
        System.out.print("Fahrenheit: ");
        System.out.printf("%.2f", fahrenheit);
        double kelvin = celcius + 273.15;
        System.out.print("\nKelvin: ");
        System.out.printf("%.2f", kelvin);
        double reamur = (4.0 / 5) * celcius;
        System.out.print("\nReamur: ");   
        System.out.printf("%.2f", reamur);
    }
}
