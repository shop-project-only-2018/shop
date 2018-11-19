package shop.controller.security;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping(value = "/login")
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE},
//            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public TokenDTO login(@RequestBody UsernamePasswordDTO authData)
            throws JwtException {
        return customerService.login(authData.getUsername(), authData.getPassword());
    }

}