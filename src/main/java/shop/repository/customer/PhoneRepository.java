package shop.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.customer.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
