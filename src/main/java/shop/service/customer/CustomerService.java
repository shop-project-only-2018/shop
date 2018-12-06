package shop.service.customer;

import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.customer.CreateUpdateCustomerDto;
import shop.dtos.customer.CustomerDto;
import shop.dtos.security.TokenDTO;
import shop.mappers.customer.CustomerMapper;
import shop.model.customer.Customer;
import shop.repository.customer.CustomerRepository;
import shop.service.security.SecurityService;
import shop.service.security.userdetails.IdentifiedUser;
import shop.system.CheckedException;

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

    public boolean exists(String username) {
        return repo.findByUsername(username) != null;
    }

    public Customer getById(Integer id) throws CheckedException {
        Customer customer = repo.findById(id).orElse(null);
        if (customer == null) {
            throw new CheckedException("error.unknown");
            // TODO: log id
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
    public CustomerDto getDtoById(Integer id) throws Exception {
        Customer customer = getById(id);
        CustomerDto orderDto = mapper.getDto(customer);
        return orderDto;
    }

    public Integer create(CreateUpdateCustomerDto dto) {
        if (exists(dto.getUsername())) {
            throw new BadCredentialsException("Input error");
        }
        Customer customer = mapper.getEntity(dto);
        customer.setPassword(passwordEncoder.encode(dto.getPassword()));
        save(customer);
        return customer.getId();
    }

    @Transactional(readOnly = true)
    public TokenDTO signIn(@NotNull String login, @NotNull String password) throws CheckedException, JwtException {
        Customer user;

        user = repo.findByUsername(login);
        if (user == null) {
            throw new CheckedException("signIn.error");
        } else if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CheckedException("signIn.error");
        }

        return new TokenDTO()
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

    @Transactional(readOnly = true)
    public Customer findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public void save(Customer customer) {
        repo.saveAndFlush(customer);
    }
}
