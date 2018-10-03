package shop.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.product.Category;
import shop.model.product.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
