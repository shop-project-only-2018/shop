package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.DTOs.product.CategoryDto;
import shop.DTOs.product.mappers.CategoryMapper;
import shop.model.product.Category;
import shop.repository.product.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public boolean save(CategoryDto categoryDTO){
        Category category = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDTO);
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return true;
    }
}
