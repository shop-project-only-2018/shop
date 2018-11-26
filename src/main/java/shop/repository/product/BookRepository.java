package shop.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shop.model.product.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
}
