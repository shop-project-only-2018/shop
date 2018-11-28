package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.model.order.OrderItem;
import shop.repository.order.OrderItemRepository;

@Service
public class OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Autowired
    public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void save(OrderItem item) {
        orderItemRepository.saveAndFlush(item);
    }
}
