package shop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.system.exceptions.ResourceNotFoundException;

import static shop.util.ResponseEntityBuilder.*;

@RestControllerAdvice
public class ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException e) {
        return notFound();
    }

}