package DI.services;

public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMail(String message, String receiver) {
        System.out.println("Email send to " + receiver + " with message " + message);
    }
}
