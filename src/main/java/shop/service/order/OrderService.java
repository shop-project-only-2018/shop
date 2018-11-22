package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.order.OrderDto;
import shop.mappers.order.OrderMapper;
import shop.model.order.Order;
import shop.repository.order.OrderRepository;
import shop.service.message.Messages;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository repo;

    private OrderMapper mapper;

    private Messages messages;

    @Autowired
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Autowired
    public void setRepo(OrderRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(OrderMapper mapper) {
        this.mapper = mapper;
    }

    private Order getById(Integer id) throws Exception {
        Order order = repo.findById(id).orElse(null);
        if (order == null) {
            throw new Exception(messages.get("error.unknown"));
            // TODO: log id
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
    public OrderDto getDtoById(Integer id) throws Exception {
        Order order = getById(id);
        return mapper.getDto(order);
    }

    public Integer create(OrderDto orderDto) {
        Order order = mapper.getEntity(orderDto);
        repo.saveAndFlush(order);
        return order.getId();
    }

}
