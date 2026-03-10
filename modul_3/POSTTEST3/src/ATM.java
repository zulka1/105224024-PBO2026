import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int saldo = 500000;
        boolean status = false;
        do{
            System.out.println("==========================================================");
            System.out.println("1. Cek Saldo \n2. Setor Tunai \n3. Tarik Tunai \n4. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = input.nextInt();
            switch(pilihan){
                case 1:
                    System.out.println("Saldo Anda : Rp. " + saldo);
                    break;
                case 2:
                    System.out.print("Setor Tunai : Rp. ");
                    int setor = input.nextInt();
                    saldo += setor;
                    System.out.println("Setor Tunai Berhasil");
                    break;
                case 3:
                    System.out.print("Tarik Tunai : Rp. ");
                    int tarik = input.nextInt();
                    if(tarik > saldo){
                        if(saldo < 50000){
                            System.out.println("Tarik Tunai Minimal Rp. 50.000");
                        }
                        System.out.println("Saldo Anda Tidak Mencukupi");
                    }
    
                    else{
                        System.out.println("Tarik Tunai Berhasil");
                        saldo -= tarik;
                    }
                    break;
                case 4:
                    status = true;
                    break;
            }
        }while(status != true);
        input.close();
    }
}
