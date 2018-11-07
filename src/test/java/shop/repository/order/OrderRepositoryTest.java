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
import shop.model.order.Order;
import shop.model.order.PaymentMethod;
import shop.model.order.Status;
import shop.repository.customer.CustomerRepository;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class OrderRepositoryTest {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public StatusRepository statusRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {

        Order o1 = new Order();
        Order o2 = new Order();
        Customer c = new Customer("abc", "def", "ghi", "jkl");
        PaymentMethod p = new PaymentMethod("Blah-blah");
        Status s = new Status("Done");

        customerRepository.save(c);
        paymentMethodRepository.save(p);
        statusRepository.save(s);

        o1.setCustomer(c);
        o2.setCustomer(c);
        o1.setPaymentMethod(p);
        o2.setPaymentMethod(p);
        o1.setStatus(s);
        o2.setStatus(s);
        o1.setPrice(new BigDecimal(0));
        o2.setPrice(new BigDecimal(0));

        orderRepository.save(o1);
        orderRepository.save(o2);

        assert orderRepository.count() == 2;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        orderRepository.deleteAll();
        customerRepository.deleteAll();
        paymentMethodRepository.deleteAll();
        statusRepository.deleteAll();
    }
}