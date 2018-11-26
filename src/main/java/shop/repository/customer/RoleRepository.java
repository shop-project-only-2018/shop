package shop.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.customer.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
