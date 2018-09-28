package shop.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.customer.Customer;
import shop.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
