package shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The main function is to redirect to /swagger-ui.html
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index", "/index.htm", "/index.html"})
    public String index() {
        return "redirect:/swagger-ui.html";
    }

}
