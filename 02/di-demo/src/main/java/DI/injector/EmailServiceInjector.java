package DI.injector;

import DI.consumer.Consumerable;
import DI.consumer.DIClient;
import DI.services.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {
    @Override
    public Consumerable getConsumer() {
        DIClient client = new DIClient(new EmailServiceImpl());
        return client;
    }
}
