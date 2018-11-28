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
import shop.repository.customer.CustomerRepository;
import shop.repository.order.OrderRepository;
import shop.service.product.BookService;
import shop.service.security.SecurityService;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private OrderMapper mapper;

    private BookService bookService;

    private SecurityService securityService;

    private CustomerRepository customerRepository;

    private OrderItemService orderItemService;

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setOrderItemService(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setMapper(OrderMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    private Order getById(Integer id) throws CheckedException {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new CheckedException("error.unknown");
            // TODO: log id
        }
        return order;
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getAll() {
        List<Order> list = orderRepository.findAll();
        List<OrderDto> dtoList = new ArrayList<>();
        for (Order order : list) {
            OrderDto dto = mapper.getDto(order);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public OrderDto getDtoById(Integer id) throws Exception {
        Order order = getById(id);
        return mapper.getDto(order);
    }

    @Transactional
    public Integer create(OrderDto orderDto) {
        Order order = mapper.getEntity(orderDto);
        orderRepository.saveAndFlush(order);
        return order.getId();
    }

    @Transactional
    public void addBookToCurrentCart(String token, Integer id) throws CheckedException {
        Book book = bookService.getById(id);
        Order cart = getCurrentCart(token);

        if (!cart.contains(book)) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(cart);
            orderItem.setPrice(book.getPrice());
            orderItem.setBook(book);
            orderItem.setQuantity(1);
            orderItemService.save(orderItem);
            cart.addOrderItem(orderItem);
        }
        save(cart);
    }

    @Transactional
    public void save(Order order) {
        orderRepository.saveAndFlush(order);
    }


    @Transactional(readOnly = true)
    public Integer getNumberOfItemsInCurrentCart(String token) throws CheckedException {
        return getCurrentCart(token).getNumberOfItems();
    }

    @Transactional(readOnly = true)
    private Order getCurrentCart(String token) throws CheckedException {

        // TODO: MOVE TO AUTHENTICATION SERVICE?
        Customer customer;
        customer = customerRepository.findById(securityService.checkTokenGetId(token)).orElse(null);
        if (customer == null) {
            throw new CheckedException("error.security.authentication");
        }

        if (customer.getCurrentOrder() == null) {
            Order order = new Order();
            save(order);
            customer.setCurrentOrder(order);
            customerRepository.saveAndFlush(customer);
        }

        return customer.getCurrentOrder();
    }
}
