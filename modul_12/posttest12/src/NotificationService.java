public class NotificationService {

    private final EmailSender emailSender;

    public NotificationService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void notifyCustomer(String orderId) {
        emailSender.sendEmail("Pesanan #" + orderId + " telah berhasil diproses. Terima kasih!");
    }
}
