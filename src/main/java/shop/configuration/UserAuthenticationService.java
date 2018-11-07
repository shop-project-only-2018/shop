package shop.configuration;

import shop.model.customer.Customer;

import java.util.Optional;

public interface UserAuthenticationService {
    Optional<String> login(String username, String password);
    Optional<Customer> findByToken(String token);
    void logout(Customer user);}