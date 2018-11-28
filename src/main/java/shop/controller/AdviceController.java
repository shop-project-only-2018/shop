package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.dtos.message.Message;
import shop.service.message.MessageService;
import shop.system.CheckedException;

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
        return messageService.getError(e.getMessage());
    }
}
