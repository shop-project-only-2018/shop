package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.order.OrderDto;
import shop.mappers.order.OrderMapper;
import shop.model.customer.Customer;
import shop.model.order.Order;
import shop.model.order.OrderItem;
import shop.model.product.Book;
import shop.repository.order.OrderItemRepository;
import shop.repository.order.OrderRepository;
import shop.service.customer.CustomerService;
import shop.service.product.BookService;
import shop.service.security.SecurityService;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Autowired
    public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void save(OrderItem item) {
        orderItemRepository.saveAndFlush(item);}
}
