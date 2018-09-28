package shop.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
