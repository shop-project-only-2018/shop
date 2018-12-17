package shop.service.message;

import org.springframework.stereotype.Component;
import shop.dtos.message.Message;

@Component
public interface MessageService {
    String get(String id);
    Message getMessage(String id);
    Message getError(String id);
}
