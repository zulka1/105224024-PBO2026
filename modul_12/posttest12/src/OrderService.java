public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderService(OrderRepository orderRepository,
                        PaymentService paymentService,
                        NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public void placeOrder(String orderId, double amount) {
        System.out.println("=== Memproses Pesanan #" + orderId + " ===");
        orderRepository.saveOrder(orderId, amount);
        paymentService.processPayment(amount);
        notificationService.notifyCustomer(orderId);
        System.out.println("=== Pesanan #" + orderId + " selesai diproses ===\n");
    }
}
