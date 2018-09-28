package shop.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.order.PaymentMethod;
import shop.model.order.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
