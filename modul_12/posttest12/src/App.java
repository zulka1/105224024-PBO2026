public class App {
    public static void main(String[] args) {

        Payable creditCard = new CreditCard();
        EmailSender emailSystem = new EmailSystem();

        OrderService orderCC = new OrderService(
            new OrderRepository(),
            new PaymentService(creditCard),
            new NotificationService(emailSystem)
        );
        orderCC.placeOrder("ORD-001", 250000);

        Payable giftVoucher = new GiftVoucher();

        OrderService orderGV = new OrderService(
            new OrderRepository(),
            new PaymentService(giftVoucher),
            new NotificationService(emailSystem)
        );
        orderGV.placeOrder("ORD-002", 100000);

        Payable ovo = new OVO();

        OrderService orderOVO = new OrderService(
            new OrderRepository(),
            new PaymentService(ovo),
            new NotificationService(emailSystem)
        );
        orderOVO.placeOrder("ORD-003", 75000);

        System.out.println("=== Demo Refund ===");

        if (creditCard instanceof Refundable) {
            ((Refundable) creditCard).refund(250000);
        }

        if (giftVoucher instanceof Refundable) {
            ((Refundable) giftVoucher).refund(100000);
        } else {
            System.out.println("GiftVoucher tidak mendukung refund.");
        }

        System.out.println();

        System.out.println("=== Demo Notifikasi Terpisah ===");

        EmailSender email = new EmailSystem();
        SmsSender sms = new SmsSystem();
        WhatsAppSender wa = new WhatsAppSystem();

        email.sendEmail("Pesanan Anda telah dikonfirmasi.");
        sms.sendSMS("Kode OTP Anda: 123456");
        wa.sendWhatsApp("Paket Anda sedang dalam perjalanan!");
    }
}
