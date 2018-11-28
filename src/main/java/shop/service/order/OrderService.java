package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.order.OrderDto;
import shop.dtos.product.OrderItemBookDto;
import shop.mappers.order.OrderMapper;
import shop.mappers.product.BookMapper;
import shop.model.customer.Customer;
import shop.model.order.Order;
import shop.model.order.OrderItem;
import shop.model.product.Book;
import shop.repository.customer.CustomerRepository;
import shop.repository.order.OrderItemRepository;
import shop.repository.order.OrderRepository;
import shop.service.product.BookService;
import shop.service.security.SecurityService;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private OrderMapper orderMapper;

    private OrderItemRepository orderItemRepository;

    private BookMapper bookMapper;

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
    public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
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
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
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
            OrderDto dto = orderMapper.getDto(order);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public OrderDto getDtoById(Integer id) throws Exception {
        Order order = getById(id);
        return orderMapper.getDto(order);
    }

    @Transactional
    public Integer create(OrderDto orderDto) {
        Order order = orderMapper.getEntity(orderDto);
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


    // TODO: @Transactional READONLY!
    @Transactional
    public Integer getNumberOfItemsInCurrentCart(String token) throws CheckedException {
        return getCurrentCart(token).getNumberOfItems();
    }

    // TODO: @Transactional READONLY!
    @Transactional
    private Order getCurrentCart(String token) throws CheckedException {

        // TODO: MOVE TO AUTHENTICATION SERVICE?
        Customer customer;
        customer = customerRepository.findById(securityService.checkTokenGetId(token)).orElse(null);
        if (customer == null) {
            throw new CheckedException("error.security.authentication");
        }// /TODO

        if (customer.getCurrentOrder() == null) {
            Order order = new Order();
            save(order);
            customer.setCurrentOrder(order);
            // TODO: @Transactional READONLY!
            customerRepository.saveAndFlush(customer);
        }

        return customer.getCurrentOrder();
    }

    // TODO: @Transactional READONLY!
    @Transactional
    public List<OrderItemBookDto> getBooksInCurrentCart(String token) throws CheckedException {
        Order cart = getCurrentCart(token);
        List<OrderItemBookDto> result = new ArrayList<>();
        for (OrderItem item : cart.getOrderItems()) {
            OrderItemBookDto dto = bookMapper.getDto(item.getBook());
            dto.setOrderItemId(item.getOrderItemId());
            result.add(dto);
        }
        return result;
    }

    @Transactional
    @Modifying
    public void removeBookFromCurrentCart(String tokenFromHeader, Integer orderItemId) throws CheckedException {
        OrderItem item = orderItemRepository.findById(orderItemId).orElse(null);
        if (item == null) throw new CheckedException("error.notFound");

        Order cart = getCurrentCart(tokenFromHeader);
        cart.getOrderItems().remove(item);
        orderRepository.save(cart);
        orderItemRepository.deleteById(orderItemId);
        orderItemRepository.flush();
        save(cart);
    }

    @Transactional
    @Modifying
    public void removeAllBooksFromCurrentCart(String tokenFromHeader) throws CheckedException {
        Order cart = getCurrentCart(tokenFromHeader);
        orderRepository.deleteById(cart.getOrderId());
        orderItemRepository.flush();
    }
}
