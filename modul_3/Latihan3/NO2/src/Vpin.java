import java.util.Scanner;

public class Vpin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String benar = "123456";
        int salah = 0;

        do {
            System.out.print("Enter your pin: ");
            String pin = input.nextLine();

            if (pin.equals(benar)) {
                System.out.println("Sandi Benar!");
                salah = 99; // keluar loop
            } else {
                salah++;
                if (salah < 3) {
                    System.out.println("Sandi salah! Percobaan ke-" + salah);
                }
            }

        } while (salah < 3);

        if (salah == 3) {
            System.out.println("Sandi salah! Percobaan ke-3");
        }

        input.close();
    }
}