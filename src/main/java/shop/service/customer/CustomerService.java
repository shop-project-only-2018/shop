package shop.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.customer.CustomerDto;
import shop.mappers.customer.CustomerMapper;
import shop.model.customer.Customer;
import shop.repository.customer.CustomerRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repo;

    private CustomerMapper mapper;

    @Autowired
    public void setRepo(CustomerRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(CustomerMapper mapper) {
        this.mapper = mapper;
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

}
