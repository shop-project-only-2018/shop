package shop.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.dtos.MessageDto;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.UUID;

import static shop.util.ResponseEntityBuilder.notFound;

@RestControllerAdvice
public class AdviceController {

//    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException e) {
        return notFound();
    }

    public MessageDto getWarningDto(Throwable ex, String logMessage) {
        return new MessageDto(getUUID(logMessage), ex.getMessage());
    }
    public UUID getUUID(String logMessage) {
        UUID uuid = UUID.randomUUID();
//        logger.warn(logMessage + " UUID: {}", uuid);
        return uuid;
    }
}
