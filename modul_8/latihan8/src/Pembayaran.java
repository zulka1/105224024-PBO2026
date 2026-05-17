abstract class Pembayaran {
    protected String namaPembayar;
    protected double nominal;
 
    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }
 
    public void tampilkanDetail() {
        System.out.println("Pembayar : " + namaPembayar);
        System.out.println("Nominal : " + nominal);
    }
 
    public abstract void prosesPembayaran();
}