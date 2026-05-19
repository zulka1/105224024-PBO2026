public class Ban {
    private int idBan;
    private String merk;
    private int ukuranRing;

    public Ban(int idBan, String merk, int ukuranRing) {
        this.idBan = idBan;
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }

    public void tampilkanInfo() {
        System.out.println("=== Ban === \nID=" + idBan + "\nMerk=" + merk + "\nRing=" + ukuranRing);
    }

    public int getIdBan() { 
        return idBan; 
    }
}