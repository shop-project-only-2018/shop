package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.order.OrderDto;
import shop.dtos.order.mappers.OrderMapper;
import shop.model.order.Order;
import shop.repository.order.OrderRepository;
import shop.system.exceptions.ResourceNotFoundException;
import shop.util.Mapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

//    @Autowired
//    public CustomerRepository customerRepository;
//
//    @Autowired
//    public PaymentMethodRepository paymentMethodRepository;
//
//    @Autowired
//    public StatusRepository statusRepository;

    private Order getById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public boolean delete(Integer id) {
        Order order = getById(id);
        if (order != null) {
            orderRepository.delete(order);
            return true;
        } else {
            return false;
        }
    }

    public List<OrderDto> getAll() {
        List<Order> list = orderRepository.findAll();
        List<OrderDto> dtoList = new ArrayList<>();
        for (Order order : list) {
            OrderDto sd = Mapper.getDto(order);
            dtoList.add(sd);
        }
        return dtoList;
    }

    public OrderDto getDtoById(Integer id) throws ResourceNotFoundException {
        Order order = getById(id);
        if (order == null) {
            throw new ResourceNotFoundException();
        } else {
            OrderDto orderDto = Mapper.getDto(order);
            return orderDto;
        }
    }

    public Integer create(OrderDto orderDto) {
        Order order = Mapper.getEntity(orderDto);
        orderRepository.save(order);
        return order.getId();
    }

    public boolean update(OrderDto orderDto) {
        try {
            Order order = OrderMapper.INSTANCE.orderDtoToOrder(orderDto);
            orderRepository.save(order);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}