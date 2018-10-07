package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.product.CategoryDto;
import shop.dtos.product.mappers.CategoryMapper;
import shop.model.product.Category;
import shop.repository.product.CategoryRepository;

@Service
public class ProductService {

    @Autowired
    public CategoryRepository categoryRepository;

    public boolean save(CategoryDto categoryDTO){
        Category category = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDTO);
        categoryRepository.save(category);
        return true;
    }
}
