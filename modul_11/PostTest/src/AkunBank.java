public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHarian;

    public AkunBank(String nomorRekening, int saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHarian = 0;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiExpection {
        if (this.saldo - nominal < 0) {
            throw new SaldoTidakMencukupiExpection("Saldo tidak mencukupi");
        }
        else {
            this.saldo -= nominal;
        }
    }

    public void transfer(String nomorRekening, double nominal)  throws SaldoTidakMencukupiExpection, BatasHarianTransferExpection {
        if (this.saldo - nominal < 0) {
            throw new SaldoTidakMencukupiExpection("Saldo tidak mencukupi");
        }
        else if (this.totalTransferHarian + nominal > 1000000) {
            throw new BatasHarianTransferExpection("Batas transfer harian telah tercapai");
        }
        else {
            this.saldo -= nominal;
            this.totalTransferHarian += nominal;
        }
    }
}
