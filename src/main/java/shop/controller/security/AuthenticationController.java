package shop.controller.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.system.exceptions.ResourceNotFoundException;

import static shop.util.ResponseEntityBuilder.notFound;

@RestController
@RequestMapping("login")
public class AuthenticationController {

}
