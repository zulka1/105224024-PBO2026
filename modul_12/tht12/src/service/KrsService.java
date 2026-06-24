package service;

import model.Krs;
import model.MataKuliah;
import repository.KrsRepository;
import service.pdf.KrsPdfGenerator;
import service.sks.SksCalculationStrategy;
import service.ukt.UktCalculationStrategy;
import service.validation.PrereqValidationService;

public class KrsService {
    private final PrereqValidationService validator;
    private final KrsRepository repository;
    private final KrsPdfGenerator pdfGenerator;
    private final SksCalculationStrategy sksCalculator;

    // Dependency Injection via Constructor
    public KrsService(
            PrereqValidationService validator, 
            KrsRepository repository, 
            KrsPdfGenerator pdfGenerator, 
            SksCalculationStrategy sksCalculator) {
        this.validator = validator;
        this.repository = repository;
        this.pdfGenerator = pdfGenerator;
        this.sksCalculator = sksCalculator;
    }

    public void prosesKrs(Krs krs, UktCalculationStrategy uktStrategy) {
        for (MataKuliah mk : krs.getDaftarMataKuliah()) {
            boolean isValid = validator.validatePrereq(krs.getMahasiswa(), mk);
            if (!isValid) {
                System.out.println("Gagal memproses KRS " + krs.getMahasiswa().getNama() + 
                                   ": Mata kuliah " + mk.getNama() + " tidak memenuhi prasyarat.\n");
                return;
            }
        }

        double uktTagihan = uktStrategy.calculateUkt(krs.getMahasiswa());
        repository.save(krs);
        pdfGenerator.generateKrsPdf(krs, sksCalculator, uktTagihan);
    }
}
