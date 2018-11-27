package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.dtos.message.Message;
import shop.dtos.message.MessageDto;
import shop.service.message.MessageService;
import shop.system.CheckedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class AdviceController {

    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @ExceptionHandler(CheckedException.class)
    @ResponseStatus(HttpStatus.OK)
    public Message handleCheckedException(CheckedException e) {
        return messageService.getError(e.getMessage());}













        // TODO: REMOVE
    public MessageDto getWarningDto(Throwable ex, String logMessage) {
        return new MessageDto(getUUID(logMessage), ex.getMessage());
    }

    public UUID getUUID(String logMessage) {
        UUID uuid = UUID.randomUUID();
//        logger.warn(logMessage + " UUID: {}", uuid);
        return uuid;
    }
}
