public class App {
    public static void main(String[] args) throws Exception {
        user user = new user();
        user.daftar("Anton", "081234567");
        user.setor(50000);

        tagihan tagih = new tagihan();
        tagih.setTagihan(60000);
        tagih.bayar(user.saldo);

        user.setor(20000);
        tagih.bayar(user.saldo);
    }
}
