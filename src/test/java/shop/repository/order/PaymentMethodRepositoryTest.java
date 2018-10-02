package shop.repository.order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.customer.Customer;
import shop.model.order.PaymentMethod;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class PaymentMethodRepositoryTest {

    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
        paymentMethodRepository.save(new PaymentMethod("1"));
        paymentMethodRepository.save(new PaymentMethod("2"));
        paymentMethodRepository.save(new PaymentMethod("3"));
        paymentMethodRepository.save(new PaymentMethod("4"));
        paymentMethodRepository.save(new PaymentMethod("5"));
        assert paymentMethodRepository.count() == 5;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        paymentMethodRepository.deleteAll();
    }
}
