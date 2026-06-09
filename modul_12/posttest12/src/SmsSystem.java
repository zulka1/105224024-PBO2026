public class SmsSystem implements SmsSender {

    @Override
    public void sendSMS(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}
