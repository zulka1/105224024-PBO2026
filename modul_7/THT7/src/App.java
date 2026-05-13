import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<LayananEkspedisi> ekspedisi = new ArrayList<>();      //menginisialisasi arraylist

        ekspedisi.add(new LayananReguler("REG-11", 2, 50, 50, 50));     // Reguler: Resi "REG-11", Berat 2kg, Dimensi 50x50x50 cm
        ekspedisi.add(new LayananExpress("EXP-22", 5, 10, 10, 10));     // Express: Resi "EXP-22", Berat 5kg, Dimensi 10x10x10 cm
        ekspedisi.add(new LayananInternasional("INT-33", 3, 20, 20, 20, "Korea", 100));     // Internasional: Resi "INT-33", Berat 3kg, Dimensi 20x20x20 cm, Tujuan "Korea", Nilai USD 100

        double totalPendapatanPerusahaan = 0.0;     //membuat variabel totalPendapatanPerusahaan

        for (LayananEkspedisi e : ekspedisi) {      //perulangan untuk menelusuri isi koleksi
            e.cetakResi();                          //menampilkan resi
            totalPendapatanPerusahaan += e.hitungOngkir();      //menghitung ongkir
            
            //downcasting
            if(e instanceof LayananReguler) {       //jika reguler
                ((LayananReguler)e).hitungOngkir(true, 25);
            }
            else if(e instanceof LayananExpress) {      //jika express
                ((LayananExpress)e).klaimAsuransi(1500000);
            }
            else if(e instanceof LayananInternasional) {        //jika internasional
                ((LayananInternasional)e).cekManifest();
            }
        }

        System.out.println("Total Pendapatan Perusahaan: " + totalPendapatanPerusahaan);        //menampilkan total pendapatan
    }
}
