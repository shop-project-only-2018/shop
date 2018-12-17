package shop.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.model.customer.Customer;
import shop.service.security.RolesService;
import shop.system.CheckedException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthorizationRestController {

    private RolesService rolesService;

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/api/get-menu")
    public String cartAvailableCheck(HttpServletRequest request) throws CheckedException {
        Customer customer;
        try {
            return rolesService.getCustomer(request).getRole().getDescription();
        } catch (Exception e) {
            return "NONE";
        }
    }


}