public class user {
    String nama_lengkap;
    String nomor_telepon;
    int saldo;

    void daftar(String nama_lengkap, String nomor_telepon) {
        this.nama_lengkap = nama_lengkap;
        this.nomor_telepon = nomor_telepon;
        this.saldo = 0;
    }

    void setor(int saldo) {
        if(saldo < 10000) {
            System.out.println("Setor minimal 10000");
            return;
        }

        this.saldo += saldo;
    }

}
