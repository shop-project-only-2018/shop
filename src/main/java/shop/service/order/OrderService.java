package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.repository.customer.CustomerRepository;
import shop.repository.order.OrderRepository;
import shop.repository.order.PaymentMethodRepository;
import shop.repository.order.StatusRepository;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public StatusRepository statusRepository;

}
