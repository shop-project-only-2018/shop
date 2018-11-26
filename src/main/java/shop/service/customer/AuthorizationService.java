package shop.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shop.dtos.security.UsernameTokenDTO;
import shop.mappers.customer.CustomerMapper;
import shop.repository.customer.CustomerRepository;
import shop.service.security.SecurityService;

@Service
public class AuthorizationService {

    private BCryptPasswordEncoder passwordEncoder;

    private CustomerRepository repo;

    private CustomerMapper mapper;

    private SecurityService securityService;

    @Autowired
    public void setRepo(CustomerRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(CustomerMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public Boolean isAuthenticated(UsernameTokenDTO usernameTokenDTO) {
        return usernameTokenDTO.getUsername()
                .equals(securityService.checkTokenGetUsername(usernameTokenDTO.getToken()));
    }}
