package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;
import shop.repository.product.CategoryRepository;
import shop.util.Mapper;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public boolean save(CategoryDto categoryDTO) {
        Category category = Mapper.getEntity(categoryDTO);
        categoryRepository.save(category);
        return true;
    }
}
