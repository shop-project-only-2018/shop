package shop.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import shop.model.product.Book;
import shop.model.product.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {}
