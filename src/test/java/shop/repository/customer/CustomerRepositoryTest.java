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


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CustomerRepositoryTest {

    @Autowired
    public CustomerRepository customerRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {

        customerRepository.save(new Customer("abc", "def", "ghi", "jkl"));
        customerRepository.save(new Customer("abc", "def", "ghi1", "jkl"));
        customerRepository.save(new Customer("abc", "def", "ghi2", "jkl"));
        customerRepository.save(new Customer("abc", "def", "ghi3", "jkl"));

        assert customerRepository.count() == 4;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        customerRepository.deleteAll();
    }
}
