public class RekeningBank {
    private int saldo;

    
    public int getSaldo() {
        return saldo;
    }
    
    public void setSaldo(int saldo) {
        if(saldo < 0){
            System.out.println("Saldo tidak boleh negatif");
            return;
        }
        
        System.out.println("Saldo berhasil diubah");
        this.saldo = saldo;
    }    

}
