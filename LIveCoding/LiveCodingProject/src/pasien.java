public class pasien{
    private String namaPasien;
    private int biayaObat;

    public pasien(String namaPasien, int biayaObat){
        this.namaPasien = namaPasien;
        this.biayaObat = biayaObat;

    }

    public int getBiayaObat(){
        return biayaObat;
    }

    public void setBiayaObat(int biayaObat){
        if(biayaObat > 0){
            this.biayaObat = biayaObat;
            return;
        }
    
    }
}