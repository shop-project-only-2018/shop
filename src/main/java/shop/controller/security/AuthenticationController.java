package shop.controller.security;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.dtos.security.TokenDTO;
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

        UsernamePasswordDTO authData = new UsernamePasswordDTO("admin", "123");
        model.addAttribute("authData", authData);

        return "customers/signInForm";
    }}