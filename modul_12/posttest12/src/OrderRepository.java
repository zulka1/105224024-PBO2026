public class OrderRepository {

    public void saveOrder(String orderId, double amount) {
        System.out.println("Menyimpan pesanan #" + orderId + " dengan total Rp" + amount);
    }
}
