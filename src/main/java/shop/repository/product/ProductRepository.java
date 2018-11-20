package shop.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.product.Book;

@Repository
public interface ProductRepository extends JpaRepository<Book, Integer> {
}
