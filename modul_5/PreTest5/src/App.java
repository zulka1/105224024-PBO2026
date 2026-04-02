public class App {
    public static void main(String[] args) throws Exception {
        RekeningBank rekeningBank = new RekeningBank();

        rekeningBank.setSaldo(1000000);         //input saldo positif
        rekeningBank.setSaldo(-5000000);        //input saldo negatif

        System.out.println(rekeningBank.getSaldo());        //output saldo
        
    }
}
