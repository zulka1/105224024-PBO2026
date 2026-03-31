public class tagihan {
    int tanggungan;
    
    void setTagihan(int tanggungan){
        this.tanggungan = tanggungan;
    }

    void bayar(int saldo){
        if(tanggungan > saldo){
            System.out.println("Saldo tidak cukup");
        }else{
            saldo -= tanggungan;
            System.out.println("Pembayaran berhasil");
        }
    }
}
