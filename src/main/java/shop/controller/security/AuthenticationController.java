package shop.controller.security;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.dtos.security.TokenDTO;
import shop.service.customer.CustomerService;

@Controller
public class AuthenticationController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/login")
    public String getLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestParam String login, @RequestParam String password)
            throws JwtException {
        return customerService.login(login, password);
    }

}