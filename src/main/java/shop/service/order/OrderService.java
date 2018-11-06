package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.order.OrderDto;
import shop.mappers.order.OrderMapper;
import shop.model.order.Order;
import shop.repository.order.OrderRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository repo;

    private OrderMapper mapper;

    @Autowired
    public void setRepo(OrderRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(OrderMapper mapper) {
        this.mapper = mapper;
    }

    private Order getById(Integer id) throws ResourceNotFoundException {
        Order order = repo.findById(id).orElse(null);
        if (order == null) {
            throw new ResourceNotFoundException("Order id = " + id.toString());
        }
        return order;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> getAll() {
        List<Order> list = repo.findAll();
        List<OrderDto> dtoList = new ArrayList<>();
        for (Order order : list) {
            OrderDto dto = mapper.getDto(order);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public OrderDto getDtoById(Integer id) throws ResourceNotFoundException {
        Order order = getById(id);
        if (order == null) {
            throw new ResourceNotFoundException();
        } else {
            return mapper.getDto(order);
        }
    }

    public Integer create(OrderDto orderDto) {
        Order order = mapper.getEntity(orderDto);
        repo.saveAndFlush(order);
        return order.getId();
    }

    public void update(OrderDto dto) {
//        Order order = getById(dto.getOrderId());
//        Order updOrder = mapper.getEntity(dto);
//        order = mapper.merge(order, updOrder);
//        repo.saveAndFlush(order);
    }

}
