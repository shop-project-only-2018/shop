package shop.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.model.customer.Customer;
import shop.repository.customer.CustomerRepository;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;

@Service
public class RolesService {

    private SecurityService securityService;
    private TokenParserService tokenParserService;
    private CustomerRepository customerRepository;

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    public void setTokenParserService(TokenParserService tokenParserService) {
        this.tokenParserService = tokenParserService;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Throw exception if the user does not have a certain role
     *
     * @param request - auto
     * @param role    - role description
     * @throws CheckedException if the user does not have a certain role
     */
    public void mustHaveRole(HttpServletRequest request, String role) throws CheckedException {
        String token = tokenParserService.getTokenFromHeader(request);
        Customer customer;
        customer = customerRepository.findById(securityService.checkTokenGetId(token))
                .orElseThrow(() -> new CheckedException("error.security.authentication"));
        if (!customer.hasRole(role)) {
            throw new CheckedException("error.security.notAuthorized");
        }
    }
}
