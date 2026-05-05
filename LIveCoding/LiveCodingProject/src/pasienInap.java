public class pasienInap extends pasien{
    private int jenisKamar;

    pasienInap(String namaPasien, int biayaObat, int jenisKamar){
        super(namaPasien, biayaObat);
        this.jenisKamar = jenisKamar;
    }

    public void hitungBiaya(){
        int total;
        if(jenisKamar == 1){
            total = getBiayaObat() + 500000;
            System.out.println("total biaya : " + total);
        }
        else if(jenisKamar == 2){
            total = getBiayaObat() + 200000;
            System.out.println("total biaya : " + total);
        }
        else if(jenisKamar == 3){
            total = getBiayaObat() + 50000;
            System.out.println("total biaya : " + total);
        }
    }
}


//kelas 1 + 500000
//kelas 2 + 200000
//kelas 3 + 50000

//buat pasien inap + hitung tagihan