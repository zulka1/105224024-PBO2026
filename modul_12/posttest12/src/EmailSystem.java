public class EmailSystem implements EmailSender {

    @Override
    public void sendEmail(String message) {
        System.out.println("Mengirim email: " + message);
    }
}
