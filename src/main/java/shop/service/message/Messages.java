package shop.service.message;

import org.springframework.stereotype.Component;
import shop.dtos.message.Message;

@Component
public interface Messages {
    String get(String id);
    Message getMessage(String id);
    Message getError(String id);
}
