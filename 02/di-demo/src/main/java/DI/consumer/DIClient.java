package DI.consumer;

import DI.services.MessageService;


public class DIClient implements Consumerable{
    private final MessageService messageService;

    public DIClient(MessageService messageService) {
        this.messageService = messageService;
    }


    @Override
    public void processMessage(String message, String receiver) {
        messageService.sendMail(message, receiver);
    }
}
