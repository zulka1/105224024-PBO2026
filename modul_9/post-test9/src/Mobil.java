public class Mobil {
    private String idMobil;
    private String warna;
    private Mesin mesin;        
    private Ban[] setBan;       
    private int jumlahBan;

    public Mobil(String idMobil, String warna, String tipeEnjin, int kapasitasCC) {
        this.idMobil = idMobil;
        this.warna = warna;
        this.mesin = new Mesin(tipeEnjin, kapasitasCC);
        this.setBan = new Ban[4];
        this.jumlahBan = 0;
        System.out.println("Mobil " + idMobil + " selesai dirakit");
    }

    public void pasangSetBan(Ban[] banBaru) {
        for (Ban b : banBaru) {
            if (jumlahBan < 4) {
                setBan[jumlahBan++] = b;
            } else {
                System.out.println("Kapasitas ban penuh! Maks 4 ban.");
                break;
            }
        }
    }

    public void tampilkanSpesifikasi() {
        System.out.println("=== Spesifikasi Mobil ===");
        System.out.println("ID    : " + idMobil);
        System.out.println("Warna : " + warna);
        System.out.print("Mesin : ");
        mesin.tampilkanInfo();
        System.out.println("Ban   : " + jumlahBan + " terpasang");
        for (int i = 0; i < jumlahBan; i++) {
            setBan[i].tampilkanInfo();
        }
    }

    // Dipanggil sebelum di-null untuk simulasi "hancur"
    public void hancurkan() {
        System.out.println("Mobil " + idMobil + " dilebur/dihancurkan!");
        mesin.hancurkan();
        System.out.println("Ban-ban dilepas, tapi masih ada di memori!");
    }

    public String getIdMobil() { 
        return idMobil; 
    }
}