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
import shop.model.customer.Phone;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class PhoneRepositoryTest {

    @Autowired
    public PhoneRepository phoneRepository;
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

        phoneRepository.save(new Phone("1", c));
        phoneRepository.save(new Phone("2", c));
        phoneRepository.save(new Phone("3", c));
        phoneRepository.save(new Phone("4", c));
        phoneRepository.save(new Phone("5", c));
        phoneRepository.save(new Phone("6", c));

        assert phoneRepository.count() == 6;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        phoneRepository.deleteAll();
        customerRepository.deleteAll();
    }
}
