package shop.repository.customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.customer.Address;
import shop.model.customer.Customer;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class AddressRepositoryTest {

    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    public CustomerRepository customerRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
        Customer c = new Customer();
        customerRepository.save(c);

        addressRepository.save(new Address("1", c));
        addressRepository.save(new Address("2", c));
        addressRepository.save(new Address("3", c));

        assert addressRepository.count() == 3;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        addressRepository.deleteAll();
        customerRepository.deleteAll();
    }
}
