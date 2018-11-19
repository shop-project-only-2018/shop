package shop.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = {"/error", "/error.html"})
    public String handleError(Model model) {
        model.addAttribute("title", "general.error.title");
        model.addAttribute("description", "general.error.description");
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
