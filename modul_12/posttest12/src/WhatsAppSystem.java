public class WhatsAppSystem implements WhatsAppSender {

    @Override
    public void sendWhatsApp(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}
