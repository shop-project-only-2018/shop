package shop.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.customer.Customer;
import shop.model.customer.Organization;
import shop.model.customer.Person;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Customer> {
}
