package shop.repository.customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.customer.Customer;
import shop.model.customer.Person;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class PersonRepositoryTest {

    @Autowired
    public PersonRepository personRepository;
    @Autowired
    public CustomerRepository customerRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
        Customer customerJohn = new Customer();

        Customer customerJon = new Customer();

        Person personJohn = new Person();
        personJohn.setCustomer(customerJohn);
        personJohn.setCustomerId(customerJohn.getCustomerId());
        personJohn.setFirstName("John");
        personJohn.setLastName("Smith");
        Person personJon = new Person();
        personJon.setCustomer(customerJon);
        personJon.setCustomerId(customerJon.getCustomerId());
        personJon.setFirstName("Jon");
        personJon.setLastName("Smith");
        customerJon.setPerson(personJon);
        customerJohn.setPerson(personJohn);
        personRepository.save(personJohn);
        personRepository.save(personJon);
        customerRepository.save(customerJon);
        customerRepository.save(customerJohn);
        assert customerRepository.count() == 2;
        assert personRepository.count() == 2;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        personRepository.deleteAll();
        customerRepository.deleteAll();
    }
}
