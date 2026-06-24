import java.util.List;
import model.*;
import repository.*;
import service.KrsService;
import service.pdf.KrsPdfGenerator;
import service.sks.*;
import service.ukt.*;
import service.validation.PrereqValidationService;

public class App {
    public static void main(String[] args) throws Exception {
        MataKuliah pbo = new MataKuliahTeori("IF211", "Pemrograman Berorientasi Objek", 3);
        MataKuliah strukdat = new MataKuliahTeori("IF212", "Struktur Data", 3);
        MataKuliah dpl = new MataKuliahTeori("IF213", "Desain Perangkat Lunak", 3, "IF211"); 
        MataKuliah praktikumPbo = new MataKuliahPraktikum("IF211P", "Praktikum Pemrograman Berorientasi Objek", 1, "Lab RPL");
        MataKuliah kkn = new MataKuliahLapangan("IF400", "Kuliah Kerja Nyata (KKN) Tematik", 4, "Desa Sukamaju");

        PrereqValidationService validator = new PrereqValidationService();
        KrsPdfGenerator pdfGenerator = new KrsPdfGenerator();
        
        List<MataKuliah> daftarSemuaMatakuliah = List.of(pbo, strukdat, dpl, praktikumPbo, kkn);
        for (MataKuliah mk : daftarSemuaMatakuliah) {
            if (mk instanceof AsistenLabAllocatable) {
                ((AsistenLabAllocatable) mk).alokasiAsistenLab();
            }
            if (mk instanceof PeralatanCheckable) {
                ((PeralatanCheckable) mk).cekPeralatanPraktikum();
            }
        }
        System.out.println();

        Mahasiswa budi = new Mahasiswa("105224001", "Budi Santoso", JalurMasuk.REGULER);
        budi.tambahRiwayat("IF211");

        Mahasiswa alice = new Mahasiswa("105224002", "Alice Smith", JalurMasuk.INTERNASIONAL);

        Mahasiswa charlie = new Mahasiswa("105224003", "Charlie", JalurMasuk.BIDIKMISI);
        charlie.tambahRiwayat("IF211");

        Mahasiswa daniel = new Mahasiswa("105224004", "Daniel Siregar", JalurMasuk.KARYAWAN);

        UktCalculationStrategy regulerUkt = new RegulerUktStrategy();
        UktCalculationStrategy internasionalUkt = new InternasionalUktStrategy();
        UktCalculationStrategy bidikmisiUkt = new BidikmisiUktStrategy();
        UktCalculationStrategy karyawanUkt = new KaryawanUktStrategy();

        SksCalculationStrategy standardSks = new StandardSksCalculator();
        SksCalculationStrategy mbkmSks = new MbkmSksCalculator();

        KrsRepository mysqlRepo = new MySqlKrsRepository();
        KrsService krsServiceMysql = new KrsService(validator, mysqlRepo, pdfGenerator, standardSks);

        Krs krsBudi = new Krs(budi);
        krsBudi.tambahMataKuliah(pbo);
        krsBudi.tambahMataKuliah(dpl); 
        krsBudi.tambahMataKuliah(praktikumPbo);
        krsServiceMysql.prosesKrs(krsBudi, regulerUkt);

        KrsRepository cloudNoSqlRepo = new CloudNoSqlKrsRepository();
        KrsService krsServiceCloud = new KrsService(validator, cloudNoSqlRepo, pdfGenerator, standardSks);

        Krs krsAlice = new Krs(alice);
        krsAlice.tambahMataKuliah(strukdat);
        krsAlice.tambahMataKuliah(dpl);
        krsServiceCloud.prosesKrs(krsAlice, internasionalUkt);

        Krs krsCharlieReguler = new Krs(charlie);
        krsCharlieReguler.tambahMataKuliah(strukdat);
        krsCharlieReguler.tambahMataKuliah(kkn);
        
        KrsService serviceCharlieReguler = new KrsService(validator, cloudNoSqlRepo, pdfGenerator, standardSks);
        serviceCharlieReguler.prosesKrs(krsCharlieReguler, bidikmisiUkt);

        Krs krsCharlieMbkm = new Krs(charlie);
        krsCharlieMbkm.tambahMataKuliah(strukdat);
        krsCharlieMbkm.tambahMataKuliah(kkn);
        
        KrsService serviceCharlieMbkm = new KrsService(validator, cloudNoSqlRepo, pdfGenerator, mbkmSks);
        serviceCharlieMbkm.prosesKrs(krsCharlieMbkm, bidikmisiUkt);

        Krs krsDaniel = new Krs(daniel);
        krsDaniel.tambahMataKuliah(pbo);
        krsDaniel.tambahMataKuliah(strukdat);
        
        KrsService serviceDaniel = new KrsService(validator, cloudNoSqlRepo, pdfGenerator, standardSks);
        serviceDaniel.prosesKrs(krsDaniel, karyawanUkt);
    }
}
