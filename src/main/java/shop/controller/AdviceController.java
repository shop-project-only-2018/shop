package shop.controller;


import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.dtos.message.MessageDto;

import java.util.UUID;

@RestControllerAdvice
public class AdviceController {

//    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException e) {
//        return !!!;
//    }

    public MessageDto getWarningDto(Throwable ex, String logMessage) {
        return new MessageDto(getUUID(logMessage), ex.getMessage());
    }

    public UUID getUUID(String logMessage) {
        UUID uuid = UUID.randomUUID();
//        logger.warn(logMessage + " UUID: {}", uuid);
        return uuid;
    }
}
