package shop.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shop.dtos.security.UsernamePasswordDTO;
import shop.service.customer.CustomerService;

@Controller
public class AuthenticationController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/sign-in")
    public String getLoginForm(Model model) {
        model.addAttribute("authData", new UsernamePasswordDTO());
        model.addAttribute("title", "signIn.title");
                return "customers/signInForm";
    }
}