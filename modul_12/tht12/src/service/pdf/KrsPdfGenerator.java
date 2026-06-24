package service.pdf;

import model.Krs;
import service.sks.SksCalculationStrategy;

public class KrsPdfGenerator {
    public void generateKrsPdf(Krs krs, SksCalculationStrategy sksCalculator, double uktTagihan) {
        System.out.println("\n========================================================");
        System.out.println("                 KARTU RENCANA STUDI (KRS)              ");
        System.out.println("               UNIVERSITAS TEKNOLOGI NEGERI             ");
        System.out.println("========================================================");
        System.out.println("NIM            : " + krs.getMahasiswa().getNim());
        System.out.println("Nama Mahasiswa : " + krs.getMahasiswa().getNama());
        System.out.println("Jalur Masuk    : " + krs.getMahasiswa().getJalurMasuk());
        System.out.println("Tagihan UKT    : Rp " + String.format("%,.2f", uktTagihan));
        System.out.println("--------------------------------------------------------");
        System.out.println("Daftar Mata Kuliah yang Diambil:");
        
        var listMk = krs.getDaftarMataKuliah();
        for (int i = 0; i < listMk.size(); i++) {
            var mk = listMk.get(i);
            System.out.println((i + 1) + ". [" + mk.getKode() + "] " + mk.getNama() + " (" + mk.getSks() + " SKS)");
        }
        
        int totalSks = krs.hitungTotalSks(sksCalculator);
        System.out.println("--------------------------------------------------------");
        System.out.println("Total SKS yang Diambil: " + totalSks + " SKS");
        System.out.println("========================================================\n");
    }
}
