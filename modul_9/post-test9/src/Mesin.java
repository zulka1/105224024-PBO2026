public class Mesin {
    private String tipeEnjin;
    private int kapasitasCC;

    public Mesin(String tipeEnjin, int kapasitasCC) {
        this.tipeEnjin = tipeEnjin;
        this.kapasitasCC = kapasitasCC;
        System.out.println("Mesin dibuat: " + tipeEnjin + " " + kapasitasCC + "cc");
    }

    public void tampilkanInfo() {
        System.out.println("=== Mesin === \nTipe=" + tipeEnjin + "\nCC=" + kapasitasCC);
    }

    public void hancurkan() {
        System.out.println("Mesin " + tipeEnjin + " ikut hancur bersama mobil!");
    }
}