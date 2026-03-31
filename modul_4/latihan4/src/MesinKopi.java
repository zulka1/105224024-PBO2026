public class MesinKopi {    //No.1
    float bijiKopi = 0; //No.4
    float air = 0;  //No.4
    float susu = 0; //No.4

    void isiUlangBahan(float bijiKopi, float air, float susu) {     //No.2
        this.bijiKopi = bijiKopi;
        this.air = air;
        this.susu = susu;
        
        System.out.println("Bahan baku berhasil diisi ulang:");
    }

    boolean cekBahan() {    //No.3
        if (this.bijiKopi < 50 || this.air < 50 || this.susu < 100) {
            return false;
        }
        return true;
    }
}
