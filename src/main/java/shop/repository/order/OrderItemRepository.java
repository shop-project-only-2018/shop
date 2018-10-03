package shop.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.order.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
