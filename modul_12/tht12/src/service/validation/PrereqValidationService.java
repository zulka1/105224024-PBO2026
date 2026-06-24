package service.validation;

import model.Mahasiswa;
import model.MataKuliah;

public class PrereqValidationService {
    public boolean validatePrereq(Mahasiswa mahasiswa, MataKuliah mk) {
        if (!mk.hasPrereq()) {
            return true;
        }

        String prereqKode = mk.getPrereqKode();
        return mahasiswa.sudahLulus(prereqKode);
    }
}
