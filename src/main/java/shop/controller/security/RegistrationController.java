package shop.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.dtos.security.UsernamePasswordDTO;
import shop.service.customer.CustomerService;

@Controller
public class RegistrationController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/sign-up")
    public String getLoginForm(Model model) {
        model.addAttribute("title", "signUp.title");
        return "customers/signUpForm";
    }

}