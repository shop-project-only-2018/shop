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
        customerRepository.deleteAll();
    }

    @Test
    public void test() {
        customerRepository.save(new Customer());
        customerRepository.save(new Customer());
        customerRepository.save(new Customer());
        customerRepository.save(new Customer());
        assert customerRepository.count() == 4;
    }

    @After
    public void tearDown() {
        customerRepository.deleteAll();
    }

}
