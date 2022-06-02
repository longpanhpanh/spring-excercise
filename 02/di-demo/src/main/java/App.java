import DI.consumer.Consumerable;
import DI.injector.EmailServiceInjector;
import DI.injector.MessageServiceInjector;
import DI.injector.SMSServiceInjector;

public class App {
    public static void main(String[] args) {
        String message = "Hello Guys";
        String email = "long@gmail.com";
        String phone = "01234567989";
        MessageServiceInjector injector = null;
        Consumerable client = null;

        injector = new EmailServiceInjector();
        client = injector.getConsumer();
        client.processMessage(message, email);

        injector = new SMSServiceInjector();
        client = injector.getConsumer();
        client.processMessage(message, phone);
    }
}


