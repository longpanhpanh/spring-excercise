package DI.services;

public class SMSServiceImpl implements MessageService {
    @Override
    public void sendMail(String message, String phone) {
        System.out.println("SMS send to " + phone + " with message " + message);
    }
}
