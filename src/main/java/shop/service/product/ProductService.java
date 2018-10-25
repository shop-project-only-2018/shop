package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;
import shop.repository.product.ProductRepository;
import shop.util.Mapper;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public void save(CategoryDto categoryDTO) {
         Mapper.getEntity(categoryDTO);
    }
}
