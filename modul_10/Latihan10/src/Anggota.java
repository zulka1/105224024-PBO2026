import java.util.Objects;

public class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anggota)) return false;
        Anggota lain = (Anggota) o;
        return this.idAnggota.equals(lain.idAnggota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    }

    @Override
    public String toString() {
        return "[" + idAnggota + "] " + nama + " (" + tipe + ")";
    }
    
    public String getIdAnggota() {
        return idAnggota;
    }
}
