package DI.injector;

import DI.consumer.Consumerable;
import DI.consumer.DIClient;
import DI.services.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {
    @Override
    public Consumerable getConsumer() {
        return new DIClient(new SMSServiceImpl());
    }
}
