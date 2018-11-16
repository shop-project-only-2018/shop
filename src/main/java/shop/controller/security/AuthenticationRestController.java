package shop.controller.security;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.dtos.security.TokenDTO;
import shop.dtos.security.UsernamePasswordDTO;
import shop.service.customer.CustomerService;

@RestController
public class AuthenticationRestController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestBody UsernamePasswordDTO authData)
            throws JwtException {
        return customerService.login(authData.getUsername(), authData.getPassword());
    }

}