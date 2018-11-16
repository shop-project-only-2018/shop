package shop.service.customer;

import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.customer.CustomerDto;
import shop.dtos.security.TokenDTO;
import shop.mappers.customer.CustomerMapper;
import shop.model.customer.Customer;
import shop.repository.customer.CustomerRepository;
import shop.service.security.SecurityService;
import shop.service.security.userdetails.IdentifiedUser;
import shop.system.exceptions.ResourceNotFoundException;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

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

    private Customer getById(Integer id) throws ResourceNotFoundException {
        Customer customer = repo.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("Customer id = " + id.toString());
        }
        return customer;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CustomerDto> getAll() {
        List<Customer> list = repo.findAll();
        List<CustomerDto> dtoList = new ArrayList<>();
        for (Customer customer : list) {
            CustomerDto dto = mapper.getDto(customer);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public CustomerDto getDtoById(Integer id) throws ResourceNotFoundException {
        Customer customer = getById(id);
        if (customer == null) {
            throw new ResourceNotFoundException();
        } else {
            CustomerDto orderDto = mapper.getDto(customer);
            return orderDto;
        }
    }

    public Integer create(CustomerDto customerDto) {
        Customer customer = mapper.getEntity(customerDto);
        repo.saveAndFlush(customer);
        return customer.getId();
    }

    public void update(CustomerDto dto) throws ResourceNotFoundException {
//        Customer customer = getById(dto.getCustomerId());
//        Customer updCustomer = mapper.getEntity(dto);
//        customer = mapper.merge(customer, updCustomer);
//        repo.saveAndFlush(customer);
    }

    @Transactional(readOnly = true)
    public TokenDTO login(@NotNull String login, @NotNull String password) throws BadCredentialsException, JwtException {
        Customer user;

        user = repo.findByUsername(login);
        if (user == null) {
            throw new BadCredentialsException("Authentication error");
        } else if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication error");
        }

        return new TokenDTO()
                .setUser(mapper.toAuthDTO(user))
                .setTokenType(securityService.getTokenType())
                .setAccessToken(
                        securityService.login(
                                new IdentifiedUser(
                                        user.getId(),
                                        User.builder()
                                                .username(user.getUsername())
                                                .password(user.getPassword())
                                                .roles("USER")
//                                                .roles(user.getRole().getCode().toUpperCase())
                                                .build()
                                )
                        )
                );
    }

}
