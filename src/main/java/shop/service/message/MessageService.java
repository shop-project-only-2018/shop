package shop.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import shop.dtos.message.Message;

import java.util.Locale;

@Component
public class MessageService implements Messages {

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String get(String id) {
        return messageSource.getMessage(id, null, Locale.getDefault());
    }

    @Override
    public Message getMessage(String id) {
        return new Message(messageSource.getMessage(id, null, Locale.getDefault()));
    }

    @Override
    public Message getError(String id) {
        return new Message(true, messageSource.getMessage(id, null, Locale.getDefault()));
    }

}
