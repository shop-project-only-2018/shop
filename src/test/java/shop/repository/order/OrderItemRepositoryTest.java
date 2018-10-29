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
import shop.model.order.OrderItem;
import shop.model.order.PaymentMethod;
import shop.model.order.Status;
import shop.model.product.Product;
import shop.repository.customer.CustomerRepository;
import shop.repository.product.ProductRepository;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class OrderItemRepositoryTest {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public OrderItemRepository orderItemRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public StatusRepository statusRepository;

    @Autowired
    public ProductRepository productRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {

        Customer c = new Customer("abc", "def");
        PaymentMethod p = new PaymentMethod("Blah-blah");
        Status s = new Status("Done");
        customerRepository.save(c);
        paymentMethodRepository.save(p);
        statusRepository.save(s);

        Order o1 = new Order();
        o1.setCustomer(c);
        o1.setPaymentMethod(p);
        o1.setStatus(s);
        o1.setPrice(new BigDecimal(10));
        orderRepository.save(o1);

        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(new BigDecimal(10));
        product1.setQuantity(10);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(new BigDecimal(10));
        product2.setQuantity(10);
        productRepository.save(product2);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setOrder(o1);
        orderItem1.setPrice(new BigDecimal(10));
        orderItem1.setProduct(product1);
        orderItem1.setQuantity(1);
        orderItemRepository.save(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setOrder(o1);
        orderItem2.setPrice(new BigDecimal(10));
        orderItem2.setProduct(product2);
        orderItem2.setQuantity(1);
        orderItemRepository.save(orderItem2);


        assert orderRepository.count() == 1;
        assert customerRepository.count() == 1;
        assert paymentMethodRepository.count() == 1;
        assert statusRepository.count() == 1;

        assert productRepository.count() == 2;

        assert orderItemRepository.count() == 2;
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
        productRepository.deleteAll();
        orderItemRepository.deleteAll();
    }
}