package shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import shop.dtos.order.StatusDto;
import shop.service.order.StatusService;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index", "/index.htm", "/index.html"})
    public String index() {
        return "redirect:/swagger-ui.html";
    }

}
